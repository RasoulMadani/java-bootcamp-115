
INSERT INTO Artist (name, birthplace, age, style) VALUES
('Vincent van Gogh', 'Zundert, Netherlands', 37, 'Post-Impressionism'),
('Leonardo da Vinci', 'Vinci, Italy', 67, 'Renaissance');


INSERT INTO Artwork (artist_id, year_made, title, type, price) VALUES
(1, 1889, 'The Starry Night', 'Painting', 1500000.00),
(2, 1503, 'Mona Lisa', 'Painting', 200000000.00);


INSERT INTO ArtworkGroup (group_name) VALUES
('Impressionism'),
('Renaissance');


INSERT INTO Artwork_ArtworkGroup (artwork_id, group_id) VALUES
(1, 1),
(2, 2);


INSERT INTO Customer (name, address, total_spent) VALUES
('John Doe', '123 Main St, Anytown', 5000.00),
('Jane Smith', '456 Oak St, Otherville', 10000.00);


INSERT INTO Customer_Artist (customer_id, artist_id) VALUES
(1, 1),
(2, 2);


INSERT INTO Customer_ArtworkGroup (customer_id, group_id) VALUES
(1, 1),
(2, 2);
