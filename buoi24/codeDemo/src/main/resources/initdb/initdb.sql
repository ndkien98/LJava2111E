create database demosecurity;
use demosecurity;
INSERT INTO demosecurity.user (id, encrypted_password, username) VALUES (1, '$2a$10$8gQhCggpkGageZ/l4HQSNel.fp6iJh.1P9OJTkGWJWbT5FKC3rWoW', 'admin');
INSERT INTO demosecurity.user (id, encrypted_password, username) VALUES (2, '$2a$10$Gy5/r0Eql.ddLNJiubJ2suA4FW91amspHd4c66J1pUg8aaQnzau1a', 'user');
INSERT INTO demosecurity.role (id, role_name) VALUES (1, 'ADMIN');
INSERT INTO demosecurity.role (id, role_name) VALUES (2, 'USER');
INSERT INTO demosecurity.user_role (id, role_id, user_id) VALUES (1, 1, 1);
INSERT INTO demosecurity.user_role (id, role_id, user_id) VALUES (2, 2, 1);
INSERT INTO demosecurity.user_role (id, role_id, user_id) VALUES (3, 2, 2);