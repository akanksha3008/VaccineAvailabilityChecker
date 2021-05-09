package com.example.vaccinenotifier;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Toast;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
  private SetuAPI apiConnect;
  ArrayList<CenterModel> sessions=new ArrayList<CenterModel>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        RecyclerView rcv = findViewById(R.id.recycleView1);

        try{
            String userAgent = System.getProperty("http.agent");
            OkHttpClient client = new OkHttpClient().newBuilder().build();
            DateFormat df = new SimpleDateFormat("dd-MM-YYYY");
            Calendar calendar= Calendar.getInstance();
            calendar.add(Calendar.DATE,1);
            String tomorrow = df.format(calendar.getTime());
            Toast.makeText(this,tomorrow,Toast.LENGTH_SHORT).show();
            System.out.println(tomorrow);
            Request request = new Request.Builder().url("https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByDistrict?district_id=140&date="+tomorrow)
                    .method("GET",null)
                    .addHeader("User-Agent",userAgent)
                    .build();
            Response response = client.newCall(request).execute();
            JSONArray centerList = new JSONObject(response.body().string()).getJSONArray("sessions");
            for(int i =0;i<centerList.length();i++)
            {
                JSONObject obj = centerList.getJSONObject(i);
                CenterModel cm = new CenterModel(obj.getInt("center_id"),obj.getString("name"), obj.getString("address"), obj.getInt("pincode")
                        , obj.getString("fee_type"), obj.getInt("min_age_limit"), obj.getInt("available_capacity"),
                        obj.getString("date"), obj.getString("vaccine"));
                System.out.println(cm.toString());
                sessions.add(cm);
            }
            CenterListAdapter adapter = new CenterListAdapter(sessions);
            rcv.setAdapter(adapter);
            rcv.setLayoutManager(new LinearLayoutManager(this));
        }
        catch (Exception e){
            e.printStackTrace();
        }
//        try {
//            String userAgent = System.getProperty("http.agent");
//            System.out.println(userAgent);
//            OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//            Request request = new Request.Builder()
//                .url("https://cdn-api.co-vin.in/api/v2/admin/location/states")
//                .method("GET", null)
//                .addHeader("User-Agent", userAgent)
//                .build();
//
//            Response response = client.newCall(request).execute();
//            JSONObject Jobject = new JSONObject(response.body().string());
//            JSONArray Jarray = Jobject.getJSONArray("states");
//     Toast.makeText(this,Jarray.getJSONObject(0).getString("state_name"),Toast.LENGTH_SHORT).show();
//
//        } catch (IOException | JSONException e) {
//            e.printStackTrace();
//        }

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://cdn-api.co-vin.in/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        apiConnect = retrofit.create(SetuAPI.class);
//        Call<AllStates> call = apiConnect.getStateList();
//
//        call.enqueue(new Callback<AllStates>() {
//            @Override
//            public void onResponse(Call<AllStates> call, Response<AllStates> response) {
//                if(response.code()!=200){
//                    try {
//                        Toast.makeText(getApplicationContext(),response.errorBody().string(), Toast.LENGTH_LONG).show();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    try {
//                        System.out.println(response.errorBody().string());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(response.message());
//                }
//                else{
//                    AllStates stateList = response.body();
//                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//                    System.out.println(stateList.toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<AllStates> call, Throwable t) {
//                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
//                System.out.println(t.getMessage());
//            }
//        });
//

    }
}