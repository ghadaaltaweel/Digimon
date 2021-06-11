package com.example.digimon.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.digimon.R;
import com.example.digimon.model.DigimonModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DigimonViewModel digimonViewModel;
    RecyclerView recyclerView;
    DigimonAdapter digimonAdapter;
    ArrayList<DigimonModel> digimonList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        digimonViewModel = new ViewModelProvider(this).get(DigimonViewModel.class);
        recyclerView = findViewById(R.id.recycler);
        digimonAdapter = new DigimonAdapter(digimonList,this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(digimonAdapter);

        digimonViewModel.getDigimons();

        digimonViewModel.digimonMutableLiveData.observe(this, new Observer<List<DigimonModel>>() {
            @Override
            public void onChanged(List<DigimonModel> digimonModels) {
                digimonAdapter.setList((ArrayList<DigimonModel>) digimonModels);
            }
        });



    }
}