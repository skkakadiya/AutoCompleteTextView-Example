package com.test.autocompletetextviewexample

import android.util.Log
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import java.lang.Exception
import java.util.ArrayList

/**
 * Created by Sanjay on 5/7/20.
 */
class MainViewModel(
    private val repository: UserRepository
): ViewModel()  {

    val user = MutableLiveData("")
    var userList: MutableLiveData<ArrayList<User>> = MutableLiveData()

    val valid = MediatorLiveData<Boolean>().apply {
        addSource(user) {
            searchUser(it)
            value = true
        }
    }

    private fun searchUser(name: String) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val response = repository.searchUser(name)
                if(response.isSuccessful){
                    userList.value = response.body()?.items
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}