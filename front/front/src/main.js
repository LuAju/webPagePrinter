// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'

Vue.config.productionTip = false

// 挂载到vue的全局(原型上),在每个组件都可以使用 ,prototype是固定的,$axios是自定义的
Vue.prototype.$axios = axios;
// 指定默认的请求域名
axios.defaults.baseURL = "http://localhost:8080"

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
