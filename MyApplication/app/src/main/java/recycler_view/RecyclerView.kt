package com.example.assignment3

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityRecyclerViewBinding

class RecyclerView : AppCompatActivity() {
    private val bestPracticeAdapter by lazy { Movies_adapter() }
    private lateinit var binding: ActivityRecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityRecyclerViewBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.toolbar))

        val userName = intent.getStringExtra("UserName")
        val text_username = findViewById<TextView>(R.id.textView2)
        text_username.text = userName.toString()

        bestPracticeAdapter.ubdateList(getMoreItems())
        binding.rvMovies.adapter = bestPracticeAdapter
        binding.rvMovies.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

    }

    private fun getMoreItems(): List<Movies_adapter.CardItem> {
        return listOf(
            Movies_adapter.CardItem("Nemo",
                "The film tells the story of a clownfish named Nemo (voiced by Alexander Gould) who gets abducted from his home in the Great Barrier Reef and winds up in a dentist's office aquarium.",
                "Publish_Date : 2003","Rate : 8.0",R.drawable.image2),
            Movies_adapter.CardItem("LionKing",
                "The Lion King is about a young lion prince named Simba who, after losing his father in a staged accident which he feels he caused, must face his fear of responsibility and take his rightful place on the throne.",
                "Publish_Date : 1994","Rate : 9.0",R.drawable.image3),
            Movies_adapter.CardItem("Priserky",
                "Monsters, Inc. is a film about monsters who collect children's screams for energy but discover the power of laughter and friendship.",
                "Publish_Date : 2001","Rate : 8.1",R.drawable.image4),
            Movies_adapter.CardItem("ToyStory",
                "Toy Story is an animated film about a group of toys that come to life when humans aren't around.It follows Woody,and Buzz,as they navigate rivalry,friendship,and adventures while trying to return to their owner,Andy.",
                "Publish_Date : 1995","Rate : 9.3",R.drawable.image5),
            Movies_adapter.CardItem("Aladdin",
                "Aladdin follows a kind-hearted thief who discovers a magical lamp and uses its genie to win the heart of Princess Jasmine while facing the evil sorcerer Jafar.",
                "Publish_Date : 1992","Rate : 8.4",R.drawable.image6),
            Movies_adapter.CardItem("Tarzan",
                "Tarzan follows a man raised by apes who must choose between his jungle home and the human world after meeting Jane.",
                "Publish_Date : 1999","Rate : 9",R.drawable.image7),
            Movies_adapter.CardItem("Ralph",
                "Wreck-It Ralph follows a video game villain, Ralph, who dreams of being a hero. He embarks on an adventure across different games to prove his worth.",
                "Publish_Date : 2012","Rate : 6.5",R.drawable.image8),
            Movies_adapter.CardItem("LUCA",
                "Luca is an animated film about a young sea monster named Luca who explores the Italian Riviera, discovering friendship, self-acceptance, and the world above the water",
                "Publish_Date : 2021","Rate : 9.5",R.drawable.image9),
            Movies_adapter.CardItem("PeterPan",
                "Peter Pan is about a boy who never grows up and leads a group of children on adventures in Neverland, where they battle the villainous Captain Hook.",
                "Publish_Date : 1998","Rate : 7.4",R.drawable.image10),
            Movies_adapter.CardItem("UP",
                "Up is an animated film about an elderly man, Carl, who embarks on an adventure to fulfill his late wife's dream, with an unexpected companion, a young boy named Russell.",
                "Publish_Date : 2009","Rate : 9.0", R.drawable.image11),

            )

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item1 -> {
                var count = 10
                for (i in 1..10){
                    Toast.makeText(this, "count is $count", Toast.LENGTH_SHORT).show()
                    count+=5
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}