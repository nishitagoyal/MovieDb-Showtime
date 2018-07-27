package com.example.goyal.showtime;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EnterDeActivity extends AppCompatActivity {

    Button button;
    Intent intent1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        intent1 = new Intent(EnterDeActivity.this,MainFragment.class);
        if(!isFirstTimeStartApp()){
            setFirstTimeStartStatus(true);
            startActivity(intent1);
            finish();
        }
        setContentView(R.layout.activity_enter_de);
        button = findViewById(R.id.start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFirstTimeStartStatus(true);
                startActivity(intent1);
                finish();
            }
        });

    }
    private boolean isFirstTimeStartApp(){

        SharedPreferences ref = getApplicationContext().getSharedPreferences("IntroSliderApp", Context.MODE_PRIVATE);
        return ref.getBoolean("FirstTimeStartFlag",true);

    }
    private void setFirstTimeStartStatus(boolean stt){
        SharedPreferences ref = getApplicationContext().getSharedPreferences("IntroSliderApp",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = ref.edit();
        editor.putBoolean("FirstTimeStartFlag",stt);
        editor.commit();

    }
}