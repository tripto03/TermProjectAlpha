package com.example.vacuumtubee.android_project;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by NIT on 5/9/2016.
 */
public class Background extends AsyncTask<String, Void, String> {

    String EmpAddInfo_url;
    private String urlConnection;
    public Background(Context context) {
        this.context = context;
    }

    Context context;
    @Override
    protected void onPreExecute() {
        EmpAddInfo_url="http://easyhire.site88.net/EmpAddInfo.php";
       // EmpAddInfo_url="http://10.0.2.2/EasyHire_php_files/EmpAddInfo.php";

    }

    @Override
    protected String doInBackground(String... params) {

        String type,name,password,phn,location;
        type=params[0];
        if(type.equals("SignUp")) {
            name = params[1];
            password = params[2];
            phn = params[3];
            location = params[4];
            try {
                URL url = new URL(EmpAddInfo_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data_str= URLEncoder.encode("Emp_Name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
                        URLEncoder.encode("Emp_Password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"+
                        URLEncoder.encode("Emp_MobileNo","UTF-8")+"="+URLEncoder.encode(phn,"UTF-8");
                bufferedWriter.write(data_str);
                bufferedWriter.flush();
                InputStream inputStream=httpURLConnection.getInputStream();
                inputStream.close();
                httpURLConnection.disconnect();
                Log.d(urlConnection,"url connection Successful");
                return  "SignUp successfully";

            }
            catch (Exception e){
                Log.d(urlConnection,"url connection failure");
                e.printStackTrace();
            }
        }
        return "Not Succeeded";
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(context,result,Toast.LENGTH_LONG).show();
    }
}
