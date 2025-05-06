package com.example.lost_and_found

import android.app.Application
import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.initialize
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class LostAndFoundMainApp :Application() {
    override fun onCreate() {
        super.onCreate()
         Timber.plant(Timber.DebugTree())
        Timber.i("Starting DonationX Application")
        Firebase.initialize(context = this)
//       Initialize any libraries or perform setup tasks here
    }
}