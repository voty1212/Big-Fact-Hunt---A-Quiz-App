package com.example.quizus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class categoryAdapter extends RecyclerView.Adapter<categoryAdapter.categoryViewHolder> {

    Context context;
    ArrayList<categoryModel> categoryModels;
    public categoryAdapter(Context context, ArrayList<categoryModel> categoryModels){

        this.context = context;
        this.categoryModels = categoryModels;
    }

    @NonNull
    @Override
    public categoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_category,null);
        return categoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull categoryViewHolder holder, int position) {
        categoryModel model = categoryModels.get(position);

        holder.textView.setText(model.getCategoryName());
    }

    @Override
    public int getItemCount() {
        return categoryModels.size();
    }

    public class categoryViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public categoryViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewsWithText(R.id.category);
        }
    }
}
