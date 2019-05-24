package com.mariana.cesar;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements Filterable {
    private List<String> listfilter;
    private List<String> mDataset;

    public MyAdapter(List<String> myDataset) {
        mDataset = myDataset;
        listfilter = new ArrayList<>(mDataset);
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_main, parent, false);
        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(listfilter.get(position));
    }

    @Override
    public int getItemCount() {
        return listfilter.size();
    }


    @Override
    public Filter getFilter() {
        return filter;
    }

    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<String> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mDataset);
            } else {
                String filterPattern = constraint.toString().toUpperCase();
                Log.i("Teste", filterPattern);
//                filteredList.add(item);
                Verify verify = new Verify();
                for (String word : mDataset) {
                    //Verificar pois so pega a palavra correta
                    if (verify.verifyPermuted(word.toUpperCase(), filterPattern) || verify.verifyTypo(word.toUpperCase(), filterPattern)) {
                        filteredList.add(word);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            listfilter.clear();
            listfilter.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public MyViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.textView);
        }
    }


}
