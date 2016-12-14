package com.example.android.applicationhorsequiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score;
    boolean question1;
    boolean question2;
    String question3;
    boolean question4;
    boolean question5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //** Question 1 answers if mare and gelding are selected the score is 1 and if any other combination are selected no soore is given**//
    private void question_1(View view) {
        CheckBox mareCheckBox = (CheckBox) findViewById(R.id.mare_checkbox);
        boolean mareRightAnswer = mareCheckBox.isChecked();
        CheckBox geldingCheckBox = (CheckBox) findViewById(R.id.gelding_checkbox);
        boolean geldingRightAnswer = geldingCheckBox.isChecked();
        CheckBox jackCheckBox = (CheckBox) findViewById(R.id.jack_checkbox);
        boolean jackWrongAnswer = jackCheckBox.isChecked();
        CheckBox jennyCheckBox = (CheckBox) findViewById(R.id.jenny_checkbox);
        boolean jennyWrongAnswer = jennyCheckBox.isChecked();
        question1 = mareRightAnswer && geldingRightAnswer && !jackWrongAnswer && !jennyWrongAnswer;
    }

    //** Question 2 answers the false statement must be checked to be considered correct**//
    private void question_2(View view) {
        RadioButton no = (RadioButton) findViewById(R.id.false_radio_button);
        question2 = no.isChecked();
    }

    //**Question 3 answer takes in the users input**//
    private void question_3(View view) {
        EditText questionInput = (EditText) findViewById(R.id.user_input);
        question3 = questionInput.getText().toString().trim();
    }

    //**Question 4 answer is foal**//
    private void question_4(View view) {
        RadioButton foal = (RadioButton) findViewById(R.id.foal_radio_button);
        question4 = foal.isChecked();
    }

    //**Question 5 answer is frog**//
    private void question_5(View view) {
        RadioButton frog = (RadioButton) findViewById(R.id.frog_radio_button);
        question5 = frog.isChecked();
    }

    //** Calculates the score of the questions**//
    public void calculateScore(View view) {
        //**initializing score to 0**//
        score = 0;
        question_1(view);
        question_2(view);
        question_3(view);
        question_4(view);
        question_5(view);

        if (question1) {
            score++;
        }
        if (question2) {
            score++;
        }
        if (question3.equalsIgnoreCase("Herds")) {
            score++;
        }
        if (question4) {
            score++;
        }
        if (question5) {
            score++;
        }
        if (score > 0) { //creates pop up when you submit the scores if there is at least 1 question correct//
            Toast.makeText(this, "Your score is " + score + " out of 5", Toast.LENGTH_SHORT).show();
        }
        if (score == 0) { //creates a pop up when you submit the answers AND there are no correct answers//
            Toast.makeText(this, "Your score is 0 out of 5 Please Try Again", Toast.LENGTH_SHORT).show();
        }

    }
}




