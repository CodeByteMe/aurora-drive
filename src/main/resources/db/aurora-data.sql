DELETE FROM SYSTEM_CONFIG;

INSERT INTO SYSTEM_CONFIG (id, key, value, remark) VALUES
(1, 'username', 'admin', '(默认)用户名'),
(2, 'password', 'f379eaf3c831b04de153469d1bec345e', '(默认)密码'),
(3, 'nickName', '贝丝', '昵称'),
(4, 'userId', '1', '用户id'),
(5, 'avatarUrl', 'https://52bess.com/uploads/avatar.png', '用户头像'),
(6, 'siteName', '极光网盘', '站点名称'),
(7, 'siteUrl', 'https://github.com/besscroft/aurora-drive', '站点网址');

INSERT INTO drive_config (config_id, drive_name, drive_type, cache_enable, cloud_name, cloud_account, cloud_pwd, accelerated_domain_name, root_path) VALUES
(1, '阿里云OSS', '1', '0', '阿里云OSS', 'admin@qq.com', '666666', 'https://oss.aliyun.com', '/'),
(2, 'OneDrive外链网盘', '3', '1', 'OneDrive for Business', 'bess@besscloud.onmicrosoft.com', '666666', 'https://mirrors.52bess.com', '/public'),
(3, '七牛', '5', '0', '七牛云对象存储Kodo', 'admin@qq.com', '666666', 'https://baidu.com', '/');