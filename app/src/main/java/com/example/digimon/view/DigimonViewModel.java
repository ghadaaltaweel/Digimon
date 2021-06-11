package com.example.digimon.view;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.digimon.data.DigimonClient;
import com.example.digimon.model.DigimonModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DigimonViewModel extends ViewModel {
    private static final String TAG = "DigimonViewModel";

    MutableLiveData<List<DigimonModel>> digimonMutableLiveData = new MutableLiveData<>();
        public void getDigimons()
        {
            DigimonClient.getINSTANCE().getDigimon().enqueue(new Callback<List<DigimonModel>>() {

                @Override
                public void onResponse(Call<List<DigimonModel>> call, Response<List<DigimonModel>> response) {
                    digimonMutableLiveData.setValue(response.body());
                }

                @Override
                public void onFailure(Call<List<DigimonModel>> call, Throwable t) {
                    Log.d(TAG,t.getMessage());
                }
            });
        }
}
