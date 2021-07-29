package com.example.harajtask.views

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import com.example.harajtask.R
import com.example.harajtask.databinding.FragmentPostDetailsBinding
import com.example.harajtask.models.Post
import com.squareup.picasso.Picasso


class PostDetailsFragment : Fragment() {

    private var _binding: FragmentPostDetailsBinding? = null

    private val binding get() = _binding!!
    private lateinit var post: Post;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
        if(bundle == null) {
            Log.i("PostDetailsFragment", "onCreate: No arguments where passed")
        }else{
            val args = PostDetailsFragmentArgs.fromBundle(bundle)
            post = args.post
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPostDetailsBinding.inflate(inflater, container, false)
        Picasso.get().load(post.thumbUrl).into(binding.imageDetails)
        binding.titleDetails.text = post.title
        binding.timeDetails.text = post.humanizedTime
        binding.userDetails.text = post.username
        binding.userDetails.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_round_person_14, 0, 0, 0)
        binding.cityDetails.text = post.city
        binding.cityDetails.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_round_location_on_14, 0)
        binding.bodyDetails.text = post.body
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.app_bar_actions, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.share_action -> {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, post.title)
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)

            }
        }
        return super.onOptionsItemSelected(item)
    }
}