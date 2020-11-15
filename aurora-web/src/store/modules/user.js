import { login, logout, getInfo, updateInfo, updateUser } from '@/api/user'
import { getToken, setToken, removeToken } from '@/utils/auth'
import { resetRouter } from '@/router'
import { Message } from 'element-ui'

const getDefaultState = () => {
  return {
    token: getToken(),
    name: '',
    avatar: ''
  }
}

const state = getDefaultState()

const mutations = {
  RESET_STATE: (state) => {
    Object.assign(state, getDefaultState())
  },
  SET_TOKEN: (state, token) => {
    state.token = token
  },
  SET_NAME: (state, name) => {
    state.name = name
  },
  SET_AVATAR: (state, avatar) => {
    state.avatar = avatar
  }
}

const actions = {
  // user login
  login({ commit }, userInfo) {
    const { username, password } = userInfo
    return new Promise((resolve, reject) => {
      login(username, password).then(response => {
        const { data } = response
        console.log(data)
        commit('SET_TOKEN', data)
        setToken(data)
        resolve()
      }).catch(error => {
        reject(error)
      })
    })
  },

  // get user info
  getInfo({ commit, state }) {
    return new Promise((resolve, reject) => {
      getInfo(state.token).then(response => {
        const { data } = response

        if (!data) {
          return reject('Verification failed, please Login again.')
        }
        const { nickName, avatarUrl } = data

        commit('SET_NAME', nickName)
        commit('SET_AVATAR', avatarUrl)
        resolve(data)
      }).catch(error => {
        reject(error)
      })
    })
  },

  // user logout
  logout({ commit, state }) {
    return new Promise((resolve, reject) => {
      logout(state.token).then(() => {
        removeToken() // must remove  token  first
        resetRouter()
        commit('RESET_STATE')
        resolve()
      }).catch(error => {
        reject(error)
      })
    })
  },

  // remove token
  resetToken({ commit }) {
    return new Promise(resolve => {
      removeToken() // must remove  token  first
      commit('RESET_STATE')
      resolve()
    })
  },
  // update User
  updateInfo({ commit, state }, userInfo) {
    const { nickName, avatarUrl } = userInfo
    return new Promise((resolve, reject) => {
      updateInfo(nickName, avatarUrl).then(response => {
        if (response.code === 0) {
          Message.success('信息修改成功！')
        }
        const { data } = response
        if (!data) {
          return reject('Verification failed, please Login again.')
        }
        const { nickName, avatarUrl } = data
        console.log(nickName + '---' + avatarUrl)
        commit('SET_NAME', nickName)
        commit('SET_AVATAR', avatarUrl)
        resolve(data)
      }).catch(error => {
        reject(error)
      })
    })
  },

  // update password
  updateUser({ commit, state }, userInfo) {
    const { lowPassWord, newPassWord, confirmPassWord } = userInfo
    return new Promise((resolve, reject) => {
      updateUser(lowPassWord, newPassWord, confirmPassWord).then(response => {
        if (response.code === 0) {
          Message.success('密码修改成功！')
        }
        const { data } = response
        if (!data) {
          return reject('Verification failed, please Login again.')
        }
      }).catch(error => {
        reject(error)
      })
    })
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}

