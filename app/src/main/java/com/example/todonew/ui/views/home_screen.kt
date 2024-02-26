import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun HomeScreen(navController: NavController) {
    Box {
        displayList(navController = navController)
        addTask(navController)
    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun displayList(navController: NavController) {
    Column(
        // inside this column we are specifying modifier
        // to specify max width and max height
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        // on below line we are specifying horizontal alignment
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // on below line we are creating a simple text
        // view for displaying heading for our application
        Text(
            text = "Todo",
            // in modifier we are specifying padding
            // for our text from all sides.
            modifier = Modifier.padding(10.dp),
            // on below line we are specifying
            // style for our text
            style = TextStyle(
                color = Color.Black,
                fontSize = TextUnit(value = 20.0F, type = TextUnitType.Sp)
            ), fontWeight = FontWeight.Black
        )
        // on below line we are calling lazy column
        // for displaying listview.
        LazyColumn {

            // on below line we are populating
            // items for listview.
            itemsIndexed(tasks) { index, task ->
                // on below line we are specifying ui for each item of list view.
                // we are specifying a simple text for each item of our list view.
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillParentMaxWidth()
                ) {
                    Text(
                        task, modifier = Modifier
                            .weight(1f)
                            .padding(15.dp)
                    )

                    IconButton(
                        onClick = {
                            Log.d("AddTodoScreen", "Task: $task, Index: $index")
                            navController.navigate("add_todo?editableDescription=${task}&index=${index}")
                        },
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Edit",
                            tint = Color.Green
                        )
                    }

                    IconButton(
                        onClick = { tasks.removeAt(index) },
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Delete",
                            tint = Color.Red
                        )
                    }
                }
                Divider()
            }
        }
    }
}

@Composable
fun addTask(navController: NavController) {
//    val navController = rememberNavController()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                end = 16.dp,
                bottom = 16.dp
            ), // Adding padding of 16dp only to the right side (end)
        contentAlignment = Alignment.BottomEnd
    ) {
        FloatingActionButton(

            onClick = { navController.navigate("add_todo") },
        )
        {
            Icon(Icons.Filled.Add, "Floating action button.")
        }

    }


}