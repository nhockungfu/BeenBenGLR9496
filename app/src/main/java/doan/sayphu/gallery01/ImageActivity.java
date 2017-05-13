package doan.sayphu.gallery01;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.github.chrisbanes.photoview.PhotoView;

import doan.sayphu.transformations.BlurTransformation;
import doan.sayphu.transformations.ColorFilterTransformation;
import doan.sayphu.transformations.CropCircleTransformation;
import doan.sayphu.transformations.gpu.SepiaFilterTransformation;
import doan.sayphu.transformations.gpu.ToonFilterTransformation;

/**
 * Created by BEN on 26/04/2017.
 */

public class ImageActivity extends AppCompatActivity {

    String image_current_path;
    Button button;
    PhotoView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        button = (Button)findViewById(R.id.button);
        image_current_path = getIntent().getStringExtra("image_path");
        imageView = (PhotoView)findViewById(R.id.image_view);


/*
        Glide.with(getApplicationContext()).load("file://" + image_current_path)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(imageView);*/


        /*Glide.with(getApplicationContext()).load("file://" + image_current_path)
                .bitmapTransform(new BlurTransformation(getApplicationContext(), 25), new CropCircleTransformation(getApplicationContext()))
                .into(imageView);*/
        Glide.with(getApplicationContext())
                .load("file://" + image_current_path)
                .bitmapTransform(new ToonFilterTransformation(getApplicationContext()))
                .into(imageView);
       /* Glide.with(getApplicationContext()).load("file://" + image_current_path)
                .bitmapTransform(new CropCircleTransformation(getApplicationContext()), new SepiaFilterTransformation(getApplicationContext(), ))
                .into(imageView);*/
/*
        Glide.with(getApplicationContext()).load("file://" + image_current_path)
                .bitmapTransform(new BlurTransformation(getApplicationContext(), 25), new CropCircleTransformation(getApplicationContext()))
                .into(imageView);*/
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Glide.with(getApplicationContext()).load("file://" + image_current_path).asBitmap().centerCrop().into(new BitmapImageViewTarget(imageView) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(getApplicationContext().getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        imageView.setImageDrawable(circularBitmapDrawable);
                    }
                });
            }
        });
    }
}
