package info.androidhive.ucidining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class phoenixActivity extends AppCompatActivity {
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phoenix);

        ExpandableListView expListView = (ExpandableListView) findViewById(R.id.lvExp);
        prepareListData();
        ExpandableListAdapter listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        try {
            InputStreamReader is = new InputStreamReader(getAssets().open("phoenix.csv"));
            BufferedReader reader = new BufferedReader(is);
            reader.readLine();
            String line = reader.readLine();
            for (int i = 0;  line != null; i++) {
                String[] line_arr = line.split(",");
                listDataHeader.add(line_arr[0]);
                List<String> info = new ArrayList<String>();
                for (int j=1; j<line_arr.length; j++) {
                    info.add(line_arr[j]);
                }
                listDataChild.put(listDataHeader.get(i), info);
                line = reader.readLine();
            }
        } catch (Exception e) {
            Log.d("exception", e.getMessage());
        }
    }
}
