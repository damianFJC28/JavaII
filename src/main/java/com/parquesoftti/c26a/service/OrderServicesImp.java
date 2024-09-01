package com.parquesoftti.c26a.service;

import com.parquesoftti.c26a.model.Order;
import com.parquesoftti.c26a.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServicesImp implements OrderService {

    final OrderRepository orderRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Order> findAll() {
        return orderRepository.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = false,propagation = Propagation.REQUIRED,rollbackFor = RuntimeException.class)
    public Order save(Order order) {
        return orderRepository.save(order);
    }


    @Override
    @Transactional(readOnly = false,propagation = Propagation.REQUIRED,rollbackFor = RuntimeException.class)
    public Order update(Long id, Order order) {
        Order ordersTmp = orderRepository.findById(id)
                .orElseThrow(()->new RuntimeException("order not found"));
        ordersTmp.setOrderDate(order.getOrderDate());
        ordersTmp.setQuantity(order.getQuantity());
        //ordersTmp.setPhoneNumber(order.getPhoneNumber());
        return orderRepository.save(ordersTmp);
    }

    @Override
    @Transactional(readOnly = false,propagation = Propagation.REQUIRED)
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Order findByName(String name) {
        return orderRepository.findByOrderName(name)
                .orElseThrow(()->new RuntimeException("order not found"));
    }

}
