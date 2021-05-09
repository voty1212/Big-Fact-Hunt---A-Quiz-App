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
        categories.add(new categoryModel("tLUsOBmUTDvqkR7vPU9R" , "Mathematics", "https://i.ytimg.com/vi/Kp2bYWRQylk/maxresdefault.jpg"));
        categories.add(new categoryModel("T2Xo3D4HxSYVAHU8uiBw", "Science", "https://i.ytimg.com/vi/Kp2bYWRQylk/maxresdefault.jpg"));
        categories.add(new categoryModel("PXdA0HZuokdUfIZroPWJ" , "History", "https://i.ytimg.com/vi/Kp2bYWRQylk/maxresdefault.jpg"));
        categories.add(new categoryModel("6RtSS0AsdwPqEB8d8t4p" , "Language", "https://i.ytimg.com/vi/Kp2bYWRQylk/maxresdefault.jpg"));

        categoryAdapter adapter = new categoryAdapter(getContext(), categories);



        binding.categoryList.setLayoutManager(new GridLayoutManager(getContext(),2));
        binding.categoryList.setAdapter(adapter);


        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}