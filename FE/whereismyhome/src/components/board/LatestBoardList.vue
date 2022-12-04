<template>
    <div>
        <table class="table table-hover bg-white">
            <thead>
                <tr>
                    <th style="padding-left: 5rem" scope="col">제목</th>
                    <th class="text-center" scope="col">날짜</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(board, idx) in boardList" :key="idx">
                    <td style="padding-left: 3rem">
                        <a class="custom-text" href="" @click.prevent="$router.push('/BoardPage/' + board.boardId)">{{ board.boardTitle }}</a>
                    </td>
                    <td class="text-center">{{ board.fDate }}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import http from "@/common/axios.js";

export default {
    components: {},
    data() {
        return {
            searchParams: {
                type: 0,
                sido: "",
                gugun: "",
                dong: "",
                title: "",
                limit: 5,
            },
            boardList: [],
        };
    },
    computed: {
        formatDate() {
            this.boardList.forEach((el) => {
                el.fDate = ("" + el.boardRegisterDate.date.year).slice(-2) + "/" + ("00" + el.boardRegisterDate.date.month).slice(-2) + "/" + ("00" + el.boardRegisterDate.date.day).slice(-2);
            });

            return this.boardList;
        },
    },
    mounted() {
        let params = this.searchParams;
        http.get("/boards", { params }).then(({ data }) => {
            this.boardList = data.data;
            this.boardList = this.formatDate;
        });
    },
};
</script>

<style></style>
