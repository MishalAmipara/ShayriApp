package com.example.shayriapp.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.shayriapp.Adapter.ShayriAdapter;
import com.example.shayriapp.R;

public class Shayri_List extends AppCompatActivity
{
    String[] BestWishes={"Zindagi Har Pal Kuchh Khaas Nahi Hoti",
            "Tum Dost Ban Ke Aise Aaye Zindagi Mein Ki Hum Yeh Zamana Hi Bhool Gaye",
            "Zindagi Ke Toofanon Ka Saahil Hai Dosti Dil Ke Armaanon Ki Manzil Hai Dosti",
            "Aapki Humari Dosti Suron Ka Saaj Hai Aap Jaise Dost Par Hamein Naaz Hai " ,
            "Insaniyat Ki Roshni Gumm Ho Gayi Kahan? Saaye To Hain Aadmi Ke Magar Aadmi Kahan?"};
    String[] Friendship={"Zindagi Har Pal Kuchh Khaas Nahi Hoti",
            "Tum Dost Ban Ke Aise Aaye Zindagi Mein Ki Hum Yeh Zamana Hi Bhool Gaye",
            "Zindagi Ke Toofanon Ka Saahil Hai Dosti Dil Ke Armaanon Ki Manzil Hai Dosti",
            "Aapki Humari Dosti Suron Ka Saaj Hai Aap Jaise Dost Par Hamein Naaz Hai " ,
            "Insaniyat Ki Roshni Gumm Ho Gayi Kahan? Saaye To Hain Aadmi Ke Magar Aadmi Kahan?"};
    String[] Fun={"Zindagi Har Pal Kuchh Khaas Nahi Hoti",
            "Tum Dost Ban Ke Aise Aaye Zindagi Mein Ki Hum Yeh Zamana Hi Bhool Gaye",
            "Zindagi Ke Toofanon Ka Saahil Hai Dosti Dil Ke Armaanon Ki Manzil Hai Dosti",
            "Aapki Humari Dosti Suron Ka Saaj Hai Aap Jaise Dost Par Hamein Naaz Hai " ,
            "Insaniyat Ki Roshni Gumm Ho Gayi Kahan? Saaye To Hain Aadmi Ke Magar Aadmi Kahan?"};
    String[] God={"Zindagi Har Pal Kuchh Khaas Nahi Hoti",
            "Tum Dost Ban Ke Aise Aaye Zindagi Mein Ki Hum Yeh Zamana Hi Bhool Gaye",
            "Zindagi Ke Toofanon Ka Saahil Hai Dosti Dil Ke Armaanon Ki Manzil Hai Dosti",
            "Aapki Humari Dosti Suron Ka Saaj Hai Aap Jaise Dost Par Hamein Naaz Hai " ,
            "Insaniyat Ki Roshni Gumm Ho Gayi Kahan? Saaye To Hain Aadmi Ke Magar Aadmi Kahan?"};
    String[] Inspiration={"Zindagi Har Pal Kuchh Khaas Nahi Hoti",
            "Tum Dost Ban Ke Aise Aaye Zindagi Mein Ki Hum Yeh Zamana Hi Bhool Gaye",
            "Zindagi Ke Toofanon Ka Saahil Hai Dosti Dil Ke Armaanon Ki Manzil Hai Dosti",
            "Aapki Humari Dosti Suron Ka Saaj Hai Aap Jaise Dost Par Hamein Naaz Hai " ,
            "Insaniyat Ki Roshni Gumm Ho Gayi Kahan? Saaye To Hain Aadmi Ke Magar Aadmi Kahan?"};
    String[] Life={"Zindagi Har Pal Kuchh Khaas Nahi Hoti",
            "Tum Dost Ban Ke Aise Aaye Zindagi Mein Ki Hum Yeh Zamana Hi Bhool Gaye",
            "Zindagi Ke Toofanon Ka Saahil Hai Dosti Dil Ke Armaanon Ki Manzil Hai Dosti",
            "Aapki Humari Dosti Suron Ka Saaj Hai Aap Jaise Dost Par Hamein Naaz Hai " ,
            "Insaniyat Ki Roshni Gumm Ho Gayi Kahan? Saaye To Hain Aadmi Ke Magar Aadmi Kahan?"};
    int pos;
    int[] img_arr;
    String[] category_name_arr;
    String activity_title;
    int category_img;
    ActionBar actionBar;
    String[] temp;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shayri_list);

        pos= getIntent().getIntExtra("pos",0);
        category_name_arr=getIntent().getStringArrayExtra("cat_name_arr");
        img_arr=getIntent().getIntArrayExtra("img_arr");

        ShayriAdapter myShayriAdapter;
        activity_title=category_name_arr[pos];
        actionBar=getSupportActionBar();
        actionBar.setTitle(activity_title);
        category_img=img_arr[pos];

        if (pos==0)
        {
            temp=BestWishes;
        }
        if(pos==1)
        {
            temp=Friendship;
        }
        if(pos==2)
        {
            temp=Fun;
        }
        if(pos==3)
        {
            temp=God;
        }
        if(pos==4)
        {
            temp=Inspiration;
        }
        if(pos==5)
        {
            temp=Life;
        }

        ListView category_listView=findViewById(R.id.shayri_list);
        myShayriAdapter=new ShayriAdapter(this,temp,category_img);
        category_listView.setAdapter(myShayriAdapter);
        category_listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Intent intent=new Intent(Shayri_List.this,Shayri_Details_Activity.class);
                intent.putExtra("shayriArr",temp);
                intent.putExtra("pos",i);
                startActivity(intent);
            }
        });
    }
}