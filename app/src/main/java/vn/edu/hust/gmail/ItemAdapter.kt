package vn.edu.hust.gmail

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import vn.edu.hust.listexamples.R

class ItemAdapter(val items: ArrayList<ItemModel>): BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var itemView: View
        var itemViewHolder: ItemViewHolder

        if (convertView == null) {
            itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.layout_item, parent, false)

            itemViewHolder = ItemViewHolder(itemView)
            itemView.tag = itemViewHolder
        } else {
            itemView = convertView
            itemViewHolder = itemView.tag as ItemViewHolder
        }

        itemViewHolder.textCaption.text = items[position].caption
        itemViewHolder.imageThumb.setImageResource(items[position].imageThumb)


        return itemView
    }

    class ItemViewHolder(itemView: View) {
        val imageThumb: ImageView
        val textCaption: TextView
        init {
            imageThumb = itemView.findViewById(R.id.image_thumb)
            textCaption = itemView.findViewById(R.id.text_caption)

            Log.v("TAG", "findViewById")
        }
    }
}