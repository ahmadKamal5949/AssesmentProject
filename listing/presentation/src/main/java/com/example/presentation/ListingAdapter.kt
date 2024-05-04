package com.example.presentation

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Universities
import com.example.presentation.databinding.ViewHolderUniListBinding
import com.example.utils.Activities
import com.example.utils.Navigator

class ListingAdapter : RecyclerView.Adapter<ListingAdapter.MyViewHolder>() {

    lateinit var provider: Navigator.Provider
    private var list = listOf<Universities>()
    lateinit var context: Activity

    fun setData(list: List<Universities>, context: Activity, provider: Navigator.Provider) {
        this.list = list
        this.context = context
        this.provider = provider
        notifyItemInserted(this.list.lastIndex)
    }

    inner class MyViewHolder(val viewDataBinding: ViewHolderUniListBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            ViewHolderUniListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.viewDataBinding.apply {
            val item = list[position]
            tvHeadlines.text = item.name
            tvContent.text = item.state
        }
        holder.itemView.setOnClickListener {
            provider.getActivities(Activities.DetailsActivity).navigate(context)
        }
    }

    override fun getItemCount(): Int {
        return this.list.size
    }

}