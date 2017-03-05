package org.sawhers.altafhussain.textviewediting;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_Combine,btn_Clear;
    EditText et_FirstName,et_Lastname;
    TextView tv_Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_Combine= (Button) findViewById(R.id.btn_combine);
        btn_Clear= (Button) findViewById(R.id.btn_clear);
        et_FirstName= (EditText) findViewById(R.id.et_firstname);
        et_Lastname= (EditText) findViewById(R.id.et_lastname);
        tv_Result= (TextView) findViewById(R.id.tv_result);
        btn_Combine.setOnClickListener(this);
        btn_Clear.setOnClickListener(this);

        btn_Clear.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    btn_Clear.setBackgroundColor(Color.DKGRAY);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    btn_Clear.setBackgroundColor(Color.BLUE);
                }
                return false;
            }

        });
        btn_Combine.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    btn_Combine.setBackgroundColor(Color.DKGRAY);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    btn_Combine.setBackgroundColor(Color.BLUE);
                }
                return false;
            }

        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_combine:
                //Toast.makeText(MainActivity.this,"combine",Toast.LENGTH_SHORT).show();
                String first=et_FirstName.getText().toString();
                String last=et_Lastname.getText().toString();
                if (TextUtils.isEmpty(first)){
                et_FirstName.setError("please enter your first name");
                    return;
                }
                if (TextUtils.isEmpty(last)){
                    et_Lastname.setError("please enter your last name");
                    return;
                }
                String full=first+" "+last;
                tv_Result.setText(""+full);

                break;
            case R.id.btn_clear:
                //Toast.makeText(MainActivity.this,"Clear",Toast.LENGTH_SHORT).show();
                et_FirstName.setText("");
                et_Lastname.setText("");
                tv_Result.setText("");
                break;

        }

    }
}
