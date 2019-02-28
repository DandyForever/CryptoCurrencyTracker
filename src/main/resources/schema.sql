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

CREATE SEQUENCE IF NOT EXIST user_id_sequence START WITH 1 MINVALUE 1 INCREMENT BY 1;
COMMENT ON SEQUENCE user_id_sequence IS 'Sequence for ID of table ''users''';


CREATE TABLE IF NOT EXISTS user_subscriptions (
  user_id BIGINT REFERENCES users(id),
  currency_id BIGINT REFERENCES currencies(id),
  user_val NUMERIC,
  CONSTRAINT user_currency_pk PRIMARY KEY (user_id, currency_id)
);

COMMENT ON TABLE user_subscriptions IS 'Linkage table between tables ''users'' and ''currencies'' ';
COMMENT ON COLUMN user_subscriptions.user_id IS 'User ID';
COMMENT ON COLUMN user_subscriptions.currency_id IS 'Currency ID';
COMMENT ON COLUMN user_subscriptions.user_val IS 'User value of money';