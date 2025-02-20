package com.example.vroom.utils;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class FirebaseHelper {
    private static FirebaseAuth auth;
    private static FirebaseFirestore mFirestore;

    public static FirebaseAuth getAuth() {
        if (auth == null) {
            auth = FirebaseAuth.getInstance();
        }
        return auth;
    }

    public static FirebaseFirestore getFirestore() {
        if (mFirestore == null) {
            mFirestore = FirebaseFirestore.getInstance();
        }
        return mFirestore;
    }

    public static FirebaseUser getCurrentUser() {
        return getAuth().getCurrentUser();
    }
} 