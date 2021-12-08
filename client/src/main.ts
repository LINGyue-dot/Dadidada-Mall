import {createApp} from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import "./assets/style/style.css"
import "bootstrap/dist/css/bootstrap.min.css";

import Vant from 'vant'
import 'vant/lib/index.css'


createApp(App).use(store).use(router).use(Vant).mount('#app')
