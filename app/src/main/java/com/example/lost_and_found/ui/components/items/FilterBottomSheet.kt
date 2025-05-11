import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Button

//@Composable
//fun FilterBottomSheet(
//    selected: List<String>,
//    onToggle: (String) -> Unit, // Use String instead of Category
//    onClose: () -> Unit
//) {
//    Column(modifier = Modifier.padding(4.dp)) {
//        Text("Filter by Category", style = MaterialTheme.typography.titleMedium)
//        Spacer(modifier = Modifier.padding(2.dp))
//        // List of categories as Strings
//        listOf("PETS", "WALLETS", "ELECTRONICS", "OTHERS", "ALL").forEach { category -> // Directly use Strings
//            Row(verticalAlignment = Alignment.CenterVertically) {
//                Checkbox(
//                    checked = selected.contains(category),
//                    onCheckedChange = { onToggle(category) }
//                )
//                Text(text = category) // Display the category string
//            }
//        }
//        Button(onClick = { onClose() }, modifier = Modifier.fillMaxWidth()) {
//            Text("Apply")
//        }
//    }
//}

@Composable
fun FilterBottomSheet(
    selected: List<String>,
    onToggle: (String) -> Unit,
    onClose: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(12.dp)
            .wrapContentHeight()
    ) {
        Text(
            "Filter by Category",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Display two checkboxes per row
        val categories = listOf("PETS", "WALLETS", "ELECTRONICS", "OTHERS", "ALL")
        categories.chunked(2).forEach { rowItems ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
            ) {
                rowItems.forEach { category ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(1f)
                    ) {
                        Checkbox(
                            checked = selected.contains(category),
                            onCheckedChange = { onToggle(category) },
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = category,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
                // Fill remaining space if there's only one item in the last row
                if (rowItems.size == 1) Spacer(modifier = Modifier.weight(1f))
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

//        Button(
//            onClick = { onClose() },
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text("Apply")
//        }
    }
}

