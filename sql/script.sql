INSERT INTO roles(name) VALUES ('ADMIN');
INSERT INTO roles(name) VALUES ('BUSINESS');
INSERT INTO roles(name) VALUES ('CUSTOMER');

-- qwer
INSERT INTO users (gender, username, full_name, encrypted_password, profile_uri)
VALUES ('Male', 'oudom', 'Phoem Oudom', '$2a$12$PaCg7VruSkBfwjuqZJ4p5.BBOdtNd2W.vvFEWpMPKUHZExfWFnV6a', 'oudom.png');

-- 123
INSERT INTO users (gender, username, full_name, encrypted_password, profile_uri)
VALUES ('Male', 'koko', 'Koko', '$2a$12$i19ltyYcO232HD2.nJDOMOeX0iKQg9M4Nu7YeY4PL4Siqt6gPCN5y', 'koko.png');

-- 321
INSERT INTO users (gender, username, full_name, encrypted_password, profile_uri)
VALUES ('Male', 'Chhaya', 'Chan Chhaya', '$2a$12$sa8t8oxhBo082hTmclS9LepKn/9ikwFoX.fnupsXiqYkBX7Xs4LAe', 'chhaya.png');

INSERT INTO users_roles (user_id, role_id)
VALUES (3, 2);