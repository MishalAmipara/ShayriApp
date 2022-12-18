package com.example.shayriapp.Adapter;

//import static androidx.core.graphics.drawable.IconCompat.getResources;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shayriapp.Activity.Edit_Shayri_Activity;
import com.example.shayriapp.Color_Array;
import com.example.shayriapp.R;

public class BackgroundAdapter extends BaseAdapter
{
    Context context;
    int[] backGroound;
    String type;
    public BackgroundAdapter(Context context, int[] backGround,String type)
    {
        this.backGroound=backGround;
        this.context=context;
        this.type=type;
    }

    @Override
    public int getCount()
    {
        return backGroound.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view= LayoutInflater.from(context).inflate(R.layout.background_grid_item,viewGroup,false);
        TextView gridText=view.findViewById(R.id.grid_text);

       if(type=="color")
       {
           gridText.setBackgroundColor(view.getResources().getColor(backGroound[i]));
           gridText.setTextColor(backGroound[i]);
       }
       else
       {
           gridText.setBackgroundResource(backGroound[i]);
       }
       return view;
    }
}
