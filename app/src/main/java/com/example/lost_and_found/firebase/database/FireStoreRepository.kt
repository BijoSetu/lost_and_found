package com.example.lost_and_found.firebase.database


import com.example.lost_and_found.data.rules.Constants.Lost_Items
import com.example.lost_and_found.firebase.services.FireStoreService
import com.example.lost_and_found.firebase.services.LostItems
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.dataObjects
import com.google.firebase.firestore.toObject

import kotlinx.coroutines.tasks.await
import java.util.Date
import javax.inject.Inject


class FireStoreRepository
@Inject constructor(
                    private val firestore: FirebaseFirestore
) : FireStoreService {

    override suspend fun getAll(): LostItems {
        return firestore.collection(Lost_Items)
            .dataObjects()
    }
//    override suspend fun get(email: String,
//                             donationId: String): Donation? {
//        return firestore.collection(DONATION_COLLECTION)
//            .document(donationId).get().await().toObject()
//    }
//
//    override suspend fun insert(email: String,
//                                donation: Donation)
//    {
//        val donationWithEmail = donation.copy(email = email)
//
//        firestore.collection(DONATION_COLLECTION)
//            .add(donationWithEmail)
//            .await()
//
//    }
//
//    override suspend fun update(email: String,
//                                donation: Donation) {
//        val donationWithModifiedDate =
//            donation.copy(dateModified = Date())
//
//        firestore.collection(DONATION_COLLECTION)
//            .document(donation._id)
//            .set(donationWithModifiedDate).await()
//    }
//
//    override suspend fun delete(email: String,
//                                donationId: String) {
//        firestore.collection(DONATION_COLLECTION)
//            .document(donationId)
//            .delete().await()
//    }
}