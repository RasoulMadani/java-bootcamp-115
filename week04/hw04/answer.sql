1 - SELECT Artist.*, Artwork.*
    FROM Artist
    JOIN Artwork ON Artist.artist_id = Artwork.artist_id
    WHERE Artwork.price > (SELECT AVG(price) FROM Artwork);



2 - SELECT COUNT(DISTINCT c.customer_id) AS num_customers
    FROM Customer c
    JOIN Customer_Artist ca ON c.customer_id = ca.customer_id
    JOIN Artist a ON ca.artist_id = a.artist_id
    WHERE a.style = 'Renaissance'
    AND c.customer_id NOT IN (
        SELECT DISTINCT c2.customer_id
        FROM Customer c2
        JOIN Artwork aw ON c2.customer_id = aw.customer_id
        JOIN Artist a2 ON aw.artist_id = a2.artist_id
        WHERE a2.style = 'Renaissance'
    );



3 - SELECT a.artist_id, a.name, COUNT(ag.group_id) AS num_art_groups
    FROM Artist a
    LEFT JOIN Artwork aw ON a.artist_id = aw.artist_id
    LEFT JOIN Artwork_ArtworkGroup aag ON aw.artwork_id = aag.artwork_id
    LEFT JOIN ArtworkGroup ag ON aag.group_id = ag.group_id
    GROUP BY a.artist_id, a.name
    ORDER BY num_art_groups ASC
    LIMIT 1;



4 - SELECT *
    FROM Customer
    WHERE total_spent = 0;



5 - SELECT a.name, a.style, COUNT(aw.artwork_id) AS num_artworks
    FROM Artist a
    JOIN Artwork aw ON a.artist_id = aw.artist_id
    WHERE a.style = 'Renaissance'
    GROUP BY a.name, a.style;



6 - SELECT DISTINCT a.name
    FROM Artist a
    JOIN Artwork aw ON a.artist_id = aw.artist_id
    WHERE aw.year_made = 1200;



7 - SELECT aw.*
    FROM Artwork aw
    JOIN (
        SELECT artwork_id
        FROM Artwork_Artist
        GROUP BY artwork_id
        HAVING COUNT(artist_id) >= 2
    ) AS multi_artist ON aw.artwork_id = multi_artist.artwork_id;



8 - SELECT c.*
    FROM Customer c
    JOIN Customer_Artist ca ON c.customer_id = ca.customer_id
    JOIN Artist a ON ca.artist_id = a.artist_id
    WHERE c.address LIKE '%Anytown%'
    AND a.style = 'Renaissance';



9 - SELECT a.name, AVG(aw.price) AS avg_price
    FROM Artist a
    JOIN Artwork aw ON a.artist_id = aw.artist_id
    GROUP BY a.name;



10 - SELECT c.name, COUNT(aw.artwork_id) AS num_purchases
     FROM Customer c
     JOIN Artwork aw ON c.customer_id = aw.customer_id
     JOIN Artwork_ArtworkGroup aag ON aw.artwork_id = aag.artwork_id
     JOIN ArtworkGroup ag ON aag.group_id = ag.group_id
     WHERE ag.group_name = 'Renaissance'
     GROUP BY c.name
     ORDER BY num_purchases DESC
     LIMIT 1;

