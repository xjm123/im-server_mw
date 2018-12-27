/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.27 : Database - qiqiim
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`qiqiim` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;

USE `qiqiim`;

/*Table structure for table `live_room` */

DROP TABLE IF EXISTS `live_room`;

CREATE TABLE `live_room` (
  `id` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_id` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '会话房间所属人',
  `room_name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '房间名称',
  `room_total` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '房间最大人数',
  `room_state` int(1) DEFAULT '0' COMMENT '房间状态，0:正常，1：封禁，2：解散',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `live_room` */

/*Table structure for table `user_account` */

DROP TABLE IF EXISTS `user_account`;

CREATE TABLE `user_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(30) DEFAULT NULL COMMENT '帐号',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `disablestate` int(11) DEFAULT NULL COMMENT '禁用状态（0 启用  1 禁用）',
  `isdel` int(11) DEFAULT NULL COMMENT '是否删除（0未删除1已删除）',
  `createdate` datetime DEFAULT NULL COMMENT '创建日期',
  `updatedate` datetime DEFAULT NULL COMMENT '修改日期',
  `updateuser` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COMMENT='用户帐号';

/*Data for the table `user_account` */

insert  into `user_account`(`id`,`account`,`password`,`disablestate`,`isdel`,`createdate`,`updatedate`,`updateuser`) values (3,'1','1',NULL,NULL,'2017-11-27 15:08:37','2017-11-27 15:08:37',NULL);
insert  into `user_account`(`id`,`account`,`password`,`disablestate`,`isdel`,`createdate`,`updatedate`,`updateuser`) values (4,'2','2',0,0,'2017-11-27 18:00:14','2017-11-27 18:00:14',NULL);
insert  into `user_account`(`id`,`account`,`password`,`disablestate`,`isdel`,`createdate`,`updatedate`,`updateuser`) values (5,'3','3',0,0,'2017-11-27 18:06:20','2017-11-27 18:06:20',NULL);
insert  into `user_account`(`id`,`account`,`password`,`disablestate`,`isdel`,`createdate`,`updatedate`,`updateuser`) values (6,'4','4',0,0,'2017-11-27 18:12:11','2017-11-27 18:12:11',NULL);
insert  into `user_account`(`id`,`account`,`password`,`disablestate`,`isdel`,`createdate`,`updatedate`,`updateuser`) values (7,'5','5',0,0,'2017-11-27 18:13:18','2017-11-27 18:13:18',NULL);
insert  into `user_account`(`id`,`account`,`password`,`disablestate`,`isdel`,`createdate`,`updatedate`,`updateuser`) values (8,'6','6',0,0,'2017-11-27 18:13:58','2017-11-27 18:13:58',NULL);
insert  into `user_account`(`id`,`account`,`password`,`disablestate`,`isdel`,`createdate`,`updatedate`,`updateuser`) values (9,'7','7',0,0,'2017-11-27 18:14:24','2017-11-27 18:14:24',NULL);

/*Table structure for table `user_department` */

DROP TABLE IF EXISTS `user_department`;

CREATE TABLE `user_department` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `count` int(11) DEFAULT NULL COMMENT '部门人数',
  `level` int(11) DEFAULT NULL COMMENT '等级',
  `parentid` bigint(20) DEFAULT NULL COMMENT '上级部门ID',
  `remark` text COMMENT '备注',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  `updatedate` datetime DEFAULT NULL COMMENT '修改时间',
  `updateuser` bigint(50) DEFAULT NULL COMMENT '修改人',
  `isdel` int(11) DEFAULT NULL COMMENT '是否删除（0否1是）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='部门';

/*Data for the table `user_department` */

insert  into `user_department`(`id`,`name`,`count`,`level`,`parentid`,`remark`,`createdate`,`updatedate`,`updateuser`,`isdel`) values (1,'总经办',NULL,NULL,0,NULL,NULL,NULL,NULL,NULL);
insert  into `user_department`(`id`,`name`,`count`,`level`,`parentid`,`remark`,`createdate`,`updatedate`,`updateuser`,`isdel`) values (2,'开发一部',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL);
insert  into `user_department`(`id`,`name`,`count`,`level`,`parentid`,`remark`,`createdate`,`updatedate`,`updateuser`,`isdel`) values (3,'开发二部',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL);
insert  into `user_department`(`id`,`name`,`count`,`level`,`parentid`,`remark`,`createdate`,`updatedate`,`updateuser`,`isdel`) values (4,'财务部',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) DEFAULT NULL COMMENT '用户id',
  `deptid` bigint(11) DEFAULT NULL COMMENT '部门',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `sex` int(11) DEFAULT NULL COMMENT '性别（0女 1男）',
  `birthday` varchar(50) DEFAULT NULL COMMENT '生日',
  `cardid` varchar(20) DEFAULT NULL COMMENT '身份证',
  `signature` varchar(20) DEFAULT NULL COMMENT '签名',
  `school` varchar(50) DEFAULT NULL COMMENT '毕业院校',
  `education` int(11) DEFAULT NULL COMMENT '学历',
  `address` varchar(200) DEFAULT NULL COMMENT '现居住地址',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `remark` text COMMENT '备注',
  `profilephoto` varchar(256) DEFAULT NULL COMMENT '个人头像',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  `createuser` bigint(20) DEFAULT NULL COMMENT '创建人',
  `updatedate` datetime DEFAULT NULL COMMENT '修改时间',
  `updateuser` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';

/*Data for the table `user_info` */

insert  into `user_info`(`id`,`uid`,`deptid`,`name`,`nickname`,`sex`,`birthday`,`cardid`,`signature`,`school`,`education`,`address`,`phone`,`email`,`remark`,`profilephoto`,`createdate`,`createuser`,`updatedate`,`updateuser`) values (1,3,1,'张三',NULL,NULL,NULL,NULL,'我的签名',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2017-11-27 15:08:41',3,'2017-11-27 15:08:41',3);
insert  into `user_info`(`id`,`uid`,`deptid`,`name`,`nickname`,`sex`,`birthday`,`cardid`,`signature`,`school`,`education`,`address`,`phone`,`email`,`remark`,`profilephoto`,`createdate`,`createuser`,`updatedate`,`updateuser`) values (2,4,4,'李四',NULL,NULL,NULL,NULL,'Ta的签名',NULL,NULL,NULL,NULL,NULL,NULL,'layui/images/0.jpg','2017-11-27 18:00:14',4,'2017-11-27 18:00:14',4);
insert  into `user_info`(`id`,`uid`,`deptid`,`name`,`nickname`,`sex`,`birthday`,`cardid`,`signature`,`school`,`education`,`address`,`phone`,`email`,`remark`,`profilephoto`,`createdate`,`createuser`,`updatedate`,`updateuser`) values (3,5,4,'王五',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'layui/images/0.jpg','2017-11-27 18:06:20',5,'2017-11-27 18:06:20',5);
insert  into `user_info`(`id`,`uid`,`deptid`,`name`,`nickname`,`sex`,`birthday`,`cardid`,`signature`,`school`,`education`,`address`,`phone`,`email`,`remark`,`profilephoto`,`createdate`,`createuser`,`updatedate`,`updateuser`) values (4,6,3,'赵六',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'layui/images/0.jpg','2017-11-27 18:12:11',6,'2017-11-27 18:12:11',6);
insert  into `user_info`(`id`,`uid`,`deptid`,`name`,`nickname`,`sex`,`birthday`,`cardid`,`signature`,`school`,`education`,`address`,`phone`,`email`,`remark`,`profilephoto`,`createdate`,`createuser`,`updatedate`,`updateuser`) values (5,7,3,'孙七',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'layui/images/0.jpg','2017-11-27 18:13:18',7,'2017-11-27 18:13:18',7);
insert  into `user_info`(`id`,`uid`,`deptid`,`name`,`nickname`,`sex`,`birthday`,`cardid`,`signature`,`school`,`education`,`address`,`phone`,`email`,`remark`,`profilephoto`,`createdate`,`createuser`,`updatedate`,`updateuser`) values (6,8,1,'周八',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'layui/images/0.jpg','2017-11-27 18:13:58',8,'2017-11-27 18:13:58',8);
insert  into `user_info`(`id`,`uid`,`deptid`,`name`,`nickname`,`sex`,`birthday`,`cardid`,`signature`,`school`,`education`,`address`,`phone`,`email`,`remark`,`profilephoto`,`createdate`,`createuser`,`updatedate`,`updateuser`) values (7,9,1,'吴九',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'layui/images/0.jpg','2017-11-27 18:14:24',9,'2017-11-27 18:14:24',9);

/*Table structure for table `user_info_tmp` */

DROP TABLE IF EXISTS `user_info_tmp`;

CREATE TABLE `user_info_tmp` (
  `id` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名，即登录名。',
  `password` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码，加密后的密码',
  `user_type` int(1) DEFAULT '0' COMMENT '用户类型：',
  `nickname` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '昵称',
  `mobile` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `email` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `imqq` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'QQ',
  `user_status` int(1) DEFAULT '0' COMMENT '用户状态，0：正常，1封禁',
  `reg_type` int(1) DEFAULT '4' COMMENT '1：email，2：手机，3：微博，4：微信，5:  QQ',
  `profilephoto` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '个人头像',
  `sex` int(1) DEFAULT NULL COMMENT '性别（0女 1男）',
  `user_intro` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '户介绍',
  `reg_time` datetime DEFAULT NULL COMMENT '注册时间',
  `wb_id` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微博第三方ID',
  `qq_id` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'QQ第三方ID',
  `wx_openid` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信openid',
  `wx_union_id` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信union_id',
  `third_icon` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '第三方注册的头像',
  `qualify` varchar(2) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '认证状态：0-未认证;1-认证中;2-认证失败;3-认证成功',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `user_info_tmp` */

/*Table structure for table `user_message` */

DROP TABLE IF EXISTS `user_message`;

CREATE TABLE `user_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `send_user_id` varchar(40) DEFAULT NULL COMMENT '发送人user_id',
  `receive_user_id` varchar(40) DEFAULT NULL COMMENT '接收人user_id',
  `senduser` varchar(100) DEFAULT NULL COMMENT '发送人session',
  `receiveuser` varchar(100) DEFAULT NULL COMMENT '接收人session',
  `groupid` varchar(100) DEFAULT NULL COMMENT '群ID',
  `isread` int(11) DEFAULT NULL COMMENT '是否已读 0 未读  1 已读',
  `type` int(11) DEFAULT NULL COMMENT '类型 0 单聊消息  1 群消息',
  `content` text COMMENT '消息内容',
  `createuser` bigint(20) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  `updatedate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=153 DEFAULT CHARSET=utf8mb4;

/*Data for the table `user_message` */

insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (29,NULL,NULL,'DA0875E968961ED8E516B9209AEF424C',NULL,'0',0,1,'测试',NULL,'2017-11-24 10:58:33','2017-11-24 10:58:33');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (30,NULL,NULL,'DA0875E968961ED8E516B9209AEF424C',NULL,'0',0,1,'测试',NULL,'2017-11-24 10:58:56','2017-11-24 10:58:56');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (31,NULL,NULL,'269A734E0AC76F7BE6262124BE104BCC',NULL,'0',0,1,'测试什么？\n',NULL,'2017-11-24 10:59:06','2017-11-24 10:59:06');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (112,NULL,NULL,'3','8','',1,0,'你好face[微笑] ',NULL,'2017-11-29 11:34:39','2017-11-29 11:34:39');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (113,NULL,NULL,'8','3','',1,0,'你好，在干什么呢face[疑问] ',NULL,'2017-11-29 11:35:31','2017-11-29 11:35:31');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (114,NULL,NULL,'3','8','',1,0,'img[/upload/img/temp/3ed0460ec-82fa-4f46-8373-ccfa1742bf89.jpg?1511926548410]',NULL,'2017-11-29 11:35:48','2017-11-29 11:35:48');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (115,NULL,NULL,'8','3','',1,0,'你发的这个图好挫face[偷笑] ',NULL,'2017-11-29 11:36:30','2017-11-29 11:36:30');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (116,NULL,NULL,'3582012064DFEBA24AA43B718A18B3B0','7871124696264218bbb06923814a13d6','',1,0,'你好',NULL,'2018-12-18 18:30:24','2018-12-18 18:30:24');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (117,NULL,NULL,'3582012064DFEBA24AA43B718A18B3B0','7871124696264218bbb06923814a13d6','',1,0,'11',NULL,'2018-12-18 18:30:37','2018-12-18 18:30:37');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (118,NULL,NULL,'59D96B53C94EEADEC7D061DED8A7BA38',NULL,'0',1,1,'1111',NULL,'2018-12-19 09:52:45','2018-12-19 09:52:45');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (119,NULL,NULL,'59D96B53C94EEADEC7D061DED8A7BA38',NULL,'0',1,1,'2222',NULL,'2018-12-19 09:53:07','2018-12-19 09:53:07');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (120,NULL,NULL,'59D96B53C94EEADEC7D061DED8A7BA38',NULL,'0',1,1,'2222',NULL,'2018-12-19 09:53:26','2018-12-19 09:53:26');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (121,NULL,NULL,'59D96B53C94EEADEC7D061DED8A7BA38',NULL,'0',1,1,'222',NULL,'2018-12-19 09:55:48','2018-12-19 09:55:48');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (122,NULL,NULL,'59D96B53C94EEADEC7D061DED8A7BA38',NULL,'0',1,1,'3333',NULL,'2018-12-19 09:55:52','2018-12-19 09:55:52');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (123,NULL,NULL,'59D96B53C94EEADEC7D061DED8A7BA38',NULL,'0',1,1,'1211212\n',NULL,'2018-12-19 09:57:54','2018-12-19 09:57:54');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (124,NULL,NULL,'EB10C867CE06BAF86139A2B11E663A6A',NULL,'0',1,1,'1111',NULL,'2018-12-19 09:58:21','2018-12-19 09:58:21');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (125,NULL,NULL,'FB95B9C5FD7075640C720FCA7A508FCD',NULL,'0',1,1,'1',NULL,'2018-12-19 10:12:57','2018-12-19 10:12:57');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (126,NULL,NULL,'EDCEC1CEF9CE6535DE23140E98C81D14',NULL,'0',1,1,'222',NULL,'2018-12-19 10:13:25','2018-12-19 10:13:25');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (127,NULL,NULL,'FB95B9C5FD7075640C720FCA7A508FCD',NULL,'0',1,1,'你好\n',NULL,'2018-12-19 10:13:40','2018-12-19 10:13:40');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (128,NULL,NULL,'FB95B9C5FD7075640C720FCA7A508FCD',NULL,'0',1,1,'群聊\n',NULL,'2018-12-19 10:15:01','2018-12-19 10:15:01');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (129,NULL,NULL,'EDCEC1CEF9CE6535DE23140E98C81D14',NULL,'0',1,1,'22222',NULL,'2018-12-19 10:18:01','2018-12-19 10:18:01');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (130,NULL,NULL,'FB95B9C5FD7075640C720FCA7A508FCD',NULL,'0',1,1,'你好',NULL,'2018-12-19 10:18:04','2018-12-19 10:18:04');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (131,NULL,NULL,'FB95B9C5FD7075640C720FCA7A508FCD',NULL,'0',1,1,'11',NULL,'2018-12-19 10:27:16','2018-12-19 10:27:16');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (132,NULL,NULL,'7AD0BF5C3265E1547279988E096D513E',NULL,'0',1,1,'good\n',NULL,'2018-12-19 10:27:26','2018-12-19 10:27:26');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (133,NULL,NULL,'7AD0BF5C3265E1547279988E096D513E',NULL,'0',1,1,'okoppo',NULL,'2018-12-19 10:27:48','2018-12-19 10:27:48');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (134,NULL,NULL,'FB95B9C5FD7075640C720FCA7A508FCD','da6b64541ee94deaacf68bf878c3ab9b','',1,0,'111',NULL,'2018-12-19 10:40:17','2018-12-19 10:40:17');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (135,NULL,NULL,'7AD0BF5C3265E1547279988E096D513E',NULL,'0',1,1,'都是撒',NULL,'2018-12-19 11:26:58','2018-12-19 11:26:58');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (136,NULL,NULL,'305862CCC25B990785684C012C17D44B',NULL,'0',1,1,'11',NULL,'2018-12-19 14:14:35','2018-12-19 14:14:35');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (137,NULL,NULL,'52CAE6C100107BA968E7BDB8AD1CF4EE',NULL,'0',1,1,'222222222',NULL,'2018-12-19 17:07:46','2018-12-19 17:07:46');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (138,NULL,NULL,'83B2C02A575BCECFE0445894B9D76527',NULL,'0',1,1,'1234556',NULL,'2018-12-19 17:14:05','2018-12-19 17:14:05');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (139,NULL,NULL,'83B2C02A575BCECFE0445894B9D76527','1919e33d6b8149fa9490d9226d5dc998','',1,0,'444444',NULL,'2018-12-19 17:15:38','2018-12-19 17:15:38');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (140,NULL,NULL,'8E67B83067EAE527CECAD62D843116C2',NULL,'0',1,1,'123456群聊',NULL,'2018-12-19 19:17:41','2018-12-19 19:17:41');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (141,NULL,NULL,'362972A2CF727DC34E9C184633197BCC',NULL,'0',1,1,'群聊1111',NULL,'2018-12-19 19:18:49','2018-12-19 19:18:49');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (142,NULL,NULL,'362972A2CF727DC34E9C184633197BCC',NULL,'0',1,1,'群聊222',NULL,'2018-12-19 19:19:04','2018-12-19 19:19:04');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (143,NULL,NULL,'50CD86A3678EACA62BA4D2DBA7D4AAB0',NULL,'0',1,1,'群来哦333',NULL,'2018-12-19 19:19:48','2018-12-19 19:19:48');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (144,NULL,NULL,'7ABFDCC7AD9F54F372812442658DDFAB',NULL,'0',1,1,'111',NULL,'2018-12-20 08:59:34','2018-12-20 08:59:34');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (145,NULL,NULL,'BAF37AA802132CAE694AF64BC3A99E0C',NULL,'0',1,1,'1',NULL,'2018-12-20 09:25:14','2018-12-20 09:25:14');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (146,NULL,NULL,'38CDADC0B42ED9B5A89168A98AD72433',NULL,'0',1,1,'1',NULL,'2018-12-20 09:29:53','2018-12-20 09:29:53');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (147,NULL,NULL,'38CDADC0B42ED9B5A89168A98AD72433',NULL,'0',1,1,'1',NULL,'2018-12-20 09:30:43','2018-12-20 09:30:43');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (148,NULL,NULL,'38CDADC0B42ED9B5A89168A98AD72433',NULL,'0',1,1,'1',NULL,'2018-12-20 09:31:04','2018-12-20 09:31:04');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (149,NULL,NULL,'38CDADC0B42ED9B5A89168A98AD72433',NULL,'0',1,1,'222',NULL,'2018-12-20 10:26:01','2018-12-20 10:26:02');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (150,NULL,NULL,'DB8F2CC7A36B596ED0AB8A23E96A4F97',NULL,'3',1,1,'222',NULL,'2018-12-20 16:38:02','2018-12-20 16:38:02');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (151,NULL,NULL,'797A646711CFAFAEB074E810F70AB6C7',NULL,'3',1,1,'22',NULL,'2018-12-20 17:07:21','2018-12-20 17:07:21');
insert  into `user_message`(`id`,`send_user_id`,`receive_user_id`,`senduser`,`receiveuser`,`groupid`,`isread`,`type`,`content`,`createuser`,`createdate`,`updatedate`) values (152,NULL,NULL,'EDC7862EEA0618460C098629E9C438E1',NULL,'3',1,1,'11',NULL,'2018-12-21 18:51:08','2018-12-21 18:51:09');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
