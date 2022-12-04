<template>
    <canvas id="myChart" height="400" width="400"></canvas>
</template>

<script>
import { mapState } from "vuex";
import { Chart, BarElement, BarController, LinearScale, CategoryScale } from "chart.js";
Chart.register(BarElement, BarController, LinearScale, CategoryScale);
const houseStore = "houseStore";
export default {
    data() {
        return {
            priceChangeChart: null,
            amountPerMonth: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
            avgHousePrice: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
            addHousePrice: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        };
    },
    computed: {
        ...mapState(houseStore, ["houseDealList", "houseDeallength"]),
    },
    mounted() {
        this.$watch("houseDealList", function () {
            this.amountPerMonth = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
            this.avgHousePrice = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
            this.addHousePrice = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
            this.getAvg();
            this.makeChart();
        });
    },
    methods: {
        getAvg() {
            //avg
            for (let i = 0; i < this.houseDeallength; i++) {
                this.amountPerMonth[this.houseDealList[i].dealMonth - 1]++;
                this.addHousePrice[this.houseDealList[i].dealMonth - 1] = parseInt(this.addHousePrice[this.houseDealList[i].dealMonth - 1]) + parseInt(this.houseDealList[i].dealAmount);
            }
            for (let i = 0; i < 12; i++) {
                if (this.amountPerMonth[i] == 0) {
                    this.avgHousePrice[i] = 0;
                    continue;
                }
                this.avgHousePrice[i] = parseFloat(this.addHousePrice[i] / this.amountPerMonth[i]);
            }
            console.log(this.avgHousePrice);
        },
        makeChart() {
            if (window.priceChangeChart != undefined) {
                window.priceChangeChart.destroy();
            }
            const ctx = document.getElementById("myChart").getContext("2d");
            window.priceChangeChart = new Chart(ctx, {
                type: "bar",
                data: {
                    labels: ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"],
                    datasets: [
                        {
                            data: this.avgHousePrice,
                            borderColor: ["#36498d", "#36498d", "#36498d", "#36498d", "#36498d", "#36498d", "#36498d", "#36498d", "#36498d", "#36498d", "#36498d", "#36498d"],
                            backgroundColor: [
                                "rgba(255,206,86,0.6)",
                                "rgba(255,206,86,0.6)",
                                "rgba(255,206,86,0.6)",
                                "rgba(255,206,86,0.6)",
                                "rgba(255,206,86,0.6)",
                                "rgba(255,206,86,0.6)",
                                "rgba(255,206,86,0.6)",
                                "rgba(255,206,86,0.6)",
                                "rgba(255,206,86,0.6)",
                                "rgba(255,206,86,0.6)",
                                "rgba(255,206,86,0.6)",
                                "rgba(255,206,86,0.6)",
                            ],
                        },
                    ],
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true,
                        },
                    },
                },
            });
        },
    },
};
</script>

<style></style>
