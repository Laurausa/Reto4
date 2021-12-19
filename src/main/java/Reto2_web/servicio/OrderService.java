/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_web.servicio;

import Reto2_web.modelo.Order;
import Reto2_web.repositorio.OrderRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author laura
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepositorio orderRepository;

    public List<Order> getAll(){
        return orderRepository.getAll();
    }

    public Optional<Order> getOrder(Integer id){
        return orderRepository.getOrder(id);
    }

    public Order create(Order order){
        if (order.getId() == null){
            return order;
        } else {
            return orderRepository.create(order);
        }
    }

    public Order update(Order order){
        if (order.getId() != null){
            Optional<Order> dbOrder = orderRepository.getOrder(order.getId());
            if (!dbOrder.isEmpty()) {

                if (order.getId() != null) {
                    dbOrder.get().setId(order.getId());
                }

                if (order.getRegisterDay() != null) {
                    dbOrder.get().setRegisterDay(order.getRegisterDay());
                }

                if (order.getStatus() != null) {
                    dbOrder.get().setStatus(order.getStatus());
                }

                if (order.getSalesMan() != null) {
                    dbOrder.get().setSalesMan(order.getSalesMan());
                }

                if (order.getProducts() != null) {
                    dbOrder.get().setProducts(order.getProducts());
                }

                if (order.getQuantities() != null) {
                    dbOrder.get().setQuantities(order.getQuantities());
                }
                orderRepository.update(dbOrder.get());
                return dbOrder.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }

    public boolean delete(Integer id){
        return getOrder(id).map(order -> {
            orderRepository.delete(order);
            return true;
        }).orElse(false);
    }
    
    public List<Order> getOrderByZone(String zone){
        return orderRepository.getOrderByZone(zone);
    }
    
    public List<Order> getBySalesManId(Integer id){
        return orderRepository.getBySalesManId(id);
    }
    
public List<Order> getBySalesManIdAndStatus(Integer id, String status){
        return orderRepository.getBySalesManIdAndStatus(id, status);
    }

public List<Order> getByRegisterDayAndSalesManId(String registerDay, Integer id){
        return orderRepository.getByRegisterDayAndSalesManId(registerDay,id);
    }
  
}
