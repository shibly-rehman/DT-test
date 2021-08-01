package com.dt.test.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import com.dt.test.Constants.PRODUCT_AD
import com.dt.test.R
import com.dt.test.model.ProductAd
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_product_details.*

/**
 * Display's the product ad details
 */
class ProductDetailsFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set fragment enter/exit animation
        val inflater = TransitionInflater.from(requireContext())
        enterTransition = inflater.inflateTransition(R.transition.slide_right)
        exitTransition = inflater.inflateTransition(R.transition.slide_right)
    }

    /** Inflate the layout */
    override fun onCreateView (inflater: LayoutInflater, container: ViewGroup?, savedBundle: Bundle?): View? =
        inflater.inflate(R.layout.fragment_product_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {  a ->
            a.getParcelable<ProductAd>(PRODUCT_AD)?.let {
                // Populate view
                name.text = it.name
                rating.rating = it.rating
                description.text = it.description
                ratingCount.text = it.ratingCount
                downloadCount.text = it.downloadCount
                category.text = it.category
                Picasso.get().load(it.thumbnail).into(image)
                install.setOnClickListener {
                    Toast.makeText(activity?.applicationContext, "Install", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}