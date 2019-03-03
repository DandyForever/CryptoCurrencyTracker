CREATE TABLE IF NOT EXISTS currencies(
  id BIGINT PRIMARY KEY,
  curr_val NUMERIC NOT NULL,
  last_change NUMERIC NOT NULL,
  name VARCHAR(100) NOT NULL
);

COMMENT ON TABLE currencies IS 'Table contains the currencies'' data';
COMMENT ON COLUMN currencies.id IS 'Currency ID';
COMMENT ON COLUMN currencies.curr_val IS 'Course in USD up to day';
COMMENT ON COLUMN currencies.last_change IS 'Last course change in USD';
COMMENT ON COLUMN currencies.name IS 'CurrencyName';

CREATE TABLE IF NOT EXISTS currencies_days(
  currency_id BIGINT REFERENCES currencies(id),
  curr_date TIMESTAMP,
  CONSTRAINT currency_day_pk PRIMARY KEY(currency_id, curr_date),
  aver_day NUMERIC
);

COMMENT ON TABLE currencies_days IS 'Linkage table between  ''users'' and datetime ';
COMMENT ON COLUMN currencies_days.curr_date IS 'CurrentDate';
COMMENT ON COLUMN currencies_days.currency_id IS 'Currency ID';
COMMENT ON COLUMN currencies_days.aver_day IS 'Average course in USD up to day';


CREATE TABLE IF NOT EXISTS users (
  id BIGINT PRIMARY KEY,
  email VARCHAR(100) UNIQUE NOT NULL,
  name VARCHAR(100) UNIQUE NOT NULL,
  password_hash VARCHAR(255),
  password_salt VARCHAR(32)
);

COMMENT ON TABLE users IS 'Table contains the users'' data';
COMMENT ON COLUMN users.id IS 'User ID';
COMMENT ON COLUMN users.email IS 'User email';
COMMENT ON COLUMN users.name IS 'Username';
COMMENT ON COLUMN users.password_hash IS 'User''s password hash';
COMMENT ON COLUMN users.password_salt IS 'A salt to calculate a password hash';

CREATE SEQUENCE IF NOT EXISTS user_id_sequence START WITH 1 MINVALUE 1 INCREMENT BY 1;
COMMENT ON SEQUENCE user_id_sequence IS 'Sequence for ID of table ''users''';


CREATE TABLE IF NOT EXISTS subscriptions (
  user_id BIGINT REFERENCES users(id),
  currency_id BIGINT REFERENCES currencies(id),
  user_val NUMERIC,
  CONSTRAINT user_currency_pk PRIMARY KEY (user_id, currency_id)
);

COMMENT ON TABLE subscriptions IS 'Linkage table between tables ''users'' and ''currencies'' ';
COMMENT ON COLUMN subscriptions.user_id IS 'User ID';
COMMENT ON COLUMN subscriptions.currency_id IS 'Currency ID';
COMMENT ON COLUMN subscriptions.user_val IS 'User value of money';
