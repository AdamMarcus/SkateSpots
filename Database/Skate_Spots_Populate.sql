/*
*	Script to create the following tables:
		user, spot, spot_stats, user_spot_collection, user_spot_contribution.
	Also, populates a small amount of data for basic testing.
	Prep for implementation
*/


USE skatespots

GO
CREATE TABLE users (
  user_id integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  user_name char(30) NOT NULL,
  user_first_name char(30) NOT NULL,
  user_password char(30) NOT NULL,
  user_email char(40) NOT NULL,
  user_rating integer,
  token_count integer
);
GO
CREATE TABLE spots (
  spot_id integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  x_coordinate DECIMAL(10,6),
  y_coordinate DECIMAL(10,6),
  country char(50),
  city char(50),
  state char(50),
  spot_type char(10),
  spot_difficulty char(10)
);
GO
CREATE TABLE spot_stats (
  spot_id integer PRIMARY KEY NOT NULL,
  spot_rating integer,
  upload_count integer,
  rarity_rating integer,
  trade_count integer,
  security_rating integer
);
GO
CREATE TABLE user_spot_collection (
  user_id integer NOT NULL,
  spot_id integer NOT NULL,
  CONSTRAINT user_spot_pk PRIMARY KEY (user_id, spot_id),
  FOREIGN KEY (user_id) REFERENCES users(user_id),
  FOREIGN KEY (spot_id) REFERENCES spots(spot_id)
);
GO
CREATE TABLE user_spot_contribution (
  user_id integer NOT NULL,
  spot_id integer NOT NULL,
  CONSTRAINT user_spot_pk2 PRIMARY KEY (user_id, spot_id),
  FOREIGN KEY (user_id) REFERENCES users (user_id),
  FOREIGN KEY (spot_id) REFERENCES spots (spot_id)
);
GO
/* Insert users */
INSERT INTO users (user_name, user_first_name, user_password, user_email, user_rating, token_count) VALUES ('TestUser', 'TestUserName', 'TestPassowrd', 'TestEmail@colorado.edu', 5, 50);
INSERT INTO users (user_name, user_first_name, user_password, user_email, user_rating, token_count) VALUES ('adam.awesome', 'Adam', 'password', 'adau3486@colorado.edu', 5, 50);
INSERT INTO users (user_name, user_first_name, user_password, user_email, user_rating, token_count) VALUES ('EnergeticEvan', 'Evan', 'csci3308' , 'evan.yin@colorado.edu' , 5, 50);
INSERT INTO users (user_name, user_first_name, user_password, user_email, user_rating, token_count) VALUES ('coolcarrie', 'Carrie', 'clubsports', 'cawa1436@colorado.edu', 5, 50);
INSERT INTO users (user_name, user_first_name, user_password, user_email, user_rating, token_count) VALUES ('FitFatin', 'Fatin', 'csci3308', 'Fatin.Kamaruzaman@colorado.edu', 5, 50);
INSERT INTO users (user_name, user_first_name, user_password, user_email, user_rating, token_count) VALUES ('JumpingJack', 'Jack', 'csci3308', 'Jackson.Panetta@colorado.edu', 5, 50);
INSERT INTO users (user_name, user_first_name, user_password, user_email, user_rating, token_count) VALUES ('SuperStering', 'Sterling', 'csci3308', 'Sterling.Vangeloff@colorado.edu', 5, 50);
INSERT INTO users (user_name, user_first_name, user_password, user_email, user_rating, token_count) VALUES ('BombBlake', 'Blake', 'csci3308', 'Blake.Galbavy@colorado.edu', 5, 50);
GO
/* Insert spots */
INSERT INTO spots (x_coordinate, y_coordinate, country, city, state, spot_type, spot_difficulty) VALUES (40.005911, -105.263942, 'United States of America', 'Boulder', 'Colorado', 'Stair', 'Easy');
INSERT INTO spots (x_coordinate, y_coordinate, country, city, state, spot_type, spot_difficulty) VALUES (40.006518, -105.267539, 'United States of America', 'Boulder', 'Colorado', 'Ledge', 'Easy');
INSERT INTO spots (x_coordinate, y_coordinate, country, city, state, spot_type, spot_difficulty) VALUES (40.007453, -105.266391, 'United States of America', 'Boulder', 'Colorado', 'Curb', 'Medium');
INSERT INTO spots (x_coordinate, y_coordinate, country, city, state, spot_type, spot_difficulty) VALUES (40.004952, -105.259692, 'United States of America', 'Boulder', 'Colorado', 'Flatland', 'Easy');
GO
/* Insert spot_stats */
INSERT INTO spot_stats VALUES (1, 3, 1, 0, 0, 1);
INSERT INTO spot_stats VALUES (2, 4, 1, 0, 0, 2);
INSERT INTO spot_stats VALUES (3, 2, 1, 0, 0, 2);
INSERT INTO spot_stats VALUES (4, 5, 2, 0, 0, 2);
GO
/* Store the spots users have in their collection */
INSERT INTO user_spot_collection VALUES (0, 1);
INSERT INTO user_spot_collection VALUES (0, 3);
INSERT INTO user_spot_collection VALUES (1, 1);
INSERT INTO user_spot_collection VALUES (1, 2);
INSERT INTO user_spot_collection VALUES (1, 3);
INSERT INTO user_spot_collection VALUES (1, 4);
INSERT INTO user_spot_collection VALUES (2, 3);
INSERT INTO user_spot_collection VALUES (2, 4);
GO
/* Store the spots users have contributed */
INSERT INTO user_spot_contribution VALUES (1, 1);
INSERT INTO user_spot_contribution VALUES (1, 2);
INSERT INTO user_spot_contribution VALUES (1, 3);
INSERT INTO user_spot_contribution VALUES (1, 4);
INSERT INTO user_spot_contribution VALUES (2, 4);
GO
