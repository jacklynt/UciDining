package info.androidhive.ucidining;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class anteateryActivity extends AppCompatActivity {
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anteatery);

        Button anteateryBreakfastButton = (Button) findViewById(R.id.breakfast);
        anteateryBreakfastButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent anteateryBreakfastIntent = new Intent(anteateryActivity.this, anteateryBreakfastActivity.class);
                        startActivity(anteateryBreakfastIntent);
                    }
                }
        );

        Button anteateryLunchButton = (Button) findViewById(R.id.lunch);
        anteateryLunchButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent anteateryLunchIntent = new Intent(anteateryActivity.this, anteateryLunchActivity.class);
                        startActivity(anteateryLunchIntent);
                    }
                }
        );

        Button anteateryDinnerButton = (Button) findViewById(R.id.dinner);
        anteateryDinnerButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent anteateryDinnerIntent = new Intent(anteateryActivity.this, anteateryDinnerActivity.class);
                        startActivity(anteateryDinnerIntent);
                    }
                }
        );

        Button anteateryLateNightButton = (Button) findViewById(R.id.latenight);
        anteateryLateNightButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent anteateryLateNightIntent = new Intent(anteateryActivity.this, anteateryLateNightActivity.class);
                        startActivity(anteateryLateNightIntent);
                    }
                }
        );
        TextView hours = (TextView) findViewById(R.id.textView3);
        hours.setText(Html.fromHtml(textHours()));
    }

    private String textHours() {
        return "<strong>Mon-Fri</strong><br>Breakfast: 7:15 am - 10:00 am<br>Continental Breakfast: 10:00 am - 11:00 am<br>Lunch: 11:00 am - 2:00 pm<br>Light Lunch: 2:00 pm - 4:30 pm<br>Dinner: 4:30 pm - 8:00 pm<br><br>" +
                "<strong>Mon-Thu</strong><br>Late Night: 8:00 pm - Midnight<br><br>" +
                "<strong>Sat-Sun</strong><br>Continental Breakfast: 9:30 am - 11:00 am<br>Brunch: 11:00 am - 3:00 pm<br>Dinner: 5:00 pm - 8:00 pm";

    }
}