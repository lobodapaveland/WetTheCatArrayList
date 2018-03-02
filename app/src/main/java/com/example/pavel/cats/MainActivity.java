package com.example.pavel.cats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int numOfCats;

    private Button addNewCat;
    private Button wetTheCats;
    private Button getCurrentCatsCondition;

    private EditText name;

    private TextView catsNum;
    private TextView catsList;

    private static final String TAG = "myLogs";

    private ArrayList<String> cats = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addNewCat = (Button) findViewById(R.id.add_cat);
        wetTheCats = (Button) findViewById(R.id.wet);
        getCurrentCatsCondition = (Button) findViewById(R.id.get_cond);

        name = (EditText) findViewById(R.id.new_cat_name);

        catsNum = (TextView) findViewById(R.id.num);
        catsList = (TextView) findViewById(R.id.tv);

        addNewCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cats.add(name.getText().toString());
                Toast.makeText(MainActivity.this, name.getText() + " is added!", Toast.LENGTH_LONG).show();
                numOfCats = numOfCats+1;
               catsNum.setText(""+numOfCats+"");
            }
        });

        wetTheCats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int y=0; y<cats.size(); y++){
                    cats.set(y, "Weted");
                    Toast.makeText(MainActivity.this, "We are wetting cat number "+y+ " dont disturb!", Toast.LENGTH_LONG).show();
                    Log.d(TAG, cats.get(y));
                }
            }
        });

        getCurrentCatsCondition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int y=0; y<cats.size(); y++){
                    catsList.setText(catsList.getText().toString() + cats.get(y));
                    Log.d(TAG, cats.get(y));
                }
            }
        });

    }
}
