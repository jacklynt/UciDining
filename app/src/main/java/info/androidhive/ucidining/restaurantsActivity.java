package info.androidhive.ucidining;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class restaurantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        Button bcButton = (Button) findViewById(R.id.bc);
        bcButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent intent = new Intent(restaurantsActivity.this, bcActivity.class);
                        startActivity(intent);
                    }
                }
        );

        Button phoenixButton = (Button) findViewById(R.id.phoenix);
        phoenixButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent intent = new Intent(restaurantsActivity.this, phoenixActivity.class);
                        startActivity(intent);
                    }
                }
        );

        Button studentcenterButton = (Button) findViewById(R.id.studentcenter);
        studentcenterButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent intent = new Intent(restaurantsActivity.this, studentcenterActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}

