DROP TABLE user_spot_junction;
DROP TABLE users;
DROP TABLE spots;
DROP TABLE spot_stats;


CREATE TABLE users (
  user_id integer PRIMARY KEY NOT NULL,
  user_name char(30) NOT NULL,
  user_first_name char(30) NOT NULL,
  user_password char(30) NOT NULL,
  user_email char(40) NOT NULL,
  user_rating integer
);

CREATE TABLE spots (
  spot_id integer PRIMARY KEY NOT NULL,
  x_cordinate DECIMAL(10,6),
  y_cordinate DECIMAL(10,6),
  country char(50),
  city char(50),
  state char(50),
  spot_type char(10),
  spot_dificulty char(10)
);

CREATE TABLE spot_stats (
  spot_id integer PRIMARY KEY NOT NULL,
  spot_rating integer,
  upload_count integer,
  rarity_rating integer,
  trade_count integer,
  trade_rating integer,
  security_rating integer
);

CREATE TABLE user_spot_junction (
  user_id integer,
  spot_id integer,
  CONSTRAINT user_spot_pk PRIMARY KEY (user_id, spot_id),
  FOREIGN KEY (user_id) REFERENCES users (user_id),
  FOREIGN KEY (spot_id) REFERENCES spots (spot_id)
);


/* Insert users */
INSERT INTO users VALUES (1, "adam.awesome", "Adam", "csci3308", "adau3486@colorado.edu", 5);
INSERT INTO users VALUES (2, "evan", "Evan", "csci3308" , "evyi6056@colorado.edu" , 5);
INSERT INTO users VALUES (3, "coolcarrie", "Carrie", "clubsports", "cawa1436@colorado.edu", 5);

/* Insert spots */
INSERT INTO spots VALUES (1, 40.005911, -105.263942, "United States of America", "Bouler", "Colorado", "Stair", "Easy");
INSERT INTO spots VALUES (2, 40.006518, -105.267539, "United States of America", "Bouler", "Colorado", "Ledge", "Easy");
INSERT INTO spots VALUES (3, 40.007453, -105.266391, "United States of America", "Bouler", "Colorado", "Curb", "Medium");

/* Insert spot_stats */
INSERT INTO spot_stats VALUES (1, 3, 1, 0, 0, 0, 1);
INSERT INTO spot_stats VALUES (2, 4, 1, 0, 0, 0, 2);
INSERT INTO spot_stats VALUES (3, 2, 1, 0, 0, 0, 2);

/* Join users and spots in user_spot_junction */
INSERT INTO user_spot_junction VALUES (1, 1);

/* TESTS */
SELECT *
FROM users;

SELECT *
FROM spots;

SELECT *
FROM user_spot_junction;



/*create table tables_info (user_count integer);*/
/*Figure out how to make some sort of array in table)*/
/*create table user_spot_list (user_id integer primary key, spot_id integer);*/
