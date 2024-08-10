create type discount_type as enum ('PERCENTAGE', 'PRICE');
create type product_type as enum ('SHOE','ELECTRONIC');
create type cart_status as enum ('PAID','UNPAID');

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);


CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    product_type product_type NOT NULL,
    price DOUBLE PRECISION NOT NULL
);

CREATE TABLE carts (
    id SERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    total_price DOUBLE PRECISION NOT NULL,
    total_count DOUBLE PRECISION NOT NULL,
    cart_status cart_status NOT NULL,
    date BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)

);

CREATE TABLE discounts (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    code VARCHAR(100) NOT NULL,
    amount INT NOT NULL,
    discount_type discount_type NOT NULL
);

CREATE TABLE cart_items (
    id SERIAL PRIMARY KEY,
    cart_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    discount_id BIGINT NOT NULL,
    count INT NOT NULL,
    FOREIGN KEY (cart_id) REFERENCES carts(id),
    FOREIGN KEY (product_id) REFERENCES products(id),
    FOREIGN KEY (discount_id) REFERENCES discounts(id)
);
