package com.example.abdulrahman.readjsonfile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList <ModelDev> modelDevs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* String JsonFromURL="{" +

                "'info':{'name':'hussein','age':27 }," +

                "'jobs':" +

                "[" +

                "{'id':1, 'title':'developer','desc':'nyc'}," +

                "{'id':2, 'title':'developer','desc':'nyc'}," +

                "{'id':3, 'title':'developer','desc':'nyc'}" +

                "]" +

                "}";

        try {
            JSONObject json= new JSONObject(JsonFromURL);

            JSONObject info=json.getJSONObject("info");

            String name=info.getString("name");

            int age=info.getInt("age");

            JSONArray jobs=json.getJSONArray("jobs");
              Toast.makeText(this,name,Toast.LENGTH_LONG).show();


            for ( int i=0; i<jobs.length();i++){

                JSONObject Jobs= jobs.getJSONObject(i)  ;

                String title=Jobs.getString("title");

                String desc=Jobs.getString("desc");

                int id=Jobs.getInt("id");



            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        */

        ListView listView=(ListView) findViewById(R.id.lisd);
        modelDevs =new ArrayList<>();

       String JsonDa="{"

               +"'info':{'name':'Abdulrahman','age':22},"
               +"'jobs':["
               +"{ 'id':1,'title':'Developer '},"
               +"{'id':2,'title':'Tester '}"
               +"]"

               +"}";

        try {
            JSONObject jsonObject=new JSONObject(JsonDa);
            JSONObject info=jsonObject.getJSONObject("info");
            String name =info.getString("name");
            int age=info.getInt("age");
            Toast.makeText(this,name+" : "+age,Toast.LENGTH_LONG).show();
            JSONArray array=jsonObject.getJSONArray("jobs");
            for (int i=0;i<array.length();i++){
                JSONObject josa=array.getJSONObject(i);
                modelDevs.add(new ModelDev(josa.getString("title"),""+josa.getInt("id")));
                Toast.makeText(this,josa.getString("title"),Toast.LENGTH_LONG).show();
            }
          List list=new List(modelDevs);
           listView.setAdapter(list);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public class List extends BaseAdapter{
ArrayList<ModelDev> modelDevs;

        public List(ArrayList<ModelDev> modelDevs) {
            this.modelDevs = modelDevs;
        }

        @Override
        public int getCount() {
            return modelDevs.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater=getLayoutInflater();
                View view1=layoutInflater.inflate(R.layout.list_dev,null);
            TextView title=(TextView) view1.findViewById(R.id.textView);
            TextView id=(TextView) view1.findViewById(R.id.textView2);
            title.setText(modelDevs.get(i).title);
            id.setText(modelDevs.get(i).id+"");

            return view1;
        }
    }
}
