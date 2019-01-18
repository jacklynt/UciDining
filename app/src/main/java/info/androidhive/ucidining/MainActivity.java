package info.androidhive.ucidining;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button convenienceButton = (Button) findViewById(R.id.convenience_stores);
        convenienceButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent convenienceIntent = new Intent(MainActivity.this, convenienceActivity.class);
                        startActivity(convenienceIntent);
                    }
                }
        );

        Button cafeButton = (Button) findViewById(R.id.cafes);
        cafeButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent cafeIntent = new Intent(MainActivity.this, cafeActivity.class);
                        startActivity(cafeIntent);
                    }
                }
        );

        Button restaurantsButton = (Button) findViewById(R.id.restaurants);
        restaurantsButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent restaurantsIntent = new Intent(MainActivity.this, restaurantsActivity.class);
                        startActivity(restaurantsIntent);
                    }
                }
        );

        Button diningHallsButton = (Button) findViewById(R.id.dining_halls);
        diningHallsButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent cafeIntent = new Intent(MainActivity.this, diningHallsActivity.class);
                        startActivity(cafeIntent);
                    }
                }
        );
    }
}
