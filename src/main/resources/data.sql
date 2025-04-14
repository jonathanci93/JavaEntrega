-- Insertar clientes
INSERT INTO CLIENTS (NAME, LASTNAME, DOCNUMBER) VALUES
('María', 'Pérez', '12345678901'),
('Juan', 'Gómez', '23456789012'),
('Lucía', 'Fernández', '34567890123');

-- Insertar productos
INSERT INTO PRODUCTS (DESCRIPTION, CODE, STOCK, PRICE) VALUES
('Producto 1', 'PA001', 10, 100.0),
('Producto 2', 'PB002', 5, 200.0),
('Producto 3', 'PC003', 20, 50.0),
('Producto 4', 'PD004', 8, 150.0);2
-- Insertar facturas
INSERT INTO INVOICE (CLIENT_ID, CREATED_AT, TOTAL) VALUES
(1, '2025-04-11 10:00:00', 300.0),
(2, '2025-04-11 11:00:00', 350.0);

-- Insertar detalles de factura
INSERT INTO INVOICE_DETAILS (INVOICE_ID, PRODUCT_ID, AMOUNT, PRICE) VALUES
(1, 1, 2, 100.0),
(1, 3, 2, 50.0),
(2, 2, 1, 200.0),
(2, 4, 1, 150.0);

