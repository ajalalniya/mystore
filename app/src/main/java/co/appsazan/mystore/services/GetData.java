package co.appsazan.mystore.services;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/**
 * Created by Ali on 9/6/2016.
 */
public class GetData {
    public static final String CHARSET_NAME = "UTF-8";

    public String getJsonData(InputStream is) throws Exception {
        int ascii = 0;

        ascii = is.read();
        String content = "";
        while (ascii != -1) {

            content = content + (char) ascii;


            ascii = is.read();
        }

        is.close();
        Log.i("----b",content);
        return content;
    }

}
