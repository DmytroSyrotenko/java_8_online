package com.example.service.order.impl;

import com.example.persistence.entity.cart.Cart;
import com.example.persistence.entity.cart.CartEntry;
import com.example.persistence.entity.order.OrderEntry;
import com.example.persistence.repository.cart.CartRepository;
import com.example.persistence.repository.order.OrderEntryRepository;
import com.example.persistence.repository.order.OrderRepository;
import com.example.service.cart.CartService;
import com.example.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

    private final CartRepository cartRepository;
    private final CartService cartService;
    private final OrderRepository orderRepository;
    private final OrderEntryRepository orderEntryRepository;


    @Override
    public void createOrderInSystem() {
        Cart cart = cartService.getActiveCart();

        List<CartEntry> activeCartEntries = cartService.getActiveCartEntries();


        List<OrderEntry> orderEntryList = activeCartEntries
                .stream()
                .map(OrderEntry::new)
                .toList();

        orderEntryRepository.save(orderEntryList.get(1));
        System.out.println("часть прошли");
    }
}
