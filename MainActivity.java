package choudhary.shuvam.encrypt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private  int counter=3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name=(EditText)findViewById(R.id.etName);
        Password=(EditText)findViewById(R.id.etPassword);
        Info=(TextView)findViewById(R.id.tvinfo);
        Login=(Button)findViewById(R.id.btnLogin);
        Info.setText("No of attempt remaining:->3");
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });

    }
    private void  validate(String userName,String userPassword)
    {
        if((userName.equals("shub")) && (userPassword.equals("1234")))
        {
            Intent intent=new Intent(MainActivity.this, Secound_activity.class);
            startActivity(intent);
        }

        else {
            counter--;
            Info.setText("No of attemots remaining:" + String.valueOf(counter));
        }
        if(counter == 0)
        {
            Login.setEnabled(false);
        }
    }

}
