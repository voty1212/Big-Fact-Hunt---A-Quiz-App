package com.example.quizus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.quizus.databinding.ActivityQuizBinding;

import java.util.ArrayList;

public class quizActivity extends AppCompatActivity {

    ActivityQuizBinding binding;

    ArrayList<question> questions;

    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_quiz);

        questions = new ArrayList<>();

        questions.add(new question("What is earth?", "Planet", "car", "bike", "book", "Planet"));
        questions.add(new question("What is samosha?", "Planet", "car", "bike", "Food", "Food"));

        setNextQuestion();
    }

    void setNextQuestion(){
        if(index < questions.size()){
            question question = questions.get(index);
            binding.question.setText(question.getQuestion());
            binding.option1.setText(question.getOption1());
            binding.option2.setText(question.getOption2());
            binding.option3.setText(question.getOption3());
            binding.option4.setText(question.getOption4());
        }
    }

    public void onClick(View view ){
        switch (view.getId()){

            case R.id.option_1:
            case R.id.option_2:
            case R.id.option_3:
            case R.id.option_4:
                Toast.makeText(this, "Option Clicked", Toast.LENGTH_SHORT).show();
                break;


            case R.id.nextBtn:
                if(index < questions.size()) {
                    index++;
                    setNextQuestion();
                } else {
                    Toast.makeText(this, "Quiz Ended", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

}