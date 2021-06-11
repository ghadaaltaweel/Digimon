package com.example.digimon.data;

import com.example.digimon.model.DigimonModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DigimonInterface {

    @GET("digimon")
    public Call<List<DigimonModel>> getDigimon();
}
