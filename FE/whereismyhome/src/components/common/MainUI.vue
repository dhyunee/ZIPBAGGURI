<template>
  <!-- Header Start -->
  <div id="mainPageee" class="container-fluid header bg-white p-0">
    <div class="row g-0 align-items-center flex-column-reverse flex-md-row">
      <div class="col-md-6 p-5 mt-lg-5">
        <h1 class="text-center mb-5">ㄱ</h1>
        <!-- Search Start -->
        <search-bar></search-bar>
        <!-- Search End -->
      </div>
      <div class="col-md-6 animated fadeIn">
        <div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
          <div class="carousel-inner">
            <div class="carousel-item active" data-bs-interval="4000">
              <img src="@/assets/img/carousel-1.jpg" class="d-block w-100" alt="..." />
            </div>
            <div class="carousel-item" data-bs-interval="4000">
              <img src="@/assets/img/carousel-2.jpg" class="d-block w-100" alt="..." />
            </div>
            <!-- <div class="carousel-item">
                            <img src="..." class="d-block w-100" alt="..." />
                        </div> -->
          </div>
          <button
            class="carousel-control-prev"
            type="button"
            data-bs-target="#carouselExampleInterval"
            data-bs-slide="prev"
          >
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
          </button>
          <button
            class="carousel-control-next"
            type="button"
            data-bs-target="#carouselExampleInterval"
            data-bs-slide="next"
          >
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
          </button>
        </div>
      </div>
    </div>
  </div>
  <!-- Header End -->
</template>

<script>
import SearchBar from "@/components/house/SearchBar.vue";

export default {
  components: {
    SearchBar,
  },
};
</script>

<style>
#mainPageee {
  /* width: 100%;
    height: 500px; */
  position: absolute !important;
  width: 100% !important;
  top: 0 !important;
  height: 96% !important;
}
</style>
