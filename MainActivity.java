package com.example.tayo.integerdivisionapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;
//Basically, i had to declare all my variables within the activity class,
//i went on to convert convert the inputted text from the UI to String variables
//i created a listener method for the button, so to return the solution once clicked
//then created a constructor div with two instance variables to return the solution

//the application still hangs when the quotient is about to be returned, but runs well when the entire div is commented out


public class MainActivity extends AppCompatActivity {
    EditText E1;
    EditText E2;
    Button b1;
    //String answer;
    TextView t1, t2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        E1 = (EditText)findViewById(R.id.editText3);
        E2 = (EditText)findViewById(R.id.editText4);
        t1 = (TextView)findViewById(R.id.textView3);
        t2 = (TextView)findViewById(R.id.textView4);
        b1 = (Button)findViewById(R.id.button);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(E1.getText().toString());
                int den = Integer.parseInt(E2.getText().toString());
                int result = div(num, den);
                int result2 = mod(num, den);
                t1.setText(Integer.toString(result));
                t2.setText(Integer.toString(result2));

            }
        });

    }

    public static int div(int x, int y) {
        //check if denominator is zero
        if (y == 0) {
            return Integer.MAX_VALUE;
            //Toast.makeText(MainActivity.this, "Error: Denominator is le zero!", Toast.LENGTH_LONG).show();
        }
        //set range for result [left, right]
        //right is set to infinity
        //when y<1, x<result<Double.MAX_VALUE
        int left = 0, right = Integer.MAX_VALUE;
        //set accuracy of the result
        int precision = 1;

        //store sign of the result
        int sign = 1;
        if ((x * y) < 0){
            sign = -1;
        }

        //make both input numbers positive
        x = Math.abs(x);
        y = Math.abs(y);

        while(true){
            //calculate mid value
            int mid = left + ((right-left)/2);

            //if y*mid is almost equal to x, return mid
            if (Math.abs(y*mid-x)<= precision){
                int d = mid*sign;
                return d;
            }

            //if y*mid is less than x, update left to mid
            if((y*mid) < x){
                left = mid;
            }

            //if y*mid is greater than x, update right to mid
            if((y*mid) < x){
                right = mid;
            }
        }
    }
    public static int mod (int a, int b){
        int rem = a%b;
        return rem;

    }



}
