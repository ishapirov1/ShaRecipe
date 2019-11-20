package com.example.sharecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PostIngredients extends AppCompatActivity {

    String ingredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_ingredients);

        final TextView etName = findViewById(R.id.etTheIngedients);


        final Intent goBack = new Intent(this,PostRecipe.class);
        final Intent ingEdit = new Intent(this,IngredientEditor.class);
        Button bAdd = findViewById(R.id.bAdd);


        Intent intent = getIntent();
        if(intent.getStringExtra("ingred") != null) {
            ingredients = intent.getStringExtra("ingred");
            if(ingredients != null)
            etName.setText(ingredients);
        }

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingEdit.putExtra("ingredients",ingredients);
                startActivity(ingEdit);
            }
        });

        Button bDone = findViewById(R.id.bRecipeDone);

        bDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(goBack);
            }
        });

    }
}
