package com.example.android.calculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class activity_answer extends AppCompatActivity {
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_answer);
            String value;
            value = Objects.requireNonNull(getIntent().getExtras()).getString("key");
            TextView message = (TextView) findViewById(R.id.ans);
            message.setText(value);
        }

}
