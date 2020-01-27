package co.appsazan.mystore.utils;

import android.util.Log;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import co.appsazan.mystore.services.GetData;

/**
 * Created by Ali on 9/5/2016.
 */
public class JsonToArray {
    public static final String CHARSET_NAME = "UTF-8";
    public String initDataSet(InputStream is) {


/*


        StringWriter writer = new StringWriter();
        IOUtils.copy(is, writer, CHARSET_NAME);
        String json = writer.toString();
*/








        Writer writer =new StringWriter();
        String json;

        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, CHARSET_NAME));
            int n;
            char[] buffer = new char[1024];
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch(Exception e) {
            Log.i("----b","x1");
            e.printStackTrace();
        } finally {
            if (is != null)
                try {
                    is.close();
                    Log.i("----b","x2");
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.i("----b","x3");
                }
        }



        json = writer.toString();
        Log.i("----b","json: "+json.substring(0,10));
        return json;
    }
}
