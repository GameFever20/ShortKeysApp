package utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import app.key.ashort.craftystudio.shortkeysapp.R;

/**
 * Created by Aisha on 12/29/2017.
 */

public class ShortKeyDetailListAdapter extends ArrayAdapter {

    ArrayList<KeyBoardShortcut> mSHortKeyList;
    Context mContext;

    int mResourceID;


    public ShortKeyDetailListAdapter(@NonNull Context context, int resource, ArrayList<KeyBoardShortcut> arrayList) {
        super(context, resource);
        this.mSHortKeyList = arrayList;
        this.mContext = context;
        this.mResourceID = resource;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.custom_shortkey_textview, null, false);
        }
        //getting the view
        //  View view = layoutInflater.inflate(mResourceID, null, false);


        TextView shortKeyCodeTextview = (TextView) convertView.findViewById(R.id.custom_shortkey_code_textview);
        shortKeyCodeTextview.setText((String) mSHortKeyList.get(position).getShortKeyCode());


        TextView shortKeyExplainationTextview = (TextView) convertView.findViewById(R.id.custom_shortkey_explaination_textview);
        shortKeyExplainationTextview.setText((String) mSHortKeyList.get(position).getShortKeyExplaination());

        // Toast.makeText(mContext, "Topic set", Toast.LENGTH_SHORT).show();
        return convertView;

    }

    @Override
    public int getCount() {
        return mSHortKeyList.size();

    }

}
