 1 - SELECT c.customer_name from customer c
    left join depositor d on d.customer_id = c.id
    left join borrower b on c.id = b.customer_id
    WHERE b.customer_id IS NULL

 2 - SELECT customer_name FROM customer
     WHERE customer_street='ebrahimi' and customer_city = 'gom'

 3 - SELECT c.customer_name,count(l.branch_id),l.branch_id FROM customer c
     left join borrower b on c.id = b.customer_id
     LEFT join loan l on b.loan_id = l.id
     WHERE b.id NOTNULL
     group by l.branch_id,c.customer_name
     HAVING COUNT(l.branch_id) =1

 4 - SELECT c.customer_name FROM customer c
     join depositor d on c.id = d.customer_id
     join account a on a.id = d.account_id
     GROUP by c.customer_name
     HAVING COUNT(c.customer_name) > 1

 5 - SELECT * FROM customer c
     join borrower b on c.id = b.customer_id
     join loan l on b.loan_id = l.id
     join branch br on br.id = l.branch_id
     WHERE l.amount > 100000

 6 - SELECT * from branch b
     left join account a
     on b.id = a.branch_id
     LEFT join depositor d
     on d.account_id = a.id
     LEFT join customer c
     on c.id = d.customer_id
     LEFT join borrower bo
     on c.id = bo.customer_id

6 -  SELECT b.id,a.branch_id,d.account_id,a.id,c.id,d.customer_id,bo.customer_id bor,c.customer_name,b.branch_name from branch b
     left join account a
     on b.id = a.branch_id
     LEFT join depositor d
     on d.account_id = a.id
     LEFT join customer c
     on c.id = d.customer_id
     LEFT join borrower bo
     on c.id = bo.customer_id
6 -  SELECT *,id1 from

     	(
     		SELECT *,b.id as id1 from branch b
     		left join account a
     		on b.id = a.branch_id
     		LEFT join depositor d
     		on d.account_id = a.id
     		LEFT join customer c
     		on c.id = d.customer_id
     		LEFT join borrower bo
     		on c.id = bo.customer_id
     		LEFT join loan l
     		on bo.loan_id = l.id
     		WHERE l.id is NULL
     	) WHERE id1  not IN(3)
     	
7 - SELECT branch_name,

    CASE
        WHEN SUM(amount) IS NULL THEN 0
        ELSE SUM(amount)
    END from

    	(
    		SELECT b.branch_name,l.amount from branch b
    		left join account a
    		on b.id = a.branch_id
    		LEFT join depositor d
    		on d.account_id = a.id
    		LEFT join customer c
    		on c.id = d.customer_id
    		LEFT join borrower bo
    		on c.id = bo.customer_id
    		LEFT join loan l
    		on bo.loan_id = l.id
    	)
    GROUP by branch_name
