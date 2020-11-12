DROP TABLE IF EXISTS SYSTEM_CONFIG;

CREATE TABLE SYSTEM_CONFIG
(
	id BIGINT(20) NOT NULL COMMENT '主键ID',
	key VARCHAR(50) NULL DEFAULT NULL COMMENT 'key',
	value varchar(255) NULL DEFAULT NULL COMMENT 'value',
	remark VARCHAR(255) NULL DEFAULT NULL COMMENT '说明',
	PRIMARY KEY (id)
);

DROP TABLE IF EXISTS drive_config;
CREATE TABLE drive_config (
  config_id bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  drive_name varchar(255) DEFAULT NULL COMMENT '驱动器名称',
  drive_type varchar(255) DEFAULT NULL COMMENT '存储类型',
  cache_enable bit(1) DEFAULT NULL COMMENT '缓存',
  cloud_name varchar(255) DEFAULT NULL COMMENT '云存储服务名称',
  cloud_account varchar(255) DEFAULT NULL COMMENT '账号',
  cloud_pwd varchar(255) DEFAULT NULL COMMENT '密码',
  accelerated_domain_name varchar(255) DEFAULT NULL COMMENT '加速域名',
  root_path varchar(255) DEFAULT NULL COMMENT '根路径',
  PRIMARY KEY (config_id)
);