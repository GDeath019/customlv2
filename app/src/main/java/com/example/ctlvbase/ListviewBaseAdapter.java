package com.example.ctlvbase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListviewBaseAdapter extends BaseAdapter implements Filterable {
    private Context context;
    private ArrayList<data> arrayData;

    private CustomFilter filter;
    private ArrayList<data> filterList;
    public ListviewBaseAdapter(Context context, ArrayList<data> dsSinhVien) {
        this.context = context;
        this.arrayData = dsSinhVien;
        this.filterList = dsSinhVien;
    }
    @Override
    public int getCount() {
        return arrayData.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view =  inflater.inflate(R.layout.activity_main2, null);
        }
        data p = (data) getItem(i);
        if (p != null) {
            // Anh xa + Gan gia tri
            TextView tvname = (TextView) view.findViewById(R.id.tvName);
            ImageView img = (ImageView) view.findViewById(R.id.imageView);
            tvname.setText(p.getName());
            img.setImageResource(p.getPicture());

        }
        return view;
    }

    @Override
    public Filter getFilter() {
        if(filter == null){
            filter = new CustomFilter();
        }
        return filter;
    }
    private class CustomFilter extends Filter{
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if(constraint !=null && constraint.length()>0){
                constraint = constraint.toString().toUpperCase();
                ArrayList<data> filters = new ArrayList<data>();
                for (int i=0;i<filterList.size();i++)
                {
                    if (filterList.get(i).getName().toUpperCase().contains(constraint))
                    {
                        data p = new data(filterList.get(i).getName(),filterList.get(i).getPicture());
                        filters.add(p);
                    }
                }
                results.count = filters.size();
                results.values = filters;
            }else
            {
                results.count = filterList.size();
                results.values = filterList;
            }
            return  results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            arrayData = (ArrayList<data>)results.values;
            notifyDataSetChanged();
        }
    }
}
