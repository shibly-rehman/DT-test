package com.dt.test.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dt.test.R
import com.dt.test.adapters.ProductAdsAdapter.ProductAdsViewHolder
import com.dt.test.model.ProductAd
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_product.view.*

/**
 * Adapter for product ads
 */
class ProductAdsAdapter(val itemClick: (ProductAd) -> Unit): ListAdapter<ProductAd, ProductAdsViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ProductAdsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false))

    override fun onBindViewHolder(holder: ProductAdsViewHolder, index: Int) = holder.bind(getItem(index))

    /** ViewHolder that binds product ads view */
    inner class ProductAdsViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(productAd: ProductAd) {
            containerView.apply {
                name.text = productAd.name
                rating.rating = productAd.rating
                description.text = productAd.description
                Picasso.get().load(productAd.thumbnail).into(image)

                // Send item back to fragment
                setOnClickListener { itemClick.invoke(productAd) }
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ProductAd>() {
            override fun areItemsTheSame(oldItem: ProductAd, newItem: ProductAd): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ProductAd, newItem: ProductAd): Boolean {
                return oldItem == newItem
            }
        }
    }
}