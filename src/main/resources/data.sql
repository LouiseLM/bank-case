INSERT INTO CUSTOMER (name) VALUES ('Louise Moeller');

INSERT INTO ACCOUNT (customer_id, iban, balance) VALUES (1, 'NL63 RABO 0050 0245 57', 1500);
INSERT INTO ACCOUNT (customer_id, iban, balance) VALUES (1, 'NL34 RABO 4717 7977 72', 50000);
INSERT INTO TRANSACTION (account_id, amount, date, category, c02Footprint) VALUES ('NL63 RABO 0050 0245 57', 5000, '2023-04-24T10:15:30', 3, 11500);
INSERT INTO TRANSACTION (account_id, amount, date, category, c02Footprint) VALUES ('NL63 RABO 0050 0245 57', 48, '2023-04-24T17:04:12', 1, 216);
INSERT INTO TRANSACTION (account_id, amount, date, category, c02Footprint) VALUES ('NL63 RABO 0050 0245 57', 780, '2023-04-27T17:04:12', 2, 936);

INSERT INTO CUSTOMER (name) VALUES ('Dikkie Dik');
INSERT INTO ACCOUNT (customer_id, iban, balance) VALUES (2, 'NL40 RABO 9798 8214 44', 5);