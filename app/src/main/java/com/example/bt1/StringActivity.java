package com.example.bt1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class StringActivity extends AppCompatActivity {

    EditText edtInput;
    Button btnProcess;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string);

        edtInput = findViewById(R.id.edtInput);
        btnProcess = findViewById(R.id.btnProcess);
        tvResult = findViewById(R.id.tvResult);

        btnProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = edtInput.getText().toString().trim();

                if (s.isEmpty()) {
                    Toast.makeText(StringActivity.this, "Vui lòng nhập chuỗi!", Toast.LENGTH_SHORT).show();
                    return;
                }

                String[] words = s.split("\\s+");

                StringBuilder reversed = new StringBuilder();
                for (int i = words.length - 1; i >= 0; i--) {
                    reversed.append(words[i]);
                    if (i != 0) reversed.append(" ");
                }

                String result = reversed.toString();

                tvResult.setText(result);

            }
        });
    }
}
