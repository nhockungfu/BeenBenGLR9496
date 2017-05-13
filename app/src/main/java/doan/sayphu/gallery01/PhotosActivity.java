package doan.sayphu.gallery01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import static doan.sayphu.gallery01.MainActivity.al_images;

/**
 * Created by BEN on 20/04/2017.
 */

public class PhotosActivity  extends AppCompatActivity {
    int int_position;
    private GridView gridView;
    GridViewAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView)findViewById(R.id.gv_folder);
        int_position = getIntent().getIntExtra("value", 0);
        adapter = new GridViewAdapter(this, al_images,int_position);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String image_current_path = MainActivity.al_images.get(int_position).getAl_imagepath().get(position);
                Intent intent = new Intent(PhotosActivity.this, ImageActivity.class);
                intent.putExtra("image_path", image_current_path);
                startActivity(intent);
            }
        });

    }
}
