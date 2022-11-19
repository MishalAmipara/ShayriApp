package com.example.shayriapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import com.example.shayriapp.Adapter.CategoryAdapter;
import com.example.shayriapp.R;

public class Category_List extends AppCompatActivity
{

    String[] cat_name_arr={"Best Wishes","Friendship", "Fun",
            "God", "Inspiration", "Life",
            "Love", "Memorable","Sad",
            "Birthday","Politics","Others"};
    int[] img_arr={R.drawable.bearbar,R.drawable.bestwishesh,R.drawable.birthday,
                    R.drawable.boyfriendgirl,R.drawable.bewfa,R.drawable.child,
                    R.drawable.holiimg,R.drawable.husband,R.drawable.god,
                    R.drawable.love,R.drawable.motivational,R.drawable.sad};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);
        CategoryAdapter myCategoryAdapter;
        myCategoryAdapter=new CategoryAdapter(this,cat_name_arr,img_arr);
        ListView listView = findViewById(R.id.category_list);
        listView.setAdapter(myCategoryAdapter);
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            System.out.println(""+cat_name_arr[i]);
            Intent intent=new Intent(Category_List.this, Shayri_List.class);
            intent.putExtra("pos",i);
            intent.putExtra("cat_name_arr",cat_name_arr);
            intent.putExtra("img_arr",img_arr);

            startActivity(intent);

        });
    }
}