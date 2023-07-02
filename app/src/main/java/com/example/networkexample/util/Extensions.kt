package com.example.networkexample.util

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.networkexample.common.network.CustomResponseHandler
import com.example.networkexample.common.network.Loading
import com.example.networkexample.common.network.Success
import com.example.networkexample.common.network.Error
import com.example.networkexample.common.network.ApiException
import com.example.networkexample.common.repository.MainRepo
import kotlinx.coroutines.launch

object Extensions {

    @JvmStatic
    fun<T: Any> ViewModel.makeApiRequest(loadingData: MutableLiveData<T>? = null, liveData: MutableLiveData<T>, request: () -> CustomResponseHandler<T>) {
        this.apply {
            viewModelScope.launch {
               when (val res = request.invoke()) {
                   is Loading -> {

                   }
                   is Success -> {

                   }
                   is Error -> {

                   }
                   is ApiException -> {

                   }
               }
            }
        }
    }

}