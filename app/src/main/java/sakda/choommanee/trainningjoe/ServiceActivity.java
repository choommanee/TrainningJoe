package sakda.choommanee.trainningjoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        try {

            String urlPhp = "http://swiftcodingthai.com/joe/getFood.php";
            getUser getUser = new getUser(ServiceActivity.this);
            getUser.execute(urlPhp);
            String strJson = getUser.get();

            Log.d("14aprilV2","Json ==> "+strJson);

            JSONArray jsonArray = new JSONArray(strJson);
            final String[] foodString = new String[jsonArray.length()];
            final String[] priceString = new String[jsonArray.length()];
            String[] iconString = new String[jsonArray.length()];


            for (int i=0;i<jsonArray.length();i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                foodString[i] = jsonObject.getString("Food");
                priceString[i] = jsonObject.getString("Price");
                iconString[i] = jsonObject.getString("Source");

            }


            //Create Listview
            FoodAdapter foodAdapter = new FoodAdapter(ServiceActivity.this,
                    foodString, priceString, iconString);

            ListView listView = (ListView) findViewById(R.id.livFood);
            listView.setAdapter(foodAdapter);

            //Active Listview
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(ServiceActivity.this,
                            foodString[position]+"\n ราคา"+priceString[position]+" THB." ,
                            Toast.LENGTH_SHORT).show();
                }
            });


        } catch (Exception e) {
            Log.d("14aprilV2","e Service==>"+e.toString());
        }
    }      //Main Method


}       //Main Class
