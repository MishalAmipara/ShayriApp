package com.example.shayriapp.Activity;

import static com.example.shayriapp.Color_Array.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
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

import com.example.shayriapp.Adapter.BackgroundAdapter;
import com.example.shayriapp.Adapter.FontAdapter;
import com.example.shayriapp.Color_Array;
import com.example.shayriapp.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Collections;
import java.util.Random;

public class Edit_Shayri_Activity extends AppCompatActivity implements View.OnClickListener
{

    SeekBar seekBar;
    TextView textView;
    String text;
    String[] emog= {"\uD83D\uDE0A \uD83E\uDEE3 \uD83E\uDD2B \uD83D\uDE0A \uD83E\uDEE3 \uD83E\uDD2B",
            "\uD83D\uDE0A \uD83E\uDEE3 \uD83E\uDD2B \uD83D\uDE0A \uD83E\uDEE3 \uD83E\uDD2B",
            "\uD83D\uDE0A \uD83E\uDEE3 \uD83E\uDD2B \uD83D\uDE0A \uD83E\uDEE3 \uD83E\uDD2B",
            "\uD83D\uDE0A \uD83E\uDEE3 \uD83E\uDD2B \uD83D\uDE0A \uD83E\uDEE3 \uD83E\uDD2B",
            "\uD83D\uDE0A \uD83E\uDEE3 \uD83E\uDD2B \uD83D\uDE0A \uD83E\uDEE3 \uD83E\uDD2B",
             "\uD83E\uDD10 \uD83D\uDE2F \uD83E\uDD1A \uD83D\uDC4B",
            "\uD83E\uDDD3 \uD83E\uDDD1 \uD83D\uDC69 \uD83D\uDC67",
            "\uD83E\uDD26 \uD83D\uDE47 \uD83D\uDE46 \uD83E\uDD37",
            "\uD83D\uDC91  \uD83D\uDC6B \uD83D\uDC6D \uD83D\uDC6C"};
    int[] grad= gradients;
    TextView t_View;
    Button theme,zoom,text_color,text_size,share,font,emoji,bg;
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
        share.setOnClickListener(this);
        font.setOnClickListener(this);
        emoji.setOnClickListener(this);
        text_size.setOnClickListener(this);
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
        if(view.getId()==share.getId())
        {
            Intent intent = new Intent(android.content.Intent.ACTION_SEND);
            intent.setType("image/jpg");
            TextView textView=findViewById(R.id.fullscreen);
            Bitmap bmi= getBitmapFromView(textView);
            startActivity(Intent.createChooser(intent, ""));
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
}