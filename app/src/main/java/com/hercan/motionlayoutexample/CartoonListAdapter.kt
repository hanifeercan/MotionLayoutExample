package com.hercan.motionlayoutexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hercan.motionlayoutexample.core.data.model.Cartoon
import com.hercan.motionlayoutexample.databinding.ItemCartoonBinding
import com.squareup.picasso.Picasso

@Suppress("DEPRECATION")
class CartoonListAdapter : ListAdapter<Cartoon, CartoonListAdapter.ViewHolder>(
    COMPARATOR
) {

    private val motionStateMap = mutableMapOf<Int, Float>()

    inner class ViewHolder(private val binding: ItemCartoonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Cartoon) = with(binding) {

            tvCharacterName.text = item.title
            tvCreator.text = item.creator
            tvEpisode.text = item.episodes
            tvYear.text = item.year
            tvRuntime.text = item.runtimeInMinutes

            Picasso.get().load(item.image)
                .placeholder(R.drawable.ic_hourglass)
                .error(R.drawable.ic_no_image)
                .into(ivCartoon)


            val savedProgress = motionStateMap[position] ?: 0f
            motionLayout.progress = savedProgress

            motionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
                override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                    motionStateMap[position] = motionLayout.progress
                }

                override fun onTransitionChange(
                    p0: MotionLayout?, p1: Int, p2: Int, p3: Float
                ) {
                    motionStateMap[position] = motionLayout.progress
                }

                override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {}
                override fun onTransitionTrigger(
                    p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float
                ) {}
            })
        }
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Cartoon>() {
            override fun areItemsTheSame(
                oldItem: Cartoon, newItem: Cartoon
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: Cartoon, newItem: Cartoon
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCartoonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.bind(item)
        }
    }
}