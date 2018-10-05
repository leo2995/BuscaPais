package br.com.sample.buscapais.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmadrosid.svgloader.SvgLoader;

import java.util.List;

import br.com.sample.buscapais.R;
import br.com.sample.buscapais.bean.Country;

public class CountryAdapter extends ArrayAdapter<Country> {

    public CountryAdapter(@NonNull Context context, List<Country> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_continent, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Country country = getItem(position);
        holder.name.setText(country.getName());
        holder.name.setContentDescription(country.getName());


        SvgLoader.pluck()
                .with((Activity) getContext())
                .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                .load(country.getFlag(), holder.image);

        return convertView;
    }

    public class ViewHolder {
        ImageView image;
        TextView name;

        ViewHolder(View view) {
            image = view.findViewById(R.id.image);
            name = view.findViewById(R.id.name);
        }
    }
}
