package com.example.quizus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizus.databinding.RowLeaderboardsBinding;

import java.util.ArrayList;

public class leaderBoardAdapter extends RecyclerView.Adapter<leaderBoardAdapter.LeaderboardViewHolder> {

    Context context;
    ArrayList<user> users;

    public leaderBoardAdapter(Context context, ArrayList<user> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public LeaderboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_leaderboards, parent, false);
        return new LeaderboardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderboardViewHolder holder, int position) {
        user user = users.get(position);

        holder.binding.name.setText(user.getName());
        holder.binding.coins.setText(String.valueOf(user.getCoinPoints()));
        holder.binding.index.setText(String.format("#%d", position+1));

       /* Glide.with(context)
                .load(user.getProfile())
                .into(holder.binding.imageView7);*/
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class LeaderboardViewHolder extends RecyclerView.ViewHolder {

        RowLeaderboardsBinding binding;
        public LeaderboardViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = RowLeaderboardsBinding.bind(itemView);
        }
    }
}
