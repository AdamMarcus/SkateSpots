DROP TABLE user_spot_colection;
DROP TABLE user_spot_contribution;
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

CREATE TABLE user_spot_colection (
  user_id integer,
  spot_id integer,
  CONSTRAINT user_spot_pk PRIMARY KEY (user_id, spot_id),
  FOREIGN KEY (user_id) REFERENCES users (user_id),
  FOREIGN KEY (spot_id) REFERENCES spots (spot_id)
);

CREATE TABLE user_spot_contribution (
  user_id integer,
  spot_id integer,
  CONSTRAINT user_spot_pk PRIMARY KEY (user_id, spot_id),
  FOREIGN KEY (user_id) REFERENCES users (user_id),
  FOREIGN KEY (spot_id) REFERENCES spots (spot_id)
);


/* Insert users */
INSERT INTO users VALUES (1, "adam.awesome", "Adam", "csci3308", "adau3486@colorado.edu", 5);
INSERT INTO users VALUES (2, "EnergeticEvan", "Evan", "csci3308" , "evan.yin@colorado.edu" , 5);
INSERT INTO users VALUES (3, "coolcarrie", "Carrie", "clubsports", "cawa1436@colorado.edu", 5);
INSERT INTO users VALUES (4, "FitFatin", "Fatin", "csci3308", "Fatin.Kamaruzaman@colorado.edu", 5);
INSERT INTO users VALUES (5, "JumpingJack", "Jack", "csci3308", "Jackson.Panetta@colorado.edu", 5);
INSERT INTO users VALUES (6, "SuperStering", "Sterling", "csci3308", "Sterling.Vangeloff@colorado.edu", 5);
INSERT INTO users VALUES (7, "BombBlake", "Blake", "csci3308", "Blake.Galbavy@colorado.edu", 5);

/* Insert spots */
INSERT INTO spots VALUES (1, 40.005911, -105.263942, "United States of America", "Boulder", "Colorado", "Stair", "Easy");
INSERT INTO spots VALUES (2, 40.006518, -105.267539, "United States of America", "Boulder", "Colorado", "Ledge", "Easy");
INSERT INTO spots VALUES (3, 40.007453, -105.266391, "United States of America", "Boulder", "Colorado", "Curb", "Medium");
INSERT INTO spots VALUES (4, 40.004952, -105.259692, "United States of America", "Boulder", "Colorado", "Flatland", "Easy");

/* Insert spot_stats */
INSERT INTO spot_stats VALUES (1, 3, 1, 0, 0, 0, 1);
INSERT INTO spot_stats VALUES (2, 4, 1, 0, 0, 0, 2);
INSERT INTO spot_stats VALUES (3, 2, 1, 0, 0, 0, 2);
INSERT INTO spot_stats VALUES (4, 5, 2, 0, 0, 0, 2);

/* Store the spots users have in their collection */
INSERT INTO user_spot_colection VALUES (1, 1);
INSERT INTO user_spot_colection VALUES (1, 2);
INSERT INTO user_spot_colection VALUES (1, 3);
INSERT INTO user_spot_colection VALUES (1, 4);
INSERT INTO user_spot_colection VALUES (2, 3);
INSERT INTO user_spot_colection VALUES (2, 4);

/* Store the spots users have contributed */
INSERT INTO user_spot_contribution VALUES (1, 1);
INSERT INTO user_spot_contribution VALUES (1, 2);
INSERT INTO user_spot_contribution VALUES (1, 3);
INSERT INTO user_spot_contribution VALUES (1, 4);
INSERT INTO user_spot_contribution VALUES (2, 4);

/* TESTS */
SELECT *
FROM users;

SELECT *
FROM spots;

SELECT *
FROM user_spot_colection;

SELECT *
FROM user_spot_contribution;

SELECT users.user_name, spots.city, spots.state, spots.country, spots.spot_type
FROM users, spots, user_spot_colection
WHERE user_spot_colection.user_id = users.user_id
AND user_spot_colection.spot_id = spots.spot_id;