package recycler_view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityRecyclerViewBinding

class RecyclerView : AppCompatActivity()  {
    private lateinit var binding: ActivityRecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val username = intent.getStringExtra("USERNAME") ?: "User"
        binding.welcomeText.text = "Welcome, $username"


        val adapter = MovieAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter


        val movieList = listOf(
            Movie("Inception", "A mind-bending thriller.", "2010-07-16", 4.8f, R.drawable.inception),
            Movie("Interstellar", "Exploration beyond Earth.", "2014-11-07", 4.7f, R.drawable.interstellar),
            Movie("The Dark Knight", "A gripping tale of heroism.", "2008-07-18", 4.9f, R.drawable.dark_knight)
        )

        adapter.submitList(movieList)
    }
    }
