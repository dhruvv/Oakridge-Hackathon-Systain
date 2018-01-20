package samarthgrover.systain;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class LoginActivity extends AppCompatActivity {

    public static double tur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            URL endpoint = null;
                            try {
                                endpoint = new URL("https://oakhack.pythonanywhere.com");
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                            HttpsURLConnection connection = null;
                            try {
                                connection = (HttpsURLConnection) endpoint.openConnection();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            try {
                                if (connection.getResponseCode() == 200) {
                                    InputStream responseBody = null;
                                    try {
                                        responseBody = connection.getInputStream();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    InputStreamReader responseBodyReader = null;
                                    try {
                                        responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                                    } catch (UnsupportedEncodingException e) {
                                        e.printStackTrace();
                                    }
                                    JsonReader jsonReader = new JsonReader(responseBodyReader);
                                    try {
                                        jsonReader.beginObject();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    try {
                                        while (jsonReader.hasNext()) {
                                            String key = null;
                                            try {
                                                key = jsonReader.nextName();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            if (key.equals("turbidity")) {
                                                String turbidityVal = jsonReader.nextString();
                                                tur = Double.parseDouble(turbidityVal);


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
                    }
                });
            }
        });
    }
    public void ButtonClick(View view) {

        Intent intent = new Intent(LoginActivity.this, HeatMapActivity.class);
        startActivity(intent);
    }
}
