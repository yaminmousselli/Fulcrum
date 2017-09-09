package com.example.christhai.fulcrum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/** Represents the account activity page for security questions.
 * @author Team Atlas
 * @version 1.0
*/
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

        Spinner securityQuestionList = (Spinner) findViewById(R.id.security_question);
        EditText securityQuestionAnswer = (EditText) findViewById(R.id.security_question_answer);

        final CheckBox acceptTermsAndConditions = (CheckBox) findViewById(R.id.accept_terms_and_conditions);

        Button submit = (Button) findViewById(R.id.submit_registration);

        //TODO change this when we have the security questions
        String[] items = new String[]{"Question 1...", "Question 2...", "Question 3..."};  //This holds the different security questions
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        securityQuestionList.setAdapter(adapter);

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
