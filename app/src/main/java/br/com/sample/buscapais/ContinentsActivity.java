package br.com.sample.buscapais;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.sample.buscapais.adapter.ContinentAdapter;
import br.com.sample.buscapais.bean.Continent;
import br.com.sample.buscapais.util.Constants;

public class ContinentsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continents);

        setupList();
    }

    private void setupList() {
        ListView lvContinents = findViewById(R.id.list);
        lvContinents.setAdapter(new ContinentAdapter(this, getContinents()));
        lvContinents.setOnItemClickListener(this);
    }

    private List<Continent> getContinents() {
        List<Continent> continents = new ArrayList<>();

        continents.add(new Continent("Africa",
                "http://www.joaoleitao.com/viagens/wp-content/uploads/2014/04/Mapa-Africa.jpg"));

        continents.add(new Continent("Americas",
                "https://upload.wikimedia.org/wikipedia/en/f/f0/Nintendo%27s_distribution_in_the_Americas.png"));

        continents.add(new Continent("Asia",
                "https://1.bp.blogspot.com/-JUjOuEfscZc/WYCm6aScCsI/AAAAAAABdpM/eTp2i2hJctYpzkknew78B4RaIBgxYZEegCLcBGAs/s640/Mapa-Asia.jpg"));

        continents.add(new Continent("Europe",
                "http://www.joaoleitao.com/viagens/wp-content/uploads/2018/06/EUROPA-MAPA-MUNDO.jpg"));

        continents.add(new Continent("Oceania",
                "http://www.joaoleitao.com/viagens/wp-content/uploads/2014/04/Mapa-Oceania.jpg"));

        return continents;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Continent continent = (Continent) parent.getItemAtPosition(position);

        Intent intent = new Intent(this, CountriesActivity.class);
        intent.putExtra(Constants.CONTINENT, continent);
        startActivity(intent);
    }
}
