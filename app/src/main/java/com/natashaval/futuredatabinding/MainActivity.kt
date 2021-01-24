package com.natashaval.futuredatabinding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.natashaval.futuredatabinding.ProfileActivity.Companion.FIRST_NAME_KEY
import com.natashaval.futuredatabinding.ProfileActivity.Companion.LAST_NAME_KEY
import com.natashaval.futuredatabinding.databinding.ActivityMainBinding
import com.natashaval.futuredatabinding.model.User
import com.natashaval.futuredatabinding.viewmodel.MainViewModel

@BindingAdapter("hidePlus")
fun hidePlus(view: View, score: Int){
  view.visibility = if (score == 20) View.GONE else View.VISIBLE
}

@BindingAdapter("hideMinus")
fun hideMinus(view: View, score: Int){
  view.visibility = if (score == 0) View.GONE else View.VISIBLE
}

class MainActivity : AppCompatActivity(), ScoreAdapter.ScoreListener {

  private val viewModel by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }

  private val user = User("Yahya", "Yahya")
  private lateinit var score: TextView
  private var scoreList: MutableList<Int> = mutableListOf()
  private lateinit var mRecyclerView: RecyclerView
  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    // TODO: A3. change how to inflate with DataBinding
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    // TODO: A4. bind user and score data with name UI
    binding.user = user
    binding.activity = this
    binding.lifecycleOwner = this
    binding.viewModel = viewModel

    binding.btProfileFragment.setOnClickListener {
      openFragment(it)
    }

    binding.btGenerateScore.setOnClickListener {
      generateScore()
      showRecyclerViewScore()
    }


  }

//  TODO: A5. implement event handling Method References when clicking Activity button
  fun openActivity(view: View) {
    val intent = Intent(this, ProfileActivity::class.java)
    intent.putExtra(FIRST_NAME_KEY, user.firstName)
    intent.putExtra(LAST_NAME_KEY, user.lastName)
    startActivity(intent)
  }

  // TODO: A6. implement setOnClickListener to Fragment button
  fun openFragment(view: View) {
    val fragment = ProfileFragment.newInstance(user.firstName, user.lastName)
    fragment.show(supportFragmentManager, ProfileFragment.TAG)
  }

  private fun generateScore(){
    val score: Int = viewModel.score.value ?: 0
    scoreList.clear()
    for(i in 0.. score){
      scoreList.add(i)
    }
  }
  private fun showRecyclerViewScore(){
    mRecyclerView = binding.recyclerView
    val mAdapter = ScoreAdapter(scoreList, this)
    mRecyclerView.adapter = mAdapter
    mRecyclerView.layoutManager = LinearLayoutManager(this)
  }

  override fun onClickListener(value: Int) {
    openScoreActivity(value)
  }

  fun openScoreActivity(value: Int){
    val intent = Intent(this, ScoreActivity::class.java)
    Log.d("MainActivity", value.toString())
    intent.putExtra("score", value.toString())
    startActivity(intent)
  }

}