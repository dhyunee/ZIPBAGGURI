<template>
    <div>
        <div class="card-body" id="dealListCard">
            <table class="table table-hover bg-white text-center">
                <thead>
                    <tr>
                        <th scope="col-4">거래연월일</th>
                        <th scope="col-3">면적(㎡)</th>
                        <th scope="col-1">층</th>
                        <th scope="col-4">가격(만원)</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="(deal, idx) in houseDealList" :key="idx">
                        <td>{{ ("" + deal.dealYear).slice(-2) + "/" + ("00" + deal.dealMonth).slice(-2) + "/" + ("00" + deal.dealDay).slice(-2) }}</td>
                        <td>{{ deal.area.toFixed(2) }}</td>
                        <td>{{ deal.floor > 0 ? deal.floor : "-" }}</td>
                        <td>{{ (deal.dealAmount * 1).toLocaleString() }}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>
<script>
import { mapState } from "vuex";
const houseStore = "houseStore";
export default {
    computed: {
        ...mapState(houseStore, ["houseDealList"]),
    },
};
</script>

<style>
#dealListCard {
    overflow-y: auto;
    max-height: 35vh;
    margin-left: auto;
    margin-right: auto;
    padding: 0;
}
</style>
