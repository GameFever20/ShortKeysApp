package app.key.ashort.craftystudio.shortkeysapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import utils.AppRater;
import utils.FireBaseHandler;
import utils.KeyBoardShortcut;
import utils.ShortKeyDetailListAdapter;

public class ShortKeyDetailActivity extends AppCompatActivity {

    ListView mSHortKeyListview;
    ShortKeyDetailListAdapter mShortKeyAdapter;
    ArrayList<KeyBoardShortcut> mArrayList = new ArrayList<>();

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_key_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mSHortKeyListview = (ListView) findViewById(R.id.display_shortKeys_detail_listview);


        String shortKeyType = getIntent().getExtras().getString("ShortKeyType");
        toolbar.setTitle(shortKeyType);
        setSupportActionBar(toolbar);


        FireBaseHandler fireBaseHandler = new FireBaseHandler();
        showDialog();
        fireBaseHandler.downloadKeyList(30, shortKeyType, new FireBaseHandler.OnDatalistener() {
            @Override
            public void onDataDownLoad(String itemData, boolean isSuccessful) {

            }

            @Override
            public void onShortkeyDownload(ArrayList<KeyBoardShortcut> keyBoardShortcutArrayList, boolean isSuccessful) {

                if (isSuccessful) {
                    mArrayList = keyBoardShortcutArrayList;
                    mShortKeyAdapter = new ShortKeyDetailListAdapter(getApplicationContext(), R.layout.custom_shortkey_textview, mArrayList);
                    mSHortKeyListview.setAdapter(mShortKeyAdapter);

                    //  Toast.makeText(ShortKeyDetailActivity.this, keyBoardShortcutArrayList.get(0).getShortKeyCode(), Toast.LENGTH_SHORT).show();
                }

                hideDialog();
            }

            @Override
            public void onDataUpload(boolean isSuccessful) {

            }
        });

        //App Rater
        AppRater.app_launched(ShortKeyDetailActivity.this);
    }

    void showDialog() {
        progressDialog = new ProgressDialog(ShortKeyDetailActivity.this);
        progressDialog.setMessage("Loading..");
        progressDialog.show();
    }

    void hideDialog() {
        progressDialog.hide();
    }

}
