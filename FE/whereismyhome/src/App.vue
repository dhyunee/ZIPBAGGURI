<template>
    <div id="app">
        <spinner-ui v-if="isLoading" />
        <header-ui />
        <router-view></router-view>
        <footer-ui />
    </div>
</template>

<script>
import HeaderUi from "@/components/common/HeaderUI.vue";
import FooterUi from "@/components/common/FooterUI.vue";
import SpinnerUi from "@/components/common/SpinnerUI.vue";

import http from "@/common/axios.js";

export default {
    name: "App",
    data() {
        return {
            isLoading: false,
        };
    },
    components: {
        SpinnerUi,
        HeaderUi,
        FooterUi,
    },
    created() {
        http.interceptors.request.use(
            (config) => {
                this.isLoading = true;
                return config;
            },
            (error) => {
                this.isLoading = false;
                return Promise.reject(error);
            }
        );

        http.interceptors.response.use(
            (response) => {
                this.isLoading = false;
                return response;
            },
            (error) => {
                this.isLoading = false;
                return Promise.reject(error);
            }
        );
    },
};
</script>

<style></style>
