BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, posts, comments, favorites, likes;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	user_picture varchar(300),
	email varchar(50) NOT NULL,
	
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE posts	(
	post_id SERIAL,
	user_id integer NOT NULL,
	post_picture varchar(300) NOT NULL,
	caption varchar(1000) NOT NULL,
	date_posted timestamp NOT NULL,

	CONSTRAINT PK_post PRIMARY KEY(post_id),
	CONSTRAINT FK_posts_users FOREIGN KEY(user_id) REFERENCES users(user_id)
);

CREATE TABLE comments	(
	comment_id SERIAL,
	post_id integer NOT NULL,
	user_id integer NOT NULL,
	comment_description varchar(1000) NOT NULL,
	date_posted timestamp NOT NULL,
	
	CONSTRAINT PK_comments PRIMARY KEY(comment_id),
	CONSTRAINT FK_comments_posts FOREIGN KEY(post_id) REFERENCES posts(post_id),
	CONSTRAINT FK_comments_users FOREIGN KEY(user_id) REFERENCES users(user_id)
);

CREATE TABLE favorites	(
	user_id integer,
	post_id integer,

	CONSTRAINT PK_favorites PRIMARY KEY(user_id, post_id),
	CONSTRAINT FK_favorites_users FOREIGN KEY(user_id) REFERENCES users(user_id),
	CONSTRAINT FK_favorites_posts FOREIGN KEY(post_id) REFERENCES posts(post_id)
);

CREATE TABLE likes	(
	user_id integer,
	post_id integer,
	
	CONSTRAINT PK_likes PRIMARY KEY(user_id, post_id),
	CONSTRAINT FK_likes_users FOREIGN KEY(user_id) REFERENCES users(user_id),
	CONSTRAINT FK_likes_posts FOREIGN KEY(post_id) REFERENCES posts(post_id)
);


COMMIT TRANSACTION;
