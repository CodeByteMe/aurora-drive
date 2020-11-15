<template>
  <div class="app-container">
    <el-card class="box-card" shadow="hover">
      <span>驱动器列表</span>
      <i style="float: right; padding: 3px 0" class="el-icon-folder-opened"></i>
    </el-card>

    <el-card class="box-card" style="margin-top: 30px">
      <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
        >新增</el-button>
      </el-col>
    </el-row>
      <el-table v-loading="loading" :data="configList">
      <el-table-column label="ID" align="center" prop="configId" />
      <el-table-column label="驱动器名称" align="center" prop="driveName" />
      <el-table-column label="存储类型" align="center" prop="driveType">
        <template slot-scope="scope">
          <p v-if="scope.row.driveType == '1'">阿里云OSS</p>
          <p v-if="scope.row.driveType == '2'">腾讯云COS</p>
          <p v-if="scope.row.driveType == '3'">OneDrive</p>
          <p v-if="scope.row.driveType == '4'">GoogleDrive</p>
          <p v-if="scope.row.driveType == '5'">七牛云对象存储Kodo</p>
          <p v-if="scope.row.driveType == '6'">AWS S3</p>
          <p v-if="scope.row.driveType == '7'">又拍云存储 USS</p>
        </template>
      </el-table-column>
      <el-table-column label="缓存" align="center" prop="cacheEnable">
        <template slot-scope="scope">
          <el-switch
            v-model="scope.row.cacheEnable"
            active-color="#13ce66"
            inactive-color="#ff4949"
            @change="handleCache(scope.row)">
          </el-switch>
        </template>
      </el-table-column>
      <el-table-column label="云存储服务名称" align="center" prop="cloudName" />
      <el-table-column label="账号" align="center" prop="cloudAccount" />
      <el-table-column label="加速域名" align="center" prop="acceleratedDomainName" />
      <el-table-column label="根路径" align="center" prop="rootPath" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    </el-card>

    <!-- 添加或修改driveConfig对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="600px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="125px">
        <el-form-item label="驱动器名称" prop="driveName">
          <el-input v-model="form.driveName" placeholder="请输入驱动器名称" />
        </el-form-item>
        <el-form-item label="存储类型" prop="driveType">
          <el-select v-model="form.driveType" placeholder="请输入存储类型">
            <el-option label="阿里云OSS" value="1" />
            <el-option label="腾讯云COS" value="2" />
            <el-option label="OneDrive" value="3" />
            <el-option label="GoogleDrive" value="4" />
            <el-option label="七牛云对象存储Kodo" value="5" />
            <el-option label="AWS S3" value="6" />
            <el-option label="又拍云存储 USS" value="7" />
          </el-select>
        </el-form-item>
        <el-form-item label="是否开启缓存" prop="cacheEnable">
          <el-select v-model="form.cacheEnable" placeholder="请选择">
            <el-option label="是" value="true" />
            <el-option label="否" value="false" />
          </el-select>
        </el-form-item>
        <el-form-item label="云存储服务名称" prop="cloudName">
          <el-input v-model="form.cloudName" placeholder="请输入云存储服务名称" />
        </el-form-item>
        <el-form-item label="账号" prop="cloudAccount">
          <el-input v-model="form.cloudAccount" placeholder="请输入账号" />
        </el-form-item>
        <el-form-item label="密码" prop="cloudPwd">
          <el-input v-model="form.cloudPwd" placeholder="请输入密码" />
        </el-form-item>
        <el-form-item label="加速域名" prop="acceleratedDomainName">
          <el-input v-model="form.acceleratedDomainName" placeholder="请输入加速域名" />
        </el-form-item>
        <el-form-item label="根路径" prop="rootPath">
          <el-input v-model="form.rootPath" placeholder="请输入根路径" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listConfig, getConfig, delConfig, addConfig, updateConfig, updateCache } from '@/api/drive/config'
import { Message } from 'element-ui'

export default {
  name: 'Config',
  data() {
    return {
      // 遮罩层
      loading: true,
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // driveConfig表格数据
      configList: [],
      // 弹出层标题
      title: '',
      // 是否显示弹出层
      open: false,
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        driveName: [
          { required: true, message: '驱动器名称不能为空', trigger: 'blur' }
        ],
        driveType: [
          { required: true, message: '存储类型不能为空', trigger: 'change' }
        ],
        cacheEnable: [
          { required: true, message: '缓存不能为空', trigger: 'change' }
        ],
        cloudName: [
          { required: true, message: '云存储服务名称不能为空', trigger: 'blur' }
        ],
        cloudAccount: [
          { required: true, message: '账号不能为空', trigger: 'blur' }
        ],
        cloudPwd: [
          { required: true, message: '密码不能为空', trigger: 'blur' }
        ],
        acceleratedDomainName: [
          { required: true, message: '加速域名不能为空', trigger: 'blur' }
        ],
        rootPath: [
          { required: true, message: '根路径不能为空', trigger: 'blur' }
        ]
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询driveConfig列表 */
    getList() {
      this.loading = true
      listConfig().then(response => {
        this.configList = response.data
        this.loading = false
      })
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        configId: null,
        driveName: null,
        driveType: null,
        cacheEnable: false,
        cloudName: null,
        cloudAccount: null,
        cloudPwd: null,
        acceleratedDomainName: null,
        rootPath: null
      }
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = '添加驱动器'
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const configId = row.configId || this.ids
      getConfig(configId).then(response => {
        this.form = response.data
        this.open = true
        this.title = '修改驱动器配置'
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs['form'].validate(valid => {
        if (valid) {
          if (this.form.configId != null) {
            updateConfig(this.form).then(response => {
              if (response.code === 0) {
                Message.success('修改成功！')
              }
              this.open = false
              this.getList()
            })
          } else {
            addConfig(this.form).then(response => {
              if (response.code === 0) {
                Message.success('新增成功！')
              }
              this.open = false
              this.getList()
            })
          }
        }
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const configIds = row.configId || this.ids
      this.$confirm('是否确认删除driveConfig编号为"' + configIds + '"的数据项?', '警告', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(function() {
        return delConfig(configIds)
      }).then(() => {
        this.getList()
        Message.success('修改成功！')
      })
    },
    /** 缓存按钮操作 */
    handleCache(row) {
      updateCache(row.configId, row.cacheEnable).then(response => {
        if (response.code === 0) {
          Message.success('更新成功！')
        } else {
          Message.error('更新失败！')
        }
      })
    }
  }
}
</script>
