CREATE TABLE POST (
    id BIGINT NOT NULL AUTO_INCREMENT,
    user VARCHAR(100) NOT NULL,
    post_date DATE NOT NULL,
    post_description VARCHAR(1000),
    post_image VARCHAR(1000) NOT NULL,
    PRIMARY KEY (id)
);