BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role,email,user_picture) VALUES ('user1','user1','ROLE_USER','email','');
INSERT INTO users (username,password_hash,role,email,user_picture) VALUES ('user2','user2','ROLE_USER','email','');
INSERT INTO users (username,password_hash,role,email,user_picture) VALUES ('user3','user3','ROLE_USER','email','');

INSERT INTO posts(user_id, post_picture, caption, likes, date_posted) VALUES(1, 'pic', 'caption', 44, '2016-06-22 19:10:25-07');
INSERT INTO posts(user_id, post_picture, caption, likes, date_posted) VALUES(2, 'pic', 'caption', 32, '2016-06-22 19:10:25-07');
INSERT INTO posts(user_id, post_picture, caption, likes, date_posted) VALUES(3, 'pic', 'caption', 45, '2016-06-22 19:10:25-07');
INSERT INTO posts(user_id, post_picture, caption, likes, date_posted) VALUES(1, 'pic', 'caption', 34, '2016-06-22 19:10:25-07');

INSERT INTO comments(post_id, user_id, comment_description, date_posted) VALUES(1, 3, 'description', '2016-06-22 19:10:25-07');
INSERT INTO comments(post_id, user_id, comment_description, date_posted) VALUES(1, 2, 'description', '2016-06-22 19:10:25-07');
INSERT INTO comments(post_id, user_id, comment_description, date_posted) VALUES(3, 3, 'description', '2016-06-22 19:10:25-07');
COMMIT TRANSACTION;
