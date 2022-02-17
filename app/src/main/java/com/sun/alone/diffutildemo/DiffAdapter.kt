package com.sun.alone.diffutildemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DiffAdapter(context: Context, datas: List<TestBean>): RecyclerView.Adapter<DiffAdapter.DiffVH>() {

  var context: Context? = null
  var datas: List<TestBean>? = null
  var inflater: LayoutInflater? = null

  init {
    this.context = context
    this.datas = datas
    inflater = LayoutInflater.from(context)
  }

  class DiffVH(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
    var text1 = itemView?.findViewById<TextView>(R.id.tv1)
    var text2 = itemView?.findViewById<TextView>(R.id.tv2)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiffVH {
    return DiffVH(inflater?.inflate(R.layout.item_diff, parent, false))
  }

  override fun onBindViewHolder(holder: DiffVH, position: Int) {
    holder.text1?.text = datas?.get(position)?.name
    holder.text2?.text = datas?.get(position)?.desc
  }

  override fun getItemCount(): Int {
    return datas?.size ?: 0
  }

}