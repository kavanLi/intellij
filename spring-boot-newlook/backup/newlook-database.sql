CREATE DATABASE IF NOT EXISTS newlook DEFAULT CHARSET utf8;

USE newlook;

CREATE TABLE IF NOT EXISTS coupon (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	NAME VARCHAR(64) NOT NULL
) DEFAULT CHARSET utf8;