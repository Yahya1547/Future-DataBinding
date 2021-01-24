package com.natashaval.futuredatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.natashaval.futuredatabinding.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        // TODO: B2. implement how to use ViewBinding in Activity
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO: B3. change firstName and lastName to your own name with viewbinding
        binding.tvFirstName.text = intent.getStringExtra(FIRST_NAME_KEY)
        binding.tvLastName.text = intent.getStringExtra(LAST_NAME_KEY)
    }

    companion object {
        const val FIRST_NAME_KEY = "first_name"
        const val LAST_NAME_KEY = "last_name"
    }
}