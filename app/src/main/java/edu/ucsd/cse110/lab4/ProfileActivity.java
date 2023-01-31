package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        loadProfile();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveProfile();
    }

    public void loadProfile() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        String nameBase = preferences.getString("name", "");
        String statusBase = preferences.getString("status", "");
        EditText name = (EditText)findViewById(R.id.name_textview);
        EditText status = (EditText)findViewById(R.id.status_textview);
        name.setText(nameBase);
        status.setText(statusBase);
    }

    public void saveProfile() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        EditText name = (EditText)findViewById(R.id.name_textview);
        EditText status = (EditText)findViewById(R.id.status_textview);
        editor.putString("name", name.getText().toString());
        editor.putString("status", status.getText().toString());
        editor.apply();
    }

    public void onGoBackClicked(View view) {
        finish();
    }
}