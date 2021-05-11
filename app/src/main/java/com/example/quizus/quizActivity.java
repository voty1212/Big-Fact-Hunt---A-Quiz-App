package com.example.quizus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
/*
 //fetching questions using database
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
    ArrayList<Question> questionScience, questionMaths, questionGk, questionHistory, questions;
    int index = 0;
    Question question;
    CountDownTimer timer;
    int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        questionScience = new ArrayList<>();
        questionMaths = new ArrayList<>();
        questionGk = new ArrayList<>();
        questionHistory = new ArrayList<>();

        questionScience.add(new Question("Which of these chemical elements is heavier than iron?", "gold", "potassium", "carbon", "manganese", "gold"));
        questionScience.add(new Question("A baby blue whale drinks this many liters of milk per day:", "190", "250", "20", "50", "190"));
        questionScience.add(new Question("In physics, for every action there is an equal and opposite what?", "subtraction", "reaction", "distraction", "impaction", "reaction"));
        questionScience.add(new Question("Which of the following technological developments came first?", "teletype", "telephone", "telegraph", "telescope", "telescope"));
        questionScience.add(new Question("Moths are a member of what order?", "lepidoptera", "optica", "leprosy", "octagon", "lepidoptera"));
        questionScience.add(new Question("For what is the Jurassic period named?", "the French word for 'day'", "a soccer hero", "a mountain range", "a kind of dinosaur", "a mountain range"));
        questionScience.add(new Question("What kind of substance makes litmus paper turn blue?", "Base", "Alkali", "Acid", "Salt", "Alkali"));
        questionScience.add(new Question("Which of these particles was discovered by J.J. Thompson?", "Electron", "Neutron", "Proton", "Atom", "Electron"));
        questionScience.add(new Question("Which of these chemicals help fruit to ripen?", "Methane", "Carbon dioxide", "Nitrogen oxide", "Ethylene", "Ethylene"));
        questionScience.add(new Question("The layer of the atmosphere in which weather occurs is called the:", "Stratosphere", "Ionosphere", "Mesosphere", "Troposphere", "Troposphere"));
        questionScience.add(new Question("What is the International System of Units (SI) name for a unit of magnetic flux?", "Ampere", "Weber", "Coulomb", "Tesla", "Weber"));
        questionScience.add(new Question("Who is the only woman to have won two Nobel Prizes in two different fields?", "Irène Joliot-Curie", "Lise Meitner", "Ève Curie", "Marie Curie", "Marie Curie"));
        questionScience.add(new Question("Faraday is a unit of measurement for:", "Electricity", "Power", "Sound", "Temperature", "Electricity"));
        questionScience.add(new Question("How many laws are there in Kepler's planetary motion?", "3", "5", "7", "1", "3"));
        questionScience.add(new Question("This isotope of hydrogen is also known as heavy hydrogen:", "Protium", "Polonium", "Deuterium", "Tritium", "Deuterium"));

        questionMaths.add(new Question("In poker, what are the odds of drawing a royal flush?","327,123 to 1","649,740 to 1","1,243,961 to 1","1,704,199 to 1","649,740 to 1"));
        questionMaths.add(new Question("What is the best way to represent a subset?","pie chart","Venn diagram","table","exploding diagram","Venn diagram"));
        questionMaths.add(new Question("In Roman numerals, what is represented by the letter C?","1,000","100","10","50","100"));
        questionMaths.add(new Question("What is a polygon with three sides called?","rectangle","square","parallelogram","triangle","triangle"));
        questionMaths.add(new Question("Find the missing terms in multiple of 3: 3, 6, 9, __, 15","10","11","12","13","12"));
        questionMaths.add(new Question("What is the next prime number after 5?","6","7","9","11","7"));
        questionMaths.add(new Question("In triangle ABC, if AB=BC and ∠B = 70°, ∠A will be:","70","110","55","130","55"));
        questionMaths.add(new Question("If ABC and DBC are two isosceles triangles on the same base BC. Then:","∠ABD = ∠ACD","∠ABD = ∠ACD","∠ABD < ∠ACD","None of the above","∠ABD = ∠ACD"));
        questionMaths.add(new Question("The sum of all the angles of a quadrilateral is equal to:___ degrees","180","270","360","90","360"));
        questionMaths.add(new Question("A rhombus can be a:","Parallelogram","Parallelogram","Kite","Square","Square"));
        questionMaths.add(new Question(" If ABCD is a trapezium in which AB || CD and AD = BC, then:","∠A = ∠B","∠A > ∠B","∠A < ∠B"," None of the above","∠A = ∠B"));
        questionMaths.add(new Question("The probability of each event lies between:","1 & 2","1 & 10","0 & 1","0 & 5","0 & 1"));
        questionMaths.add(new Question("If P(E) = 0.44, then P(not E) will be:","0.44","0.55","0.50","0.56","0.56"));
        questionMaths.add(new Question(" x2-2x+1 is a polynomial in:","One Variable","Two Variables","Three Variables","None of the above","One Variable"));
        questionMaths.add(new Question(" A binomial of degree 20 in the following is:","20x + 1","x/20 + 1","x^20 +1","x2+20","x^20 +1"));

        questionGk.add(new Question("The book, ‘Dalits in India: A Profile,’ was written by …","Amitabh Bagchi"," Vikram Seth","Sukhadeo Thorat"," Amitabh Ghosh","Sukhadeo Thorat"));
        questionGk.add(new Question("Which among the following is the nearest to earth planet?","Mercury","Venus","Mars","Neptune","Venus"));
        questionGk.add(new Question("National Sugar Research Institute is located in …","Kanpur","Dhanbad","Karnal","Lucknow","Kanpur"));
        questionGk.add(new Question("National Emblem of the United States is ……….","Kangaroo","White Lily","Rose","Lily","Rose"));
        questionGk.add(new Question("The trophy ‘Amrit Diwan Cup’ is related to …","Hockey","Badminton","Football","Basketball","Badminton"));
        questionGk.add(new Question("The First Modern Olympics were played in …","1896","1866","1826","1926","1896"));
        questionGk.add(new Question("Which among the following is popular as Pillars of Hercules?","English Channel","Leaning Tower","Eiffel Tower","Strait of Gibraltar","Strait of Gibraltar"));
        questionGk.add(new Question("Pentagon is located in …","UK","USA","Russia","Italy","USA"));
        questionGk.add(new Question("Atomic Energy Commission is located in …","Jadugoda","Mumbai","Trombay","Hyderabad","Mumbai"));
        questionGk.add(new Question("Which among the following was the first city attacked by atom bomb?","Hiroshima","Nagasaki","Yokohoma","Kawasaki","Hiroshima"));
        questionGk.add(new Question("Air Defence Guided Missiles School is located in …","Kolkata","Bengaluru","Gopalpur","Guindy","Gopalpur"));
        questionGk.add(new Question("The playing area of Archery is known as …","Rink","Track","Ring","Range","Range"));
        questionGk.add(new Question("Ctrl, Shift and Alt are called .......... keys.","modifier","function","alphanumeric","adjustment","modifier"));
        questionGk.add(new Question("The tropic of cancer does not pass through which of these Indian states ?","Madhya Pradesh","West Bengal","Rajasthan","Odisha","Odisha"));
        questionGk.add(new Question("Fathometer is used to measure","Earthquakes","Rainfall","Ocean depth","Sound intensity","Ocean depth"));

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
                String s1 = "maths";
                String s2 = "science";
               // String s3 = "history";
                String s4 = "gk";
                final String catId = getIntent().getStringExtra("catId");

                if(s1.equals(catId))
                {
                    questions = questionMaths;
                }
                if(s2.equals(catId))
                {
                    questions = questionScience;
                }
                if(s4.equals(catId))
                {
                    questions = questionGk;
                }

                    if (index < questions.size()) {
                        binding.questionCounter.setText(String.format("%d/%d", (index + 1), (questions.size())));
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
                    correctAnswers++;
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
                       // Toast.makeText(this, "Option Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nextBtn:
                        reset();
                        if(index < questions.size()-1) {
                            index++;
                            setNextQuestion();
                        } else {
                            Intent intent = new Intent(quizActivity.this, resultActivity.class);
                            intent.putExtra("correct",correctAnswers);
                            intent.putExtra("total", questions.size());
                            startActivity(intent);
                           // Toast.makeText(this, "Quiz Ended", Toast.LENGTH_SHORT).show();
                        }
                        break;


                }
            }
        }
