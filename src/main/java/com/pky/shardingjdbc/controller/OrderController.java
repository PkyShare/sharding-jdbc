package com.pky.shardingjdbc.controller;

import com.pky.shardingjdbc.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "orders")
public class OrderController {

    @Autowired
    OrderMapper orderMapper;

    @GetMapping(value = "")
    public String test() {
        orderMapper.insert(new BigDecimal(11), 1l, "success");
        return "yes";
    }
}
