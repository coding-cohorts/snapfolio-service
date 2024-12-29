CREATE TABLE portfolio (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           title VARCHAR(255),
                           theme VARCHAR(255),
                           about CLOB,
                           work_experience CLOB,
                           projects CLOB,
                           education CLOB,
                           skills CLOB,
                           user_id BIGINT NOT NULL,
                           FOREIGN KEY (user_id) REFERENCES app_user(id)
);
