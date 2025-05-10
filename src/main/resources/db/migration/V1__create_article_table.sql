CREATE TABLE article (
                         userId int AUTO_INCREMENT PRIMARY KEY,
                         title VARCHAR(255) NOT NULL,
                         slug VARCHAR(255) UNIQUE NOT NULL,
                         description TEXT,
                         content LONGTEXT,
                         image_url VARCHAR(2048),
                         published_at DATETIME
);

CREATE TABLE article_tags (
                              article_id int NOT NULL,
                              tags VARCHAR(255),
                              FOREIGN KEY (article_id) REFERENCES article(id)
);
