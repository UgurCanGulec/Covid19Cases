package com.gulecugurcan.covidincontries.view;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gulecugurcan.covidincontries.R;
import com.gulecugurcan.covidincontries.model.CovidModel;
import com.gulecugurcan.covidincontries.model.CovidRecordList;
import com.gulecugurcan.covidincontries.service.CovidAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    //Tüm verileri içerecek ArrayList
    ArrayList<CovidModel> tumVerilerArrayList;
    private String BASE_URL="https://api.collectapi.com/corona/";
    Retrofit retrofit;
    ListView calismaListView;
    //Veri tiplerinin ArrayListleri
    ArrayList<String> countryList,totalCasesList,newCasesList,totalDeathsList,
            newDeathsList,totalRecoveredList,activeCasesList;

//https://api.collectapi.com/corona/countriesData?apiKey=6pw5YCjqpkywaWdHiiOwkU:6AXb6T1Yl6IFoqhL3jjbF7


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Retrofit JSON
        Gson gson=new GsonBuilder().setLenient().create();

        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        calismaListView=findViewById(R.id.calismaListView);
        countryList=new ArrayList<>();
        totalCasesList=new ArrayList<>();
        newCasesList=new ArrayList<>();
        totalDeathsList=new ArrayList<>();
        newDeathsList=new ArrayList<>();
        totalRecoveredList=new ArrayList<>();
        activeCasesList=new ArrayList<>();
        VeriyiApidenAl();


    }
    private void VeriyiApidenAl(){

        final CovidAPI covidAPI=retrofit.create(CovidAPI.class);
        Call<CovidRecordList> call=covidAPI.veriyiGetir();
        call.enqueue(new Callback<CovidRecordList>() {
            @Override
            public void onResponse(Call<CovidRecordList> call, Response<CovidRecordList> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this,"Ülkeler getiriliyor...",Toast.LENGTH_LONG).show();
                    List<CovidModel> responseList= response.body().covids;
                    tumVerilerArrayList=new ArrayList<>(responseList);
                    for (CovidModel covidModel:tumVerilerArrayList) {
                        countryList.add(covidModel.country);
                        totalCasesList.add(covidModel.totalCases);
                        newCasesList.add(covidModel.newCases);
                        totalDeathsList.add(covidModel.totalDeaths);
                        newDeathsList.add(covidModel.newDeaths);
                        totalRecoveredList.add(covidModel.totalRecovered);
                        activeCasesList.add(covidModel.activeCases);
                    }
                    ArrayAdapter arrayAdapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,countryList);
                    calismaListView.setAdapter(arrayAdapter);
                    calismaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent=new Intent(MainActivity.this,ValuesActivity.class);
                            intent.putExtra("country",countryList.get(position));
                            intent.putExtra("totalCases",totalCasesList.get(position));
                            intent.putExtra("newCases",newCasesList.get(position));
                            intent.putExtra("totalDeaths",totalDeathsList.get(position));
                            intent.putExtra("newDeaths",newDeathsList.get(position));
                            intent.putExtra("totalRecovered",totalRecoveredList.get(position));
                            intent.putExtra("activeCases",activeCasesList.get(position));
                            startActivity(intent);
                        }
                    });

                }
            }

            @Override
            public void onFailure(Call<CovidRecordList> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(MainActivity.this,"Lütfen internet bağlantınızı kontrol ediniz!",Toast.LENGTH_LONG).show();
            }
        });

    }



}