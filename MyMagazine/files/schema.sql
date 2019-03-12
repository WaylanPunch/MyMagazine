
-- 创建数据库
create database `mymagazine` default character set utf8 collate utf8_general_ci;

use mymagazine;

DROP TABLE IF EXISTS `t_logs`;

CREATE TABLE `t_logs` (
  `log_id` int(11) unsigned NOT NULL AUTO_INCREMENT ,
  `action` varchar(100) DEFAULT NULL ,
  `data` varchar(2000) DEFAULT NULL ,
  `user_id` int(10) DEFAULT NULL ,
  `ip` varchar(20) DEFAULT NULL ,
  `created` datetime NOT NULL ,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_attachments`;

CREATE TABLE `t_attachments` (
  `attachment_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `file_name` varchar(100) NOT NULL DEFAULT '',
  `file_type` varchar(50) DEFAULT '',
  `file_key` varchar(100) NOT NULL DEFAULT '',
  `user_id` int(10) DEFAULT NULL,
  `created` datetime NOT NULL,
  PRIMARY KEY (`attachment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_comments`;

CREATE TABLE `t_comments` (
  `comment_id` int(10) unsigned NOT NULL AUTO_INCREMENT ,
  `article_id` int(10) unsigned DEFAULT '0' ,
  `created` datetime NOT NULL,
  `name` varchar(200) DEFAULT NULL ,
  `autor_id` int(10) unsigned DEFAULT '0' ,
  `owner_id` int(10) unsigned DEFAULT '0' ,
  `mail` varchar(200) DEFAULT NULL ,
  `url` varchar(200) DEFAULT NULL ,
  `ip` varchar(64) DEFAULT NULL  ,
  `agent` varchar(200) DEFAULT NULL  ,
  `content` text ,
  `type` varchar(16) DEFAULT 'comment' ,
  `status` varchar(16) DEFAULT 'approved' ,
  `parent` int(10) unsigned DEFAULT '0',
  PRIMARY KEY (`comment_id`),
  KEY `article_id` (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_articles`;

CREATE TABLE `t_articles` (
  `article_id` int(10) unsigned NOT NULL AUTO_INCREMENT ,
  `title` varchar(200) DEFAULT NULL ,
  `slug` varchar(200) DEFAULT NULL ,
  `created` datetime NOT NULL,
  `modified` datetime NOT NULL,
  `content` text COMMENT '内容文字',
  `user_id` int(10) unsigned DEFAULT '0' ,
  `type` varchar(16) DEFAULT 'post'  ,
  `status` varchar(16) DEFAULT 'publish' ,
  `tags` varchar(200) DEFAULT NULL ,
  `categories` varchar(200) DEFAULT NULL ,
  `hits` int(10) unsigned DEFAULT '0' ,
  `comments_number` int(10) unsigned DEFAULT '0' ,
  `allow_comment` tinyint(1) DEFAULT '1' ,
  `allow_ping` tinyint(1) DEFAULT '1' ,
  `allow_feed` tinyint(1) DEFAULT '1' ,
  PRIMARY KEY (`article_id`),
  UNIQUE KEY `slug` (`slug`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_articles` WRITE;

INSERT INTO `t_articles` (`article_id`, `title`, `slug`, `created`, `modified`, `content`, `user_id`, `type`, `status`, `tags`, `categories`, `hits`, `comments_number`, `allow_comment`, `allow_ping`, `allow_feed`)
VALUES
	(1,'about my blog','about','2017-1-2 22:11:00','2017-1-3 22:11:00','### Hello World\r\n\r\nabout me\r\n\r\n### ...\r\n\r\n...',1,'page','publish',NULL,NULL,0,0,1,1,1),
	(2,'Hello My Blog',NULL,'2017-1-4 22:11:00','2017-1-5 22:11:00','## Hello  World.\r\n\r\n> ...\r\n\r\n----------\r\n\r\n\r\n<!--more-->\r\n\r\n```java\r\npublic static void main(String[] args){\r\n    System.out.println(\"Hello 13 Blog.\");\r\n}\r\n```',1,'post','publish','','default',10,0,1,1,1);

UNLOCK TABLES;

DROP TABLE IF EXISTS `t_metas`;

CREATE TABLE `t_metas` (
  `meta_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `slug` varchar(200) DEFAULT NULL,
  `type` varchar(32) NOT NULL DEFAULT '' ,
  `description` varchar(200) DEFAULT NULL ,
  `sort` int(10) unsigned DEFAULT '0',
  `parent` int(10) unsigned DEFAULT '0',
  PRIMARY KEY (`meta_id`),
  KEY `slug` (`slug`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_metas` WRITE;

INSERT INTO `t_metas` (`meta_id`, `name`, `slug`, `type`, `description`, `sort`, `parent`)
VALUES
	(1,'default',NULL,'category',NULL,0,0),
	(6,'my github','https://github.com/ZHENFENG13','link',NULL,0,0);

UNLOCK TABLES;

DROP TABLE IF EXISTS `t_options`;

CREATE TABLE `t_options` (
  `name` varchar(32) NOT NULL DEFAULT '',
  `value` varchar(1000) DEFAULT '',
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_options` WRITE;

INSERT INTO `t_options` (`name`, `value`, `description`)
VALUES
	('site_title','My Blog',''),
	('social_weibo','',NULL),
	('social_zhihu','',NULL),
	('social_github','',NULL),
	('social_twitter','',NULL),
	('site_theme','default',NULL),
	('site_keywords','13 Blog',NULL),
	('site_description','13 Blog',NULL),
	('site_record','','备案号');

UNLOCK TABLES;

DROP TABLE IF EXISTS `t_relationships`;

CREATE TABLE `t_relationships` (
  `article_id` int(10) unsigned NOT NULL,
  `meta_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`article_id`,`meta_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_relationships` WRITE;

INSERT INTO `t_relationships` (`article_id`, `meta_id`)
VALUES
	(2,1);

UNLOCK TABLES;

DROP TABLE IF EXISTS `t_users`;

CREATE TABLE `t_users` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `home_url` varchar(200) DEFAULT NULL,
  `display_name` varchar(32) DEFAULT NULL,
  `created` datetime NOT NULL,
  `activated` datetime ,
  `logged` datetime,
  `group_name` varchar(16) DEFAULT 'visitor' ,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `name` (`username`),
  UNIQUE KEY `mail` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `t_users` (`user_id`, `username`, `password`, `email`, `home_url`, `display_name`, `created`, `activated`, `logged`, `group_name`)
VALUES
	(1, 'admin', 'a66abb5684c45962d887564f08346e8d', '000000000@qq.com', NULL, 'admin', '2017-2-2 22:11:00', '2017-3-3 22:11:00', '2017-4-4 22:11:00', 'visitor');