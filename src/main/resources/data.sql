DROP TABLE IF EXISTS exchange_rate;

CREATE TABLE exchange_rate (
    id INT AUTO_INCREMENT PRIMARY KEY,
    origin_currency VARCHAR(3) NOT NULL,
    destination_currency VARCHAR(3) NOT NULL,
    rate numeric(10,2) NOT NULL
);

INSERT INTO exchange_rate (origin_currency, destination_currency, rate) VALUES
('PEN', 'USD', 3.55),
('USD', 'PEN', 3.75),
('PEN', 'EUR', 0.458),
('EUR', 'PEN', 0.422);