import { param2Obj } from '@/utils/index.js'
describe('Utils:param2Obj', () => {
  const url = 'https://github.com/besscroft/aurora-drive-web?name=bess&age=21&sex=1&field=dGVzdA==&key=%E6%B5%8B%E8%AF%95'

  it('param2Obj test', () => {
    expect(param2Obj(url)).toEqual({
      name: 'bess',
      age: '21',
      sex: '1',
      field: window.btoa('test'),
      key: '测试'
    })
  })
})
