package com.example.myapplication1;

import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnStart;
    private TextView tvTextValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart=findViewById(R.id.btnStartActivity );
        tvTextValue =findViewById(R.id.tvText);
        btnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnStartActivity){
            Intent intent = new Intent (this, CalcActivity.class);
            activityResultLaunch.launch(intent);
        }
    }
    ActivityResultLauncher<Intent> activityResultLaunch = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
    @Override
      public void onActivityResult(ActivityResult result)  {
        if (result.getData() != null) {
                int res = result.getData().getIntExtra("data", 0);
                Log.d("simple_app_tag", "Result: " + res);
                tvTextValue.setText("Разность чисел: " + res);
            }
        }
    });

            }



