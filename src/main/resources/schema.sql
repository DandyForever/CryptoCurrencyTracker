CREATE TABLE IF NOT EXISTS currencies(
  id BIGINT PRIMARY KEY,
  curr_val NUMERIC NOT NULL,
  name VARCHAR(100) NOT NULL
);




CREATE TABLE IF NOT EXISTS currencies_days(
  currency_id BIGINT REFERENCES currencies(id),
  curr_date TIMESTAMP,
  CONSTRAINT currency_day_pk PRIMARY KEY(currency_id, curr_date),
  aver_day NUMERIC
);

/*INSERT INTO "currencies" VALUES(1, 100, 'BTC/USD');
INSERT INTO "currencies_days" VALUES(1, CURRENT_TIMESTAMP, 100);*/





