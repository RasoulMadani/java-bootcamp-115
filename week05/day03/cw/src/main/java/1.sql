1 -  select name from orders
 join order_product on orders.id = order_product.order_id
 join product on product.id = order_product.product_id and orders.customer_id = 1



 2 - select customer.name,customer.id,COUNT(customer.id) from orders
      join order_product on orders.id = order_product.order_id
      join customer on orders.customer_id = customer.id
      GROUP by customer.name , customer.id



3  - select customer.name from orders
      join order_product on orders.id = order_product.order_id
      join customer on orders.customer_id = customer.id
      GROUP by customer.name , customer.id
      HAVING COUNT(customer.id) > 5


4 - select customer.name,customer.id ,SUM(order_product.qty) from orders
     join order_product on orders.id = order_product.order_id
     join customer on orders.customer_id = customer.id
     GROUP by customer.name , customer.id




5 - select product.name , order_product.qty from orders
     join order_product on orders.id = order_product.order_id
     join customer on orders.customer_id = customer.id and customer.id = 1
    join product on product.id = order_product.product_id


6 - select customer.name ,SUM(order_product.qty) from orders
     join order_product on orders.id = order_product.order_id
     join customer on orders.customer_id = customer.id
    join product on product.id = order_product.product_id
    GROUP by orders.customer_id,order_product.order_id,customer.name
    order by sum desc
     LIMIT 1


7 - select orders.customer_id,customer.name ,COUNT(orders.customer_id) from orders
    join customer on orders.customer_id = customer.id
    GROUP by orders.customer_id,customer.name order by COUNT(customer_id)
     ASC LIMIT 1



8 - select customer.name ,customer.id ,COUNT(customer.id) from orders
     join order_product on orders.id = order_product.order_id
     join customer on orders.customer_id = customer.id
    join product on product.id = order_product.product_id
    GROUP by customer.id
    HAVING COUNT(customer.id)>=3



9 - select orders.date ,COUNT(orders.date) from orders

    GROUP by orders.date



10 - select customer.name customer_name,product.name product_name,order_product.qty from orders
      join order_product on orders.id = order_product.order_id
      join customer on orders.customer_id = customer.id
     join product on product.id = order_product.product_id
     GROUP by customer.name,product.name ,order_product.qty