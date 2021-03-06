package com.tom.expense;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class QueryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        ListView list = (ListView) findViewById(R.id.list);
        DBHelper helper = new DBHelper(this, "expense.db", null , 1);
        Cursor c = helper.getReadableDatabase().query("expense", null, null, null, null, null, null);

        String[] from = {"udate", "name", "amount"};
//        int[] to = {android.R.id.text1, android.R.id.text2};
        int[] to = {R.id.col_date, R.id.col_name, R.id.col_amount};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                R.layout.row, c, from, to, 1);

        list.setAdapter(adapter);


        /*String[] data = {"AAA", "BBB", "CCC"};
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.fruits));
        list.setAdapter(adapter);*/





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_query, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
