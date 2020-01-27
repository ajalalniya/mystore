package co.appsazan.mystore.utils;

import co.appsazan.mystore.R;

/**
 * Created by Ali on 10/6/2016.
 */
public class ReverseArray {
    private String[] mystring;

    public ReverseArray(String[] strings) {
        this.mystring = strings;


    }

    public String[] reverseArray() {


        for (int i = 0; i < this.mystring.length / 2; i++) {
            String temp = this.mystring[i];
            this.mystring[i] = this.mystring[this.mystring.length - i - 1];
            this.mystring[this.mystring.length - i - 1] = temp;
        }


        return this.mystring;
    }

}
