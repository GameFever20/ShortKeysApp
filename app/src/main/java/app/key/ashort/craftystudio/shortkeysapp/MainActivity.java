package app.key.ashort.craftystudio.shortkeysapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.google.firebase.analytics.FirebaseAnalytics;

import io.fabric.sdk.android.Fabric;
import java.util.ArrayList;

import utils.FireBaseHandler;
import utils.KeyBoardShortcut;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                KeyBoardShortcut keyBoardShortcut = new KeyBoardShortcut();
                keyBoardShortcut.setShortKeyExplaination("");
                keyBoardShortcut.setShortKeyCode("");
                FireBaseHandler fireBaseHandler = new FireBaseHandler();
                fireBaseHandler.uploadShortKeys(keyBoardShortcut, "Youtube Short Key", new FireBaseHandler.OnDatalistener() {
                    @Override
                    public void onDataDownLoad(String itemData, boolean isSuccessful) {

                    }

                    @Override
                    public void onShortkeyDownload(ArrayList<KeyBoardShortcut> keyBoardShortcut, boolean isSuccessful) {

                    }

                    @Override
                    public void onDataUpload(boolean isSuccessful) {
                        if (isSuccessful)
                            Toast.makeText(MainActivity.this, "Uploaded", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void basicShortKeys(View view) {

        Intent intent = new Intent(MainActivity.this, ShortKeyDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("ShortKeyType", "Basic Shortcut Keys");
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void microsoftWindowsKeys(View view) {

        Intent intent = new Intent(MainActivity.this, ShortKeyDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("ShortKeyType", "Microsoft Windows Short Keys");
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void micrsoftWordKey(View view) {

        Intent intent = new Intent(MainActivity.this, ShortKeyDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("ShortKeyType", "Micrsoft Word Short Key");
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void microsoftExcelKey(View view) {

        Intent intent = new Intent(MainActivity.this, ShortKeyDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("ShortKeyType", "Microsoft Excel Short Key");
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void googleChromeKey(View view) {

        Intent intent = new Intent(MainActivity.this, ShortKeyDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("ShortKeyType", "Google Chrome Short Key");
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void specialChracterKey(View view) {

        Intent intent = new Intent(MainActivity.this, ShortKeyDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("ShortKeyType", "Special Chracter Short Key");
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void linuAndUnixKey(View view) {

        Intent intent = new Intent(MainActivity.this, ShortKeyDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("ShortKeyType", "Linux And Unix Short Key");
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void appleShortKey(View view) {

        Intent intent = new Intent(MainActivity.this, ShortKeyDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("ShortKeyType", "Apple Short Key");
        intent.putExtras(bundle);
        startActivity(intent);
    }


    public void youtubeShortKey(View view) {
        Intent intent = new Intent(MainActivity.this, ShortKeyDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("ShortKeyType", "Youtube Short Key");
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void internetExplorerShortKey(View view) {
        Intent intent = new Intent(MainActivity.this, ShortKeyDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("ShortKeyType", "Explorer Short Key");
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void outlookShortKey(View view) {
        Intent intent = new Intent(MainActivity.this, ShortKeyDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("ShortKeyType", "Outlook Short Key");
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void notepadShortKey(View view) {
        Intent intent = new Intent(MainActivity.this, ShortKeyDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("ShortKeyType", "Notepad Short Key");
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_aptitude) {
            try {
                String link = "https://play.google.com/store/apps/details?id=app.aptitude.quiz.craftystudio.aptitudequiz";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(link)));

                // Answers.getInstance().logCustom(new CustomEvent("Logical Reasoning Click"));


            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (id == R.id.nav_editorial) {
            try {
                String link = "https://play.google.com/store/apps/details?id=app.craftystudio.vocabulary.dailyeditorial";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(link)));

                // Answers.getInstance().logCustom(new CustomEvent("Logical Reasoning Click"));


            } catch (Exception e) {
                e.printStackTrace();

            }
        }else if (id == R.id.nav_personality) {
            try {
                String link = "https://play.google.com/store/apps/details?id=app.story.craftystudio.shortstory";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(link)));

                // Answers.getInstance().logCustom(new CustomEvent("Logical Reasoning Click"));


            } catch (Exception e) {
                e.printStackTrace();

            }
        } else if (id == R.id.nav_logical) {
            onLogicalReasoningClick();

        } else if (id == R.id.nav_pib) {
            try {
                String link = "https://play.google.com/store/apps/details?id=app.crafty.studio.current.affairs.pib";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(link)));

                // Answers.getInstance().logCustom(new CustomEvent("Logical Reasoning Click"));


            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (id == R.id.nav_rate) {

            onRateUs();
        } else if (id == R.id.nav_share) {

            onShare();
        } else if (id == R.id.nav_suggestion) {

            giveSuggestion();
        }else if (id == R.id.nav_basicComputer) {

            onBasicCOmputerClick();
        }else if(id == R.id.nav_privacy_policy){
            onPrivacyPolicyClick();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void onPrivacyPolicyClick() {
        try {
            String link = "http://aspirantworld.in/privacy-policy";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(link)));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void onLogicalReasoningClick() {
        try {
            String link = "https://play.google.com/store/apps/details?id=app.reasoning.logical.quiz.craftystudio.logicalreasoning";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(link)));

            // Answers.getInstance().logCustom(new CustomEvent("Logical Reasoning Click"));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onBasicCOmputerClick() {
        try {
            String link = "https://play.google.com/store/apps/details?id=app.computer.basic.quiz.craftystudio.computerbasic";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(link)));

            // Answers.getInstance().logCustom(new CustomEvent("Logical Reasoning Click"));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void giveSuggestion() {

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"acraftystudio@gmail.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Suggestion For " + getResources().getString(R.string.app_name));
        emailIntent.setType("text/plain");

        startActivity(Intent.createChooser(emailIntent, "Send mail From..."));

    }

    private void onRateUs() {
        try {
            String link = "https://play.google.com/store/apps/details?id=app.key.ashort.craftystudio.shortkeysapp";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(link)));
        } catch (Exception e) {

        }
    }

    private void onShare() {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");

        //sharingIntent.putExtra(Intent.EXTRA_STREAM, newsMetaInfo.getNewsImageLocalPath());

        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT,
                " " + "\n\nhttps://play.google.com/store/apps/details?id=app.key.ashort.craftystudio.shortkeysapp" + "\n Short Key App \n Download App Now");
        startActivity(Intent.createChooser(sharingIntent, "Share Short Keys App via"));


    }

}
