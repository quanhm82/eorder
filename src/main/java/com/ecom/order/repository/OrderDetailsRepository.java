/**
 * 
 */
package com.ecom.order.repository;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecom.order.model.OrderDetail;

/**
 * @author quanhoang
 * Rest Repository for OrderDetails resource
 */
@RepositoryRestResource(path = "orderDetail", itemResourceRel = "orderDetail", collectionResourceRel = "orderDetails")
public interface OrderDetailsRepository extends PagingAndSortingRepository<OrderDetail, UUID> {

}
