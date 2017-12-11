package com.example.humayunt.gestationtry;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
    private SQLiteDatabase db;
    DatabaseHandler dh = new DatabaseHandler(this);
    public ImageView diagram;
    public TextView fact;
    public ImageView img;
    public TextView info;
    boolean isImageFitToScreen;
    public TextView month;

    public Main2Activity() throws IOException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        this.db = this.dh.getReadableDatabase();
        this.month = (TextView) findViewById(R.id.textView);
        this.info = (TextView) findViewById(R.id.textView2);
        this.fact = (TextView) findViewById(R.id.textView3);
        this.img = (ImageView) findViewById(R.id.imageView2);
        this.diagram = (ImageView) findViewById(R.id.imageView3);
        String id = getIntent().getExtras().getString("month");
        int mon = Integer.parseInt(id);
        Toast.makeText(this, id, Toast.LENGTH_LONG).show();
        String selectQuery = "SELECT  * FROM twodguide where month =" + mon;
        Log.d("rawquery", "inputs" + selectQuery);
        Cursor cursor = this.db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            DbEntity itto = new DbEntity();
            byte[] byteArray = cursor.getBlob(2);
            byte[] byteArray2 = cursor.getBlob(3);
            Bitmap bm = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            Bitmap bm2 = BitmapFactory.decodeByteArray(byteArray2, 0, byteArray2.length);
            this.month.setText("Month : " + cursor.getString(0));
            this.info.setText(cursor.getString(1));
            this.img.setImageBitmap(bm);
            this.diagram.setImageBitmap(bm2);
            this.fact.setText(cursor.getString(4));
        }
        this.img.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (Main2Activity.this.isImageFitToScreen) {
                    Main2Activity.this.isImageFitToScreen = false;
                    Main2Activity.this.img.setLayoutParams(new LayoutParams(-2, -2));
                    Main2Activity.this.img.setAdjustViewBounds(true);
                    return;
                }
                Main2Activity.this.isImageFitToScreen = true;
                Main2Activity.this.img.setLayoutParams(new LayoutParams(-1, -1));
                Main2Activity.this.img.setScaleType(ScaleType.FIT_XY);
            }
        });
        this.diagram.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (Main2Activity.this.isImageFitToScreen) {
                    Main2Activity.this.isImageFitToScreen = false;
                    Main2Activity.this.diagram.setLayoutParams(new LayoutParams(-2, -2));
                    Main2Activity.this.diagram.setAdjustViewBounds(true);
                    return;
                }
                Main2Activity.this.isImageFitToScreen = true;
                Main2Activity.this.diagram.setLayoutParams(new LayoutParams(-1, -1));
                Main2Activity.this.diagram.setScaleType(ScaleType.FIT_XY);
            }
        });
    }
}
