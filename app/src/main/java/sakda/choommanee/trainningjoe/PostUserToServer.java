package sakda.choommanee.trainningjoe;

import android.content.Context;
import android.os.AsyncTask;
import android.speech.tts.Voice;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by sakdachoommanee on 4/14/2017 AD.
 */

public class PostUserToServer extends AsyncTask<Void,Void,String>{

    private Context context;
    private  String nameString,userString,passwordString, urlAdduser;


    public PostUserToServer(Context context,
                            String nameString,
                            String userString,
                            String passwordString,
                            String urlAdduser) {
        this.context = context;
        this.nameString = nameString;
        this.userString = userString;
        this.passwordString = passwordString;
        this.urlAdduser = urlAdduser;
    }

    @Override
    protected String doInBackground(Void... params) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd","true")
                    .add("Name",nameString)
                    .add("User",userString)
                    .add("Password",passwordString)
                    .build();

            Request.Builder builder  = new Request.Builder();
            Request request = builder.url(urlAdduser).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
            Log.d("14AprilV1", "e doIn==>" + e.toString());
            return null;
        }


    }
}       //Main Class
