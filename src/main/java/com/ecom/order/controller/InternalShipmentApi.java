package com.ecom.order.controller;

import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.SpanName;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.order.feign.ECustomerFeignClient;
import com.ecom.order.feign.EProductFeignClient;
import com.ecom.order.feign.dto.CustomerDTO;
import com.ecom.order.model.Order;
import com.ecom.order.model.Shipment;
import com.ecom.order.repository.OrderRepository;
import com.ecom.order.repository.ShipmentRepository;

import brave.Tracer;

/**
 * @author quanhoang
 * Shipment API for internal call
 */
@RestController
public class InternalShipmentApi {
	
	Logger logger = LoggerFactory.getLogger(InternalShipmentApi.class);
	
	@Autowired
	Tracer tracer;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ShipmentRepository shipmentRepository;
	
	@Autowired
	ECustomerFeignClient eCustomerFeignClient;
	
	@Autowired
	EProductFeignClient eProductFeignClient;
	
	@RequestMapping(method = RequestMethod.POST, value = "/api/internalShipping/{orderId}/shipment")
	@SpanName("ConfirmInvoice")
	public ResponseEntity<?> invoiceToShipment(@PathVariable UUID orderId, @RequestParam("invoiceNo") String invoiceNo) {
		try {
			Optional<Order> order = orderRepository.findById(orderId);
			
			if (!order.isPresent()) {
				logger.error("Order {} does not exist", orderId);
				return ResponseEntity.notFound().build();
			}
			
			CustomerDTO customer = eCustomerFeignClient.findById(UUID.fromString(order.get().getUserId()));
			
			if (customer == null || customer.getCustomerId() == null) {
				logger.error("Customer {} does not exist");
				return ResponseEntity.notFound().build();
			}
			
			logger.info("Starting create shipment for invoice {}", invoiceNo);
			Shipment s = new Shipment();
			s.setAddress(customer.getAddress());
			s.setOrder(order.get());
			s.setPhoneNumber(customer.getPhone());
			s.setDeliveryDate(order.get().getDeliveryDate());
			s.setReceiverName(customer.getFullName());
			s.setStatus("Init");
			
			shipmentRepository.save(s);
			
			tracer.currentSpan().finish();
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			logger.error(e.getMessage());
			tracer.currentSpan().abandon();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
