package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivityRecyclerViewBinding
import com.example.myapplication.databinding.RvItemBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.signIn.setOnClickListener {
            // قراءة اسم المستخدم
            val username = binding.UserName.text.toString().trim()


        if (username.isEmpty()) {
            binding.UserName.error = "Please enter your username"
            return@setOnClickListener
        }

        // الانتقال إلى MovieListActivity مع نقل اسم المستخدم
        val intent = Intent(this, RvItemBinding::class.java)
        intent.putExtra("USERNAME", username)
        startActivity(intent)
    }
    }
}