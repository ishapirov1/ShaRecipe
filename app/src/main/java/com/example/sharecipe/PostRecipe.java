package com.example.sharecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class PostRecipe extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String spinnerText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_recipe);

        Spinner spinnerTime = findViewById(R.id.spinnerTime);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Time, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTime.setAdapter(adapter);
        spinnerTime.setOnItemSelectedListener(this);

        Button bIngredients = findViewById(R.id.bIngredients);
        final Intent ingredientsIntent = new Intent(this,PostIngredients.class);

        bIngredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ingredientsIntent);
            }
        });

        Button bWrite = findViewById(R.id.bWrite);
        final Intent addStepsIntent = new Intent(this,AddSteps.class);

        bWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(addStepsIntent);
            }
        });

        Button bPostRecipe = findViewById(R.id.bPostRecipe);

        final Intent i = new Intent(this,FinalRecipeInfo.class);
        bPostRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinnerText = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
