package com.example.shayriapp.Activity;

import static com.example.shayriapp.Color_Array.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.example.shayriapp.Adapter.BackgroundAdapter;
import com.example.shayriapp.Color_Array;
import com.example.shayriapp.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Collections;

public class Edit_Shayri_Activity extends AppCompatActivity implements View.OnClickListener
{

    TextView textView;
    String text;
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
        if (view.getId()==theme.getId())
        {

        }
        if(view.getId()==zoom.getId())
        {

        }
        if(view.getId()==bg.getId())
        {
            BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(this);
            View view1= LayoutInflater.from(this).inflate(R.layout.layout_background,null);

            GridView gridView=view1.findViewById(R.id.layout_background_grid);
            //t_View.setBackgroundColor(getResources().getColor(Color_Array.colors[0]));
            //ArrayAdapter arrayAdapter=new ArrayAdapter(this,R.layout.background_grid_item,R.id.grid_text, Collections.singletonList(colors));
            BackgroundAdapter backgroundAdapter=new BackgroundAdapter(this, colors);
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
            BackgroundAdapter backgroundAdapter=new BackgroundAdapter(this, colors);
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
            /*This will be the actual content you wish you share.*/

            String shareBody = text;
            /*The type of the content is text, obviously.*/
            intent.setType("text/plain");
            /*Applying information Subject and Body.*/
            //intent.putExtra(android.content.Intent.EXTRA_SUBJECT, getString(R.string.share_subject));
            intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            /*Fire!*/
            startActivity(Intent.createChooser(intent, ""));
        }
        if (view.getId()==font.getId())
        {

        }
        if(view.getId()==emoji.getId())
        {

        }
        if (view.getId()==text_size.getId())
        {

        }

    }
}