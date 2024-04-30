
-- Inserting ten customers
INSERT INTO customer (name, address, gender, date_of_birth)
VALUES
    ('Sara Mohammadi', '111 Dana St, Tehran, Iran', 'F', '1992-07-12'),
    ('Ali Ahmadi', '222 Moalem Ave, Isfahan, Iran', 'M', '1985-11-03'),
    ('Neda Ghasemi', '333 Arak St, Shiraz, Iran', 'F', '1998-04-20'),
    ('Amir Hosseini', '444 Elm St, Tabriz, Iran', 'M', '1979-09-15'),
    ('Parisa Rezaei', '555 Bahonar Rd, Mashhad, Iran', 'F', '1993-12-30'),
    ('Mehran Kazemi', '666 Ebrahimi Blvd, Yazd, Iran', 'M', '1982-01-18'),
    ('Fatemeh Sadeghi', '777 Ashrafi Dr, Kerman, Iran', 'F', '1987-06-25'),
    ('Hossein Farahani', '888 Somaye Ln, Ahvaz, Iran', 'M', '1990-03-08'),
    ('Yasmin Safari', '999 Ash Ct, Bandar Abbas, Iran', 'F', '1980-08-05'),
    ('Mohammad Esfahani', '1010 Shiri Pl, Kish, Iran', 'M', '1995-05-22');

-- Inserting ten suppliers
INSERT INTO supplier (name, contact)
VALUES
    ('Zahra Electronic Industries', 'Zahra Zand'),
    ('Mohammad Appliance Manufacturing', 'Mohammad Mohebi'),
    ('Leila Industrial Group', 'Leila Lotfi'),
    ('Behzad Electronics Corporation', 'Behzad Bakhtiari'),
    ('Roya Home Appliances', 'Roya Rahimi'),
    ('Reza Technology Co.', 'Reza Rafiei'),
    ('Narges Electronics', 'Narges Norouzi'),
    ('Hamid Distribution', 'Hamid Hemmati'),
    ('Negar Wholesale', 'Negar Namazi'),
    ('Saman Corporation', 'Saman Soltani');

-- Inserting ten products
INSERT INTO product (supplier_id, name)
VALUES
    (1, 'Smartphone 1'),
    (2, 'Big Refrigerator'),
    (3, 'Powerful Laptop'),
    (4, 'Smart TV'),
    (5, 'New Vacuum Cleaner'),
    (6, 'Quality Tablet'),
    (7, 'Digital Microwave'),
    (8, 'Electric Blender'),
    (9, 'Professional Camera'),
    (10, 'Excellent Speaker');

-- Inserting ten purchase orders
INSERT INTO orders (customer_id, date, total)
VALUES
    (1, '2024-04-29', 500.00),
    (2, '2024-04-28', 750.00),
    (3, '2024-04-27', 600.00),
    (4, '2024-04-26', 400.00),
    (5, '2024-04-25', 550.00),
    (6, '2024-04-24', 350.00),
    (7, '2024-04-23', 450.00),
    (8, '2024-04-22', 300.00),
    (9, '2024-04-21', 200.00),
    (10, '2024-04-20', 150.00);

-- Inserting ten products into orders
INSERT INTO order_product (order_id, product_id, qty)
VALUES
    (1, 1, 2),
    (1, 2, 1),
    (2, 2, 3),
    (3, 3, 2),
    (3, 1, 1),
    (4, 4, 1),
    (5, 5, 2),
    (5, 6, 1),
    (6, 7, 3),
    (7, 8, 2),
    (1, 7, 6);