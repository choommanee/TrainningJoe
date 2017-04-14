package sakda.choommanee.trainningjoe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by sakdachoommanee on 4/14/2017 AD.
 */

public class FoodAdapter extends BaseAdapter{

    private Context context;
    private String[] foodString,priceString, iconString;
    private TextView foodTextView, priceTextView;
    private ImageView iconImageView;

    public FoodAdapter(Context context,
                       String[] foodString,
                       String[] priceString,
                       String[] iconString) {
        this.context = context;
        this.foodString = foodString;
        this.priceString = priceString;
        this.iconString = iconString;
    }

    @Override
    public int getCount() {
        return foodString.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.food_layout, parent, false);

        //Initial View
        foodTextView = (TextView) view1.findViewById(R.id.txtFood);
        priceTextView = (TextView) view1.findViewById(R.id.txtPrice);
        iconImageView = (ImageView) view1.findViewById(R.id.ImvIcon);


        //Show View
        foodTextView.setText(foodString[position]);
        priceTextView.setText(priceString[position]);


        // Add Libs and Extract ->app->depentence
        Picasso.with(context).load(iconString[position]).into(iconImageView);

        return view1;
    }
}       //Main Class
