package com.foodypark.foodypark.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.foodypark.foodypark.R;
import com.foodypark.foodypark.restaurant.MenuItems;
import com.foodypark.foodypark.restaurant.MenuItemsImage;
import com.foodypark.foodypark.restaurant.RestaurantsInfo;
import com.foodypark.foodypark.Restaurant_Items;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ALiBH on 2/14/2017.
 */

public class GlobalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Object> mData;
    Context cx;
    private LayoutInflater inflater;
    private final int IMAGE = 1, TEXT = 0, RECOMMEND = 2, REGULAR = 3;
    View v;

    public GlobalAdapter(Context context, List<Object> data) {
        cx = context;
        inflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View view = inflater.inflate(R.layout.restaurant_card, parent, false);
        RecyclerView.ViewHolder holder;

        switch (viewType) {
            case IMAGE:
                v = inflater.inflate(R.layout.slider, parent, false);
                holder = new Slider(v);
                break;
            case TEXT:
                v = inflater.inflate(R.layout.recyclerview_title,parent,false);
                holder = new RecyclerViewTitle(v);
                break;
            case RECOMMEND:
                v = inflater.inflate(R.layout.item_image_card,parent,false);
                holder = new MenuItemsImageView(v);
                break;
            case REGULAR:
                v = inflater.inflate(R.layout.item_card,parent,false);
                holder = new MenuItemsView(v);
                break;
            default:
                v = inflater.inflate(R.layout.restaurant_card, parent, false);
                holder = new MyViewHolder(v);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Object current = mData.get(position);
        switch (holder.getItemViewType()) {
            case IMAGE:
                Slider slide = (Slider) holder;
                configureViewHolder2(slide);
                break;
            case TEXT:
                RecyclerViewTitle title = (RecyclerViewTitle) holder;
                configureViewHolder3(title);
                break;
            case REGULAR:
                MenuItemsView miv = (MenuItemsView) holder;
                MenuItems data = (MenuItems) current;
                miv.setData(data,position);
                break;
            case RECOMMEND:
                MenuItemsImageView miiv = (MenuItemsImageView) holder;
                MenuItemsImage imageData = (MenuItemsImage) current;
                miiv.setData(imageData,position);
                break;
            default:
                MyViewHolder mvh = (MyViewHolder) holder;
                RestaurantsInfo rn = (RestaurantsInfo) current;
                mvh.setData(rn,position);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mData.get(position) instanceof String) {
            return IMAGE;
        } else if (mData.get(position) instanceof Integer) {
            return TEXT;
        } else if(mData.get(position) instanceof MenuItems) {
            return REGULAR;
        } else if (mData.get(position) instanceof MenuItemsImage){
            return RECOMMEND;
        }
        return -1;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title,desc;
        ImageView imgThumb;
        int position;
        RestaurantsInfo current;
        public final static String EXTRA_MESSAGE = "NAME";

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title       = (TextView)  itemView.findViewById(R.id.tvTitle);
            imgThumb    = (ImageView) itemView.findViewById(R.id.rest_img);
            desc        = (TextView) itemView.findViewById(R.id.tvDescription);
        }

        public void setData(RestaurantsInfo current, int position) {
            this.title.setText(current.getName());
            Picasso.with(cx).setIndicatorsEnabled(false);
            Picasso.with(cx).load(current.getImageID())
                    .into(imgThumb);
            //this.imgThumb.setImageResource(current.getImageID());
            this.desc.setText(current.getLoc());
            this.position = position;
            this.current = current;
        }

        @Override
        public void onClick(View v) {
            //Toast.makeText(v.getContext(), "ITEM PRESSED = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
            Intent ii = new Intent(v.getContext(), Restaurant_Items.class);
            ii.putExtra(EXTRA_MESSAGE,current);
            cx.startActivity(ii);
        }
    }
    private void configureViewHolder2(Slider vh2) {
        SliderLayout sl = vh2.getImageView();
        DefaultSliderView textSliderView = new DefaultSliderView(cx);
        textSliderView.image(R.drawable.food);
        sl.addSlider(textSliderView);
        sl.addSlider(new DefaultSliderView(cx).image(R.drawable.food2));
        sl.addSlider(new DefaultSliderView(cx).image(R.drawable.food3));
    }
    private void configureViewHolder3(RecyclerViewTitle title){
        TextView tv = title.getView();
        tv.setText("Restaurants");
        tv.setTextSize(15);
    }

    public class MenuItemsImageView extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView pname,price;
        int pos;
        MenuItemsImage data;
        public MenuItemsImageView(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.productimageview);
            pname = (TextView) itemView.findViewById(R.id.productname);
            price = (TextView) itemView.findViewById(R.id.productprice);
        }
        public void setData(MenuItemsImage data,int pos){
            this.data = data;
            this.pos = pos;
            Picasso.with(cx).setIndicatorsEnabled(false);
            Picasso.with(cx).load(data.getItemImage())
                    .into(iv);
            pname.setText(data.getItem());
            price.setText(data.getPrice()+"");
            //resize(iv);
        }
    }
    public class MenuItemsView extends RecyclerView.ViewHolder {
        TextView pname,price;
        int pos;
        MenuItems data;
        public MenuItemsView(View itemView) {
            super(itemView);
            pname = (TextView) itemView.findViewById(R.id.productname_noimage);
            price = (TextView) itemView.findViewById(R.id.productprice_noimage);
        }
        public void setData(MenuItems data, int pos){
            this.pos = pos;
            this.data = data;
            pname.setText(data.getItem());
            price.setText(data.getPrice()+"");
        }
    }

    public class Slider extends RecyclerView.ViewHolder {

        private SliderLayout ivExample;

        public Slider(View v) {
            super(v);
            ivExample = (SliderLayout) v.findViewById(R.id.slider);
        }

        public SliderLayout getImageView() {
            return ivExample;
        }

        public void setImageView(SliderLayout ivExample) {
            this.ivExample = ivExample;
        }
    }
    public class RecyclerViewTitle extends RecyclerView.ViewHolder {
        private TextView tv;
        public RecyclerViewTitle(View v) {
            super(v);
            tv = (TextView) v.findViewById(R.id.recyclerView_title);
        }
        public TextView getView(){
            return tv;
        }
    }
}