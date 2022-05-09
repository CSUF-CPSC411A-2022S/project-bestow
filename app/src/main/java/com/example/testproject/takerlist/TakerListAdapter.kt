package com.example.testproject.takerlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.data.TakerData
import com.example.testproject.databinding.TakerItemBinding

/**
 * A RecyclerView adapter that uses the DiffCallback for better performance.
 */
class TakerListAdapter(val clickListener: TakerListener) : ListAdapter<TakerData,
        TakerListAdapter.ItemViewHolder>(TakerDiffCallback()) {

    /**
     * Inner class used to store data about each element in the RecyclerView. We provide a binding
     * to make it easy to access elements of the layout.
     */
    class ItemViewHolder(val binding: TakerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /**
         * Assign a taker object
         */
        fun bind(item: TakerData, clickListener: TakerListener) {
            binding.taker = item
            binding.clickListener = clickListener
        }
    }

    /**
     * Creates a View to visualize one element in the RecyclerView.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // We use an inflater based on the parent (IntersectionListFragment) and create an
        // ItemViewHolder with binding to the layout to simplify access.
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = TakerItemBinding.inflate(layoutInflater, parent, false)
        return ItemViewHolder(binding)
    }

    /**
     * The function is called whenever the RecyclerView displays a specific element. It provides
     * access to the ItemViewHolder and its position.
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // Assign the corresponding element from the data and the click listener. Take note getItem
        // is a function provided by ListAdapter.
        holder.bind(getItem(position), clickListener)
    }
}

/**
 * Manages a RecyclerView list using the Eugene W. Myers's difference algorithm to reduce processing.
 */
class TakerDiffCallback : DiffUtil.ItemCallback<TakerData>() {
    /**
     * We use takerId because it is a unique ID referring to a single element.
     */
    override fun areItemsTheSame(oldItem: TakerData, newItem: TakerData): Boolean {
        return oldItem.takerId == newItem.takerId
    }

    /**
     * We check all properties to check equality between TakerData objects.
     */
    override fun areContentsTheSame(oldItem: TakerData, newItem: TakerData): Boolean {
        return oldItem.takername == newItem.takername && oldItem.item == newItem.item
                && oldItem.description == newItem.description
    }
}

/**
 * Listener that accepts a lambda function clickListener. It will be called when an element of the
 * RecyclerView is clicked/tapped.
 */
class TakerListener(val clickListener: (intersectionId: Long) -> Unit) {
    fun onClick(intersection: TakerData) = clickListener(intersection.takerId)
}