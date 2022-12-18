package com.example.shayriapp.Activity;

import static com.example.shayriapp.Color_Array.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shayriapp.Adapter.BackgroundAdapter;
import com.example.shayriapp.Adapter.FontAdapter;
import com.example.shayriapp.Color_Array;
import com.example.shayriapp.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class Edit_Shayri_Activity extends AppCompatActivity implements View.OnClickListener
{

    SeekBar seekBar;
    TextView textView;
    String text;

    int[] grad= gradients;
    TextView t_View;
    Button theme,zoom,text_color,text_size,share,font,emoji,bg;
    File f;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_shayri);
        text=getIntent().getStringExtra("Text_Shayri");

        textView=findViewById(R.id.fullscreen);
        textView.setText(text);
        theme=findViewById(R.id.thme);
        zoom=findViewById(R.id.zoom);
        bg=findViewById(R.id.btnbg);
        text_color=findViewById(R.id.btn_text_color);
        share=findViewById(R.id.btn_text_share);
        font=findViewById(R.id.btn_Font);
        emoji=findViewById(R.id.btn_Emoji);
        text_size=findViewById(R.id.btn_text_Size);

        theme.setOnClickListener(this);
        zoom.setOnClickListener(this);
        bg.setOnClickListener(this);
        text_color.setOnClickListener(this);

        font.setOnClickListener(this);
        emoji.setOnClickListener(this);
        text_size.setOnClickListener(this);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                Bitmap icon = getBitmapFromView(textView);
                //Intent share = new Intent(Intent.ACTION_SEND);
                Intent share =new Intent(Intent.ACTION_SEND);
                share.setType("image/jpeg");
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                icon.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                int num=new Random().nextInt(2000);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
                String currentDateandTime = sdf.format(new Date());

                f= new File(Color_Array.file.getAbsolutePath() + "/IMG_"+currentDateandTime+".jpg");
                try
                {
                    f.createNewFile();
                    FileOutputStream fo = new FileOutputStream(f);
                    fo.write(bytes.toByteArray());
                    Toast.makeText(Edit_Shayri_Activity.this,"File Downloaded",Toast.LENGTH_SHORT).show();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }

                share.putExtra(Intent.EXTRA_STREAM, Uri.parse(f.getAbsolutePath()));
                startActivity(Intent.createChooser(share, "Share Image"));
            }

        });
    }

    @Override
    public void onClick(View view)
    {
        if (view.getId()==zoom.getId())
        {
            BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(this);
            View view1= LayoutInflater.from(this).inflate(R.layout.layout_background,null);

            GridView gridView=view1.findViewById(R.id.layout_background_grid);
            gridView.setNumColumns(2);
            //t_View.setBackgroundColor(getResources().getColor(Color_Array.colors[0]));
            //ArrayAdapter arrayAdapter=new ArrayAdapter(this,R.layout.background_grid_item,R.id.grid_text, Collections.singletonList(colors));
            BackgroundAdapter backgroundAdapter=new BackgroundAdapter(this, gradients,"gradient");
            gridView.setAdapter(backgroundAdapter);
            bottomSheetDialog.setContentView(view1);
            bottomSheetDialog.show();

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    textView.setBackgroundResource(gradients[i]);
                }
            });
        }
        if(view.getId()==theme.getId())
        {
            int min=0;
            int max= gradients.length;
            int random=new Random().nextInt(max-min)+min;
            textView.setBackgroundResource(gradients[random]);


        }
        if(view.getId()==bg.getId())
        {
            BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(this);
            View view1= LayoutInflater.from(this).inflate(R.layout.layout_background,null);

            GridView gridView=view1.findViewById(R.id.layout_background_grid);
            //t_View.setBackgroundColor(getResources().getColor(Color_Array.colors[0]));
            //ArrayAdapter arrayAdapter=new ArrayAdapter(this,R.layout.background_grid_item,R.id.grid_text, Collections.singletonList(colors));
            gridView.setNumColumns(3);
            BackgroundAdapter backgroundAdapter=new BackgroundAdapter(this, colors,"color");
            gridView.setAdapter(backgroundAdapter);
            bottomSheetDialog.setContentView(view1);
            bottomSheetDialog.show();

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    textView.setBackgroundColor(view.getResources().getColor(Color_Array.colors[i]));
                }
            });
        }
        if (view.getId()==text_color.getId())
        {
            BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(this);
            View view1= LayoutInflater.from(this).inflate(R.layout.layout_background,null);

            GridView gridView=view1.findViewById(R.id.layout_background_grid);
            //t_View.setBackgroundColor(getResources().getColor(Color_Array.colors[0]));
            //ArrayAdapter arrayAdapter=new ArrayAdapter(this,R.layout.background_grid_item,R.id.grid_text, Collections.singletonList(colors));
            gridView.setNumColumns(5);
            BackgroundAdapter backgroundAdapter=new BackgroundAdapter(this, colors,"color");
            gridView.setAdapter(backgroundAdapter);
            bottomSheetDialog.setContentView(view1);
            bottomSheetDialog.show();

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    textView.setTextColor(view.getResources().getColor(Color_Array.colors[i]));
                    bottomSheetDialog.dismiss();
                }
            });
        }


        if (view.getId()==font.getId())
        {
            BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(this);
            View view1= LayoutInflater.from(this).inflate(R.layout.layout_font_change,null);

            GridView gridView=view1.findViewById(R.id.font_change_list);
            gridView.setNumColumns(font.length());
            //t_View.setBackgroundColor(getResources().getColor(Color_Array.colors[0]));
            //ArrayAdapter arrayAdapter=new ArrayAdapter(this,R.layout.background_grid_item,R.id.grid_text, Collections.singletonList(colors));
            FontAdapter fontAdapter=new FontAdapter(this,fonts);
            gridView.setAdapter(fontAdapter);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
                {
                    Typeface typeface= Typeface.createFromAsset(getAssets(),fonts[i]);
                    textView.setTypeface(typeface);
                }
            });
            bottomSheetDialog.setContentView(view1);
            bottomSheetDialog.show();

        }
        if(view.getId()==emoji.getId())
        {

            ListView listView;
            listView=findViewById(R.id.layout_emogies_list);
            ArrayAdapter arrayAdapter;

            BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(this);
            View view1= LayoutInflater.from(this).inflate(R.layout.layout_emogies,null);

            listView =view1.findViewById(R.id.layout_emogies_list);
            ListAdapter listAdapter=new com.example.shayriapp.Adapter.ListAdapter(this, emog);
            listView.setAdapter(listAdapter);
            bottomSheetDialog.setContentView(view1);
            bottomSheetDialog.show();

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    textView.setText(emog[i]+"\n"+text+"\n"+emog[i]);
                    bottomSheetDialog.dismiss();
                }
            });


        }
        if (view.getId()==text_size.getId())
        {
            BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(this);
            View view1= LayoutInflater.from(this).inflate(R.layout.layout_seekbar,null);
            //SeekBar seekBar=findViewById(R.id.seekbar);
            seekBar=view1.findViewById(R.id.seekbar);
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    textView.setTextSize(2,30+i);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
            bottomSheetDialog.setContentView(view1);
            bottomSheetDialog.show();
        }

    }

    private Bitmap getBitmapFromView(View view1)
    {
        //Define a bitmap with the same size as the view
        Bitmap returnedBitmap = Bitmap.createBitmap(view1.getWidth(), view1.getHeight(), Bitmap.Config.ARGB_8888);
        //Bind a canvas to it
        Canvas canvas = new Canvas(returnedBitmap);
        //Get the view's background
        Drawable bgDrawable = view1.getBackground();
        if (bgDrawable != null)
        {
            //has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas);
        }
        else
        {
            //does not have background drawable, then draw white background on the canvas
            canvas.drawColor(Color.WHITE);
        }
        // draw the view on the canvas
        view1.draw(canvas);
        //return the bitmap
        return returnedBitmap;
    }
}