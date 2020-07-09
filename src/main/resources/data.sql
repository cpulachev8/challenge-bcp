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

DROP TABLE IF EXISTS user;
CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR (20),
    password VARCHAR (255)
);

INSERT INTO user (username, password) VALUES ('cpulachev8', '$2a$08$m62TUDQQk9duygBD0mBCTevZn8gO5ItlkW0Qm5nDM/DKr6d6wL84.');