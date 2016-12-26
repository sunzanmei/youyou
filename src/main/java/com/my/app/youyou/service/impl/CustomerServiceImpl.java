package com.my.app.youyou.service.impl;

import com.my.app.youyou.dal.mapper.CustomerMapper;
import com.my.app.youyou.model.Customer;
import com.my.app.youyou.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther sunzanmei
 * @date 16/12/26
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Customer findOneCustomer(){
        return customerMapper.findOneCustomer();
    }
}
