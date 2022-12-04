package com.example.shayriapp.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shayriapp.Activity.Edit_Shayri_Activity;
import com.example.shayriapp.R;

public class FontAdapter extends BaseAdapter
{

    String[] fonts;
    Context context;
    public FontAdapter(Context context, String[] fonts)
    {
        this.context=context;
        this.fonts=fonts;
    }

    @Override
    public int getCount() {
        return fonts.length;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(context).inflate(R.layout.font_list_item,viewGroup,false);
        TextView fontText=view.findViewById(R.id.font_list_item_text);
        fontText.setText("ShayriApp");
        Typeface typeface=Typeface.createFromAsset(context.getAssets(), fonts[i]);
        fontText.setTypeface(typeface);
        return view;
    }
}
