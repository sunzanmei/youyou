package com.my.app.youyou.controller;

import com.my.app.youyou.model.Customer;
import com.my.app.youyou.service.CustomerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auther sunzanmei
 * @date 16/12/26
 */
@Controller
@RequestMapping("/customer")
public class CustomerDataController {
    @Autowired
    private CustomerService customerService;

    private Logger logger = Logger.getLogger(CustomerDataController.class);


    @RequestMapping("/getCustomer")
    @ResponseBody
    public Customer getUserInfo() {
        Customer customer = customerService.findOneCustomer();
        if(customer!=null){
            System.out.println(customer.toString());
            logger.info("user.info():"+customer.toString());
        }
        return customer;
    }

}
