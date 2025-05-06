package com.example.lost_and_found.ui.screens.items


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
class ItemsViewModel @Inject
constructor(private val repository: FireStoreService,

            ) : ViewModel() {
    private val _lostItems
            = MutableStateFlow<List<LostItemModel>>(emptyList())
    val uiLostItems: StateFlow<List<LostItemModel>>
            = _lostItems.asStateFlow()
    var iserror = mutableStateOf(false)
    var isloading = mutableStateOf(false)
    var error = mutableStateOf(Exception())

    init { getAllLostItems() }

    fun getAllLostItems() {
        viewModelScope.launch {
            try {
                isloading.value = true
                repository.getAll().collect{ items ->
                    _lostItems.value = items
                    iserror.value = false
                    isloading.value = false
                }
                Timber.i("DVM RVM = : ${_lostItems.value}")
            }
            catch(e:Exception) {
                iserror.value = true
                isloading.value = false
                error.value = e
                Timber.i("RVM Error ${e.message}")
            }
        }
    }


}