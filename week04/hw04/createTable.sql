CREATE TABLE Artist (
    artist_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birthplace VARCHAR(255),
    age INT,
    style VARCHAR(255)
);

CREATE TABLE Artwork (
    artwork_id SERIAL PRIMARY KEY,
    artist_id INT,
    year_made INT,
    title VARCHAR(255) NOT NULL,
    type VARCHAR(255),
    price NUMERIC(10, 2),
    FOREIGN KEY (artist_id) REFERENCES Artist(artist_id)
);

CREATE TABLE ArtworkGroup (
    group_id SERIAL PRIMARY KEY,
    group_name VARCHAR(255) NOT NULL
);

CREATE TABLE Artwork_ArtworkGroup (
    artwork_id INT,
    group_id INT,
    PRIMARY KEY (artwork_id, group_id),
    FOREIGN KEY (artwork_id) REFERENCES Artwork(artwork_id),
    FOREIGN KEY (group_id) REFERENCES ArtworkGroup(group_id)
);

CREATE TABLE Customer (
    customer_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    total_spent NUMERIC(10, 2)
);

CREATE TABLE Customer_Artist (
    customer_id INT,
    artist_id INT,
    PRIMARY KEY (customer_id, artist_id),
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id),
    FOREIGN KEY (artist_id) REFERENCES Artist(artist_id)
);

CREATE TABLE Customer_ArtworkGroup (
    customer_id INT,
    group_id INT,
    PRIMARY KEY (customer_id, group_id),
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id),
    FOREIGN KEY (group_id) REFERENCES ArtworkGroup(group_id)
);
