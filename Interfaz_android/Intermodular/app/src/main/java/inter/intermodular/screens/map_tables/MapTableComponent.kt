package inter.intermodular.screens.map_tables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.orhanobut.logger.Logger
import inter.intermodular.R
import inter.intermodular.ScreenNav
import inter.intermodular.models.TableModel
import inter.intermodular.support.*
import inter.intermodular.view_models.MapViewModel
import kotlinx.coroutines.*

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MapTableComponent(
    mapViewModel: MapViewModel,
    navController: NavHostController,
    scope: CoroutineScope
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(6),
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        mapViewModel.getZoneTables(currentZone?._id ?: "Error")
        if (!mapViewModel.zoneTablesResponse.isNullOrEmpty()) {

            currentZoneTables = mapViewModel.zoneTablesResponse
            currentZoneTables = currentZoneTables.sortedWith(compareBy<TableModel> { it.num_row }.thenBy { it.num_column })

            for (i in 0 until currentZoneTables.count()) {

                item {
                    //RowContent(i, mapViewModel, navController)
                    ButtonMesa(i, navController)

                }
            }
        }
    }
}

@Composable
fun RowContent(
    i: Int,
    mapViewModel: MapViewModel,
    navController: NavHostController,
) {

    if (currentZone != null) {
        if (!currentZoneTables.isNullOrEmpty()) {

            for (table in currentZoneTables) Logger.w("All tables $table")


            // if (!emptySpace) {
            /**TODO Colocar en orden fila x columna las diferentes mesas*/
            ButtonMesa(i, navController)
            //emptySpace = false

            // } else {
            //TODO CREAR UN BOTON VACIO

            /*  Button(
                    modifier = Modifier
                        .height(60.dp)
                        .width(60.dp)
                        .padding(3.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),

                    onClick = {

                        //currentTable = currentZoneTables[i]
                        //Logger.i("Mesa seleccionada $currentTable")
                        //navController.navigate(ScreenNav.TableScreen.route)
                    }) {
                    Text(
                        text = "", fontSize = 8.sp,
                    )
                    emptySpace = true
                    lastTable = currentZoneTables[i]
                    //lastTable!!.num_column++
                    //astTable!!.num_row++

                    //ButtonMesa(i, navController)
                }
            }*/
            // lastTable = currentZoneTables[i]
            // tableColumn++
            //if (tableColumn == 6) {
            //    tableColumn = 1
            //   tableRow++
        }

    }
}

@Composable
private fun ButtonMesa(i: Int, navController: NavHostController) {
    Button(
        modifier = Modifier
            .height(60.dp)
            .width(60.dp)
            .padding(3.dp),
        colors =
            if (currentZoneTables[i].ocupada)ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.rojo))
            else ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.azul)),
       /* elevation = ButtonDefaults.elevation(
            defaultElevation = 10.dp,
            pressedElevation = 1.dp,
            disabledElevation = 0.dp
        ),*/
        onClick = {

            //currentTable = if(emptySpace) currentZoneTables[i-1] else currentZoneTables[i]
            currentTable = currentZoneTables[i]
            Logger.i("Mesa seleccionada $currentTable")
            navController.navigate(ScreenNav.TableScreen.route)
        }) {
        Text(
            text =  if (currentZoneTables[i].name.length > 3)
                        currentZoneTables[i].name.substring(0, 3)
                    else currentZoneTables[i].name,
            fontSize = 8.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}