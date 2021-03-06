package br.com.safeguardian.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import br.com.safeguardian.model.db.CredentialsTable
import br.com.safeguardian.repository.CredentialsListRepository
import br.com.safeguardian.utils.Resource
import kotlinx.coroutines.Dispatchers

class CredentialsListViewModel(private val repository: CredentialsListRepository): ViewModel() {

    fun getCredentialList() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getListOfCredentials()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    fun addItemList(credential: CredentialsTable) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.saveCredential(credential)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}