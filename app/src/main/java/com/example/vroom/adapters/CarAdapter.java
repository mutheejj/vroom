package com.example.vroom.adapters;

import android.content.Context;
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
import java.util.Locale;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {
    private List<Car> cars;
    private OnCarClickListener listener;
    private Context context;

    public interface OnCarClickListener {
        void onCarClick(Car car);
    }

    public CarAdapter(List<Car> cars, OnCarClickListener listener) {
        this.cars = cars;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_car, parent, false);
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        Car car = cars.get(position);
        
        // Get the resource ID dynamically
        int imageResourceId = context.getResources().getIdentifier(
            car.getImageResourceName(),
            "drawable",
            context.getPackageName()
        );
        
        holder.carImage.setImageResource(imageResourceId);
        holder.carName.setText(car.getName());
        holder.carDescription.setText(car.getDescription());
        holder.carPrice.setText(String.format(Locale.US, "$%.2f", car.getPrice()));
        
        holder.buyButton.setOnClickListener(v -> {
            if (listener != null) {
                listener.onCarClick(car);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cars.size();
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