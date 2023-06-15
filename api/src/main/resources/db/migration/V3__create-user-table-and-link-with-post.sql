CREATE TABLE USER (
    id BIGINT NOT NULL AUTO_INCREMENT,
    uuid VARCHAR(255) NOT NULL,
    user_name VARCHAR(100) NOT NULL,
    user_email VARCHAR(100) NOT NULL,
    user_password VARCHAR(100) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT UC_Email UNIQUE (id, user_email)
);

ALTER TABLE POST
MODIFY user BIGINT NOT NULL;

ALTER TABLE POST
ADD CONSTRAINT FK_user
FOREIGN KEY (user) REFERENCES USER(id);

ALTER TABLE POST
ADD COLUMN uuid VARCHAR(255) NOT NULL AFTER id;