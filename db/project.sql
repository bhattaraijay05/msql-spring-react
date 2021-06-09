CREATE DATABASE PROJECT;

CREATE TABLE USERS(user_id varchar(30) NOT NULL PRIMARY KEY, user_name varchar(30), email varchar(30), password varchar(30), createdat date);
cREATE TABLE PROFILES(profile_id varchar(30) PRIMARY KEY, user_id varchar(30), name varchar(30));
CREATE TABLE SUBSCRIPTIONS(subscription_id varchar(30) PRIMARY KEY, user_id varchar(30), plan_id varchar(30));
CREATE TABLE VIDEOS(video_id varchar(30) PRIMARY KEY, title varchar(30), summary varchar(200), censor_rating int, video_rating int);
CREATE TABLE PLAN(plan_id varchar(30) PRIMARY KEY, plan_name varchar(30));

