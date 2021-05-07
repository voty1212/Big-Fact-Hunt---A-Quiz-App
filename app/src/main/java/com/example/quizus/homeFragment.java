package com.example.quizus;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quizus.databinding.FragmentHomeBinding;

import java.util.ArrayList;


public class homeFragment extends Fragment {


    public homeFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);

        ArrayList<categoryModel> categories = new ArrayList<>();
        categories.add(new categoryModel("" , "Mathematics", "https://i.ytimg.com/vi/Kp2bYWRQylk/maxresdefault.jpg"));
        categories.add(new categoryModel("" , "Science", "https://i.ytimg.com/vi/Kp2bYWRQylk/maxresdefault.jpg"));
        categories.add(new categoryModel("" , "History", "https://i.ytimg.com/vi/Kp2bYWRQylk/maxresdefault.jpg"));
        categories.add(new categoryModel("" , "Language", "https://i.ytimg.com/vi/Kp2bYWRQylk/maxresdefault.jpg"));

        categoryAdapter adapter = new categoryAdapter(getContext(), categories);



        binding.categoryList.setLayoutManager(new GridLayoutManager(getContext(),2));
        binding.categoryList.setAdapter(adapter);


        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}