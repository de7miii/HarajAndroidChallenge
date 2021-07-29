package com.example.harajtask.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.harajtask.adapters.PostsListAdapter
import com.example.harajtask.viewmodels.PostsListViewModel
import com.example.harajtask.databinding.FragmentPostsListBinding

class PostsListFragment : Fragment() {

    private var _binding: FragmentPostsListBinding? = null
    private val model: PostsListViewModel by activityViewModels()
    private lateinit var adapter: PostsListAdapter;

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPostsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.fetchPosts()
        val layoutManager = LinearLayoutManager(activity)
        adapter = PostsListAdapter()
        binding.rvPostsList.layoutManager = layoutManager
        binding.rvPostsList.addItemDecoration(DividerItemDecoration(activity, layoutManager.orientation))
        binding.rvPostsList.adapter = adapter
        model.posts.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}