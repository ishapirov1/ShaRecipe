package com.example.sharecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StepEditor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_editor);

        Button bStepDone = findViewById(R.id.bStepDone);
        final Intent stepDone = new Intent(this,AddSteps.class);
        final EditText step = findViewById(R.id.etTheStep);




        bStepDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stepDone.putExtra("step",step.getText().toString());
                startActivity(stepDone);
            }
        });

    }
}
