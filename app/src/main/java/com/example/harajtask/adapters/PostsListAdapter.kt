package com.example.harajtask.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.harajtask.R
import com.example.harajtask.models.Post
import com.example.harajtask.databinding.PostListItemBinding
import com.example.harajtask.views.PostsListFragmentDirections
import com.squareup.picasso.Picasso

class PostsListAdapter:
    ListAdapter<Post, PostsListAdapter.ViewHolder>(PostDiffCallback){
    private lateinit var binding: PostListItemBinding;

    class ViewHolder(private val itemBinding: PostListItemBinding): RecyclerView.ViewHolder(itemBinding.root),
        View.OnClickListener {
        private lateinit var post: Post
        init {
            itemView.setOnClickListener(this)
        }
        fun bind(item: Post){
            post = item;
            itemBinding.postTitle.text = post.title
            itemBinding.postCity.text = post.city
            itemBinding.postCity.setCompoundDrawablesWithIntrinsicBounds(0, 0 , R.drawable.ic_round_location_on_12, 0)
            if(post.commentCount > 0) {
                itemBinding.postCommentCount.text = itemView.rootView.context.getString(
                    R.string.post_comment_count,
                    post.commentCount
                )
                itemBinding.postCommentCount.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_round_chat_bubble_12, 0)
            }
            itemBinding.postUser.text = post.username
            itemBinding.postUser.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_round_person_12, 0)
            itemBinding.postTimestamp.text = post.humanizedTime
            Picasso.get().load(post.thumbUrl).into(itemBinding.postImage)

        }

        override fun onClick(v: View) {
            Log.i("PostListAdapter", "onClick: ${post.title}")
            val action = PostsListFragmentDirections.actionPostsListFragmentToPostDetailsFragment(post)
            v.findNavController().navigate(action)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = PostListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position);
        holder.bind(item)
    }
}


object PostDiffCallback: DiffUtil.ItemCallback<Post>(){
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }

}