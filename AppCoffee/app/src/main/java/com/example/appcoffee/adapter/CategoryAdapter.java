package com.example.appcoffee.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appcoffee.R;
import com.example.appcoffee.model.Category;

import java.util.ArrayList;

public class CategoryAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Category> arrayList;

    public CategoryAdapter(Context context, int layout, ArrayList<Category> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        TextView tvNameCaterogy;
        ImageView imgCaterogy;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_category,null);
            viewHolder = new ViewHolder();
            viewHolder.tvNameCaterogy = convertView.findViewById(R.id.tv_category_name);
            viewHolder.imgCaterogy = convertView.findViewById(R.id.img_category);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Category category = arrayList.get(position);
        viewHolder.tvNameCaterogy.setText(category.getName());
        Uri imgUri = Uri.parse("android.resource://" + context.getPackageName() + "/drawable/" + category.getImage());
        viewHolder.imgCaterogy.setImageURI(imgUri);
        return convertView;
    }
}
