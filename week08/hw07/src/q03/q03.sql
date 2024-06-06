CREATE TABLE branch (
    id SERIAL PRIMARY KEY,
    branch_name VARCHAR(50),
    branch_city VARCHAR(50),
    assets DECIMAL(10, 2)
);

CREATE TABLE customer (
    id SERIAL PRIMARY KEY,
    customer_name VARCHAR(50),
    customer_street VARCHAR(100),
    customer_city VARCHAR(50)
);

CREATE TABLE loan (
    id SERIAL PRIMARY KEY,
    loan_number INT,
    branch_id INT,
    amount DECIMAL(10, 2),
   	FOREIGN KEY (branch_id) REFERENCES branch(id)
);

CREATE TABLE borrower (
    id SERIAL PRIMARY KEY,
    customer_id INT,
    loan_id INT,
    FOREIGN KEY (customer_id) REFERENCES customer(id),
	FOREIGN KEY (loan_id) REFERENCES loan(id)
);

CREATE TABLE account (
    id SERIAL PRIMARY KEY,
    account_number INT,
    branch_id INT,
    balance DECIMAL(10, 2),
    FOREIGN KEY (branch_id) REFERENCES branch(id)
);

CREATE TABLE depositor (
    id SERIAL PRIMARY KEY,
    customer_id INT,
    account_id INT,
	FOREIGN KEY (account_id) REFERENCES account(id),
	FOREIGN KEY (customer_id) REFERENCES customer(id)
);