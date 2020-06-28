# Getting Started

### Introduction
eOrder service expose APIs (HATEOAS) for read/save resources such as Order, OrderDetail and Shipment. Swagger-ui is rendered at runtime to make it easier to call APIs.


### Guides
Building jar file by maven
```sh
$ mvn clean install
```
Starting eOrder instance with "dev" profile
```sh
$ cd target
...
$ java -jar eorder-{version}.jar -Dspring.profile.active=dev
```
Access eDiscovery by http://localhost:9999/swagger-ui.html

### Noted CURL
-Create Order
```sh
curl -X POST "http://localhost:9999/api/order" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"deliveryDate\": \"2020-07-14\", \"status\": \"Init\", \"userId\": \"customer_id\"}"
```
-Create OrderDetail for an order
```sh
curl -X POST "http://localhost:9999/api/orderDetail" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"order\": \"http://localhost:9999/api/order/orderId\", \"price\": 700, \"productId\": \"product_Id\", \"productName\": \"curl -X POST "http://localhost:9899/invoice" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"customerName\": \"George Bane\", \"orderId\": \"09915783-369d-4add-a7c2-325d7ee5de5e\", \"status\": \"init\", \"totalAmount\": 700}"", \"quantity\": 1}"
```