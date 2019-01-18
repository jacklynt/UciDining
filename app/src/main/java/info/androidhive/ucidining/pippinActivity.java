package info.androidhive.ucidining;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class pippinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pippin);

        Button pippinBreakfastButton = (Button) findViewById(R.id.breakfast);
        pippinBreakfastButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent pippinBreakfastIntent = new Intent(pippinActivity.this, pippinBreakfastActivity.class);
                        startActivity(pippinBreakfastIntent);
                    }
                }
        );

        Button pippinLunchButton = (Button) findViewById(R.id.lunch);
        pippinLunchButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent pippinLunchIntent = new Intent(pippinActivity.this, pippinLunchActivity.class);
                        startActivity(pippinLunchIntent);
                    }
                }
        );

        Button pippinDinnerButton = (Button) findViewById(R.id.dinner);
        pippinDinnerButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent pippinDinnerIntent = new Intent(pippinActivity.this, pippinDinnerActivity.class);
                        startActivity(pippinDinnerIntent);
                    }
                }
        );

        TextView hours = (TextView) findViewById(R.id.pippin_hours);
        hours.setText(Html.fromHtml(textHours()));
    }

    private String textHours() {
        return "<strong>Mon-Fri</strong><br>Breakfast: 7:15 am - 10:00 am<br>Continental Breakfast: 10:00 am - 11:00 am<br>Lunch: 11:00 am - 2:00 pm<br>Light Lunch: 2:00 pm - 4:30 pm<br>Dinner: 4:30 pm - 8:00 pm<br><br>" +
                "<strong>Mon-Thu</strong><br>Late Night: 8:00 pm - Midnight<br><br>" +
                "<strong>Sat-Sun</strong><br>Continental Breakfast: 9:30 am - 11:00 am<br>Brunch: 11:00 am - 3:00 pm<br>Dinner: 5:00 pm - 8:00 pm";
    }
}