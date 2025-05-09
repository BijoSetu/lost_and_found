package com.example.lost_and_found.ui.screens.myItems

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lost_and_found.data.model.LostItemModel
import com.example.lost_and_found.firebase.services.AuthService
import com.example.lost_and_found.firebase.services.FireStoreService
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MyItemsViewModel @Inject
constructor(private val repository: FireStoreService,
            private val authService: AuthService
) : ViewModel() {
    private val _myItems
            = MutableStateFlow<List<LostItemModel>>(emptyList())
    val uiMyItems: StateFlow<List<LostItemModel>>
            = _myItems.asStateFlow()
    var iserror = mutableStateOf(false)
    var isloading = mutableStateOf(false)
    var error = mutableStateOf(Exception())

    init { getMyLostItems() }

    fun getMyLostItems() {
        viewModelScope.launch {
            try {
                isloading.value = true
                repository.get(authService.email!!).collect{ items ->
                    _myItems.value = items
                    iserror.value = false
                    isloading.value = false
                }
                Timber.i("DVM RVM = : ${_myItems.value}")
            }
            catch(e:Exception) {
                iserror.value = true
                isloading.value = false
                error.value = e
                Timber.i("RVM Error ${e.message}")
            }
        }
    }

//    fun deleteDonation(donation: LostItemModel)
//            = viewModelScope.launch {
//        repository.delete(authService.email!!,donation._id)
//    }
}

