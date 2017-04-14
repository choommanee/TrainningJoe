package sakda.choommanee.trainningjoe;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Created by sakdachoommanee on 4/14/2017 AD.
 */

public class getUser extends AsyncTask<String,Void,String>{
    private Context context;

    public getUser(Context context) {
        this.context = context;


    }

    @Override
    protected String doInBackground(String... params) {

        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder  builder = new Request.Builder();
            Request request = builder.url(params[0]).build();

            Response response = okHttpClient.newCall(request).execute();

            return response.body().string();

        } catch (Exception e) {
            Log.d("14ApirV2","E DoIn ==>"+e.toString());
            return null;
        }

    }
}
