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
import com.example.appcoffee.model.Product;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Product> arrayList;

    public ProductAdapter(Context context, int layout, ArrayList<Product> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        ImageView imgProduct;
        TextView tvName;
        TextView tvPrice;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_product,null);
            viewHolder = new ViewHolder();
            viewHolder.imgProduct   = convertView.findViewById(R.id.img_product);
            viewHolder.tvName       = convertView.findViewById(R.id.tv_product_name);
            viewHolder.tvPrice      = convertView.findViewById(R.id.tv_price);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Product product = arrayList.get(position);
        viewHolder.tvName.setText(product.getName());
        viewHolder.tvPrice.setText(String.valueOf(product.getPrice()));
        Uri imgUri = Uri.parse("android.resource://" + context.getPackageName() + "/drawable/" + product.getImage());
        viewHolder.imgProduct.setImageURI(imgUri);
        return convertView;
    }
}
