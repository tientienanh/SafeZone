package com.example.activity.safezone;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseObject;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnMother, btnSon;
    List<ParseObject> objects;
    private static final String TIME_FROM = "timeFrom";
    private static final String TIME_TO = "timeTo";
    private static final String LOCATION = "location";
    private static final String RADIUS = "rsdius";
    public static final String D_LATITUTE = "dLatitute";
    public static final String D_LONGITUTE = "dLongitute";

    public static boolean isLoginSon = false;
    public static boolean isLoginMother = false;

    TextView tvYouAre;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        btnMother = (Button) findViewById(R.id.btnMother);
        btnSon = (Button) findViewById(R.id.btnSon);
//        Typeface tf1 = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/mtcorsva.ttf");

        Typeface tf2 = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/segoesc.ttf");
        btnMother.setTypeface(tf2);
        btnSon.setTypeface(tf2);

        btnSon.setOnClickListener(this);
        btnMother.setOnClickListener(this);


    if (isNetworkAvailable(this) == false){
        Toast.makeText(MainActivity.this, "Please, check the Internet!", Toast.LENGTH_SHORT).show();
    }
    }

    public boolean isNetworkAvailable(final Context context) {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnSon){
            Intent intentLoginSon = new Intent(MainActivity.this, LoginSonActivity.class);
            startActivity(intentLoginSon);
        } else {
            if (id == R.id.btnMother) {
                if (isLoginMother == false) {
                    Intent intentMother = new Intent(MainActivity.this, LoginMotherActivity.class);
                    startActivity(intentMother);
                }
            }
        }
    }

}
