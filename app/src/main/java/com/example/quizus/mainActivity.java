package com.example.quizus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.example.quizus.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class mainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<categoryModel> categories = new ArrayList<>();
        categories.add(new categoryModel("", "Mathematics",""));
        categories.add(new categoryModel("", "Science",""));
        categories.add(new categoryModel("", "History",""));
        categories.add(new categoryModel("", "Language",""));

        categoryAdapter adapter = new categoryAdapter(this, categories);
        binding.categoryList.setLayoutManager(new GridLayoutManager(this,2));
        binding.categoryList.setAdapter(adapter);

    }
}