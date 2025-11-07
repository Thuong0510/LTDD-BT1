package com.example.bt1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OddEvenActivity extends AppCompatActivity {

    private static final String TAG = "ArrayDemo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odd_even);

        EditText edtNumbers = findViewById(R.id.edtNumbers);
        Button btnProcess    = findViewById(R.id.btnProcess);
        TextView tvEven      = findViewById(R.id.tvEven);
        TextView tvOdd       = findViewById(R.id.tvOdd);

        btnProcess.setOnClickListener(v -> {
            String raw = edtNumbers.getText().toString().trim();
            if (raw.isEmpty()) {
                Toast.makeText(this, "Nhập dãy số trước đã bạn ơi!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Tách theo dấu phẩy hoặc khoảng trắng (1,2,3  4 5,6)
            String[] parts = raw.split("[,\\s]+");

            ArrayList<Integer> numbers = new ArrayList<>();
            for (String p : parts) {
                try {
                    if (p.isEmpty()) continue;
                    numbers.add(Integer.parseInt(p));
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Bỏ qua giá trị không hợp lệ: " + p, Toast.LENGTH_SHORT).show();
                }
            }

            if (numbers.isEmpty()) {
                Toast.makeText(this, "Không có số hợp lệ để xử lý.", Toast.LENGTH_SHORT).show();
                return;
            }

            ArrayList<Integer> even = new ArrayList<>();
            ArrayList<Integer> odd  = new ArrayList<>();
            for (int n : numbers) {
                if (n % 2 == 0) even.add(n); else odd.add(n);
            }

            // In Logcat
            Log.d(TAG, "Input   : " + numbers);
            Log.d(TAG, "Số chẵn : " + even);
            Log.d(TAG, "Số lẻ   : " + odd);

            // Hiển thị ra UI
            tvEven.setText("Số chẵn: " + even);
            tvOdd.setText("Số lẻ: " + odd);
        });
    }
}
