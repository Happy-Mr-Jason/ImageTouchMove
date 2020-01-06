package com.example.imagetouchmove;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout layoutMain;
    Button btn1;
    ImageView ivBlue, ivRed, ivGreen, ivYellow;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutMain = findViewById(R.id.layoutMain);
        btn1 = findViewById(R.id.btn1);
        ivBlue = findViewById(R.id.ivBlue);
        ivRed = findViewById(R.id.ivRed);
        ivGreen = findViewById(R.id.ivGreen);
        ivYellow = findViewById(R.id.ivYellow);

        btn1.setOnTouchListener(new MyTouchListener());
        ivBlue.setOnTouchListener(new MyTouchListener());
        ivRed.setOnTouchListener(new MyTouchListener());
        ivGreen.setOnTouchListener(new MyTouchListener());
        ivYellow.setOnTouchListener(new MyTouchListener());

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "버튼 눌렸다", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
