CREATE TABLE IF NOT EXISTS aq (
  aq_id      SERIAL8 PRIMARY KEY,
  location   VARCHAR(256)                NOT NULL,
  city       VARCHAR(128)                NOT NULL,
  country    VARCHAR(64)                 NOT NULL,
  utc_time   TIMESTAMP WITH TIME ZONE    NOT NULL,
  local_time TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  parameter  VARCHAR(16)                 NOT NULL,
  value      NUMERIC(32, 8)              NOT NULL,
  unit       VARCHAR(32)                 NOT NULL,
  geo        POINT                       NOT NULL
);


CREATE INDEX aq_city_index ON AQ USING HASH(city);

CREATE TABLE IF NOT EXISTS vendor (
  vendor_id INT PRIMARY KEY,
  vendor_name VARCHAR(128) NOT NULL
);

INSERT INTO vendor (vendor_id, vendor_name) VALUES (1, 'Creative Mobile Technologies');
INSERT INTO vendor (vendor_id, vendor_name) VALUES (2, 'VeriFone Inc');

CREATE TABLE IF NOT EXISTS rate_code (
  rate_code_id          INT PRIMARY KEY,
  rate_code_description VARCHAR(64)
);

INSERT INTO rate_code (rate_code_id, rate_code_description) VALUES (1, 'Standard rate');
INSERT INTO rate_code (rate_code_id, rate_code_description) VALUES (2, 'JFK');
INSERT INTO rate_code (rate_code_id, rate_code_description) VALUES (3, 'Newark');
INSERT INTO rate_code (rate_code_id, rate_code_description) VALUES (4, 'Nassau or Westchester');
INSERT INTO rate_code (rate_code_id, rate_code_description) VALUES (5, 'Negotitiated fare');
INSERT INTO rate_code (rate_code_id, rate_code_description) VALUES (6, 'Group rate');


CREATE TABLE IF NOT EXISTS payment_type (
  payment_type_id          INT PRIMARY KEY,
  payment_type_description VARCHAR(32)
);

INSERT INTO payment_type (payment_type_id, payment_type_description) VALUES (1, 'Credit card');
INSERT INTO payment_type (payment_type_id, payment_type_description) VALUES (2, 'Cash');
INSERT INTO payment_type (payment_type_id, payment_type_description) VALUES (3, 'No charge');
INSERT INTO payment_type (payment_type_id, payment_type_description) VALUES (4, 'Dispute');
INSERT INTO payment_type (payment_type_id, payment_type_description) VALUES (5, 'Unknown');
INSERT INTO payment_type (payment_type_id, payment_type_description) VALUES (6, 'Voided trip');

CREATE TABLE IF NOT EXISTS yellow_cab_record (
  yellow_cab_record_id  SERIAL8 PRIMARY KEY,
  vendor_id             INT,
  -- date and time meter engaged
  tpep_pickup_datetime  TIMESTAMP WITH TIME ZONE NOT NULL,
  -- date and time meter disengaged
  tpep_dropoff_datetime TIMESTAMP WITH TIME ZONE NOT NULL,
  passenger_count       INT,
  trip_distance         NUMERIC(32, 2)           NOT NULL,
  pu_location_id        INT,
  do_location_id        INT,
  rate_code_id          INT,
  store_and_fwd_flag    CHAR(1),
  payment_type          INT,
  fare_amount           NUMERIC(32, 2),
  extra                 NUMERIC(32, 2),
  mta_tax               NUMERIC(32, 2),
  improved_surcharge    NUMERIC(32, 2),
  tip_amount            NUMERIC(32, 2),
  tolls_amount          NUMERIC(32, 2),
  total_amount          NUMERIC(32, 2)
) PARTITION BY RANGE (tpep_pickup_datetime);


CREATE TABLE IF NOT EXISTS yellow_cab_record_q1 PARTITION OF yellow_cab_record FOR VALUES FROM ('2018-01-01 00:00:00') TO ('2018-04-01 00:00:00');
CREATE TABLE IF NOT EXISTS yellow_cab_record_q2 PARTITION OF yellow_cab_record FOR VALUES FROM ('2018-04-01 00:00:01') TO ('2018-07-01 00:00:00');
CREATE TABLE IF NOT EXISTS yellow_cab_record_q3 PARTITION OF yellow_cab_record FOR VALUES FROM ('2018-07-01 00:00:01') TO ('2018-10-01 00:00:00');
CREATE TABLE IF NOT EXISTS yellow_cab_record_q4 PARTITION OF yellow_cab_record FOR VALUES FROM ('2018-10-01 00:00:01') TO ('2018-12-31 23:59:59');


CREATE TABLE IF NOT EXISTS zone_lookup (
  zone_lookup_id SERIAL PRIMARY KEY,
  borough        VARCHAR(64),
  zone           VARCHAR(64),
  service_zone   VARCHAR(64)
);