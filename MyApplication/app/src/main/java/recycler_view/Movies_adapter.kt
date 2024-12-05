package recycler_view



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.RvItemBinding



class MovieAdapter :
    ListAdapter<Movie, MovieAdapter.MovieViewHolder>(MovieDiffCallback()) {


    class MovieViewHolder(val binding: RvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.movieImage.setImageResource(movie.imageResId)
            binding.movieTitle.text = movie.title
            binding.movieDescription.text = movie.description
            binding.movieReleaseDate.text = "Release Date: ${movie.releaseDate}"
            binding.movieRating.text = "Rating: ${movie.rating}/5"
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = RvItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MovieViewHolder(binding)
    }


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
    }
}
