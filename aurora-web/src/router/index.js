import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* 布局 */
import Layout from '@/layout'

/**
 * 注意：子菜单仅在路由children.length> = 1时出现
 * 详细请看: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   如果设置为true，则项目不会显示在边栏中（默认为false）
 * alwaysShow: true               如果设置为true，将始终显示根菜单
 *                                如果未设置alwaysShow，则当项具有多个子路线时，
 *                                它将变为嵌套模式，否则不显示根菜单
 * redirect: noRedirect           如果设置noRedirect，则不会在面包屑中重定向
 * name:'router-name'             该名称由<keep-alive>使用（必须设置！！！）
 * meta : {
    roles: ['admin','editor']    控制页面角色（您可以设置多个角色）
    title: 'title'               名称显示在侧边栏和面包屑中（推荐设置）
    icon: 'svg-name'/'el-icon-x' 侧栏中的图标显示
    breadcrumb: false            如果设置为false，则该项目将隐藏在面包屑中（默认为true）
    activeMenu: '/example/list'  如果设置了路径，则侧边栏将突出显示您设置的路径
  }
 */

/**
 * constantRoutes
 * 没有权限要求的基本页面
 * 可以访问所有角色
 */
export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },

  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [{
      path: 'dashboard',
      name: '仪表板',
      component: () => import('@/views/dashboard/index'),
      meta: { title: '仪表板', icon: 'dashboard' }
    }]
  },

  {
    path: '/pan',
    component: Layout,
    redirect: '/pan/drive',
    name: 'Drive',
    meta: { title: '网盘管理', icon: 'el-icon-s-promotion' },
    children: [
      {
        path: 'drive',
        name: 'Drive',
        component: () => import('@/views/pan/drive/index'),
        meta: { title: '驱动器列表', icon: 'el-icon-folder-opened' }
      },
      {
        path: 'other',
        name: 'Other',
        component: () => import('@/views/pan/other/index'),
        meta: { title: '其它设置', icon: 'el-icon-s-tools' }
      }
    ]
  },

  {
    path: '/monitor',
    component: Layout,
    children: [
      {
        path: 'monitor',
        name: 'Monitor',
        component: () => import('@/views/monitor/index'),
        meta: { title: '系统监控', icon: 'el-icon-monitor' }
      }
    ]
  },

  {
    path: '/system',
    component: Layout,
    redirect: '/system/newInfo',
    name: 'System',
    meta: {
      title: '系统设置',
      icon: 'el-icon-setting'
    },
    children: [
      {
        path: 'newInfo',
        component: () => import('@/views/system/newInfo/index'), // Parent router-view
        name: 'NewInfo',
        meta: { title: '信息修改', icon: 'el-icon-user' }
      },
      {
        path: 'help',
        component: () => import('@/views/system/help/index'),
        name: 'Help',
        meta: { title: '帮助中心', icon: 'el-icon-question' }
      }
    ]
  },

  {
    path: 'external-link',
    component: Layout,
    children: [
      {
        path: 'https://github.com/besscroft/aurora-drive',
        meta: { title: 'GitHub', icon: 'link' }
      }
    ]
  },

  // 404页必须放在最后！
  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  // mode: 'history', // 需要服务支持
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// 详细请看: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // 重置路由器
}

export default router
