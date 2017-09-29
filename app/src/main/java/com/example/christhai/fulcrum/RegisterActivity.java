package com.example.christhai.fulcrum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_register);

        //There is no logic to check anything yet, since we will handle this when we set up the database
        EditText firstName = (EditText) findViewById(R.id.first_name_registration);
        EditText lastName = (EditText) findViewById(R.id.last_name_registration);
        EditText email = (EditText) findViewById(R.id.email_registration);
        EditText password = (EditText) findViewById(R.id.password_registration);
        EditText confirmPassword = (EditText) findViewById(R.id.confirm_pw_registration);

        DatePicker birthday = (DatePicker) findViewById(R.id.birthday);
        Spinner sexList = (Spinner) findViewById(R.id.sex);
        EditText height = (EditText) findViewById(R.id.height);
        EditText weight = (EditText) findViewById(R.id.weight);

        Spinner securityQuestionList = (Spinner) findViewById(R.id.security_question);
        EditText securityQuestionAnswer = (EditText) findViewById(R.id.security_question_answer);

        final CheckBox acceptTermsAndConditions = (CheckBox) findViewById(R.id.accept_terms_and_conditions);
        TextView terms_and_conditions = (TextView) findViewById(R.id.Terms_and_Conditions_Link_Registration);

        Button submit = (Button) findViewById(R.id.submit_registration);

        String[] sexes = new String[]{"Male", "Female"};  //This holds the different sexes
        ArrayAdapter<String> sexAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, sexes);
        sexList.setAdapter(sexAdapter);

        //TODO change this when we have the security questions
        String[] questions = new String[]{"Question 1...", "Question 2...", "Question 3..."};  //This holds the different security questions
        ArrayAdapter<String> secQuestionAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, questions);
        securityQuestionList.setAdapter(secQuestionAdapter);

        /*terms_and_conditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TermsAndConditionsActivity.class);
                startActivity(intent);
            }
        });*/

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (acceptTermsAndConditions.isChecked()){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
