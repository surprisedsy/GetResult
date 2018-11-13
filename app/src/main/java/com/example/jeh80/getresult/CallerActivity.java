package com.example.jeh80.getresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CallerActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_CALLEEACTIVITY = 1;
    private static final int REQUEST_CODE_DIALOGACTIVITY = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caller);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CallerActivity.this, CalleeActivity.class);
                startActivityForResult(intent, REQUEST_CODE_CALLEEACTIVITY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        switch (requestCode) {
            case REQUEST_CODE_CALLEEACTIVITY: {
                if(resultCode == Activity.RESULT_OK) {
                    int dataNumber = intent.getIntExtra("data-number", -1);
                    String dataString = intent.getStringExtra("data-string");

                    String data = "data number: " + dataNumber + " dataString: " + dataString;
                    TextView textView = findViewById(R.id.textView3);
                    textView.setText(data);

                } else {
                    Log.d("MainActivity", "Result Cancel");     // button이 두 개 있을때 cancle이 된 경우. 지금은 안만들어서 없음
                }
                break;
            }
            case REQUEST_CODE_DIALOGACTIVITY: {
                break;
            }
            default: {
                break;
            }
        }
    }
}
