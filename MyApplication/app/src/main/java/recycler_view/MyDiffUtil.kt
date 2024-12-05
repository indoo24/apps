package recycler_view

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

class MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {

        return oldItem.title == newItem.title
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {

        return oldItem == newItem
    }
}
