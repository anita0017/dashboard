package com.internshala.mapp;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget. ImageView;
import android.widget. TextView;
import androidx.annotation.NonNull;
import androidx. recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
public class AdapterProductSeller extends RecyclerView.Adapter<AdapterProductSeller.HolderProductSeller>{

    public Filter getFilter;
    private Context context;
public ArrayList<ModelProduct> productList,filterList;
private FilterProduct  filter;

public AdapterProductSeller(Context context, ArrayList<ModelProduct> productlist){

        this.context=context;
        this.productList= productList;
        }


    @Override
    public HolderProductSeller onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.row_product_seller,parent,false);
       return new HolderProductSeller(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProductSeller.HolderProductSeller holder, int position) {
        ModelProduct modelProduct = productList.get(position);
        String id = modelProduct.getProductId();
        String uid = modelProduct.getUid();
        String discountAvailable = modelProduct.getDiscountAvailable();
        String discountNote = modelProduct.getDiscountNote();
        String discountPrice = modelProduct.getDiscountPrice();
        String productCategory = modelProduct.getProductCategory();
        String productDescription = modelProduct.getProductDescription();
        String icon = modelProduct.getProductIcon();
        String quantity = modelProduct.getProductQuantity();
        String title = modelProduct.getProductTitle();
        String timestamp = modelProduct.getTimestamp();
        String originalPrice = modelProduct.getOriginalPrice();


        holder.titleTv.setText(title);
        holder.quantityTv.setText(quantity);
        holder.discountedNoteTv.setText(discountNote);
        holder.discountedPriceTv.setText("$" + discountPrice);
        holder.originalPriceTv.setText("$" + originalPrice);

        if (discountAvailable.equals("true")) {

//product is on discount

            holder.discountedPriceTv.setVisibility(View.VISIBLE);
            holder.discountedNoteTv.setVisibility(View.VISIBLE);
            holder.originalPriceTv.setPaintFlags(holder.originalPriceTv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG); //add strike through
        } else {

//product is not on discount

            holder.discountedPriceTv.setVisibility(View.GONE);
            holder.discountedNoteTv.setVisibility(View.GONE);
        }
        try {
            Picasso.get().load(icon).placeholder(R.drawable.ic__add_shopping_primary).into(holder.productIconIv);
        } catch (Exception e) {
            holder.productIconIv.setImageResource(R.drawable.ic__add_shopping_primary);

        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    @Override
    public int getItemCount(){
        return productList.size();
    }

    public Filter getFilter(){
    if(filter==null){
        filter = new FilterProduct(this,filterList);
    }
    return  filter;
    }


                class HolderProductSeller extends RecyclerView.ViewHolder {
private ImageView productIconIv;
private TextView discountedNoteTv, titleTv, quantityTv, discountedPriceTv, originalPriceTv ;
public HolderProductSeller(@NonNull View itemView) {
        super(itemView);

        productIconIv =itemView.findViewById(R.id.productIconIv);
    discountedNoteTv= itemView.findViewById(R.id.discountedNoteTv);
    titleTv =itemView.findViewById(R.id.titleTv);
        quantityTv = itemView.findViewById(R.id.quantityTv);
    discountedPriceTv= itemView.findViewById(R.id.discountedPriceTv);
    originalPriceTv= itemView.findViewById(R.id.originalPriceTv);
}
}}