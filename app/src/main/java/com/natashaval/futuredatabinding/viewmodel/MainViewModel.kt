package com.natashaval.futuredatabinding.viewmodel

import android.util.Log
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.natashaval.futuredatabinding.model.User

/**
 * Created by natasha.santoso on 21/01/21.
 */
class MainViewModel : ViewModel() {
    // TODO: A7. move user and score data to viewModel and make score Observable
    private var _user = MutableLiveData<User>(User("Yahya", "Yahya"))
    private var _score = MutableLiveData<Int>(0)

    val user: LiveData<User> = _user
    val score: LiveData<Int> = _score
    // TODO: A8. Refactor updateScore function and implement event handling Listener Binding
    fun updateScore(value: Int) {
        _score.value = (_score.value ?: 0 ) + value
        Log.d("MainViewModel", ((_score.value ?: 0) + value).toString())
    }

}