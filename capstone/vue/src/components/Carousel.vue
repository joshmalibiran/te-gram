<template>
  <div>
    <!-- <img  src="../images/ezgif.com-gif-maker.gif" /> -->
    <div class="portfolio">
      <div class="portfolio_item">
        <img src="https://unsplash.it/250?image=1080" alt="" />
        <div class="portfolio_desc"></div>
      </div>

      <div class="portfolio_item">
        <img src="https://unsplash.it/250?image=1070" alt="" />
        <div class="portfolio_desc"></div>
      </div>

      <div class="portfolio_item">
        <img src="https://unsplash.it/250?image=1060" alt="" />
        <div class="portfolio_desc"></div>
      </div>

      <div class="portfolio_item">
        <img src="https://unsplash.it/250?image=1020" alt="" />
        <div class="portfolio_desc"></div>
      </div>

    <!-- The portfolio lightboxes -->
    <div class="portfolio-lightboxes">
      <div class="portfolio-lightbox">
        <div class="portfolio-lightbox_content">
          <a href="#" class="close"></a>
          <img src="https://unsplash.it/500/400?image=1080" alt="" />
          <h3 class="portfolio-lightbox_title">title in lightbox</h3>
          <p class="portfolio-lightbox_body">the content in lightbox</p>
        </div>
      </div>
    </div>
    
    <div class="portfolio-lightboxes">
      <div class="portfolio-lightbox">
        <div class="portfolio-lightbox_content">
          <a href="#" class="close"></a>
          <img src="https://unsplash.it/500/400?image=1070" alt="" />
          <h3 class="portfolio-lightbox_title">title in lightbox</h3>
          <p class="portfolio-lightbox_body">the content in lightbox</p>
        </div>
      </div>
    </div>
    
    <div class="portfolio-lightboxes">
      <div class="portfolio-lightbox">
        <div class="portfolio-lightbox_content">
          <a href="#" class="close"></a>
          <img src="https://unsplash.it/500/400?image=1060" alt="" />
          <h3 class="portfolio-lightbox_title">title in lightbox</h3>
          <p class="portfolio-lightbox_body">the content in lightbox</p>
        </div>
      </div>
    </div>
    
    <div class="portfolio-lightboxes">
      <div class="portfolio-lightbox">
        <div class="portfolio-lightbox_content">
          <a href="#" class="close"></a>
          <img src="https://unsplash.it/500/400?image=1020" alt="" />
          <h3 class="portfolio-lightbox_title">title in lightbox</h3>
          <p class="portfolio-lightbox_body">the content in lightbox</p>
        </div>
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
img{
  max-width: 100%;
}
.portfolio{
  height: 300px;
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-gap: 1em;
  padding: 1em;
  background: rgb(207, 234, 255);
}
.portfolio_item{
  
}
.portfolio-description{
  padding: 1.5em;
}
.portfolio-title{
  font-size: 1.5em;
  margin-top: 0;
}
/* .portfolio-lightboxes {
  position: fixed;
  top: 0;
  left: 0;
  width: 100 vw;
  height: 100 vh;
} */
.portfolio-lightboxes{
  display: none;
}
</style>