package doan.sayphu.gallery01;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.github.chrisbanes.photoview.PhotoView;

/**
 * Created by BEN on 26/04/2017.
 */

public class ImageActivity extends AppCompatActivity {

    String image_current_path;
    PhotoView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        image_current_path = getIntent().getStringExtra("image_path");
        imageView = (PhotoView)findViewById(R.id.image_view);


        Glide.with(getApplicationContext()).load("file://" + image_current_path)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(imageView);
    }
}
