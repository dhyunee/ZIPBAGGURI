import Vue from "vue";
import VueRouter from "vue-router";

import BoardPage from "@/views/BoardPage.vue";
import HousePage from "@/views/HousePage.vue";
import MainPage from "@/views/MainPage.vue";
import BoardList from "@/components/board/BoardList.vue";
import BoardRegistForm from "@/components/board/BoardRegistForm.vue";
import BoardDetail from "@/components/board/BoardDetail.vue";
import BoardUpdateForm from "@/components/board/BoardUpdateForm.vue";
import store from "@/store/index";

Vue.use(VueRouter);

export default new VueRouter({
    routes: [
        {
            path: "/",
            name: "/",
            components: {
                default: MainPage,
            },
        },
        {
            path: "/MainPage",
            name: "MainPage",
            components: {
                default: MainPage,
            },
        },
        {
            path: "/BoardPage",
            name: "",
            component: BoardPage,
            children: [
                {
                    path: "/",
                    name: "BoardPage",
                    component: BoardList,
                },
                {
                    path: "regist",
                    name: "BoardRegistForm",
                    component: BoardRegistForm,
                    beforeEnter: (to, from, next) => {
                        console.log(store.state.isLogin);
                        if (!store.state.isLogin) {
                            alert("로그인이 필요한 페이지입니다.");
                        } else {
                            return next();
                        }
                    },
                },
                {
                    path: ":id",
                    name: "BoardDetail",
                    component: BoardDetail,
                    props: true,
                    beforeEnter: (to, from, next) => {
                        console.log(store.state.isLogin);
                        if (!store.state.isLogin) {
                            alert("로그인이 필요한 페이지입니다.");
                        } else {
                            return next();
                        }
                    },
                },
                {
                    path: ":id/update",
                    name: "BoardUpdateForm",
                    component: BoardUpdateForm,
                    props: true,
                },
            ],
        },

        {
            path: "/HousePage",
            name: "HousePage",
            components: {
                default: HousePage,
            },
        },
    ],
});
