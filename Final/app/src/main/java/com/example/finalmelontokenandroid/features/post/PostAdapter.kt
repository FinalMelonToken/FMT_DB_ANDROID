package com.example.finalmelontokenandroid.features.post

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalmelontokenandroid.databinding.ItemPostBinding
import com.example.finalmelontokenandroid.model.Post

class PostAdapter(private val postList: List<Post>): RecyclerView.Adapter<PostAdapter.MainViewHolder>() {
    inner class MainViewHolder(binding: ItemPostBinding): RecyclerView.ViewHolder(binding.root) {
        val title = binding.title
        val timestamp = binding.timestamp
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)).apply {

        }
    }

    override fun getItemCount(): Int = postList.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val post = postList[position]
        with(holder) {
            title.text = post.title
            timestamp.text = post.timestamp
        }
    }
}