BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, posts, comments, favorites, likes;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	user_picture varchar(600),
	email varchar(50) NOT NULL,
	
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE posts	(
	post_id SERIAL,
	user_id integer NOT NULL,
	post_picture varchar(600) NOT NULL,
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

INSERT INTO users(username, password_hash, role, user_picture, email) VALUES('josh', '$2a$10$EXPaoQBQcKQRXP27qC0zee.sXEwVt0uM67tDUayR79OUpqClm00ZC', 'ROLE_USER', 'https://artwork.espncdn.com/categories/cd70a58e-a830-330c-93ed-52360b51b632/1x1Feature/1440_201903062023.jpg', 'josh@gmail.com' );
INSERT INTO users(username, password_hash, role, user_picture, email) VALUES('robertdowneyjr', 'hash','ROLE_USER', 'https://static.catapult.co/cdn-cgi/image/width=1170,height=658,dpr=2,fit=cover,format=auto/production/stories/31705/cover_photos/original/iron_man_site_1633028435_1637683340.jpg', 'email');
INSERT INTO users(username, password_hash, role, user_picture, email) VALUES('catluver22', 'hash', 'ROLE_USER', 'https://www.travelandleisure.com/thmb/lZeCZo1hq_41edFv-hEop-VtQ-w=/1600x1200/smart/filters:no_upscale()/red-pink-orange-purple-sunset-WHYCOLORS1220-7684b47c858b4e1e9d73018e213c7ff3.jpg', 'email');
INSERT INTO users(username, password_hash, role, user_picture, email) VALUES('theohiostateuniversity','hash','ROLE_USER','https://1000logos.net/wp-content/uploads/2018/01/ohio-state-university-logo.jpg','email');
INSERT INTO users(username, password_hash, role, user_picture, email) VALUES('lizluvsdogs','hash','ROLE_USER','https://www.science.org/do/10.1126/science.aaw5856/abs/dog_16x9_3.jpg','email');
INSERT INTO users(username, password_hash, role, user_picture, email) VALUES('rocknroll13','hash','ROLE_USER','https://www.superprof.com/blog/wp-content/uploads/2018/06/drums.jpg','email');

INSERT INTO posts(user_id, post_picture, caption, date_posted) VALUES(2,'https://m.media-amazon.com/images/M/MV5BMTQ5MjUyMzk5NV5BMl5BanBnXkFtZTcwMzUyNTIzMw@@._V1_.jpg','at work','2022-01-01');
INSERT INTO posts(user_id, post_picture, caption, date_posted) VALUES(3,'https://www.humanesociety.org/sites/default/files/styles/1240x698/public/2020-07/kitten-510651.jpg?h=f54c7448&itok=ZhplzyJ9', 'cute little guy', '2022-01-01');
INSERT INTO posts(user_id, post_picture, caption, date_posted) VALUES(4,'https://scarletandgame.com/wp-content/uploads/getty-images/2018/08/1173876752.jpeg', 'What a view!', '2022-01-01');
INSERT INTO posts(user_id, post_picture, caption, date_posted) VALUES(5,'https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/dog-puppy-on-garden-royalty-free-image-1586966191.jpg?crop=1.00xw:0.669xh;0,0.190xh&resize=640:*', 'My pupper', '2022-01-01' );
INSERT INTO posts(user_id, post_picture, caption, date_posted) VALUES(5,'https://www.princeton.edu/sites/default/files/styles/half_2x/public/images/2022/02/KOA_Nassau_2697x1517.jpg?itok=iQEwihUn', 'Growing up so fast!', '2022-01-01' );
INSERT INTO posts(user_id, post_picture, caption, date_posted) VALUES(6,'https://cdn.vox-cdn.com/thumbor/Al48-pEnyIn2rlgKX7MIHNmlE68=/0x0:5563x3709/1200x800/filters:focal(2302x1311:3192x2201)/cdn.vox-cdn.com/uploads/chorus_image/image/65752607/1048232144.jpg.0.jpg', '#sunset', '2022-01-01');
INSERT INTO posts(user_id, post_picture, caption, date_posted) VALUES(1,'https://newyorksimply.com/wp-content/uploads/2021/11/Central-Park-fALL-3494.jpg', 'Went to the park today', '2022-01-01');
INSERT INTO posts(user_id, post_picture, caption, date_posted) VALUES(6,'https://upload.wikimedia.org/wikipedia/commons/e/e7/Everest_North_Face_toward_Base_Camp_Tibet_Luca_Galuzzi_2006.jpg', 'Long way up', '2022-01-01');
INSERT INTO posts(user_id, post_picture, caption, date_posted) VALUES(3,'https://media-be.chewy.com/wp-content/uploads/2020/10/06104830/foster-kittens-1024x548.jpg', 'my kitten!', '2022-01-01');
INSERT INTO posts(user_id, post_picture, caption, date_posted) VALUES(1,'https://cdn.britannica.com/93/94493-050-35524FED/Toronto.jpg', 'the 6', '2022-01-01');
INSERT INTO posts(user_id, post_picture, caption, date_posted) VALUES(1,'https://midwestexplored.com/wp-content/uploads/2021/03/things-to-do-in-Hocking-Hills-waterfall.jpg', 'hiking at hocking hills', '2022-01-01');
INSERT INTO posts(user_id, post_picture, caption, date_posted) VALUES(1,'https://www.wanderlustchloe.com/wp-content/uploads/2019/10/Cappadocia-balloons-3.jpg', 'wow', '2022-01-01');
INSERT INTO posts(user_id, post_picture, caption, date_posted) VALUES(1,'https://www.kikkoman.com/homecook/search/recipe/img/00005163.jpg', 'so delicious!', '2022-01-01');
INSERT INTO posts(user_id, post_picture, caption, date_posted) VALUES(1,'https://www.caterease.com/wp-content/uploads/2019/01/Put-this-in-1.png', 'zzz...', '2022-01-01');
INSERT INTO comments(post_id, user_id, comment_description, date_posted) VALUES(1, 1, 'great picture!', '2022-01-01');
INSERT INTO comments(post_id, user_id, comment_description, date_posted) VALUES(1, 3, 'no way!', '2022-01-01');
INSERT INTO comments(post_id, user_id, comment_description, date_posted) VALUES(1, 2, 'thanks guys', '2022-01-01');
INSERT INTO comments(post_id, user_id, comment_description, date_posted) VALUES(1, 4, 'cool suit, wish I had one', '2022-01-01');
INSERT INTO comments(post_id, user_id, comment_description, date_posted) VALUES(1, 5, 'love to see it', '2022-01-01');
INSERT INTO comments(post_id, user_id, comment_description, date_posted) VALUES(1, 6, ':)', '2022-01-01');

INSERT INTO likes(user_id, post_id) VALUES(2, 1);
INSERT INTO likes(user_id, post_id) VALUES(3, 1);
INSERT INTO likes(user_id, post_id) VALUES(4, 1);
INSERT INTO likes(user_id, post_id) VALUES(5, 1);
INSERT INTO likes(user_id, post_id) VALUES(6, 1);

INSERT INTO likes(user_id, post_id) VALUES(2, 2);
INSERT INTO likes(user_id, post_id) VALUES(3, 2);
INSERT INTO likes(user_id, post_id) VALUES(4, 2);

INSERT INTO likes(user_id, post_id) VALUES(2, 3);
INSERT INTO likes(user_id, post_id) VALUES(3, 3);
INSERT INTO likes(user_id, post_id) VALUES(4, 3);

INSERT INTO likes(user_id, post_id) VALUES(3, 4);
INSERT INTO likes(user_id, post_id) VALUES(4, 4);

INSERT INTO favorites(user_id, post_id) VALUES(1, 4);
INSERT INTO favorites(user_id, post_id) VALUES(1, 7);



COMMIT TRANSACTION;
