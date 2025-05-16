CREATE TABLE admin_profile (
                               admin_profile_id INT PRIMARY KEY AUTO_INCREMENT,
                               user_id INT UNIQUE,
                               first_name VARCHAR(255),
                               last_name VARCHAR(255),
                               city VARCHAR(255),
                               state VARCHAR(255),
                               country VARCHAR(255),
                               company VARCHAR(255),
                               phone VARCHAR(20),
                               profile_photo VARCHAR(64),
                               FOREIGN KEY (user_id) REFERENCES sveacms.users(user_id)
);

CREATE TABLE user_profile (
                              user_profile_id INT PRIMARY KEY AUTO_INCREMENT,
                              user_id INT UNIQUE,
                              first_name VARCHAR(255),
                              last_name VARCHAR(255),
                              city VARCHAR(255),
                              state VARCHAR(255),
                              country VARCHAR(255),
                              phone VARCHAR(20),
                              profile_photo VARCHAR(64),
                              CONSTRAINT fk_user_profile_user FOREIGN KEY (user_id) REFERENCES sveacms.users(user_id)
);
