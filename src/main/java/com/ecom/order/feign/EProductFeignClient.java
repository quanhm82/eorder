package com.ecom.order.feign;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecom.order.feign.dto.ProductDTO;

/**
 * @author quanhoang
 * Feign client for Product service
 */
@FeignClient("eproduct")
public interface EProductFeignClient {
	
	@RequestMapping(path = "/product/{productId}", method = RequestMethod.GET, produces = "application/json")
	ProductDTO findById(@PathVariable UUID productId);
}
