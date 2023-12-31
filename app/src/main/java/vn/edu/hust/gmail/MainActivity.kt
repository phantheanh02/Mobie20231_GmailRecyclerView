package vn.edu.hust.gmail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import vn.edu.hust.listexamples.R

class MainActivity : AppCompatActivity(), RVItemAdapter.ItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = arrayListOf<ItemModel>()
        repeat(28) {
            val index = it + 1
            items.add(ItemModel(
                "Mail $index",
                resources.getIdentifier("thumb$index", "drawable", packageName)
            ))
        }

        val adapter = RVItemAdapter(items, this)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

//        findViewById<Button>(R.id.button_add).setOnClickListener {
//            items.add(0, ItemModel("New Item", R.drawable.thumb10))
//            adapter.notifyItemInserted(0)
//            recyclerView.scrollToPosition(0)
//        }
//
//        findViewById<Button>(R.id.button_remove).setOnClickListener {
//            items.removeAt(0)
//            adapter.notifyItemRemoved(0)
//        }
//
//        findViewById<Button>(R.id.button_update).setOnClickListener {
//            items[0].caption = "Updated"
//            adapter.notifyItemChanged(0)
//        }
    }

    override fun ItemClick(position: Int) {
        Log.v("TAG", "Selected position: $position")
    }
}