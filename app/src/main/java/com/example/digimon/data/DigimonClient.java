package com.example.digimon.data;

import com.example.digimon.model.DigimonModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DigimonClient {

    private static DigimonClient INSTANCE;
    private static final String BASE_URL = "https://digimon-api.vercel.app/api/";
    private DigimonInterface digimonInterface;

    public static DigimonClient getINSTANCE() {
        if(INSTANCE == null)
        {
            INSTANCE = new DigimonClient();
        }
        return INSTANCE;
    }

    public DigimonClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        digimonInterface = retrofit.create(DigimonInterface.class);
    }

    public Call<List<DigimonModel>> getDigimon()
    {
        return digimonInterface.getDigimon();
    }
}
