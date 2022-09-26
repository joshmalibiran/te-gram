BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role,email,user_picture) VALUES ('user1','user1','ROLE_USER','email','');
INSERT INTO users (username,password_hash,role,email,user_picture) VALUES ('user2','user2','ROLE_USER','email','');
INSERT INTO users (username,password_hash,role,email,user_picture) VALUES ('user3','user3','ROLE_USER','email','');

COMMIT TRANSACTION;
