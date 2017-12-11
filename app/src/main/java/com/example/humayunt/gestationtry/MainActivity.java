package com.example.humayunt.gestationtry;

import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    Button btn_retreive;
    DatabaseHandler db;
    RecyclerView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btn_retreive = (Button) findViewById(R.id.btn_retrieve);
        this.list = (RecyclerView) findViewById(R.id.list_dblayout);
        this.list.setHasFixedSize(true);
        this.list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        RetriveDataFromDB();
    }
    protected void RetriveDataFromDB() {
        try {
            this.db = new DatabaseHandler(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.db.createdatabase();
            try {
                this.db.opendatabase();
                ArrayList<DbEntity> menuItems = new ArrayList();
                menuItems.clear();
                ArrayList<DbEntity> contacts = this.db.getInputMonths();
                Log.e("Array", ">>" + menuItems.size());
                this.list.setAdapter(new DbRetrieveAdapter(this, contacts));
            } catch (SQLException sqle) {
                throw sqle;
            }
        } catch (IOException e2) {
            throw new Error("Unable to create database");
        }
    }

    public void onClick(View v) {
    }
}
