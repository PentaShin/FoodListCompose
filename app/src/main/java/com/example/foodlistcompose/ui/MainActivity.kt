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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.ui.Modifier
import com.example.foodlistcompose.ui.theme.MyappTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
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
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = {
                    TopAppBar(
                        title = { Text("Food List") },
                        modifier = Modifier
                            .padding(16.dp)
                            .height(80.dp),
                        actions = {
                            IconButton(
                                onClick = { /* TODO */ },
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
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    )
                }
            )
        }
    }
}


val foodlist = listOf(
    FoodList(1, "Pizza", "Delicious Italian pizza", R.drawable.pizza , "$10.99", R.drawable.ic_add ),
    FoodList(2, "Burger", "Juicy beef burger", R.drawable.burger , "$8.99" , R.drawable.ic_add),
    FoodList(3, "Sushi", "Assorted sushi rolls", R.drawable.sushi , "$12.99", R.drawable.ic_add),
    FoodList(4, "Salad", "Fresh garden salad", R.drawable.salad , "$6.99", R.drawable.ic_add),
    FoodList(5, "Pasta", "Classic Italian pasta", R.drawable.pasta, "$9.99", R.drawable.ic_add),
    FoodList(6, "Tacos", "Mexican taco bowl", R.drawable.tacos, "$7.99", R.drawable.ic_add),
    FoodList(7, "Steak", "Juicy steak sandwich", R.drawable.steak, "$11.99", R.drawable.ic_add)
)



@Composable
fun FoodListStruct(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
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
                        .size(120.dp),
                )


                Column(
                    modifier = Modifier
                        .padding(end = 100.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        text = food.name,
                        color = Color.Green
                    )
                    Text(
                        text = food.price,
                        modifier = Modifier.padding(bottom = 8.dp),
                    )
                }
                IconButton(
                    onClick = { /* TODO */ },
                    modifier = Modifier
                        .size(12.dp)
                        .padding(end = 32.dp)
                ) {
                    Image(
                        painter = painterResource(id = food.icon),
                        contentDescription = "Add"
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





