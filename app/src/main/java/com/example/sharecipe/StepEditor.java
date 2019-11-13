package com.example.sharecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StepEditor extends AppCompatActivity {

    String step;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_editor);

        Button bStepDone = findViewById(R.id.bStepDone);
        final Intent stepDone = new Intent(this,AddSteps.class);
        final EditText etStep = findViewById(R.id.etTheStep);

        Intent intent = getIntent();

        if(intent.getStringExtra("step") != null) {
            step = intent.getStringExtra("step");
        }



        bStepDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String total;
                if(step != null)
                    total = step + "\nStep: "+etStep.getText().toString();
                else
                    total = "Step: "+etStep.getText().toString();
                stepDone.putExtra("step",total);
                startActivity(stepDone);
            }
        });

    }
}
