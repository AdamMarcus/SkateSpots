DROP TABLE user;

CREATE TABLE user(user_id integer PRIMARY KEY NOT NULL, user_name char(30) NOT NULL, user_first_name char(30) NOT NULL, user_password char(30) NOT NULL, user_email char(40) NOT NULL, user_rating integer);
CREATE TABLE spot (spot_id integer primary key, x_cordinate DOUBLE(9,6), y_cordinate DOUBLE(9,6), spot_rating integer);

/*Inster Users*/
INSERT INTO user VALUES (1, "adam.awesome", "Adam", "csci3308", "adau3486@colorado.edu", 5);
INSERT INTO user VALUES (2, "evan" , "Evan" , "csci3308" , "evyi6056@colorado.edu" , 5);

/*Insert Spots*/
/*INSERT INTO spot VALUES (1, 40.005911, -105.263942, 5);*/


/*create table tables_info (user_count integer);*/
/*Figure out how to make some sort of array in table)*/
/*create table user_spot_list (user_id integer primary key, spot_id integer);*/
