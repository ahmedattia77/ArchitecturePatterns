package com.alyndroid.architecturepatternstutorialshomework.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alyndroid.architecturepatternstutorialshomework.dataBase.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.ui.DataViewModel;
import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.ui.presenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button plu , mul ,div ;
    private TextView pluTv , mulTv ,divTv ;

    private DataBase dataBase;
    private DataViewModel dataViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plu = findViewById(R.id.plus_button);
        mul = findViewById(R.id.mul_button);
        div = findViewById(R.id.div_button);
        pluTv = findViewById(R.id.plus_result_textView);
        mulTv = findViewById(R.id.mul_result_textView);
        divTv = findViewById(R.id.div_result_textView);

        dataBase = new DataBase();
        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);
        dataViewModel.mutableLiveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                divTv.setText(dataViewModel.mutableLiveData+"");
            }
        });


    }

    @Override
    public void onClick(View v) {
        int sum;
        switch (v.getId()){

            // MVP
            case  R.id.plus_button:
                sum = dataBase.getNumbers().getFirstNum() + dataBase.getNumbers().getSecondNum();
                pluTv.setText(""+sum);
                break;

            //MVC
            case  R.id.mul_button:
                presenter presenter = new presenter();
                pluTv.setText(presenter.multiplication());
                break;

            //MVVM
            case  R.id.div_button:
                dataViewModel = new DataViewModel();
                dataViewModel.getDiv();
                break;
        }
    }
}
