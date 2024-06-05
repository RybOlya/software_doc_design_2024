package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.dto.OrderDto;
import ua.lviv.iot.model.Order;
import ua.lviv.iot.service.OrderService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/order")
@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<Order> orders = orderService.findAll();
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order : orders) {
            OrderDto orderDto = new OrderDto(order.getId(), order.getUser().getId(), order.getTicket().getId(),
                    order.getQuantity(), order.getOrderDate());
            orderDtos.add(orderDto);
        }
        return new ResponseEntity<>(orderDtos, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable("id") Integer orderId) {
        Order order = orderService.getById(orderId);
        if (order != null) {
            OrderDto orderDto = new OrderDto(order.getId(), order.getUser().getId(), order.getTicket().getId(),
                    order.getQuantity(), order.getOrderDate());
            return new ResponseEntity<>(orderDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
