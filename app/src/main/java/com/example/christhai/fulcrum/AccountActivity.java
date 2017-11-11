package com.example.christhai.fulcrum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/** Represents the account settings page and stores account information.
 * @author Team All-Star
 * @version 1.0
*/
public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_account);

        //TODO make it so this can access the user's info and edit it when the database is running
        TextView email = (TextView) findViewById(R.id.email_account_page);
        TextView password = (TextView) findViewById(R.id.password_account_page);

        Button deleteAccount = (Button) findViewById(R.id.delete_account);

        Button save = (Button) findViewById(R.id.save_account);

        //TODO implement this when we get the database running
        /*
        deleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        */

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(intent);
            }
        });
    }
}
