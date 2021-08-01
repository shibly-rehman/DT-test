package com.dt.test.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

/**
 * ProductAds collection
 */
@Root(name = "ads", strict = false)
data class ProductAds(
    @field:ElementList(name="ad", inline=true)
    @param:ElementList(name="ad", inline=true)
    val items: List<ProductAd> = emptyList()
)

/**
 * ProductAd
 */
@Parcelize
@Root(name="ad", strict = false)
data class ProductAd @JvmOverloads constructor(
    @field:Element(name="numberOfRatings")
    @param:Element(name="numberOfRatings")
    val ratingCount: String? = null,

    @field:Element(name="productDescription")
    @param:Element(name="productDescription")
    val description: String = "",

    @field:Element(name="productId")
    @param:Element(name="productId")
    val id: String = "",

    @field:Element(name="productName")
    @param:Element(name="productName")
    val name: String = "",

    @field:Element(name="productThumbnail")
    @param:Element(name="productThumbnail")
    val thumbnail: String? = null,

    @field:Element(name="rating")
    @param:Element(name="rating")
    val rating: Float = 0f,

    @field:Element(name="numberOfDownloads")
    @param:Element(name="numberOfDownloads")
    val downloadCount: String? = null,

    @field:Element(name="categoryName")
    @param:Element(name="categoryName")
    val category: String? = null,
) : Parcelable
