BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role,email,user_picture) VALUES ('user1','user1','ROLE_USER','email','');
INSERT INTO users (username,password_hash,role,email,user_picture) VALUES ('user2','user2','ROLE_USER','email','');
INSERT INTO users (username,password_hash,role,email,user_picture) VALUES ('user3','user3','ROLE_USER','email','');

INSERT INTO posts(user_id, post_picture, caption, likes, date_posted) VALUES(1, 'pic', 'caption', 4, '2016-06-22 19:10:25-07');

COMMIT TRANSACTION;
