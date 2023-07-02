package com.example.networkexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.networkexample.common.model.PostModel
import com.example.networkexample.common.network.ApiException
import com.example.networkexample.common.network.Error
import com.example.networkexample.common.network.Loading
import com.example.networkexample.common.network.Success
import com.example.networkexample.common.repository.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repo: MainRepo): ViewModel() {

    private val _allPosts = MutableLiveData<PostModel>()

    val allPosts
        get() = _allPosts

    init {
        fetchAllPost()
    }

    fun fetchAllPost() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            repo.getAllPosts().collectLatest { result ->
                when (result) {
                    is Loading -> {
                       // Handle loading state by showing loader

                    }
                    is Success -> {
                        // Handle successful response here
                        withContext(Dispatchers.Main) {
                            result.data?.let {
                                _allPosts.value = it
                            }
                        }
                    }
                    is Error -> {
                        // Handle Error here
                    }
                    is ApiException -> {
                        // Throwable

                    }
                }
            }
        }
    }

}