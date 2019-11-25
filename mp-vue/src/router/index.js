import Vue from 'vue'
import Router from 'vue-router'
// 导入刚才编写的组件
import AppIndex from '@/components/home/AppIndex'
import Login from '@/components/Login'
import Register from '@components/register/Register'
import Home from '@/components/Home'
import RecommendsTabs from '@/components/stulist/RecommendsTabs'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
  // 下面都是固定的写法
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/register',
      name: 'Resgister',
      component: Register
    },
    {
      path: '/home',
      name: 'Home',
      component: Home,
      // home页面并不需要被访问
      redirect: '/index',
      children: [
      {
        path: '/index',
        name: 'AppIndex',
        component: AppIndex,
        meta: {
          requireAuth: true
        }
      },
      {
        path: '/recommend',
        name: 'RecommendsTabs',
        component: RecommendsTabs,
        meta: {
          requireAuth: true
        }
      },
      ]
    }
  ]
})

