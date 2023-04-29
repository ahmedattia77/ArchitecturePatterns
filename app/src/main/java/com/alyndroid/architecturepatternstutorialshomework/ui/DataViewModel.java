package com.alyndroid.architecturepatternstutorialshomework.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alyndroid.architecturepatternstutorialshomework.dataBase.NumberModel;
import com.alyndroid.architecturepatternstutorialshomework.dataBase.DataBase;

public class DataViewModel extends ViewModel {
    private int sum;
    DataBase dataBase = new DataBase();
    public MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();


    private NumberModel getData (){
        return dataBase.getNumbers();
    }

    public void getDiv(){
        sum = getData().getFirstNum() / getData().getSecondNum();
        mutableLiveData.setValue(sum);
    }

}
