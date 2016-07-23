package com.example.halim.betak.Views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.halim.betak.R;

/**
 * Created by HalimAhmed on 4/17/2016.
 */
public class ListAdapter extends BaseAdapter{

    private Context mContext;

    public Integer[] mThumbIds = new Integer[100];

    public ListAdapter(Context c, Integer[] mThumbIds) {
        mContext = c;
        this.mThumbIds = mThumbIds;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_interested,null);
        }
        ImageView imageView1 = (ImageView) convertView.findViewById(R.id.user_image);
        imageView1.setImageResource(mThumbIds[position]);
        return convertView;
    }
    /*public GridItems[] getItems() {
        return items;
    }*/

    /*public void setItems(GridItems[] items) {
        this.items = items;
    }*/

    /*public class ViewHolder{
        public ImageView imageView;
        public TextView textView;
    }*/

    //private GridItems[] items;
    //private LayoutInflater mflater;

   /*public GridAdapter(Context context, GridItems[] locations){
        mflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mContext = context ;
        setItems(locations);
    }
    @Override
    public int getCount() {
        if(items != null){
            return items.length;
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if(items != null && position >= 0 && position < getCount()){
            return items[position];
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        if(items != null && position >= 0 && position < getCount()){
            return items[position].id;
        }
        return 0;
    }*/

    /*@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;

        if(view == null){

        view = mflater.inflate(R.layout.activity_item_home,parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) view.findViewById(R.id.grid_image_item);
            viewHolder.textView = (TextView) view.findViewById(R.id.grid_text_item);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        GridItems gridItems = items[position];
        setCatImage(position, viewHolder, gridItems.title);
        return null;
    }

    private void setCatImage(int position, ViewHolder viewHolder, String title) {
        viewHolder.imageView.setImageResource(images[position]);
        viewHolder.textView.setText(title);
    }*/
}
