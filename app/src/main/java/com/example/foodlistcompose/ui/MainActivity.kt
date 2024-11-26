package com.example.foodlistcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.foodlistcompose.ui.theme.MyappTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodlistcompose.R

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyappTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = { Text("Food List") },
                            actions ={
                                IconButton(
                                    onClick = { /*TODO*/ },
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_shop),
                                        contentDescription = "Shop"
                                    )
                                }
                            }
                        )
                    },
                    content = { innerPadding ->
                        FoodListStruct(
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                )
            }
        }
    }
}


val foodlist = listOf(
    FoodList(1, "Pizza", "Delicious Italian pizza", R.drawable.pizza , "$10.99"),
    FoodList(2, "Burger", "Juicy beef burger", R.drawable.burger , "$8.99"),
    FoodList(3, "Sushi", "Assorted sushi rolls", R.drawable.sushi , "$12.99"),
    FoodList(4, "Salad", "Fresh garden salad", R.drawable.salad , "$6.99"),
    FoodList(5, "Pasta", "Classic Italian pasta", R.drawable.pasta, "$9.99"),
    FoodList(6, "Tacos", "Mexican taco bowl", R.drawable.tacos, "$7.99"),
    FoodList(7, "Steak", "Juicy steak sandwich", R.drawable.steak, "$11.99")
)



@Composable
fun FoodListStruct(
    modifier: Modifier = Modifier
){
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(foodlist.size) { index ->
            val food = foodlist[index]
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = food.image),
                    contentDescription = food.name,
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .size(100.dp),
                )
                Column {
                    Text(
                        text = food.name,
                    )
                    Text(
                        text = food.price,
                        modifier = Modifier.padding(bottom = 8.dp),
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyappTheme {
        FoodListStruct()
    }
}





