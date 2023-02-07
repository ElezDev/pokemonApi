package com.sena.pokeapi20;

import com.sena.pokeapi20.modelos.PokemonRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface pokemonApiService {

    @GET("pokemon")
    Call<PokemonRespuesta> getPokemonList
            (@Query("limit") int limit,@Query("offset") int offset  );


}
