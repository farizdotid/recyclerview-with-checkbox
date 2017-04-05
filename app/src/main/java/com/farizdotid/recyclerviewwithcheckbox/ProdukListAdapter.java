package com.farizdotid.recyclerviewwithcheckbox;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

/**
 * Created by fariz ramadhan.
 * website : www.farizdotid.com
 * github : https://github.com/farizdotid
 */

public class ProdukListAdapter extends RecyclerView.Adapter<ProdukListAdapter.MyViewHolder> {

    private HashMap<Integer, Boolean> isChecked = new HashMap<>();
    private Context mContext;
    private LayoutInflater inflater;
    private List<String> produkList;

    public ProdukListAdapter(Context context, List<String> produkList){
        this.mContext = context;
        this.produkList = produkList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ProdukListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = inflater.inflate(R.layout.list_item_nomor, parent, false);

        MyViewHolder holder = new MyViewHolder(rootView);
        return holder;
    }

    @Override
    public void onBindViewHolder(ProdukListAdapter.MyViewHolder holder, int position) {
        holder.cbProduk.setText(produkList.get(position));
        if (isChecked.containsKey(position)){
            holder.cbProduk.setChecked(isChecked.get(position));
        } else {
            holder.cbProduk.setChecked(false);
        }
    }

    @Override
    public int getItemCount() {
        return produkList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CheckBox cbProduk;

        public MyViewHolder(View itemView) {
            super(itemView);

            cbProduk = (CheckBox) itemView.findViewById(R.id.cbProduk);

            cbProduk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                   if (isChecked){
                       Toast.makeText(mContext, "checklist", Toast.LENGTH_SHORT).show();
                   } else {
                       Toast.makeText(mContext, "unchecklist", Toast.LENGTH_SHORT).show();
                   }
                }
            });
        }
    }
}
