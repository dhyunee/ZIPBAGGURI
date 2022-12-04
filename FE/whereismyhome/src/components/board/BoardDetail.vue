<template>
    <div class="container my-5">
        <div class="row">
            <div class="col-md-8" style="min-height: 70vh">
                <div class="card">
                    <div class="card-body" style="margin-bottom: 1rem">
                        <h4 class="mb-3">{{ selectedBoard.boardTitle }}</h4>
                        <hr />
                        <div v-html="selectedBoard.boardContent" style="min-height: 35vh"></div>
                    </div>
                </div>

                <button v-if="isAuthor" class="btn btn-sm btn-primary btn-outline ms-1" @click="$router.push({ name: 'BoardUpdateForm' })" style="margin-top: 2rem">글 수정하기</button>
                <button v-if="isAuthor" class="btn btn-sm btn-danger btn-outline ms-1" @click="deleteBoard" style="margin-top: 2rem">글 삭제하기</button>
            </div>

            <div class="col-md-4">
                <ul class="list-group">
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        글번호 :
                        <span>{{ selectedBoard.boardId }}</span>
                    </li>
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        조회수 :
                        <span>{{ selectedBoard.readCount }}</span>
                    </li>
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        작성일시 :
                        <span>{{ ("" + selectedBoard.boardRegisterDate.date.year).slice(-2) + "/" + ("00" + selectedBoard.boardRegisterDate.date.month).slice(-2) + "/" + ("00" + selectedBoard.boardRegisterDate.date.day).slice(-2) }}</span>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</template>

<script>
import http from "@/common/axios.js";
import { mapActions, mapState } from "vuex";

export default {
    props: ["id"],
    data() {
        return {};
    },
    methods: {
        ...mapActions(["getBoard"]),
        moveBoardUpdateForm() {},
        deleteBoard() {
            http.delete("/boards/" + this.id)
                .then(() => {
                    this.$router.push({ name: "BoardPage" });
                })
                .catch((err) => {
                    console.log(err);
                });
        },
    },
    computed: {
        ...mapState(["isAuthor", "selectedBoard"]),
    },
    mounted() {
        this.getBoard(this.id);
    },
};
</script>

<style></style>
