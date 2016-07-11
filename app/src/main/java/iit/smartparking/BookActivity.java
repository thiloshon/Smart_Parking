package iit.smartparking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        String[] data = new String[5];


        data[0] = "            PARKING SLOTS                  AVAILABILITY" ;
        data[1] = "Galle Road, Colombo 06                        " + LoginActivity.data.get(0);
        data[2] = "Vivekananda Road, Colombo 06          " + LoginActivity.data.get(1);
        data[3] = "Testing Location                                     " + LoginActivity.data.get(2);
        data[4] = "Testing Location                                     " + LoginActivity.data.get(3);


        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.book_listview, data);


        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

    }



    public void bookSlot(View view)  {


        Intent intent = new Intent(this, BookSlot.class);
        startActivity(intent);


    }


}
