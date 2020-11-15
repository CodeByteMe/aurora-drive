import request from '@/utils/request'

export function login(username, password) {
  return request({
    url: '/user/login',
    method: 'post',
    params: {
      username: username,
      password: password
    }
  })
}

export function getInfo() {
  return request({
    url: 'user/info',
    method: 'get'
  })
}

export function logout() {
  return request({
    url: 'user/logout',
    method: 'post'
  })
}

export function updateUser(lowPassWord, newPassWord, confirmPassWord) {
  return request({
    url: 'user/updateUser',
    method: 'post',
    params: {
      lowPassWord: lowPassWord,
      newPassWord: newPassWord,
      confirmPassWord: confirmPassWord
    }
  })
}

export function updateInfo(nickName, avatarUrl) {
  return request({
    url: 'user/updateInfo',
    method: 'post',
    params: {
      nickName: nickName,
      avatarUrl: avatarUrl
    }
  })
}
