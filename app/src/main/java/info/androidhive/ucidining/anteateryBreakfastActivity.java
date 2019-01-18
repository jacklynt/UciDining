package info.androidhive.ucidining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ExpandableListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class anteateryBreakfastActivity extends AppCompatActivity {
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anteatery_breakfast);
        new prepareListData().execute();
    }

    private class prepareListData extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            listDataHeader = new ArrayList<String>();
            listDataChild = new HashMap<String, List<String>>();

            String url = "https://uci.campusdish.com/Commerce/Catalog/Menus.aspx?LocationId=3056&PeriodId=49";
            Document doc = null;
            try {
                doc = Jsoup.connect(url).get();
            } catch (IOException e) {
                Log.d("exception", e.getMessage());
            }

            String diningHall = "anteatery";

            List<String> categoriesList = new ArrayList<String>();
            if (diningHall.equals("pippin")) {
                categoriesList = new ArrayList<String>(Arrays.asList("Desserts", "Grill", "Main Line", "Salad Bar", "Saute", "Soups", "Destination", "Fresh & Healthy", "Pizza"));
            } else {
                categoriesList = new ArrayList<String>(Arrays.asList("Deli", "Dessert", "Entrée", "Grill", "Mongolian Grill",
                        "Oven", "Produce Market", "Sauté", "Vegan Sauté"));
            }

            Map<String, ArrayList<String>> foodCategories = new HashMap<String, ArrayList<String>>();

            Elements elements = doc.select("h2[class=collapsible-header], h2 ~ div");

            ArrayList<String> food = new ArrayList<String>();
            String category = "";
            for (Element element: elements) {
                String text = element.text();
                if (text.contains("Mon-Fri")) {
                    break;
                }
                if (categoriesList.contains(element.text())) {
                    if (category.equals("")) {
                        category = text;
                    } else {
                        listDataHeader.add(category);
                        listDataChild.put(category, food);
                        category = text;
                        food = new ArrayList<String>();
                    }
                } else {
                    food.add(text);
                }
            }
            listDataHeader.add(category);
            listDataChild.put(category, food);
            return null;
        }

        @Override
        protected void onPostExecute(Void param) {
            callMethods();
        }
    }

    public void callMethods() {
        ExpandableListView expListView = (ExpandableListView) findViewById(R.id.breakfast_menu);
        ExpandableListAdapter listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);
    }

}