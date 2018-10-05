package br.com.sample.buscapais.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.sample.buscapais.R;
import br.com.sample.buscapais.bean.Continent;

public class ContinentAdapter extends ArrayAdapter<Continent> {

    public ContinentAdapter(@NonNull Context context, List<Continent> list) {
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

        Continent continent = getItem(position);
        Picasso.get().load(continent.getImage()).into(holder.image);
        holder.name.setText(continent.getName());
        holder.name.setContentDescription(continent.getName());
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
