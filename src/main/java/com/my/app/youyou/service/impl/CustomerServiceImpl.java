package com.my.app.youyou.service.impl;

import javax.annotation.Resource;

import com.my.app.youyou.persistence.mapper.CustomerMapper;
import com.my.app.youyou.persistence.entity.Customer;
import com.my.app.youyou.service.CustomerService;
import org.springframework.stereotype.Service;

/**
 * @auther sunzanmei
 * @date 16/12/26
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    @Resource(name = "customerMapper")
    private CustomerMapper customerMapper;

    @Override
    public Customer findOneCustomer(){
        return customerMapper.findOneCustomer();
    }
}
