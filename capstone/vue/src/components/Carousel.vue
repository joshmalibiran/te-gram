<template>
  <div>
    <!-- <img  src="../images/ezgif.com-gif-maker.gif" /> -->
    <div class="portfolio">
      <div class="portfolio_item">
        <img src="https://unsplash.it/300?image=1080" alt="" />
        <div class="portfolio_desc"></div>
      </div>

      <div class="portfolio_item">
        <img src="https://unsplash.it/300?image=100" alt="" />
        <div class="portfolio_desc"></div>
      </div>

      <div class="portfolio_item">
        <img src="https://unsplash.it/300?image=1060" alt="" />
        <div class="portfolio_desc"></div>
      </div>

      <div class="portfolio_item">
        <img src="https://unsplash.it/300?image=1020" alt="" />
        <div class="portfolio_desc"></div>
      </div>
    </div>

    <!-- The portfolio lightboxes -->
    <div class="portfolio-lightboxes">
      <div class="portfolio-lightbox">
        <div class="portfolio-lightbox_content">
          <a href="#" class="close"></a>
          <img src="https://unsplash.it/300?image=1080" alt="" />
          <h3 class="portfolio-lightbox_title">title in lightbox</h3>
          <p class="portfolio-lightbox_body">the content in lightbox</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  components: {},
};
</script>

<style>
.portfolio{
  height: 300px;
}
</style>