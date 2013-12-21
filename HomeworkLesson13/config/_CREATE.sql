USE test;  
DROP DATABASE IF EXISTS production;
CREATE DATABASE production;
USE production; 

CREATE TABLE User(
id 	INTEGER      NOT NULL AUTO_INCREMENT PRIMARY KEY,
login	VARCHAR(20) NOT NULL,
email   VARCHAR(40) NOT NULL
);

INSERT INTO User VALUES
(50, 'Mike', 'x@a.com'),
(51, 'John', 'y@a.com'),
(52, 'Lusy', 'z@a.com');

