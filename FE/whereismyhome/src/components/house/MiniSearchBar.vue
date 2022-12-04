<template>
    <div>
        <select id="sidoSelectBar" v-model="sidoCode" @change="selectSido(sidoCode)">
            <option value="" seleted disabled hidden>시/도 선택</option>
            <option v-for="(sido, idx) in sidoList" :key="idx" :value="sido.value">
                {{ sido.text }}
            </option>
        </select>
        <select id="gugunSelectBar" v-model="gugunCode" @change="selectGugun(gugunCode)" required>
            <option value="" seleted disabled hidden>구/군 선택</option>
            <option v-for="(gugun, idx) in gugunList" :key="idx" :value="gugun.value">
                {{ gugun.text }}
            </option>
        </select>
        <select id="dongSelectBar" v-model="dongCode">
            <option value="" seleted>동 선택</option>
            <option v-for="(dong, idx) in dongList" :key="idx" :value="dong.value">
                {{ dong.text }}
            </option>
        </select>
        <button @click="searchHouse()" id="searchMini" >
        <img src="@/assets/img/search.png" style="width:20px"/>
        </button>

        <!-- <div v-for="(house, idx) in houseList" :key="idx">
          {{ house.aptName }}
      </div> -->
    </div>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";
const houseStore = "houseStore";
export default {
    data() {
        return {
            sidoCode: "",
            gugunCode: "",
            dongCode: "",
            searchCode: "",
        };
    },
    computed: {
        ...mapState(houseStore, ["sidoList", "gugunList", "dongList", "houseList"]),
    },
    methods: {
        ...mapActions(houseStore, ["getSido", "getGugun", "getDong", "getHouseList"]),
        selectSido(code) {
            this.gugunCode = "";
            this.dongCode = "";
            this.getGugun(code);
        },
        selectGugun(code) {
            this.dongCode = "";
            this.getDong(code);
        },
        searchHouse() {
            if (this.dongCode == "") {
                if (this.gugunCode == "") {
                    this.searchCode = this.sidoCode;
                } else {
                    this.searchCode = this.gugunCode;
                }
            } else {
                this.searchCode = this.dongCode;
            }
            this.getHouseList(this.searchCode);
        },
        ...mapMutations(houseStore, ["CLEAR_HOUSE_LIST"]),
    },
    mounted() {
        this.CLEAR_HOUSE_LIST();
        this.getSido();
    },
    created() {
        let $this = this;
        this.$EventBus.$on("dmddo", (param) => {
            $this.sidoCode = param.sidoCode;
            $this.gugunCode = param.gugunCode;
            $this.dongCode = param.dongCode;
            $this.searchCode = param.searchCode;

            $this.CLEAR_HOUSE_LIST();
            $this.getSido();
            $this.getGugun(param.sidoCode);
            $this.getDong(param.gugunCode);
            $this.searchHouse();
        });
    },
};
</script>

<style>
#sidoSelectBar,
#gugunSelectBar,
#dongSelectBar{
    border-radius:7px;
    border-width: 1.5;
    border-color: #808080;
}

#searchMini{
    border-radius: 7px; 
    background-color: #e2e2e2; 
    border-width:1.5px; 
    border-style: solid;
    border: color #808080;
}
</style>
