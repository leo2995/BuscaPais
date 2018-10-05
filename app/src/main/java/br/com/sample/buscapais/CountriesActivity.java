package br.com.sample.buscapais;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import br.com.sample.buscapais.adapter.CountryAdapter;
import br.com.sample.buscapais.bean.Continent;
import br.com.sample.buscapais.bean.Country;
import br.com.sample.buscapais.util.Constants;

public class CountriesActivity extends AppCompatActivity implements Response.Listener<JSONArray>, Response.ErrorListener,
        AdapterView.OnItemClickListener {

    private ProgressDialog mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);
        setupProgress();

        Continent continent = (Continent) getIntent().getSerializableExtra(Constants.CONTINENT);
        getCountries(continent);
    }

    private void setupProgress() {
        mProgress = new ProgressDialog(this);
        mProgress.setCancelable(false);
        mProgress.setMessage(getString(R.string.carregando));
    }

    private void getCountries(Continent continent) {
        mProgress.show();

        String url = "https://restcountries.eu/rest/v2/region/" + continent.getName();
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null
                , this, this);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    @Override
    public void onResponse(JSONArray response) {
        Type type = new TypeToken<ArrayList<Country>>() {
        }.getType();
        List<Country> countries = new Gson().fromJson(response.toString(), type);

        setupList(countries);
    }

    private void setupList(List<Country> countries) {
        if (mProgress.isShowing()) mProgress.dismiss();

        ListView lvCountries = findViewById(R.id.list);
        lvCountries.setAdapter(new CountryAdapter(this, countries));
        lvCountries.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Country country = (Country) parent.getItemAtPosition(position);

        Intent intent = new Intent(this, CountryDetailActivity.class);
        intent.putExtra(Constants.COUNTRY, country);
        startActivity(intent);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }
}
