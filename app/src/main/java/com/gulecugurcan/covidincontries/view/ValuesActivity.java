package com.gulecugurcan.covidincontries.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.gulecugurcan.covidincontries.R;

public class ValuesActivity extends AppCompatActivity {
    TextView ulkeTextView,toplamVakaTextView,yeniVakaTextView,toplamOlumTextView
            ,yeniOlumTextView,toplamIyilesenTextView,aktifVakalarTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_values);
        ulkeTextView=findViewById(R.id.ulkeTextView);
        toplamVakaTextView=findViewById(R.id.toplamVakaTextView);
        yeniVakaTextView=findViewById(R.id.yeniVakaTextView);
        toplamOlumTextView=findViewById(R.id.toplamOlumTextView);
        yeniOlumTextView=findViewById(R.id.yeniOlumTextView);
        toplamIyilesenTextView=findViewById(R.id.toplamIyilesenTextView);
        aktifVakalarTextView=findViewById(R.id.aktifVakalarTextView);
        Intent intent=getIntent();
        ulkeTextView.setText(intent.getStringExtra("country"));
        toplamVakaTextView.setText(" Toplam Vaka : "+intent.getStringExtra("totalCases"));
        yeniVakaTextView.setText(" Yeni Vaka : "+intent.getStringExtra("newCases"));
        toplamOlumTextView.setText(" Toplam Ölüm : "+intent.getStringExtra("totalDeaths"));
        yeniOlumTextView.setText(" Yeni Ölüm : "+intent.getStringExtra("newDeaths"));
        toplamIyilesenTextView.setText(" Toplam İyileşen : "+intent.getStringExtra("totalRecovered"));
        aktifVakalarTextView.setText(" Aktif Vaka : "+intent.getStringExtra("activeCases"));
    }
}