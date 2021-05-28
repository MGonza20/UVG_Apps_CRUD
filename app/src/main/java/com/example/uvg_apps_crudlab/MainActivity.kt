package com.example.uvg_apps_crudlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val adaptador = Adaptador({
            clickListener -> showItemClick(clickListener)
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val items : MutableList<String> = mutableListOf()
        items.add("ITEM 1")
        items.add("ITEM 2")
        items.add("ITEM 3")

        adaptador.setItems(items)


        btnAdd.setOnClickListener {
            val pos : Int =  items.size.toInt()+1
            items.add("ITEM " + pos)
            adaptador.setItems(items)
        }


        lista.layoutManager = LinearLayoutManager(this)
        lista.adapter = adaptador



    }

    fun showItemClick(position:Int){
        val item = adaptador.getItem(position)
        Toast.makeText(this, item, Toast.LENGTH_SHORT).show()
    }


}