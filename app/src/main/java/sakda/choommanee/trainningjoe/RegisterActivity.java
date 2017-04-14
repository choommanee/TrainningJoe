package sakda.choommanee.trainningjoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    // Explicit
    EditText nameEditText,userEditText, passwordEditText;
    Button button;


    String nameString,userString, passwordString;
    String urlAdd = "http://swiftcodingthai.com/joe/addUserJoe.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        //Initial View
        initialView();

        //Button Controller
        buttonController();
    }   // Main Method

    private void buttonController() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Get Value From Edit
                nameString = nameEditText.getText().toString().trim();
                userString = userEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();


                //Check Space
                if (checkSpace()) {
                    //Have space
                    MessageAlert MessageAlert = new MessageAlert(RegisterActivity.this);
                    MessageAlert.myDialog(getString(R.string.havespave),
                                getString(R.string.message_have_space));
                } else {
                    // No Space
                    uploadValueToServer();

                }


            }   //OnClick
        });
    }

    private void uploadValueToServer() {

        try {
            PostUserToServer postUserToServer = new PostUserToServer(RegisterActivity.this,
            nameString,userString,passwordString,urlAdd);

            postUserToServer.execute();
            Log.d("14aprilV1","Response==>"+postUserToServer.get());
            if (Boolean.parseBoolean(postUserToServer.get())) {
                finish();
            } else {
                Toast.makeText(RegisterActivity.this,"Cannot Save User Data",Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {
            Log.d("14ApilV1","e upload==>"+e.toString());
        }

    }

    private boolean checkSpace() {
        boolean result = false;

        if (nameString.equals("") || userString.equals("") || passwordString.equals("")) {
            // have Space
            result = true;
        } else {
            result = false;
            // No Space
        }

        return result;
    }

    private void initialView() {
        nameEditText = (EditText) findViewById(R.id.edtName);
        userEditText = (EditText) findViewById(R.id.edtUser);
        passwordEditText = (EditText) findViewById(R.id.edtPassword);

        button = (Button) findViewById(R.id.btnRegister);
    }


}  //Main Class
