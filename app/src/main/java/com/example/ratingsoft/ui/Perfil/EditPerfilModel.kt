package com.example.ratingsoft.ui.Perfil

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ratingsoft.Conexion.ApiConexion
import com.example.ratingsoft.data.Model.send.User
import com.example.ratingsoft.data.Model.send.UserAdmin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditPerfilModel: ViewModel(){


    // LiveData para observar cambios en el texto
    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
    }
    val text: LiveData<String> = _text

    // LiveData para observar cambios en el usuario
    private val userById = MutableLiveData<User>()
    val user: LiveData<User> get() = userById

    // Método para obtener el perfil del usuario
    fun getUserProfile(userId: String) {
        val apiService = ApiConexion.getApiService()

        val userProfileCall: Call<User> = apiService.getUserProfile(userId)
        userProfileCall.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val user = response.body()
                    user?.let {
                        userById.value = it
                    }
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.e("Error user", t.toString())
            }
        })
    }

    // Método para actualizar el perfil del usuario
    fun updateUserProfile(updatedUser: User) {
        val apiService = ApiConexion.getApiService()

        val updateUserCall: Call<User> = apiService.updateUserProfile(updatedUser)
        updateUserCall.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    // Procesar la respuesta si es necesario
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.e("Error updating user", t.toString())
            }
        })
    }
}