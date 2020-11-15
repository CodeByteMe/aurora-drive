## aurora-drive	极光网盘

[![](https://img.shields.io/badge/%E5%BC%80%E5%8F%91%E8%BF%9B%E5%BA%A6-%E5%BC%80%E5%8F%91%E4%B8%AD-brightgreen?style=flat-square)]() [![](https://img.shields.io/badge/license-MIT-green?style=flat-square)](https://github.com/besscroft/SpringCloud-mall/blob/master/LICENSE) [![](https://img.shields.io/badge/release-v0.0.1-orange?style=flat-square)]()

### 简介

aurora-drive 准备当成个人网盘来用，也希望能有一定程度的文件操作功能。准备采用容器化的方式部署，为前后端分离项目。**目前还在开发中，不能部署上线！**

### TODO

最近比较忙，准备先做项目需求和文档。。。

## 技术选型

### 后端技术

| 技术        | 说明                                       | 官网                                           |
| ----------- | ------------------------------------------ | ---------------------------------------------- |
| Spring Boot | 容器+MVC框架                               | https://spring.io/projects/spring-boot         |
| MyBatis     | ORM框架                                    | http://www.mybatis.org/mybatis-3/zh/index.html |
| MyBatis-Plus   | MyBatis 最好的搭档                                 | https://baomidou.com/ |
| PageHelper  | MyBatis物理分页插件                        | http://git.oschina.net/free/Mybatis_PageHelper |
| Swagger2    | 文档生产工具                               | https://swagger.io/                            |
| Docker      | 应用容器引擎                               | https://www.docker.com/                        |
| Druid       | 数据库连接池                               | https://github.com/alibaba/druid               |
| JWT         | JWT登录支持                                | https://github.com/jwtk/jjwt                   |
| Log4j       | 日志收集                                   | https://github.com/apache/logging-log4j2       |
| Lombok      | 简化对象封装工具                           | https://github.com/rzwitserloot/lombok         |
| Portainer   | 可视化Docker容器管理                       | https://github.com/portainer/portainer         |
| Jenkins     | 自动化部署工具                             | https://github.com/jenkinsci/jenkins           |
| H2database  | H2 is an embeddable RDBMS written in Java. | https://github.com/h2database/h2database       |

### 前端技术

| 技术     | 说明                  | 官网                           |
| -------- | --------------------- | ------------------------------ |
| Vue      | 前端框架              | https://vuejs.org/             |
| Element  | 前端UI框架            | https://element.eleme.io/      |
| Axios    | 前端HTTP框架          | https://github.com/axios/axios |
| ECharts           | 一个使用 JavaScript 实现的开源可视化库 | https://echarts.apache.org/zh/index.html                |
| vue-element-admin | A magical vue admin                    | https://panjiachen.github.io/vue-element-admin-site/zh/ |

### 第三方SDK

| 技术                | 说明                                                         | 官网                                           |
| ------------------- | ------------------------------------------------------------ | ---------------------------------------------- |
| 七牛云对象存储 Kodo | 七牛云对象存储 Kodo 是七牛云提供的高可靠、强安全、低成本、可扩展的存储服务。 | https://developer.qiniu.com/kodo/sdk/1239/java |
| 又拍云对象存储      | 满足大数据企业应用背景下的数据传输、处理、存储、分发与容灾需求。 | https://github.com/upyun/java-sdk              |
| OneDrive            | 微软*OneDrive*个人云储存空间                                 | https://developer.microsoft.com/zh-cn/onedrive |

## 环境搭建

### 开发环境

| 工具          | 版本号  | 下载                                                         |
| ------------- | ------- | ------------------------------------------------------------ |
| JDK           | 1.8     | https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html |
| H2            | 1.4.200 | https://h2database.com/html/main.html                        |
| idea         | 2020.2.3   | https://www.jetbrains.com/idea/     |
| nodejs   | 14.15.0  | https://nodejs.org/zh-cn/             |
| WebStorm | 2020.2.3 | https://www.jetbrains.com/webstorm/   |

### 在线开发

你可以使用 Gitpod 进行在线开发：

<p><a href="https://gitpod.io/#https://github.com/besscroft/aurora-drive" rel="nofollow"><img src="https://camo.githubusercontent.com/1eb1ddfea6092593649f0117f7262ffa8fbd3017/68747470733a2f2f676974706f642e696f2f627574746f6e2f6f70656e2d696e2d676974706f642e737667" alt="Open in Gitpod" data-canonical-src="https://gitpod.io/button/open-in-gitpod.svg" style="max-width:100%;"></a></p>

或者克隆到本地开发:

```
$ git clone https://github.com/besscroft/aurora-drive.git
```
### 项目构建

其实我更推荐[yarn](https://github.com/yarnpkg/yarn)

```bash
# 克隆项目
git clone https://github.com/besscroft/aurora-drive.git

# 进入项目目录
cd aurora-drive/aurora-web

# 安装依赖
npm install

# 建议不要用 cnpm 安装 会有各种诡异的bug 可以通过如下操作解决 npm 下载速度慢的问题
npm install --registry=https://registry.npm.taobao.org

# 本地开发 启动项目
npm run dev
```

#### 本项目的参考的项目（致谢）

[vue-element-admin](https://github.com/PanJiaChen/vue-element-admin)
[eladmin](https://github.com/elunez/eladmin)

#### 联系我

电子邮件：besscroft@foxmail.com

QQ群：<a target="_blank" href="https://qm.qq.com/cgi-bin/qm/qr?k=QGRHYDL2XE46mQMgl54WtIUl5pSuHVKP&jump_from=webapi"><img border="0" src="http://pub.idqqimg.com/wpa/images/group.png" alt="GitGitGo" title="GitGitGo"></a>

如果您有任何建议，欢迎反馈！