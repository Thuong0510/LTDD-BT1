package com.example.bt1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;

public class OddEvenActivity extends AppCompatActivity {
    private static final String TAG = "ArrayDemo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odd_even);

        TextView tvEven = findViewById(R.id.tvEven);
        TextView tvOdd  = findViewById(R.id.tvOdd);

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 11, 20, 33));
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd  = new ArrayList<>();

        for (int n : numbers) {
            if (n % 2 == 0) even.add(n);
            else odd.add(n);
        }

        Log.d(TAG, "Số chẵn: " + even);
        Log.d(TAG, "Số lẻ: " + odd);

        tvEven.setText("Số chẵn: " + even);
        tvOdd.setText("Số lẻ: " + odd);
    }
}
