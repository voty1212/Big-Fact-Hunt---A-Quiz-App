package com.example.quizus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizus.databinding.ActivityQuizBinding;

import java.util.ArrayList;

public class quizActivity extends AppCompatActivity {

    ActivityQuizBinding binding;

    ArrayList<Question> questions;

    int index = 0;
    Question question;
    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_quiz);

        questions = new ArrayList<>();

        questions.add(new Question("What is earth?", "Planet", "car", "bike", "book", "Planet"));
        questions.add(new Question("What is samosa?", "Planet", "car", "bike", "Food", "Food"));

        setNextQuestion();
        reset_timer();
    }
    void reset_timer(){
        timer=new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                binding.timer.setText(String.valueOf(millisUntilFinished/1000));

            }

            @Override
            public void onFinish() {

            }
        };
    }

    void setNextQuestion(){
        reset_timer();
        if(timer !=null)
            timer.cancel();
        timer.start();
        if(index < questions.size()){
            binding.questionCounter.setText(String.format("%d/%d",(index+1),(questions.size())));
            question = questions.get(index);
            binding.question.setText(question.getQuestion());
            binding.option1.setText(question.getOption1());
            binding.option2.setText(question.getOption2());
            binding.option3.setText(question.getOption3());
            binding.option4.setText(question.getOption4());
        }
    }
    void show_answer(){
        if(question.getAnswer().equals(binding.option1.getText().toString()))
            binding.option1.setBackground(getResources().getDrawable(R.drawable.option_right));
        else if(question.getAnswer().equals(binding.option2.getText().toString()))
            binding.option2.setBackground(getResources().getDrawable(R.drawable.option_right));
        else if(question.getAnswer().equals(binding.option3.getText().toString()))
            binding.option3.setBackground(getResources().getDrawable(R.drawable.option_right));
        else if(question.getAnswer().equals(binding.option4.getText().toString()))
            binding.option4.setBackground(getResources().getDrawable(R.drawable.option_right));


    }
    void check_answer(TextView textview){
        String Selected_ans= textview.getText().toString();
        if(Selected_ans.equals(question.getAnswer()))
        {
            textview.setBackground(getResources().getDrawable(R.drawable.option_right));
        }
        else
        {   show_answer();
            textview.setBackground(getResources().getDrawable(R.drawable.option_wrong));
        }

    }
    void reset(){
        binding.option1.setBackground(getResources().getDrawable(R.drawable.option_unselected));
        binding.option2.setBackground(getResources().getDrawable(R.drawable.option_unselected));
        binding.option3.setBackground(getResources().getDrawable(R.drawable.option_unselected));
        binding.option4.setBackground(getResources().getDrawable(R.drawable.option_unselected));

    }

    public void onClick(View view ){
        switch (view.getId()){

            case R.id.option_1:
            case R.id.option_2:
            case R.id.option_3:
            case R.id.option_4:
                if(timer!=null)
                    timer.cancel();
                TextView selected=(TextView) view;
                check_answer(selected);

                Toast.makeText(this, "Option Clicked", Toast.LENGTH_SHORT).show();
                break;


            case R.id.nextBtn:
                reset();
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