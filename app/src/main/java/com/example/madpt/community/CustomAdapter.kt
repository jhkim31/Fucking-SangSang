package com.example.madpt.community

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.madpt.R

class Data(val text: String)

class CustomAdapter(val context: Context, val DataList:ArrayList<Data>): BaseAdapter() {

    override fun getCount(): Int = DataList.size

    override fun getItem(p0: Int) = DataList[p0]

    override fun getItemId(p0: Int): Long =0L

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.custom_list, null)

        val text = view.findViewById<TextView>(R.id.textId)
        val data = DataList[p0]

        text.text = data.text
        return view
    }


}