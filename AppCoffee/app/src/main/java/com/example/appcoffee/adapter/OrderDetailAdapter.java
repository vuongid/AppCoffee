package com.example.appcoffee.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appcoffee.R;
import com.example.appcoffee.model.OrderDetail;

import java.util.ArrayList;

public class OrderDetailAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<OrderDetail> orderDetails;

    public OrderDetailAdapter(Context context, int layout, ArrayList<OrderDetail> orderDetails) {
        this.context = context;
        this.layout = layout;
        this.orderDetails = orderDetails;
    }

    @Override
    public int getCount() {
        return orderDetails.size();
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
        ImageView imgProduct,imgIncrease,imgDecrease;
        TextView tvProductName,tvProductPrice,tvQuantity;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder();
        if (view == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item_order,null);
            viewHolder.imgProduct = view.findViewById(R.id.img_order_product);
            viewHolder.imgIncrease = view.findViewById(R.id.img_increase);
            viewHolder.imgDecrease = view.findViewById(R.id.img_decrease);
            viewHolder.tvProductName = view.findViewById(R.id.tv_order_name);
            viewHolder.tvProductPrice = view.findViewById(R.id.tv_order_price);
            viewHolder.tvQuantity = view.findViewById(R.id.tv_quantity);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        OrderDetail orderDetail = orderDetails.get(i);
        Uri imgUri = Uri.parse("android.resource://" + context.getPackageName() + "/drawable/" + orderDetail.getProductImage());
        viewHolder.imgProduct.setImageURI(imgUri);
        viewHolder.tvProductName.setText(orderDetail.getProductName());
        viewHolder.tvProductPrice.setText(String.valueOf(orderDetail.getProductPrice()));
        viewHolder.tvQuantity.setText(String.valueOf(orderDetail.getProductQuantity()));
        final int[] quantity = {Integer.valueOf((String) viewHolder.tvQuantity.getText())};
        ViewHolder finalViewHolder = viewHolder;
        viewHolder.imgIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quantity[0] == 99){
                    return;
                }
                quantity[0]++;
                orderDetail.setProductQuantity(quantity[0]);
                finalViewHolder.tvQuantity.setText(String.valueOf(quantity[0]));
            }
        });
        viewHolder.imgDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity[0]--;
                orderDetail.setProductQuantity(quantity[0]);
                if (quantity[0] < 1){
                    orderDetails.remove(orderDetails.get(i));
                    notifyDataSetChanged();
                }
                finalViewHolder.tvQuantity.setText(String.valueOf(quantity[0]));
            }
        });
        return  view;
    }
}
