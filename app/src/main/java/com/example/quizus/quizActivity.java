package com.example.quizus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizus.databinding.ActivityQuizBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Random;
/* fetching questions using database
public class quizActivity extends AppCompatActivity {

    ActivityQuizBinding binding;

    ArrayList<Question> questions;

    int index = 0;
    Question question;
    CountDownTimer timer;
    FirebaseFirestore database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        questions = new ArrayList<>();
        database = FirebaseFirestore.getInstance();

       final String catId = getIntent().getStringExtra("catId");

        Random random = new Random();
       final int rand = random.nextInt(15);

        database.collection("categories")
                .document(catId)
                .collection("questions")
                .whereGreaterThanOrEqualTo("index", rand)
                .orderBy("index")
                .limit(5).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if(queryDocumentSnapshots.getDocuments().size() < 5){
                    database.collection("categories")
                            .document(catId)
                            .collection("questions")
                            .whereLessThanOrEqualTo("index", rand)
                            .orderBy("index")
                            .limit(5).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                                for(DocumentSnapshot snapshot : queryDocumentSnapshots){
                                    Question question = snapshot.toObject(Question.class);
                                    questions.add(question);
                                }
                            setNextQuestion();
                            }


                    });
                } else {
                    for(DocumentSnapshot snapshot : queryDocumentSnapshots){
                        Question question = snapshot.toObject(Question.class);
                        questions.add(question);
                    }
                    setNextQuestion();
                }

            }
        });

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

 */


// questions hardcoded
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
        setContentView(binding.getRoot());
        questions = new ArrayList<>();

        questions.add(new Question("Which of these chemical elements is heavier than iron?", "gold", "potassium", "carbon", "manganese", "gold"));
        questions.add(new Question("A baby blue whale drinks this many liters of milk per day:", "190", "250", "20", "50", "190"));
        questions.add(new Question("In physics, for every action there is an equal and opposite what?", "subtraction", "reaction", "distraction", "impaction", "reaction"));
        questions.add(new Question("Which of the following technological developments came first?", "teletype", "telephone", "telegraph", "telescope", "telescope"));
        questions.add(new Question("Moths are a member of what order?", "lepidoptera", "optica", "leprosy", "octagon", "lepidoptera"));
        questions.add(new Question("For what is the Jurassic period named?", "the French word for 'day'", "a soccer hero", "a mountain range", "a kind of dinosaur", "a mountain range"));
        questions.add(new Question("What kind of substance makes litmus paper turn blue?", "Base", "Alkali", "Acid", "Salt", "Alkali"));
        questions.add(new Question("Which of these particles was discovered by J.J. Thompson?", "Electron", "Neutron", "Proton", "Atom", "Electron"));
        questions.add(new Question("Which of these chemicals help fruit to ripen?", "Methane", "Carbon dioxide", "Nitrogen oxide", "Ethylene", "Ethylene"));
        questions.add(new Question("The layer of the atmosphere in which weather occurs is called the:", "Stratosphere", "Ionosphere", "Mesosphere", "Troposphere", "Troposphere"));
        questions.add(new Question("What is the International System of Units (SI) name for a unit of magnetic flux?", "Ampere", "Weber", "Coulomb", "Tesla", "Weber"));
        questions.add(new Question("Who is the only woman to have won two Nobel Prizes in two different fields?", "Irène Joliot-Curie", "Lise Meitner", "Ève Curie", "Marie Curie", "Marie Curie"));
        questions.add(new Question("Faraday is a unit of measurement for:", "Electricity", "Power", "Sound", "Temperature", "Electricity"));
        questions.add(new Question("How many laws are there in Kepler's planetary motion?", "3", "5", "7", "1", "3"));
        questions.add(new Question("This isotope of hydrogen is also known as heavy hydrogen:", "Protium", "Polonium", "Deuterium", "Tritium", "Deuterium"));


        reset_timer();
        setNextQuestion();
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