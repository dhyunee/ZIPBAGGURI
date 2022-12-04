import Vue from "vue";
import { BootstrapVue, IconsPlugin, PaginationPlugin } from "bootstrap-vue";
import App from "./App.vue";
import store from "./store";
import router from "./routers";

require("@/assets/css/style.css");
require("@/assets/css/bootstrap.min.css");

// for bootstrap 5
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap";
// Import Bootstrap and BootstrapVue CSS files (order is important)
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue/dist/bootstrap-vue.css";

Vue.use(router);
Vue.config.productionTip = false;
// Make BootstrapVue available throughout your project
Vue.use(BootstrapVue);
Vue.use(IconsPlugin);
Vue.use(PaginationPlugin);

// EventBus 생성
Vue.prototype.$EventBus = new Vue();

new Vue({
    router,
    store,

    render: (h) => h(App),
}).$mount("#app");
