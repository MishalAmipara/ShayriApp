package com.example.shayriapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shayriapp.Activity.Shayri_List;
import com.example.shayriapp.R;

public class ShayriAdapter extends BaseAdapter
{

    Context context;
    String[] category_name_arr;
    int category_img;
    public ShayriAdapter(Context context, String[] category_name_arr, int category_img)
    {
        this.context = context;
        this.category_name_arr=category_name_arr;
        this.category_img=category_img;
    }

    @Override
    public int getCount()
    {
        return category_name_arr.length;
    }

    @Override
    public Object getItem(int i)
    {
        return i;
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view= LayoutInflater.from(context).inflate(R.layout.shayri_list_item,viewGroup,false);
        TextView textView=view.findViewById(R.id.shayri_item_text);
        ImageView imageView=view.findViewById(R.id.shayri_item_image);

        textView.setText(""+category_name_arr[i]);
        imageView.setImageResource(category_img);

        return view;
    }
}
