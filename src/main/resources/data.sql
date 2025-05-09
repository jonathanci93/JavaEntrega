
INSERT INTO CLIENTS (NAME, LASTNAME, DOCNUMBER) VALUES
('María', 'Pérez', '12345678901'),
('Juan', 'Gómez', '23456789012'),
('Lucía', 'Fernández', '34567890123'),
('Carlos', 'Rodríguez', '45678901234'),
('Ana', 'Martínez', '56789012345');

INSERT INTO PRODUCTS (DESCRIPTION, CODE, STOCK, PRICE) VALUES
('Mixer Phillips', 'HP721', 7, 19900),
('Space Rocket', 'JR021', 1, 21000),
('Me gusta jugar de Anthony Browne', 'NJG321', 8, 10000),
('Listas las listas', 'LLL031', 6, 10000),
('Desafío Vocablos', 'DV032', 3, 10000),
('Palabrerio', 'PAL033', 5, 10000),
('Florifauna', 'FLO034', 9, 13000);

INSERT INTO INVOICE (CLIENT_ID, CREATED_AT, TOTAL) VALUES
(1, '2025-04-11 10:00:00', 47000),
(2, '2025-04-11 10:30:00', 29999.98),
(3, '2025-04-11 11:00:00', 51500),
(4, '2025-04-11 11:30:00', 60000),
(5, '2025-04-11 12:00:00', 30000);

-- Factura 1 María Pérez
INSERT INTO INVOICE_DETAILS (INVOICE_ID, PRODUCT_ID, AMOUNT, PRICE) VALUES
(1, 1, 1, 17000),
(1, 2, 1, 30000);

-- Factura 2 Juan Gómez
INSERT INTO INVOICE_DETAILS (INVOICE_ID, PRODUCT_ID, AMOUNT, PRICE) VALUES
(2, 3, 1, 29999.98);

-- Factura 3 Lucía Fernández
INSERT INTO INVOICE_DETAILS (INVOICE_ID, PRODUCT_ID, AMOUNT, PRICE) VALUES
(3, 4, 1, 25500),
(3, 5, 1, 26000);

-- Factura 4 Carlos Rodríguez
INSERT INTO INVOICE_DETAILS (INVOICE_ID, PRODUCT_ID, AMOUNT, PRICE) VALUES
(4, 6, 1, 44000);

-- Factura 5 Ana Martínez
INSERT INTO INVOICE_DETAILS (INVOICE_ID, PRODUCT_ID, AMOUNT, PRICE) VALUES
(5, 1, 1, 30000);