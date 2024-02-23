@file:OptIn(ExperimentalMaterial3Api::class)


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddTodoScreen(
    editableDescription: String = "",
    index: Int=tasks.size-1,

    onAddTodo: (String) -> Unit) {
    var description by remember { mutableStateOf(editableDescription)
    }

    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text(text = "Add Todo") },
//                backgroundColor = Color.White
//            )
//        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Description") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        if (description.isNotBlank()) {
                            if(editableDescription.isNotBlank()){
                                tasks[index]=description
                            }
                            else{
                            tasks.add(description)
                            onAddTodo.invoke(description)
                            description = ""
//                            navController.popBackStack()
                        }}
//                        onAddTodo.invoke(description)
//                        description = ""
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Add Todo")
                }
            }
        }
    )
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewAddTodoScreen() {
//    AddTodoScreen(onAddTodo = { })
//}
