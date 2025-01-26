package com.example.roomcronoalberto.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomcronoalberto.repository.CronosRepository
import com.example.roomcronoalberto.state.CronoState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CronometroViewModel @Inject constructor (private val repository: CronosRepository): ViewModel() {
    var state by mutableStateOf(CronoState())
        private set
    var cronoJob by mutableStateOf<Job?>(null)
        private set
    var tiempo by mutableStateOf(0L)
        private set

    fun getCronoById(id:Long){
        viewModelScope.launch (Dispatchers.IO) {
            repository.getCronoById(id).collect{ item->
                tiempo=item.crono
                state=state.copy(title=item.title)


            }
        }
    }
    fun onValue(value:String){
        state = state.copy(title = value)
    }

    fun iniciar(){
        state= state.copy(
            cronometroActivo = true
        )
    }
    fun pausar(){
        state= state.copy(
            cronometroActivo = false,
            showSaveButton = true
        )
    }
    fun detener(){
        cronoJob?.cancel()
        tiempo=0
        state= state.copy(
            cronometroActivo = false,
            showSaveButton = false,
            showTextFile = false
        )
    }
    fun showTextFile(){
        state=state.copy(
            showTextFile=true
        )
    }
    fun cronos(){
        if(state.cronometroActivo){
            cronoJob?.cancel()
            cronoJob= viewModelScope.launch {
                while (true){
                    delay(1000)
                    tiempo+=1000
                }
            }
        }else{
            cronoJob?.cancel()

        }
    }
}