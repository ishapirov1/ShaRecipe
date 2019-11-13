package com.example.sharecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PostIngredients extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_ingredients);

        final EditText etName = findViewById(R.id.etName);
        final EditText etQty = findViewById(R.id.etQuantity);
        final EditText etUnit = findViewById(R.id.etUnit);

        final Intent goBack = new Intent(this,PostRecipe.class);

        Button bAdd = findViewById(R.id.bAdd);

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = new TextView(PostIngredients.this);
                tv.setWidth(20);
                tv.setHeight(20);
                tv.setText("Test");
            }
        });

        Button bDone = findViewById(R.id.bRecipeDone);

        bDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ingredient = etName.getText().toString();
                String quantity = etQty.getText().toString();
                String units = etUnit.getText().toString();

                startActivity(goBack);
            }
        });

    }
}
