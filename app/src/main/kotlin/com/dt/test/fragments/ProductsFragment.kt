package com.dt.test.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.TransitionInflater
import com.dt.test.Constants.PRODUCT_AD
import com.dt.test.R
import com.dt.test.adapters.ProductAdsAdapter
import com.dt.test.viewmodels.ProductAdsViewModel
import kotlinx.android.synthetic.main.fragment_products.*

/** Display's a list of product ads */
class ProductsFragment: Fragment() {

    private val adapter: ProductAdsAdapter by lazy { ProductAdsAdapter {
        // Open product detail fragment
        parentFragmentManager.beginTransaction()
            .add(R.id.fragment, ProductDetailsFragment().apply {
                arguments = Bundle().apply { putParcelable(PRODUCT_AD, it) }
            })
            .addToBackStack(null)
            .commit()
    } }

    private val viewModel: ProductAdsViewModel by viewModels { defaultViewModelProviderFactory }

    /** Inflate the layout */
    override fun onCreateView (inflater: LayoutInflater, container: ViewGroup?, savedBundle: Bundle?): View? =
        inflater.inflate(R.layout.fragment_products, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(activity)
        val dividerItemDecoration = DividerItemDecoration(activity, layoutManager.orientation)
        list.layoutManager = layoutManager
        list.adapter = adapter
        // Add divider
        list.addItemDecoration(dividerItemDecoration)

        // Observe product ads
        viewModel.getProductAds(viewLifecycleOwner) { p ->
            progress.visibility = View.GONE
            adapter.submitList(p.items)
        }
    }
}