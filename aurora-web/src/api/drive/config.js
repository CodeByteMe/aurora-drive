import request from '@/utils/request'

// 查询driveConfig列表
export function listConfig() {
  return request({
    url: '/drive/list',
    method: 'get'
  })
}

// 查询driveConfig详细
export function getConfig(configId) {
  return request({
    url: '/drive/getInfo/' + configId,
    method: 'get'
  })
}

// 新增driveConfig
export function addConfig(data) {
  return request({
    url: '/drive/create',
    method: 'post',
    data: data
  })
}

// 修改driveConfig
export function updateConfig(data) {
  return request({
    url: '/drive/update',
    method: 'put',
    data: data
  })
}

// 删除driveConfig
export function delConfig(configId) {
  return request({
    url: '/drive/delete/' + configId,
    method: 'delete'
  })
}

// 更新cacheEnable
export function updateCache(configId, cacheEnable) {
  return request({
    url: '/drive/update/cache/' + configId + '/' + cacheEnable,
    method: 'put'
  })
}
