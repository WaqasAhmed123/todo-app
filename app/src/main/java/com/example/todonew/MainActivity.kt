package com.example.todonew

import AddTodoScreen
import HomeScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.todonew.ui.theme.TodoNewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoNewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
//                    Column {
//
////                        displayList()
////                        addTask()
////                        stackElements()
//                        AddTodoScreen(onAddTodo = { description ->
//                            println("Adding todo with description: $description")
//                        })
//                    }

                }
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home_screen") {
        composable(route = "home_screen") {
            HomeScreen(navController)
        }
        composable(route = "add_todo/{editableDescription}/{index}", arguments = listOf(
            navArgument(name = "editableDescription") {
                type = NavType.StringType
            },
            navArgument(name = "index") {
                type = NavType.IntType // Assuming index is an integer
            }
        )) {
            AddTodoScreen(
                editableDescription = editableDescription ?: "",
                index = index,
                onAddTodo = { description ->
                println("Adding todo with description: $description")
            })
        }
    }
}