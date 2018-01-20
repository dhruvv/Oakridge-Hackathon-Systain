package com.example.bangaloreboiz.oakridgejavaflaskapi;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;




public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {

                            URL endpoint = null;
                                try {
                                endpoint = new URL("http://oakhack.pythonanywhere.com/");
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                            HttpURLConnection myConnection = null;
                            try {
                                myConnection = (HttpURLConnection) endpoint.openConnection();
                            } catch (IOException e) {
                                e.printStackTrace();

                            }

                            try {
                                if (myConnection.getResponseCode() == 200) {
                                    InputStream responseBody = myConnection.getInputStream();


                                    try {
                                        InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                                        JsonReader jsonReader = new JsonReader(responseBodyReader);
                                        jsonReader.beginObject();
                                        while (jsonReader.hasNext()){
                                            String key = jsonReader.nextName();
                                            if (key.equals("data")){
                                                final String jsonStr;
                                                jsonStr = jsonReader.nextString();
                                                System.out.println(jsonStr);
                                                final String print_key = key;
                                                runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run(){



                                                    }
                                                });

                                                break;
                                            }else{
                                                jsonReader.skipValue();
                                            }
                                        }


                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                }

                            } catch (IOException e) {
                                e.printStackTrace();
                            }


                        }

                    });
                }




            });


        }


    }