-- Example of removing duplicate rows using SQL.  Only tested using PostgreSQL

CREATE TABLE IF NOT EXISTS cars (
    id      int,
    model   varchar(50),
    brand   varchar(40),
    color   varchar(30),
    make    int
);

INSERT INTO cars VALUES
    (1, 'Model S', 'Tesla', 'Blue', 2018),
    (2, 'EQS', 'Mercedes-Benz', 'Black', 2022),
    (3, 'iX', 'BMW', 'Red', 2022),
    (4, 'Ioniq 5', 'Hyundai', 'White', 2021),
    (5, 'Model S', 'Tesla', 'Silver', 2018),
    (6, 'Ioniq 5', 'Hyundai', 'Green', 2021),
    (7, 'Ioniq 5', 'Hyundai', 'White', 2021),
    (8, 'EQS', 'Mercedes-Benz', 'Black', 2022);

-- This will show that there are 2 rows duplicated with the same Model, Brand, Color and Make, rows 7 & 8
SELECT * FROM cars;

-- This should remove any duplicates
DELETE FROM cars
WHERE id IN (
    SELECT id
    FROM (
        SELECT *, row_number() OVER(partition BY model, brand, color, make ORDER BY id) AS rn
        FROM cars
    ) x
    WHERE x.rn > 1
);

-- This should show those duplicates being gone.
SELECT * FROM cars;
