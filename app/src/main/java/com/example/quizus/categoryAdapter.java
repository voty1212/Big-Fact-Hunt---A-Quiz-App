package com.example.quizus;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class categoryAdapter {

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
