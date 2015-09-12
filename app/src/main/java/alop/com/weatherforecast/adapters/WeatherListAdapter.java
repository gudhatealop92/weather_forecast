package alop.com.weatherforecast.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import alop.com.weatherforecast.R;
import alop.com.weatherforecast.fragments.SingleCityPageFragment;
import alop.com.weatherforecast.valueobjects.WeatherData;

/**
 * Created by Alop Gudhate on 8/25/15.
 */
public class WeatherListAdapter extends BaseAdapter {
    private ArrayList<WeatherData> result;
    private Context context;
    private static LayoutInflater inflater = null;

    public WeatherListAdapter(Context context, ArrayList<WeatherData> WeatherInfo) {
        this.result = WeatherInfo;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public WeatherListAdapter(SingleCityPageFragment SingleCityPageFragment, ArrayList<WeatherData> WeatherInfo) {
        this.result = WeatherInfo;
        this.context = SingleCityPageFragment.getActivity();
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return result == null ? 0 :result.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder {
        TextView cityName;
        TextView date;
        TextView dayTemp;
        TextView minimumTemp;
        TextView maximumTemp;
        TextView pressure;
        TextView humidity;
        TextView cloud;
        TextView rain;
        TextView description;
        RelativeLayout relativeLayout;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.list_item_bautified, null);
        holder.relativeLayout = (RelativeLayout) rowView.findViewById(R.id.relativeLayout2);
        String desc = new String(result.get(position).getDescription());
        if (desc.equalsIgnoreCase("sky is clear")) {
            holder.relativeLayout.setBackgroundResource(R.drawable.clear_sky_image3);
            Drawable background = holder.relativeLayout.getBackground();
            background.setAlpha(90);
        } else if (desc.equalsIgnoreCase("light rain") || desc.equalsIgnoreCase("moderate rain")) {
            holder.relativeLayout.setBackgroundResource(R.drawable.light_rain_image4);
            Drawable background = holder.relativeLayout.getBackground();
            background.setAlpha(90);
        } else if (desc.equalsIgnoreCase("heavy intensity rain")) {
            holder.relativeLayout.setBackgroundResource(R.drawable.heavy_rain_image3);
            Drawable background = holder.relativeLayout.getBackground();
            background.setAlpha(90);
        } else if (desc.equalsIgnoreCase("scattered sky")) {
            holder.relativeLayout.setBackgroundResource(R.drawable.scatteres_cloud_image2);
            Drawable background = holder.relativeLayout.getBackground();
            background.setAlpha(90);
        } else if (desc.equalsIgnoreCase("thunderstorm")) {
            holder.relativeLayout.setBackgroundResource(R.drawable.thunderstorm_image);
            Drawable background = holder.relativeLayout.getBackground();
            background.setAlpha(90);
        } else {
            holder.relativeLayout.setBackgroundResource(R.drawable.clear_sky_image3);
            Drawable background = holder.relativeLayout.getBackground();
            background.setAlpha(90);
        }
        holder.cityName = (TextView) rowView.findViewById(R.id.txtCityName);
        holder.date = (TextView) rowView.findViewById(R.id.txtDateValue);
        holder.dayTemp = (TextView) rowView.findViewById(R.id.txtDayTempValue);
        holder.minimumTemp = (TextView) rowView.findViewById(R.id.txtMinTempValue);
        holder.maximumTemp = (TextView) rowView.findViewById(R.id.txtMaxTempValue);
        holder.pressure = (TextView) rowView.findViewById(R.id.txtPressureValue);
        holder.humidity = (TextView) rowView.findViewById(R.id.txtHumidityValue);
        holder.cloud = (TextView) rowView.findViewById(R.id.txtCloudsValue);
        holder.rain = (TextView) rowView.findViewById(R.id.txtRainValue);
        holder.description = (TextView) rowView.findViewById(R.id.txtDescriptionValue);
        holder.cityName.setText(result.get(position).getCity());
        holder.date.setText(result.get(position).getDate());
        holder.dayTemp.setText(Float.toString(result.get(position).getDayTemp()) + " C");
        holder.minimumTemp.setText(Float.toString(result.get(position).getMinTemp()) + " C");
        holder.maximumTemp.setText(Float.toString(result.get(position).getMaxTemp()) + " C");
        holder.pressure.setText(Float.toString(result.get(position).getPressure()) + "%");
        holder.humidity.setText(Float.toString(result.get(position).getHumidity()) + "%");
        holder.cloud.setText(Float.toString(result.get(position).getCloud()) + "%");
        holder.rain.setText(Float.toString(result.get(position).getRain()) + "%");
        holder.description.setText(result.get(position).getDescription());
        rowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        return rowView;
    }

}