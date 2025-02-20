package com.example.vroom.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.vroom.R;
import com.example.vroom.models.Car;
import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {
    private List<Car> carList;
    private OnCarClickListener listener;

    public interface OnCarClickListener {
        void onCarClick(Car car);
    }

    public CarAdapter(List<Car> carList, OnCarClickListener listener) {
        this.carList = carList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_car, parent, false);
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        Car car = carList.get(position);
        holder.carName.setText(car.getName());
        holder.carDescription.setText(car.getDescription());
        holder.carPrice.setText(String.format("$%,.2f", car.getPrice()));
        
        // Load image from drawable
        int resourceId = holder.itemView.getContext().getResources()
            .getIdentifier(car.getImageUrl(), "drawable", 
                holder.itemView.getContext().getPackageName());
        holder.carImage.setImageResource(resourceId);

        holder.buyButton.setOnClickListener(v -> listener.onCarClick(car));
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    static class CarViewHolder extends RecyclerView.ViewHolder {
        ImageView carImage;
        TextView carName;
        TextView carDescription;
        TextView carPrice;
        Button buyButton;

        CarViewHolder(View itemView) {
            super(itemView);
            carImage = itemView.findViewById(R.id.carImage);
            carName = itemView.findViewById(R.id.carName);
            carDescription = itemView.findViewById(R.id.carDescription);
            carPrice = itemView.findViewById(R.id.carPrice);
            buyButton = itemView.findViewById(R.id.buyButton);
        }
    }
} 