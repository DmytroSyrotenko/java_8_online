package com.example.service.cart;

import com.example.persistence.entity.cart.Cart;
import com.example.persistence.entity.cart.CartEntry;

import java.util.List;

public interface CartService {

    void addProductVariantToCart(Long productVariantId, int quantity);

    void deleteProductVariantFromCart(Long productVariantId);

    Cart getActiveCart();

    List<CartEntry> getActiveCartEntries();

    void deleteCart(Cart cart);

    void deleteCartEntries(Cart cart);
}
