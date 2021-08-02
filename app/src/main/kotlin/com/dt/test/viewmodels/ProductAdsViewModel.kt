package com.dt.test.viewmodels

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.dt.test.Constants
import com.dt.test.api.ApiFactory
import com.dt.test.model.ProductAds
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * ViewModel to handle product ads call
 */
class ProductAdsViewModel(app: Application): AndroidViewModel(app), Callback<ProductAds> {

    private val data = MutableLiveData<ProductAds>()

    fun getProductAds (owner: LifecycleOwner, observer: Observer<ProductAds>) {
        data.observe( owner, observer )
        ApiFactory.api.getProductAds().enqueue(this)
    }

    override fun onResponse(call: Call<ProductAds>, response: Response<ProductAds>) {
        data.value = response.body()
    }

    override fun onFailure (call: Call<ProductAds>, t: Throwable) {
        Toast.makeText(getApplication(), t.localizedMessage, Toast.LENGTH_LONG).show()
        Log.e(TAG, t.localizedMessage ?: "")
    }

    companion object {
        private const val TAG = "${Constants.TAG}::ProductsViewModel"
    }
}