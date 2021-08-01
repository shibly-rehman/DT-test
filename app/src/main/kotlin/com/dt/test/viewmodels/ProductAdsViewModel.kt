package com.dt.test.viewmodels

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.dt.test.Constants
import com.dt.test.DTApp
import com.dt.test.api.ApiFactory
import com.dt.test.model.ProductAds
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductAdsViewModel: ViewModel(), Callback<ProductAds> {

    private val data = MutableLiveData<ProductAds>()

    fun getProductAds (owner: LifecycleOwner, observer: Observer<ProductAds>) {
        data.observe( owner, observer )
        ApiFactory.api.getProductAds().enqueue(this)
    }

    override fun onResponse(call: Call<ProductAds>, response: Response<ProductAds>) {
        data.value = response.body()
    }

    override fun onFailure (call: Call<ProductAds>, t: Throwable) {
        Toast.makeText(DTApp.context, t.localizedMessage, Toast.LENGTH_LONG).show()
        Log.e(TAG, t.localizedMessage ?: "")
    }

    companion object {
        private const val TAG = "${Constants.TAG}::ProductsViewModel"
    }
}