package com.example.Simple_Gallery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FullScreenActivity extends AppCompatActivity {

    private static final String EXTRA_IMAGE_PATHS = "extra_image_paths";
    private static final String EXTRA_POSITION = "extra_position";

    private ArrayList<String> imagePaths;
    private int position;

    public static void start(Context context, ArrayList<String> imagePaths, int position) {
        Intent intent = new Intent(context, FullScreenActivity.class);
        intent.putStringArrayListExtra(EXTRA_IMAGE_PATHS, imagePaths);
        intent.putExtra(EXTRA_POSITION, position);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);

        ImageView imageView = findViewById(R.id.imageViewFullScreen);

        imagePaths = getIntent().getStringArrayListExtra(EXTRA_IMAGE_PATHS);
        position = getIntent().getIntExtra(EXTRA_POSITION, 0);

        String imagePath = imagePaths.get(position);
        Picasso.get().load("file://" + imagePath).into(imageView);
    }
}
