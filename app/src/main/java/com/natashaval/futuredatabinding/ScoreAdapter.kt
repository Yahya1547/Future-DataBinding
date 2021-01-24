package com.natashaval.futuredatabinding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.natashaval.futuredatabinding.databinding.TextRowItemBinding

class ScoreAdapter(private val dataSet: MutableList<Int>, val listener: ScoreListener) : RecyclerView.Adapter<ScoreAdapter.ScoreViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.text_row_item, parent, false)

        return ScoreViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: ScoreViewHolder, position: Int) {
        holder.binding?.textView?.text = "Score : " + dataSet[position]
        holder.binding?.root?.setOnClickListener {
            listener.onClickListener(dataSet[position])
        }
    }

    override fun getItemCount() = dataSet.size
    inner class ScoreViewHolder(view: View, listener: ScoreListener) : RecyclerView.ViewHolder(view){
        val binding: TextRowItemBinding? = DataBindingUtil.bind(view)

    }

    interface ScoreListener{
        fun onClickListener(value: Int)
    }
}