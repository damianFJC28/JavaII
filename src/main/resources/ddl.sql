-- Crear la tabla de clientes

CREATE TABLE customers (

    customer_id SERIAL PRIMARY KEY,

    customer_name VARCHAR(100) NOT NULL,

    email VARCHAR(100) NOT NULL,

    phone_number VARCHAR(15)

);



-- Crear la tabla de productos

CREATE TABLE products (

    product_id SERIAL PRIMARY KEY,

    product_name VARCHAR(100) NOT NULL,

    price DECIMAL(10, 2) NOT NULL

);



-- Crear la tabla de órdenes

CREATE TABLE orders (

    order_id SERIAL PRIMARY KEY,

    customer_id INT REFERENCES customers(customer_id),

    product_id INT REFERENCES products(product_id),

    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    quantity INT NOT NULL

);