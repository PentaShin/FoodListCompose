package com.example.foodlistcompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.foodlistcompose.R
import com.example.foodlistcompose.ui.theme.MyappTheme

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
fun FoodPage(
    modifier: Modifier,
    navController: NavHostController
) {
    LazyColumn(
        modifier = Modifier,
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
                    onClick = {
                        navController.navigate("ShopAddScreen")
                    },
                    modifier = Modifier.size(48.dp),
                    content = {
                        Image(
                            painter = painterResource(id = food.icon),
                            contentDescription = "Add",
                            modifier = Modifier.size(24.dp),
                        )
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FoodPagePreview() {
    MyappTheme {
        FoodPage(modifier = Modifier, navController = rememberNavController())
    }
}



