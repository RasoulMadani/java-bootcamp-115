CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);


CREATE TABLE banks (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);


CREATE TABLE cards (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    card_number VARCHAR(20) NOT NULL UNIQUE,
    bank_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    FOREIGN KEY (bank_id) REFERENCES banks(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE transactions (
    id SERIAL PRIMARY KEY,
    destination_account_id BIGINT NOT NULL,
    origin_account_id BIGINT NOT NULL,
    amount DOUBLE PRECISION NOT NULL,
    fee DOUBLE PRECISION NOT NULL,
    status VARCHAR(10) NOT NULL,
    type VARCHAR(30) NOT NULL,
    message VARCHAR(100),
    date TIMESTAMP NOT NULL,
    FOREIGN KEY (destination_account_id) REFERENCES accounts(id),
    FOREIGN KEY (origin_account_id) REFERENCES accounts(id)
);



CREATE TABLE accounts (
    id SERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    bank_id BIGINT NOT NULL,
    card_id BIGINT NOT NULL,
    balance DOUBLE PRECISION NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (bank_id) REFERENCES banks(id),
    FOREIGN KEY (card_id) REFERENCES cards(id)
);

-- Step 1: Add the new column to the accounts table
ALTER TABLE cards ADD COLUMN account_id BIGINT;
-- Step 2: Add the foreign key constraint to the new column
ALTER TABLE cards ADD CONSTRAINT fk_account
    FOREIGN KEY (account_id) REFERENCES accounts(id);
ALTER TABLE accounts DROP COLUMN card_id;
ALTER TABLE accounts ADD COLUMN account_number VARCHAR(13);
ALTER TABLE accounts ADD COLUMN shaba_number VARCHAR(24);
// search card by bank name
select
	cards.id as id,
	cards.name as name,
	cards.card_number as card_number,
	cards.bank_id as bank_id,
	cards.user_id as user_id
from cards
join banks on cards.bank_id = banks.id
WHERE banks.name = 'allah'


// search card by name
select * from cards where user_id = 1 and name='allah'


// get All cards
select * from cards where user_id = 1

// find card by user id
SELECT
	accounts.id as id,
	accounts.user_id as user_id,
	accounts.bank_id as bank_id,
	accounts.balance as balance,
	accounts.shaba_number as shaba_number,
	accounts.account_number as account_number
from accounts
join users
on accounts.user_id = users.id
WHERE users.id = 1;

// find account by card number
SELECT
	accounts.id as id,
	accounts.user_id as user_id,
	accounts.bank_id as bank_id,
	accounts.balance as balance,
	accounts.shaba_number as shaba_number,
	accounts.account_number as account_number
from accounts
join cards
on accounts.id = cards.account_id
WHERE cards.card_number = '6219876459327843'