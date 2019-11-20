package com.example.sharecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddSteps extends AppCompatActivity {

    String step;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_steps);


        Intent intent = getIntent();
        if(intent.getStringExtra("step") != null) {
            step = intent.getStringExtra("step");
            TextView step1 = findViewById(R.id.tvStep);
            if(step !=null)
            step1.setText(step);
        }


        Button bDone = findViewById(R.id.bRecipeDone);
        final Intent iDone = new Intent(this,PostRecipe.class);
        bDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(iDone);
            }
        });

        Button bAdd = findViewById(R.id.bAdd);
        final Intent iStep= new Intent(this,StepEditor.class);
        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                iStep.putExtra("step",step);
                startActivity(iStep);
            }
        });

    }


}
