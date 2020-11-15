<template>
  <div style="padding:30px;">
    <el-card class="box-card" shadow="hover">
        <span>个人信息修改</span>
      <i style="float: right; padding: 3px 0" class="el-icon-user-solid"></i>
    </el-card>

    <el-card class="box-card" style="margin-top: 30px">
      <el-row>
        <img :src="avatarUrl" class="image" style="height: 150px">
        <div style="padding: 14px;">
          <span>昵称：{{ nickName }}</span>
          <div class="bottom clearfix" style="margin-top: 10px">
            <el-button type="primary" @click="userhandle()">修改密码</el-button>
            <el-dialog title="账户修改（危险操作）" :visible.sync="dialogUserVisible">
              <el-form ref="form" :model="form" :rules="formRules">
                <el-form-item label="旧密码" :label-width="formLabelWidth">
                  <el-input v-model="form.lowPassWord" placeholder="请输入旧密码" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="新密码" :label-width="formLabelWidth">
                  <el-input v-model="form.newPassWord" placeholder="请输入新密码" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="确认密码" :label-width="formLabelWidth">
                  <el-input v-model="form.confirmPassWord" placeholder="请再次输入密码" autocomplete="off"></el-input>
                </el-form-item>
              </el-form>
              <div slot="footer" class="dialog-footer">
                <el-button @click="dialogUserVisible = false">取 消</el-button>
                <el-button type="primary" @click="handleUserSubmit()">确 定</el-button>
              </div>
            </el-dialog>&nbsp;
            <el-button type="primary" @click="Infohandle">修改信息</el-button>
            <el-dialog title="信息修改" :visible.sync="dialogInfoVisible">
              <el-form :model="user">
                <el-form-item label="头像地址" :label-width="formLabelWidth">
                  <el-input v-model="user.avatarUrl" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="昵称" :label-width="formLabelWidth">
                  <el-input v-model="user.nickName" autocomplete="off"></el-input>
                </el-form-item>
              </el-form>
              <div slot="footer" class="dialog-footer">
                <el-button @click="dialogInfoVisible = false">取 消</el-button>
                <el-button :loading="loading" type="primary" @click="handleInfoSubmit()">确 定</el-button>
              </div>
            </el-dialog>
          </div>
        </div>
      </el-row>
    </el-card>
  </div>
</template>

<script>
import { getInfo } from '@/api/user'

export default {
  name: 'Login',
  data() {
    const validatePassword = (rule, value, callback) => {
      if (value.length < 6) {
        callback(new Error('密码不能少于6位数字'))
      } else {
        callback()
      }
    }
    return {
      nickName: '666',
      avatarUrl: '666',
      dialogUserVisible: false,
      dialogInfoVisible: false,
      formLabelWidth: '120px',
      loading: false,
      form: {
        lowPassWord: '',
        newPassWord: '',
        confirmPassWord: ''
      },
      user: {
        avatarUrl: '',
        nickName: ''
      },
      formRules: {
        password: [{ required: true, trigger: 'blur', validator: validatePassword }]
      }
    }
  },
  watch: {
    $route: {
      handler: function(route) {
        this.redirect = route.query && route.query.redirect
      },
      immediate: true
    }
  },
  created() {
    getInfo().then(response => {
      const { data } = response
      console.log(response)
      this.nickName = data.nickName
      this.avatarUrl = data.avatarUrl
    })
  },
  methods: {
    userhandle() {
      this.dialogUserVisible = true
    },
    handleUserSubmit() {
      this.dialogUserVisible = false
      this.$refs.form.validate(valid => {
        if (valid) {
          this.$store.dispatch('user/updateUser', this.form).then(() => {
            this.$router.push({ path: this.redirect || '/system/newInfo' })
          }).catch(() => {
            this.loading = false
          })
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    Infohandle() {
      this.dialogInfoVisible = true
      this.user.avatarUrl = this.avatarUrl
      this.user.nickName = this.nickName
    },
    handleInfoSubmit() {
      this.dialogInfoVisible = false
      this.loading = true
      this.$store.dispatch('user/updateInfo', this.user).then(() => {
        this.$router.push({ path: this.redirect || '/system/newInfo' })
        this.nickName = this.user.nickName
        this.avatarUrl = this.user.avatarUrl
        this.loading = false
      }).catch(() => {
        this.loading = false
      })
    }
  }
}
</script>
