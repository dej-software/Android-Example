package com.jikexueyuan.testjson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        try {
//            InputStreamReader isr = new InputStreamReader(getAssets().open("test.json"), "UTF-8");
//            BufferedReader br = new BufferedReader(isr);
//            String line;
//            StringBuilder builder = new StringBuilder();
//            while ((line = br.readLine()) != null) {
//                builder.append(line);
//            }
//
//            br.close();
//            isr.close();
//
//            JSONObject root = new JSONObject(builder.toString());
//            System.out.println("cat=" + root.getString("cat"));
//            JSONArray array = root.getJSONArray("languages");
//            for (int i = 0; i < array.length(); i++) {
//                JSONObject lan = array.getJSONObject(i);
//                System.out.println("----------------");
//                System.out.println("id=" + lan.getInt("id"));
//                System.out.println("name=" + lan.getString("name"));
//                System.out.println("ide=" + lan.getString("ide"));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        try {
            JSONObject root = new JSONObject();
            root.put("cat", "it");

            JSONObject lan1 = new JSONObject();
            lan1.put("id", 1);
            lan1.put("ide", "Android Studio");
            lan1.put("name", "Java");

            JSONObject lan2 = new JSONObject();
            lan2.put("id", 2);
            lan2.put("ide", "Xcode");
            lan2.put("name", "Swift");

            JSONObject lan3 = new JSONObject();
            lan3.put("id", 3);
            lan3.put("ide", "Visual Studio");
            lan3.put("name", "C#");

            JSONArray array = new JSONArray();
            array.put(lan1);
            array.put(lan2);
            array.put(lan3);

            root.put("languages", array);

            System.out.println(root.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
