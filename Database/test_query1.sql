/* 
	Simple test query to show all tables and perform one calculation.
	Note: For some reason errors show throughout it.
		  However, the query executes properly...  
*/

USE skatespots;

SELECT *
FROM users;

SELECT *
FROM spots;

SELECT *
FROM spot_stats;

SELECT *
FROM user_spot_collection;

SELECT *
FROM user_spot_contribution;


SELECT users.user_id, spots.city, spots.state, spots.country, spots.spot_type
FROM users, spots, user_spot_collection
WHERE user_spot_collection.user_id = users.user_id
AND user_spot_collection.spot_id = spots.spot_id;
