<template>
    <div class="container">
        <div class="boardSearchNav my-3 row">
            <div class="col-3 boardTypeBtn">
                <input @click="getBoard(1)" type="radio" class="btn-check" name="btnradio" id="btnradio1" autocomplete="off" />
                <label class="btn btn-outline-primary" for="btnradio1">공지사항</label>

                <input @click="getBoard(0)" type="radio" class="btn-check" name="btnradio" id="btnradio2" autocomplete="off" checked />
                <label class="btn btn-outline-primary" for="btnradio2">게시글</label>
            </div>
            <div v-if="!searchParams.type" class="col-9 boardSearchBar">
                <select id="sidoSelectBar" v-model="searchParams.sido" @change="selectSido(searchParams.sido)">
                    <option value="" seleted>시/도 선택</option>
                    <option v-for="(sido, idx) in sidoList" :key="idx" :value="sido.value">
                        {{ sido.text }}
                    </option>
                </select>
                <select id="gugunSelectBar" v-model="searchParams.gugun" @change="selectGugun(searchParams.gugun)">
                    <option value="" seleted>구/군 선택</option>
                    <option v-for="(gugun, idx) in gugunList" :key="idx" :value="gugun.value">
                        {{ gugun.text }}
                    </option>
                </select>
                <select id="dongSelectBar" v-model="searchParams.dong" @change="selectDong()">
                    <option value="" seleted>동 선택</option>
                    <option v-for="(dong, idx) in dongList" :key="idx" :value="dong.value">
                        {{ dong.text }}
                    </option>
                </select>
                <input type="text" v-model="searchParams.title" class="searchInput" />
                <button @click="search" id="searchBoard">
                    <img src="@/assets/img/search.png" style="width: 33px; height: 28px" />
                </button>
            </div>
        </div>
        <div>
            <table class="table table-hover bg-white text-center">
                <thead>
                    <tr>
                        <th scope="col-1"></th>
                        <th scope="col-5">제목</th>
                        <th scope="col-3">작성일자</th>
                        <th scope="col-2">조회수</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="(board, idx) in lists" :key="idx">
                        <th scope="row">
                            <span v-show="board.userSeq == 1 || board.showAddress">[{{ boardLocation(board) }}]</span>
                        </th>
                        <td>
                            <a class="custom-text" href="" @click.prevent="$router.push('/BoardPage/' + board.boardId)">{{ board.boardTitle }}</a>
                        </td>
                        <td>{{ board.fDate }}</td>
                        <td>{{ board.readCount }}</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <b-pagination class="justify-content-center" v-model="currentPage" :total-rows="rows" :per-page="perPage" aria-controls="my-table"></b-pagination>
        <!-- <b-table id="my-table" class="table table-hover bg-white" :fields="fields" :items="boardList" :per-page="perPage" :current-page="currentPage"> </b-table> -->
        <router-link class="float-end" to="regist">글쓰기</router-link>
    </div>
</template>

<script>
// import PaginationUi from "@/components/common/PaginationUI.vue";
import http from "@/common/axios.js";
import { mapState, mapMutations, mapActions } from "vuex";

const houseStore = "houseStore";

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
                limit: 0,
            },
            boardList: [],
            perPage: 10,
            currentPage: 1,
            rows: 0,

            // fields: ["boardId", "boardTitle", "fDate", "readCount"],
        };
    },
    methods: {
        ...mapMutations(["CLEAR_SELECTED_BOARD"]),
        ...mapActions(houseStore, ["getSido", "getGugun", "getDong"]),
        search() {
            let params = this.searchParams;
            http.get("/boards", { params }).then(({ data }) => {
                this.boardList = data.data;
                this.boardList = this.formatDate;
                this.rows = this.boardList.length;
            });
        },
        getBoard(param) {
            this.clearSearchOptions();
            this.currentPage = 1;
            this.searchParams.type = param;
            this.search();
        },
        selectSido(code) {
            this.searchParams.gugun = "";
            this.searchParams.dong = "";

            this.getGugun(code);
            this.search();
        },
        selectGugun(code) {
            this.searchParams.dong = "";

            this.getDong(code);
            this.search();
        },
        selectDong() {
            this.search();
        },
        clearSearchOptions() {
            this.searchParams.sido = "";
            this.searchParams.gugun = "";
            this.searchParams.dong = "";
            this.searchParams.title = "";
        },
        boardLocation(board) {
            if (board.userSeq == 1) {
                return "공지사항";
            } else {
                if (board.sidoName != null) {
                    if (board.sidoName.length != 4) {
                        if (board.dongName != undefined) {
                            return board.sidoName.slice(0, 2) + " " + board.dongName;
                        } else {
                            return board.sidoName.slice(0, 2);
                        }
                    } else {
                        if (board.dongName != undefined) {
                            return board.sidoName[0] + board.sidoName[2] + " " + board.dongName;
                        } else {
                            return board.sidoName[0] + board.sidoName[2];
                        }
                    }
                }
                return "";
            }
        },
    },
    computed: {
        ...mapState(houseStore, ["sidoList", "gugunList", "dongList"]),
        formatDate() {
            this.boardList.forEach((el) => {
                el.fDate = ("" + el.boardRegisterDate.date.year).slice(-2) + "/" + ("00" + el.boardRegisterDate.date.month).slice(-2) + "/" + ("00" + el.boardRegisterDate.date.day).slice(-2);
            });

            return this.boardList;
        },
        lists() {
            return this.boardList.slice((this.currentPage - 1) * this.perPage, this.currentPage * this.perPage);
        },
    },
    mounted() {
        let params = this.searchParams;
        http.get("/boards", { params }).then(({ data }) => {
            this.boardList = data.data;
            this.boardList = this.formatDate;
            this.rows = this.boardList.length;
        });

        this.CLEAR_SELECTED_BOARD();
        this.getSido();
    },
};
</script>

<style>
.boardTypeBtn {
    display: flex;
    justify-content: space-evenly;
}

.boardSearchBar {
    display: flex;
    justify-content: flex-end;
}

.boardSearchBar > * {
    margin: 0 0.5rem 0 0;
}
.searchInput {
    border-style: solid;
    border-radius: 7px;
    border-width: 1.5px;
    border-color: #808080;
}
#searchBoard {
    border-radius: 7px;
    border-style: none;
    background-color: #00b98e;
}
</style>
