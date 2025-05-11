package com.example.lost_and_found.ui.screens.items


import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateListOf
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
import java.util.Locale
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

    private val _selectedCategories = mutableStateListOf<String>() // Store selected categories as Strings
    val selectedCategories: List<String> get() = _selectedCategories

    // Filtered list state
    private val _filteredItems = MutableStateFlow<List<LostItemModel>>(emptyList())
    val filterItems: StateFlow<List<LostItemModel>> = _filteredItems.asStateFlow()


    init { getAllLostItems() }



    fun filterItems() {
        _filteredItems.value = if (_selectedCategories.isEmpty() || _selectedCategories.contains("ALL")) {
            _lostItems.value // Show all if nothing or "ALL" selected
        } else {
            _lostItems.value.filter { item ->
                _selectedCategories.any { selected ->
                    item.category.equals(selected, ignoreCase = true)
                }
            }
        }
    }



    fun toggleCategory(category: String) {
        if (category.equals("ALL", ignoreCase = true)) {
            _selectedCategories.clear()
            _selectedCategories.add("ALL")
        } else {
            _selectedCategories.remove("ALL") // Unselect "ALL" if selecting something else
            if (_selectedCategories.contains(category)) {
                _selectedCategories.remove(category)
            } else {
                _selectedCategories.add(category)
            }
        }
    }


    fun clearCategories() {
        _selectedCategories.clear()
    }


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