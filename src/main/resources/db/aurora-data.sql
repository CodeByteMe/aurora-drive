DELETE FROM SYSTEM_CONFIG;

INSERT INTO SYSTEM_CONFIG (id, key, value, remark) VALUES
(1, 'username', 'admin', '(默认)用户名'),
(2, 'password', '666666', '(默认)密码'),
(3, 'siteName', '激光网盘', '站点名称'),
(4, 'siteUrl', 'https://github.com/besscroft/aurora-drive', '站点网址');