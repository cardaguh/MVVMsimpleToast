package co.com.pragma.exampleobserver1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MVVMViewModel: ViewModel() {

    val showMessage = MutableLiveData<Boolean>()

    fun startShowMessage() {
        showMessage.value = true
        //showMessage.postValue(true)
    }

    fun endShowMessage() {
        showMessage.value = null
        //showMessage.postValue(null)
    }
}