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
    String[] Friendship={"Dushmano Se Mohabbat Hone Lagi Hai Mujhe,\n" +
            "Jaise Jaise Dosto Ko Aazmata Ja Raha Hoon.",
            "Daag Duniya Ne Diye Zakhm Zamane Se Mile,\n" +
                    "HumKo Tohfe Ye Tumhein Dost Banaane Se Mile.",
            "Dost Hokar Bhi Maheeno Nahi Milta Mujhse,\n" +
                    "Uss Se Kehna Ki Kabhi Zakhm Lagaane Aaye.",
            "Aap Jiske Waste Mujhse Kinara Kar Gaye,\n" +
                    "Aapse Bach Kar Wahi Mujhko Ishara Kar Gaye." ,
            "Toofano Ki Dushmani Se Na Bachte To Khair Thi,\n" +
                    "Saahil Se Doston Ke Bharam Ne Dubo Diya."};
    String[] Fun={"Jise Koyal Samjha Wo Kauwa Nikla,\n" +
            "Dosti Ke Naam Par Hauwa Nikla",
            "Bahut Khoobsurat Ho Tum Phool Ki Tareh,\n" +
                    "Khud Ko Duniya Ki Najar Se Bachaya Karo",
            "Twinkle Twinkle Little Star,\n" +
                    "Teri GirlFriend Gayi Bazaar,\n" +
                    "Usko Mil Gaya Doosra Yaar",
            "Mohabbat Na Sahi Mukadama Hi Kar De,\n" +
                    "Tareekh-Dar-Tareekh Mulakaat To Hogi." ,
            "Kaash Tujhe Lag Jaye Mohabbat Ki Thand.\n" +
                    "Aur Tu Maange Mujhe Kambal Ki Tarah."};
    String[] God={"Thank God for everything you have received. Whether it’s good or bad. Some are like blessings and some are lessons.",
            "God is present everywhere at all times, just need to be found.",
            "God does not give us everything that we want, but He leads us on the best and straight path that leads to him.",
            "God loves each one of us as if we are the only one for him." ,
            "God never says that the journey will be easy but when you get the destination, you will forget all the pain."};
    String[] Inspiration={"हौसले भी किसी हकीम से कम नहीं होते,\n" +
            "हर तकलीफ़ में ताकत की दवा देते हैं।",
            "एक सूरज था कि तारों के घराने से उठा,\n" +
                    "आँख हैरान है क्या शख़्स ज़माने से उठा।",
            "यही सोच कर हर तपिश में जलता आया हूँ,\n" +
                    "धूप कितनी भी तेज हो समंदर नहीं सूखा करते।",
            "लकीरें अपने हाथों की बनाना हमको आता है,\n" +
                    "वो कोई और होंगे अपनी किस्मत पे जो रोते हैं।" ,
            "दीया बुझाने की फितरत बदल भी सकती है,\n" +
                    "कोई चिराग हवा पे दवाब तो डाले।"};
    String[] Life={"उदासियों की वजहें तो बहुत हैं ज़िंदगी में,\n" +
            "बेवजह खुश रहने का मजा ही कुछ और है।",
            "चरागों तक को जहाँ मय्यसर नहीं रौशनी,\n" +
                    "लौ उम्मीद की हमने वहाँ भी जलाये रक्खी।",
            "खुद को यूँ खोकर ज़िन्दगी को मायूस न कर,\n" +
                    "मंज़िलें चारों तरफ हैं रास्तों की तलाश कर।",
            "चैन से रहने का हमको मशवरा मत दीजिये,\n" +
                    "अब मजा देने लगी है ज़िन्दगी की मुश्किलें।" ,
            "जिन के होठों पे हँसी पाँव में छाले होंगे,\n" +
                    "वही लोग अपनी मंज़िल को पाने वाले होंगे।"};
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

        category_img=img_arr[pos];

        activity_title=category_name_arr[pos];
        actionBar=getSupportActionBar();
        actionBar.setTitle(activity_title);

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

        ShayriAdapter myShayriAdapter;
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