package com.practicum.testappshop.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.practicum.testappshop.R
import com.practicum.testappshop.domain.models.Product
import com.practicum.testappshop.util.ButtonAddClickListener
import com.practicum.testappshop.util.ButtonDelClickListener
import com.practicum.testappshop.util.ProductClickListener

class CartProductsViewAdapter(
    private val buttonAddClickListener: ButtonAddClickListener,
    private val buttonDelClickListener: ButtonDelClickListener,
    private val clickListener: ProductClickListener,
) : RecyclerView.Adapter<CartViewHolder>() {

    private var products = mutableListOf<Product>()
    private var productsInCart = mutableListOf<Long>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.cart_item_view, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(products[position], productsInCart[position])
        holder.itemView.setOnClickListener { clickListener.onProductClick(products[position]) }
        val btnInc = holder.itemView.findViewById<Button>(R.id.button_add)
        val btnDec = holder.itemView.findViewById<Button>(R.id.button_remove)

        btnInc.setOnClickListener {
            if (buttonAddClickListener.onButtonAddClickListener(products[position])) {
                productsInCart[position]++
                notifyItemChanged(position)
            }
        }
        btnDec.setOnClickListener {
            if (buttonDelClickListener.onButtonDelClickListener(products[position])) {
                productsInCart[position]--
                if (productsInCart[position] < 1) {
                    products.removeAt(position)
                    productsInCart.removeAt(position)
                    notifyItemRemoved(position)
                } else {
                    notifyItemChanged(position)
                }
            }
        }
    }

    override fun getItemCount() = products.size

    fun setProducts(products: List<Product>, productsInCart: List<Long>) {
        this.products.addAll(products)
        this.productsInCart.addAll(productsInCart)
        notifyDataSetChanged()
    }
}

class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val productTitle: TextView
    private val productPrice: TextView
    private val productImage: ImageView
    private val productCountInCart: TextView

    val requestOptions = RequestOptions().transform(RoundedCorners(2.dpToPx(itemView.context)))

    init {
        productTitle = itemView.findViewById(R.id.name_cart)
        productPrice = itemView.findViewById(R.id.price_cart)
        productImage = itemView.findViewById(R.id.product_cart_img)
        productCountInCart = itemView.findViewById(R.id.counter)
    }

    fun bind(model: Product, countInCart: Long) {
        productTitle.text = model.title
        productPrice.text = model.price.toString()
        productCountInCart.text = countInCart.toString()
        Glide.with(itemView).load(model.thumbnail).error(R.drawable.placeholder)
            .apply(requestOptions).into(productImage)
    }

    private fun Int.dpToPx(context: Context): Int {
        val density = context.resources.displayMetrics.density
        return (this * density).toInt()
    }
}