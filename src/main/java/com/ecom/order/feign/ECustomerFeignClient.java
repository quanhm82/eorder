package com.ecom.order.feign;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecom.order.feign.dto.CustomerDTO;

/**
 * @author quanhoang
 * Feign client for Customer service
 */
@FeignClient("ecustomer")
public interface ECustomerFeignClient {
	
	@RequestMapping(path = "/api/customer/{customerId}", method = RequestMethod.GET, produces = "application/json")
	CustomerDTO findById(@PathVariable UUID customerId);
}
