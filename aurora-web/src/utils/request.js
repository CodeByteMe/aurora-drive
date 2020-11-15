import axios from 'axios'
import { MessageBox, Message } from 'element-ui'
import store from '@/store'
import { getToken } from '@/utils/auth'

// 创建一个axios实例
const service = axios.create({
  baseURL: process.env.VUE_APP_BASE_API, // url = base url + request url
  // withCredentials: true, // 跨域请求时发送Cookie
  timeout: 5000 // 请求超时时间
})

// 请求拦截器
service.interceptors.request.use(
  config => {
    // 在发送请求之前做一些事情

    if (store.getters.token) {
      // 每一个请求都会携带Token
      // ['X-Token'] 是一个用户自定义的 headers key
      // 请根据实际情况进行修改
      config.headers['Authorization'] = getToken()
    }
    return config
  },
  error => {
    // 做一些请求错误
    console.log(error) // 打印错误信息
    return Promise.reject(error)
  }
)

// 响应拦截器
service.interceptors.response.use(
  /**
   * 如果要获取http信息（例如标题或状态）
   * 请返回 response => response
  */

  /**
   * 通过自定义代码确定请求状态
   * 这只是一个例子
   * 还可以通过HTTP状态代码来判断状态
   */
  response => {
    const res = response.data

    // 如果自定义代码不是0，则将其判断为错误。
    if (res.code !== 0) {
      Message({
        message: res.message || 'Error',
        type: 'error',
        duration: 5 * 1000
      })

      // 50008: 非法的 token; 50012: 其他客户登录; 50014: Token 已过期;
      if (res.code === 50008 || res.code === 50012 || res.code === 50014) {
        // to re-login
        MessageBox.confirm('您已注销，可以取消停留在此页面上，或者再次登录', '确认登出', {
          confirmButtonText: '重新登录',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          store.dispatch('user/resetToken').then(() => {
            location.reload()
          })
        })
      }
      return Promise.reject(new Error(res.message || 'Error'))
    } else {
      return res
    }
  },
  error => {
    console.log('err' + error) // 打印错误信息
    Message({
      message: error.message,
      type: 'error',
      duration: 5 * 1000
    })
    return Promise.reject(error)
  }
)

export default service
