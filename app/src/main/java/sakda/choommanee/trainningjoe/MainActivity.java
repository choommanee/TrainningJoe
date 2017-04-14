package sakda.choommanee.trainningjoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Explicit
    private EditText userEditText, passwordEditText;
    private TextView textView;
    private Button button;
    private  String userString,passwordString;
    private boolean aBoolean = true;

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

        String tag = "14AprilV2";
        String urlGetUser = "http://swiftcodingthai.com/joe/getUserJoe.php";
        String truePassword = null;
        MessageAlert messageAlert = new MessageAlert(MainActivity.this);

        try {
            getUser getUser = new getUser(MainActivity.this);
            getUser.execute(urlGetUser);

            String strJson = getUser.get();
            Log.d(tag, "e Check User ==>" + strJson);

            JSONArray jsonArray = new JSONArray(strJson);
            for (int i=0;i<jsonArray.length();i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                if (userString.equals(jsonObject.getString("user"))) {
                    aBoolean = false;
                    truePassword = jsonObject.getString("password");
                }
            }
            // For

            if (aBoolean) {
                messageAlert.myDialog(getString(R.string.title_user_false),
                        getString(R.string.mess_user_false));
            } else if (passwordString.equals(truePassword)) {
                Intent intent = new Intent();
                startActivity(intent);
            } else {
                messageAlert.myDialog(getString(R.string.title_password_false),
                        getString(R.string.mess_password_false));
            }

        } catch (Exception e) {
            Log.d(tag, "e checkuser ==>" + e.toString());
        }

    }
}   //Main Class
