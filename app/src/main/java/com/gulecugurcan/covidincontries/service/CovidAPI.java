package com.gulecugurcan.covidincontries.service;

import com.gulecugurcan.covidincontries.model.CovidModel;
import com.gulecugurcan.covidincontries.model.CovidRecordList;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidAPI {

    //GET POST UPDATE DELETE İŞLEMLERİ İÇİN KULLANILIR.
    //Get notasyonuna url base i yazılmayacak.
    //Get---> URL içindeki eklenti kısmını yazıyoruz.
    //URL base i ise Retrofitin kendi nesnesini oluştururken belirtiyoruz.

    //Verdiğimiz adrese bir Get isteği yolla Sorasında bir çağrı yap ve tüm verileri bir liste halinde bana getir.
    @GET("countriesData?apiKey=6pw5YCjqpkywaWdHiiOwkU:6AXb6T1Yl6IFoqhL3jjbF7")
    Call<CovidRecordList> veriyiGetir();
    // Observable<List<CovidModel>> veriyiGetir();


}
