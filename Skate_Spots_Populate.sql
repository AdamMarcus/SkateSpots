/*
  Author: Adam Austin and Evan Yin

  A populate and build for the database for SkateSpots
*/

drop table user;
drop table spot;
drop table tables_info;
drop table user_spot_list;


create table user (user_id integer primary key, user_name char(30), user_first_name char(30), user_password char(30), user_email char(40), user_rating integer;
/*Make some sort of a cordinate and photo object*/
/*create table spot (spot_id integer primary key, x_cordinate DOUBLE(7,5), y_cordinate DOUBLE(7,5), spot_rating integer, cover_photo photo);*/
create table tables_info (user_count integer);
/*Figure out how to make some sort of array in table)*/
/*create table user_spot_list (user_id integer primary key, spot_id integer);*/

insert into user values (1, "adam.awesome", "Adam", "csci3308", "adau3486@colorado.edu", 5);
insert into user values (2, "evan" , "Evan" , "csci3308" , "evyi6056@colorado.edu" , 5);
