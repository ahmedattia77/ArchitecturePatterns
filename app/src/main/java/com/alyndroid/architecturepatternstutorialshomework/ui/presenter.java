package com.alyndroid.architecturepatternstutorialshomework.ui;

import com.alyndroid.architecturepatternstutorialshomework.dataBase.NumberModel;
import com.alyndroid.architecturepatternstutorialshomework.dataBase.DataBase;

public class presenter {
    private DataBase dataBase;

    private NumberModel GetData (){
        return new DataBase().getNumbers();
    }

    public int multiplication (){
        int sum = GetData().getFirstNum() * GetData().getSecondNum();
        return sum;
    }
}
