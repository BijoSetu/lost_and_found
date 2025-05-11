package com.example.lost_and_found.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.firestore.DocumentId
import com.google.gson.annotations.SerializedName
import java.util.Date

@Entity
data class LostItemModel(
    @DocumentId val documentId: String = "N/A",
    val _id: String = "N/A",
    val title: String = "Untitled",
    val description: String = "Untitled",
//    val subtitle: String = "No description",
    val foundLocation: String = "Unknown",
    val foundDate: Date = Date(),
    val postedDate: Date = Date(),
    val imageUrl: String = "",
    val category: String = "Miscellaneous",
    val userId: String = "user123", // Assuming a user reference for the one who posted
    var message: String = "Help us find this item!"
)

val fakeLostItems = List(30) { i ->
    LostItemModel(
        _id = "item12345$i",
        title = "Lost Item #$i",
//        subtitle = "Subtitle for item #$i",
        foundLocation = "Location #$i",
        foundDate = Date(),
        postedDate = Date(),
        imageUrl = "https://example.com/image_$i.jpg",
        category = "Category $i",
        userId = "user$i",
        message = "Please help us find this lost item!"
    )
}
