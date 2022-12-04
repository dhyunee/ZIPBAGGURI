import http from "@/common/axios.js";

export default {
    namespaced: true,
    state: {
        sidoList: [],
        gugunList: [],
        dongList: [],
        houseList: [],
        houseDealList: [],
        house: "",
        length: 0,
        houseDeallength: 0,
    },
    mutations: {
        CLEAR_SIDO_LIST(state) {
            state.sidoList = [];
        },
        CLEAR_GUGUN_LIST(state) {
            state.gugunList = [];
        },
        CLEAR_DONG_LIST(state) {
            state.dongList = [];
        },
        CLEAR_HOUSE_LIST(state) {
            state.houseList = [];
            state.house = "";
            state.length = 0;
        },
        CLEAR_HOUSE_DEAL_LIST(state) {
            state.houseDealList = [];
            state.houseDeallength = 0;
            state.house = "";
        },
        SET_SIDO_LIST(state, sidoList) {
            sidoList.forEach((sido) => {
                state.sidoList.push({ value: sido.code, text: sido.name });
            });
        },
        SET_GUGUN_LIST(state, gugunList) {
            gugunList.forEach((gugun) => {
                state.gugunList.push({
                    value: gugun.code,
                    text: gugun.name,
                });
            });
        },
        SET_DONG_LIST(state, dongList) {
            dongList.forEach((dong) => {
                state.dongList.push({
                    value: dong.code,
                    text: dong.name,
                });
            });
        },
        SET_HOUSE_LIST(state, houseList) {
            state.houseList = houseList;
            state.length = houseList.length;
        },
        SET_HOUSE_DEAL_LIST(state, houseDealList) {
            state.houseDealList = houseDealList;
            state.houseDeallength = houseDealList.length;
        },
        SET_DETAIL_HOUSE(state, house) {
            state.house = house;
        },
    },
    actions: {
        getSido({ commit }) {
            commit("CLEAR_SIDO_LIST");
            commit("CLEAR_GUGUN_LIST");
            commit("CLEAR_DONG_LIST");

            http.get("/address")
                .then(({ data }) => {
                    commit("SET_SIDO_LIST", data.data);
                })
                .catch((err) => console.log(err));
        },
        getGugun({ commit }, code) {
            commit("CLEAR_GUGUN_LIST");
            commit("CLEAR_DONG_LIST");

            if (code == null || code == "") return;

            http.get("/address/" + code)
                .then(({ data }) => {
                    commit("SET_GUGUN_LIST", data.data);
                })
                .catch((err) => console.log(err));
        },
        getDong({ commit }, code) {
            commit("CLEAR_DONG_LIST");

            if (code == null || code == "") return;

            http.get("/address/" + code)
                .then(({ data }) => {
                    commit("SET_DONG_LIST", data.data);
                })
                .catch((err) => console.log(err));
        },
        getHouseList({ commit }, code) {
            commit("CLEAR_HOUSE_LIST");

            if (code == null) return;

            const params = { code: code };

            http.get("/houses", { params })
                .then(({ data }) => {
                    if (data.data.length == 0) {
                        alert("해당 지역에 등록된 아파트가 없습니다.");
                    } else {
                        commit("SET_HOUSE_LIST", data.data);
                    }
                })
                .catch((err) => console.log(err));
        },
        getHouseDealList({ commit }, houseId) {
            http.get("/houses/" + houseId + "/deal")
                .then(({ data }) => {
                    commit("SET_HOUSE_DEAL_LIST", data.data);
                })
                .catch((err) => console.log(err));
        },
        getHouseInfo({ commit }, houseId) {
            http.get("/houses/" + houseId + "/info")
                .then(({ data }) => {
                    commit("SET_DETAIL_HOUSE", data.data);
                })
                .catch((err) => console.log(err));
        },
    },
};
