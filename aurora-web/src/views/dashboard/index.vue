<template>
  <div class="dashboard-container">
    <el-card class="box-card" shadow="hover">
      <span>欢迎：{{ name }}</span>
      <i style="float: right; padding: 3px 0" class="el-icon-user-solid"></i>
    </el-card>

    <el-card class="box-card" style="width: 42%; margin-top: 30px">
      <div slot="header" class="clearfix">
        <span>公告</span>
        <el-button style="float: right; padding: 3px 0" type="text">更新公告</el-button>
      </div>
      <div>
        <a href="https://github.com/besscroft/aurora-drive" target="_blank">aurora-drive</a> 算是我写的第一个“正式的”开源项目了。准备当成个人网盘来用，也希望能有一定程度的文件操作功能。准备采用容器化的方式部署，至于前后端分布分离，目前还在权衡中。
      </div>
    </el-card>

    <el-card class="box-card" style="width: 42%; margin-top: 30px;">
      <div slot="header" class="clearfix">
        <span>关注：QQ群821557332</span>
      </div>
      <div>
        <img src="https://blog.52bess.com/images/wechat_channel.jpg" style="width: 150px" />
        <img src="https://blog.52bess.com/images/RSS.png" style="width: 150px" />
      </div>
    </el-card>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'Dashboard',
  computed: {
    ...mapGetters([
      'name'
    ])
  }
}
</script>

<style lang="scss" scoped>
.dashboard {
  &-container {
    margin: 30px;
  }
  &-text {
    font-size: 30px;
    line-height: 46px;
  }
}
</style>
