package com.example.shayriapp.Adapter;

//import static androidx.core.graphics.drawable.IconCompat.getResources;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shayriapp.Color_Array;
import com.example.shayriapp.R;

public class ListAdapter extends BaseAdapter
{
    Context context;
    String[] emog;
    public ListAdapter(Context context, String[] emog)
    {
        this.emog=emog;
        this.context=context;
    }

    @Override
    public int getCount()
    {
        return emog.length;
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

        view= LayoutInflater.from(context).inflate(R.layout.emojies_list_item,viewGroup,false);
        TextView textView=view.findViewById(R.id.list_item_text);

        textView.setText(emog[i]);
        return view;
    }
}
