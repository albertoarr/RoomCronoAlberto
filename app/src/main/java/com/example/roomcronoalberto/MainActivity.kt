package com.example.roomcronoalberto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.roomcronoalberto.model.CronometroViewModel
import com.example.roomcronoalberto.model.CronosViewModel
import com.example.roomcronoalberto.model.NavManager
import com.example.roomcronoalberto.model.RoomCronoAlbertoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val cronometroVM: CronometroViewModel by viewModels()
        val cronosVM: CronosViewModel by viewModels()
        setContent {
            RoomCronoAlbertoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavManager(cronometroVM, cronosVM)
                }
            }
        }
    }
}
