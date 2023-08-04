DROP TABLE IF EXISTS dogs;

CREATE TABLE dogs (
    dog_id INT NOT NULL,
    name VARCHAR(250) NOT NULL,
    age INT NOT NULL
);

CREATE TABLE BONDS AS SELECT * FROM CSVREAD('db-bonds-data.csv');

ALTER TABLE BONDS
ADD bond_id int AUTO_INCREMENT PRIMARY KEY;

CREATE TABLE BOOK_1
AS SELECT *
FROM BONDS
WHERE BOOK_NAME = 'trading_book_1';

CREATE TABLE BOOK_2
AS SELECT *
FROM BONDS
WHERE BOOK_NAME = 'trading_book_2';

CREATE TABLE BOOK_3
AS SELECT *
FROM BONDS
WHERE BOOK_NAME = 'Trading_book_3';

CREATE TABLE BOOK_4
AS SELECT *
FROM BONDS
WHERE BOOK_NAME = 'Trading_book_4';

CREATE TABLE BOOK_6
AS SELECT *
FROM BONDS
WHERE BOOK_NAME = 'Trading_book_6';

CREATE TABLE BOND_SECURITY
AS SELECT BOND_ID, ISIN, CUSIP
FROM BONDS;

CREATE TABLE BOND_ISSUER
AS SELECT BOND_ID, ISSUER_NAME
FROM BONDS;

CREATE TABLE BOND_CLIENT
AS SELECT BOND_ID, BOND_HOLDER
FROM BONDS;