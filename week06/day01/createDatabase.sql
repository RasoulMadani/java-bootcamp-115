CREATE TABLE customer (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    address TEXT,
    gender CHAR(1),
    date_of_birth DATE
);

CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    customer_id INTEGER REFERENCES customer(id),
    date DATE,
    total NUMERIC(10, 2)
);

CREATE TABLE supplier (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    contact TEXT
);

CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    supplier_id INTEGER REFERENCES supplier(id),
    name VARCHAR(100)
);

CREATE TABLE order_product (
    order_id INTEGER REFERENCES orders(id),
    product_id INTEGER REFERENCES product(id),
    qty INTEGER,
    PRIMARY KEY (order_id, product_id)
);