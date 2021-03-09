package ru.pavelzhakov.simpletimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextNumber);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();

                if (!text.equalsIgnoreCase("")) {
                    Log.d("tester", "Seconds: " + text);
                    int sedonds = Integer.valueOf(text);
                    CountDownTimer countDownTimer = new CountDownTimer(sedonds * 1000, 1000) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            textView.setText("seconds: " + (int) millisUntilFinished / 1000);
                        }

                        @Override
                        public void onFinish() {
                            textView.setText("Finished");
                        }
                    };
                    countDownTimer.start();
                }
            }
        });
    }
}