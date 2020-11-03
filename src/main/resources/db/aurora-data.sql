DELETE FROM SYSTEM_CONFIG;

INSERT INTO SYSTEM_CONFIG (id, key, value, remark) VALUES
(1, 'username', 'admin', '(默认)用户名'),
(2, 'password', 'f379eaf3c831b04de153469d1bec345e', '(默认)密码'),
(3, 'nickName', '贝丝', '昵称'),
(4, 'userId', '1', '用户id'),
(5, 'avatarUrl', 'https://52bess.com/uploads/avatar.png', '用户头像'),
(6, 'siteName', '极光网盘', '站点名称'),
(7, 'siteUrl', 'https://github.com/besscroft/aurora-drive', '站点网址');