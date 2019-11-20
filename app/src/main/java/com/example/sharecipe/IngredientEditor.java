package com.example.sharecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.lang.reflect.Array;

public class IngredientEditor extends AppCompatActivity{

    String prev;
    String name;
    String quan;
    String unit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_editor);

        final EditText ingQuantity = findViewById(R.id.etIngQuantity);
        final EditText ingName = findViewById(R.id.etIngName);
        final EditText ingUnit = findViewById(R.id.etIngUnit);

        Intent intent = getIntent();
        if(intent.getStringExtra("ingredients") != null)
        prev = intent.getStringExtra("ingredients");

        Button bIngDone = findViewById(R.id.bIngDone);
        final Intent ingDone = new Intent(this,PostIngredients.class);
        bIngDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = ingName.getText().toString();
                unit = ingUnit.getText().toString();
                quan = ingQuantity.getText().toString();
                String total;
                if(prev != null)
                   total = prev + "\n"+name+"                     "+quan+"                "+unit;
                else
                    total = name+"                     "+quan+"                "+unit;
                ingDone.putExtra("ingred",total);
                startActivity(ingDone);
            }
        });

    }

}
