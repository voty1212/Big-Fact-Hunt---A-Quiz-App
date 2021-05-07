package com.example.quizus;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.example.quizus.databinding.ActivityMainBinding;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class mainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        ArrayList<categoryModel> categories = new ArrayList<>();
        categories.add(new categoryModel("" , "Mathematics", "https://i.ytimg.com/vi/Kp2bYWRQylk/maxresdefault.jpg"));
        categories.add(new categoryModel("" , "Science", "https://i.ytimg.com/vi/Kp2bYWRQylk/maxresdefault.jpg"));
        categories.add(new categoryModel("" , "History", "https://i.ytimg.com/vi/Kp2bYWRQylk/maxresdefault.jpg"));
        categories.add(new categoryModel("" , "Language", "https://i.ytimg.com/vi/Kp2bYWRQylk/maxresdefault.jpg"));

        categoryAdapter adapter = new categoryAdapter(this, categories);



        binding.categoryList.setLayoutManager(new GridLayoutManager(this,2));
        binding.categoryList.setAdapter(adapter);

    }
} 