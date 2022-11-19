package com.example.shayriapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shayriapp.R;

public class Shayri_Details_Activity extends AppCompatActivity
{

    String[] shayri_Arr;
    int pos,i=0;
    TextView textView;
    Button pre,next;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shayri_details);
        shayri_Arr=getIntent().getStringArrayExtra("shayriArr");
        pos=getIntent().getIntExtra("pos",0);
        textView=findViewById(R.id.shayri_details_text);
        textView.setText(shayri_Arr[pos]);
        pre=findViewById(R.id.pre);
        next=findViewById(R.id.next);
        TextView textCount=findViewById(R.id.txtCount);
        textCount.setText((pos+1)+"/"+shayri_Arr.length);
        Button copy=findViewById(R.id.copy);
        Button share=findViewById(R.id.share);
        Button edit=findViewById(R.id.edit);
        Button full=findViewById(R.id.full);
        Button thme=findViewById(R.id.thme);

        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

               if(pos>0)
               {
                   pos--;
                   textView.setText(shayri_Arr[pos]);
                   textCount.setText((pos+1)+"/"+shayri_Arr.length);
               }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(pos<shayri_Arr.length-1)
                {
                    pos++;
                    textView.setText(shayri_Arr[pos]);
                    textCount.setText((pos+1)+"/"+shayri_Arr.length);
                }
                //i++;
            }
        });
        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", shayri_Arr[pos]);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(Shayri_Details_Activity.this, "Copied", Toast.LENGTH_SHORT).show();
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                /*This will be the actual content you wish you share.*/
                String shareBody = shayri_Arr[pos];
                /*The type of the content is text, obviously.*/
                intent.setType("text/plain");
                /*Applying information Subject and Body.*/
                // intent.putExtra(android.content.Intent.EXTRA_SUBJECT, getString(R.string.share_subject));
                intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                /*Fire!*/
                startActivity(Intent.createChooser(intent, ""));
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent=new Intent(Shayri_Details_Activity.this,Edit_Shayri_Activity.class);
            intent.putExtra("pos",i);
            String text=textView.getText().toString();
            intent.putExtra("Text_Shayri",text);
            startActivity(intent);

            }
        });

        full.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        thme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}