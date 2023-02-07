package com.sena.pokeapi20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.sena.pokeapi20.modelos.Pokemon;
import com.sena.pokeapi20.modelos.PokemonRespuesta;

import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Lista_pokemon extends AppCompatActivity {

    private static final String TAG= "POKEDEX";
    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private PokemonAdapter pokemonAdapter;
    private int offset;
    private int limit;
    private Boolean aptoParaCargar; //loadg
    EditText searchEditText;
    private ArrayList<Pokemon> pokemonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pokemon);


        Intent intent= getIntent();
        Bundle bundle = intent.getExtras();
        offset = (int) bundle.get("start");
        limit = (int) bundle.get("end");




        recyclerView=findViewById(R.id.Recyclerview2);
        pokemonAdapter= new PokemonAdapter(this);
        recyclerView.setAdapter(pokemonAdapter);
        final GridLayoutManager layoutManager =
                          new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        retrofit= new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        aptoParaCargar=true;
        offset=0;
      getData(offset,limit);

        searchEditText=findViewById(R.id.searchEditText);
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                    filter(s.toString());
            }
        });




    }

    private void getData(int offset, int limit) {
        pokemonApiService service = retrofit.create(pokemonApiService.class);

        Call<PokemonRespuesta> pokemonRespuestaCall = service.getPokemonList(limit,offset);
       pokemonRespuestaCall.enqueue(new Callback<PokemonRespuesta>() {
            @Override
            public void onResponse(Call<PokemonRespuesta> call, retrofit2.Response<PokemonRespuesta> response) {
           aptoParaCargar=true;

           if (response.isSuccessful()){
                PokemonRespuesta pokemonRespuesta =response.body();
                pokemonList= pokemonRespuesta.getResults();
                pokemonAdapter.addPokemonList(pokemonList);

           }else{
               Log.e(TAG, "on response: "+ response.errorBody() );
           }


            }

            @Override
            public void onFailure(Call<PokemonRespuesta> call, Throwable t) {

                aptoParaCargar = true;
                Log.e(TAG, "on Failure: " +t.getMessage());


            }
        });


    }

    private void filter (String text){
        ArrayList<Pokemon> filterList= new ArrayList<>();
        for (Pokemon p : pokemonList){
            if (p.getName().toLowerCase().contains(text.toLowerCase())){
                filterList.add(p);
            }

        }

        pokemonAdapter.filterList(filterList);


    }


}