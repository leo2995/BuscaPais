package br.com.sample.buscapais;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ahmadrosid.svgloader.SvgLoader;

import br.com.sample.buscapais.bean.Country;
import br.com.sample.buscapais.util.Constants;

public class CountryDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);

        initViews();
    }

    private void initViews() {
        Country country = (Country) getIntent().getSerializableExtra(Constants.COUNTRY);

        SvgLoader.pluck()
                .with(this)
                .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                .load(country.getFlag(), findViewById(R.id.image));

        TextView name = findViewById(R.id.name);
        name.setText(country.getName());

        TextView sub = findViewById(R.id.sub);
        sub.setText(country.getSubregion());

        TextView population = findViewById(R.id.population);
        population.setText(String.valueOf(country.getPopulation()));
    }
}
