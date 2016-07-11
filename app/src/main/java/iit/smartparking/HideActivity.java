package iit.smartparking;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hide);


        String[] data = new String[5];


        data[0] = "            PARKING SLOTS                  AVAILABILITY" ;
        data[1] = "Galle Road, Colombo 06                        " + LoginActivity.data.get(0);
        data[2] = "Vivekananda Road, Colombo 06          " + LoginActivity.data.get(1);
        data[3] = "Testing Location                                     " + LoginActivity.data.get(2);
        data[4] = "Testing Location                                     " + LoginActivity.data.get(3);


        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.hide_listview, data);


        ListView listView = (ListView) findViewById(R.id.listView2);
        listView.setAdapter(adapter);

    }



    public void hideSlot(View view)  {


        Intent intent = new Intent(this, HideSlot.class);
        startActivity(intent);


    }


}
