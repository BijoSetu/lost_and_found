package com.example.lost_and_found.firebase.services


import com.example.lost_and_found.data.model.LostItemModel
import kotlinx.coroutines.flow.Flow

typealias LostItem = LostItemModel
typealias LostItems = Flow<List<LostItem>>

interface FireStoreService {

    suspend fun getAll() : LostItems
    suspend fun get(email: String) : LostItems
    suspend fun insert(lostItem: LostItem)
//    suspend fun update(email: String, donation: LostItem)
//    suspend fun delete(email: String, donationId: String)
}