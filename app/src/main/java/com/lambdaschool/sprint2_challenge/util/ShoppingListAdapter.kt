package com.lambdaschool.sprint2_challenge.util

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lambdaschool.sprint2_challenge.R
import com.lambdaschool.sprint2_challenge.model.ShoppingListModel
import kotlinx.android.synthetic.main.shopping_list_items.view.*


class ShoppingListAdapter (val shoppingList: MutableList<ShoppingListModel>):
        RecyclerView.Adapter<ShoppingListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.shopping_list_items, parent, false) as View
        )
    }

    override fun getItemCount(): Int {
        return shoppingList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shopping = shoppingList[position]
        holder.bindModel(shopping)
        holder.shoppingItemView.setOnClickListener {
            if (shopping.choose) {
                shopping.choose = false
                notifyItemChanged(position)
            } else {
                shopping.choose = true
                notifyItemChanged(position)
                holder.shoppingNameView.text = shoppingList[position].name
            }
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val shoppingIconView = view.shopping_item_view
        val shoppingNameView = view.shopping_item_name
        val shoppingItemView = view.shopping_list_linear

        fun bindModel(shopping: ShoppingListModel) {
            shoppingIconView.setImageResource(shopping.icon)
            shoppingNameView.text = shopping.name


            if (shopping.choose) {
                shoppingItemView.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.colorAccent))
            } else
                shoppingItemView.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.white))
        }
    }
}