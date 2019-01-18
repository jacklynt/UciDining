package info.androidhive.ucidining;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class diningHallsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dining_halls);

        Button anteateryButton = (Button) findViewById(R.id.anteatery);
        anteateryButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent intent = new Intent(diningHallsActivity.this, anteateryActivity.class);
                        startActivity(intent);
                    }
                }
        );

        Button pippinButton = (Button) findViewById(R.id.pippin);
        pippinButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent intent = new Intent(diningHallsActivity.this, pippinActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}
