package com.example.lost_and_found.ui.screens.post

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lost_and_found.data.model.LostItemModel
import com.example.lost_and_found.firebase.services.FireStoreService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject
constructor(private val repository: FireStoreService,

            ) : ViewModel() {
    //    private val _lostItems
//            = MutableStateFlow<List<LostItemModel>>(emptyList())
//    val uiLostItems: StateFlow<List<LostItemModel>>
//            = _lostItems.asStateFlow()
    var iserror = mutableStateOf(false)
    var isloading = mutableStateOf(false)
    var error = mutableStateOf(Exception())


    fun postLostItem(lostItem: LostItemModel) =
        viewModelScope.launch {
            try {
                isloading.value = true
                repository.insert(lostItem)
                iserror.value = false
                isloading.value = false
            } catch (e: Exception) {
                iserror.value = true
                error.value = e
                isloading.value = false
            }
            Timber.i("DVM Insert Message = : ${error.value.message} and isError ${iserror.value}")
        }
}
