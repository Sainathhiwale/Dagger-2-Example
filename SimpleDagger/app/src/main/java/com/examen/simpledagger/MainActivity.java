package com.examen.simpledagger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.examen.simpledagger.network.Api;
import com.examen.simpledagger.network.model.Android;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
   @Inject
    Retrofit retrofit;
    ListView listView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Application)getApplication()).getNetComponent().inject(this);
        listView = (ListView)findViewById(R.id.listView);

        getHeroes();
    }

    private void getHeroes() {
        Api api = retrofit.create(Api.class);
        Call<List<Android>> listCall = api.getAndroidLst();
        listCall.enqueue(new Callback<List<Android>>() {
            @Override
            public void onResponse(Call<List<Android>> call, Response<List<Android>> response) {
                List<Android> androidList = response.body();
                String [] androiditem = new String[androidList.size()];
                for (int i=0;i<androidList.size();i++){
                   androiditem[i] = androidList.get(i).getTitle();
                }
                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,androiditem));
                
            }

            @Override
            public void onFailure(Call<List<Android>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
