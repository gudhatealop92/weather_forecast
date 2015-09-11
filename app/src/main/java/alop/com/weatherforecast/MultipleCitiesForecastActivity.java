package alop.com.weatherforecast;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.astuetz.PagerSlidingTabStrip;

/**
 * Created by justbe on 4/9/15.
 */
public class MultipleCitiesForecastActivity extends FragmentActivity {
    private String[] cities;
    private ViewPager viewPager;
    private PagerSlidingTabStrip tabsStrip;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cities = getIntent().getStringArrayExtra(Constants.CITIES);
        setContentView(R.layout.multiple_cities_forecast_activity);

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MultipleCitiesFragmentPagerAdapter(getSupportFragmentManager(), cities));

        // Give the PagerSlidingTabStrip the ViewPager
        tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        // Attach the view pager to the tab strip
        tabsStrip.setViewPager(viewPager);

        btnSearch = (Button) findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                final Dialog dialog = new Dialog(MultipleCitiesForecastActivity.this);
                dialog.setContentView(R.layout.search_cities_dialog_box);
                dialog.setTitle("Enter cities here...");
                Button dialogButton = (Button) dialog.findViewById(R.id.btnDoneDialog);
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText tvm = (EditText) dialog.findViewById(R.id.txtSearchDialog);
                        if (tvm.getText().toString().length() == 0) {
                            dialog.dismiss();
                        } else {
                            String[] cities = tvm.getText().toString().split(",");
                            Intent intent = new Intent(MultipleCitiesForecastActivity.this, MultipleCitiesForecastActivity.class);
                            intent.putExtra(Constants.CITIES, cities);
                            startActivity(intent);
                            dialog.dismiss();
                        }
                    }
                });

                dialog.show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
