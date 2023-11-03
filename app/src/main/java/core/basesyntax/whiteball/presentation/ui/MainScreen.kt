package core.basesyntax.whiteball.presentation.ui

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import core.basesyntax.whiteball.R
import core.basesyntax.whiteball.presentation.navigation.Screen

@Composable
fun MainScreen(navController: NavController) {
    val context = LocalContext.current
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomButton(
                text = stringResource(id = R.string.play_button_text),
                icon = ImageVector.vectorResource(id = R.drawable.gamepad),
                backgroundColor = Color(0xFF4CAF50),
                onClick = { navController.navigate(Screen.GameScreen.route) }
            )
            Spacer(modifier = Modifier.height(16.dp))
            CustomButton(
                text = stringResource(id = R.string.politics_button_text),
                icon = Icons.Default.Info,
                backgroundColor = Color(0xFF2196F3),
                onClick = { navController.navigate(Screen.WebView.route) }
            )
            Spacer(modifier = Modifier.height(16.dp))
            CustomButton(
                text = stringResource(id = R.string.history_button_text),
                icon = Icons.Default.List,
                backgroundColor = Color(0xFF9C27B0),
                onClick = { navController.navigate(Screen.GameHistory.route) }
            )
            Spacer(modifier = Modifier.height(16.dp))
            CustomButton(
                text = stringResource(id = R.string.exit_button_text),
                icon = Icons.Default.ExitToApp,
                backgroundColor = Color(0xFFE91E63),
                onClick = { (context as? ComponentActivity)?.finish() }
            )
        }
    }
}

@Composable
fun CustomButton(
    text: String,
    icon: ImageVector,
    backgroundColor: Color,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(200.dp)
            .shadow(elevation = 0.dp, shape = RoundedCornerShape(4.dp))
    ) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(backgroundColor),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(imageVector = icon, contentDescription = null, tint = Color.White, modifier = Modifier.size(15.dp))
                Text(text = text, color = Color.White)
            }
        }
    }
}