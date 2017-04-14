package sakda.choommanee.trainningjoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Explicit
    private EditText userEditText, passwordEditText;
    private TextView textView;
    private Button button;
    private  String userString,passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // innitial view

        initialView();

        //Controller
        controller();
    }   //Main Method

    private void controller() {
        textView.setOnClickListener(MainActivity.this);
        button.setOnClickListener(MainActivity.this);
    }

    private void initialView() {
        userEditText = (EditText) findViewById(R.id.edtUser);
        passwordEditText = (EditText) findViewById(R.id.edtPassword);
        textView = (TextView) findViewById(R.id.txtRegister);
        button = (Button) findViewById(R.id.btnLogin);

    }

    @Override
    public void onClick(View view) {

        //For Textview
        if (view == textView) {
            Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
            startActivity(intent);   // Open new Form to mainActivity Main

        }

        //For Buttom
        if (view == button) {
            // get Value from Edit Text

            userString = userEditText.getText().toString().trim();
            passwordString = passwordEditText.getText().toString().trim();

            //Check Space
            MessageAlert messageAlert = new MessageAlert(MainActivity.this);
            if ((userString.length() == 0) || (passwordString.length() == 0)) {
                //have space
                messageAlert.myDialog(getResources().getString(R.string.havespave),
                        getResources().getString(R.string.message_have_space));

            } else {
                //No Space

                checkUserAndPass();
            }
        }
    }

    private void checkUserAndPass() {

    }
}   //Main Class
