package com.example.shayriapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.shayriapp.R;

public class CategoryAdapter extends BaseAdapter
{
    String[] cat_name_arr;
    int[] img_arr;
    Context context;

    public CategoryAdapter(Context context, String[] cat_name_arr, int[] img_arr)
    {
        this.cat_name_arr=cat_name_arr;
        this.img_arr=img_arr;
        this.context=context;
    }

    @Override
    public int getCount()
    {
        return cat_name_arr.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        view= LayoutInflater.from(context).inflate(R.layout.category_list_item,viewGroup,false);
        TextView textView=view.findViewById(R.id.category_item_text);
        ImageView imageView=view.findViewById(R.id.category_item_img);
        textView.setText(""+cat_name_arr[i]);
        imageView.setImageResource(img_arr[i]);
        return view;
    }
}
