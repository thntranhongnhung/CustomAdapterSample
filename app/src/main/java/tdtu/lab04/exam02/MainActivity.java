package tdtu.lab04.exam02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private CustomAdapter CustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();
    }

    /**
     * Init Data
     */
    public void init(){
        List<String> listItems = new ArrayList<String>();
        for(int i=1;i<7;i++) {
            listItems.add("item" + i);
        }
        listView = (ListView)findViewById(R.id.listview);
        CustomAdapter = new CustomAdapter(MainActivity.this,R.layout.list_item_view,listItems);
        listView.setAdapter(CustomAdapter);
    }
}