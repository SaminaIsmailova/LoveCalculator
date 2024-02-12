package com.example.lovecalculator.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator.remote.LoveModel
import com.example.lovecalculator.repository.Repository

@HiltViewModel
class LoveViewModel @Inject constructor(val repository: Repository)     : ViewModel() {
    fun getLiveLove(firstname: String, secondName:String): LiveData<LoveModel> {
        return  repository.getLove(firstname, secondName)
    }


}