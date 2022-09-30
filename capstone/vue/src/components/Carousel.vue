<template>
  <div id="carousel" class="carousel">
    <!-- <img  src="../images/ezgif.com-gif-maker.gif" /> -->
    <div id="portfolio" class="portfolio">
      <!-- portfolio item 01 -->

      <div class="portfolio_item">
        <a href="#portfolio-item-1" class="button">
          <img src="https://unsplash.it/250?image=1080" alt="" />
        </a>
      </div>

      <!-- portfolio item 02 -->
      <div class="portfolio_item">
        <a href="#portfolio-item-2" class="button">
          <img src="https://unsplash.it/250?image=1081" alt="" />
        </a>
      </div>

      <!-- portfolio item 03 -->
      <div class="portfolio_item">
        <a href="#portfolio-item-3" class="button">
          <img src="https://unsplash.it/250?image=1060" alt=""
        /></a>
      </div>

      <!-- portfolio item 04 -->
      <div class="portfolio_item">
        <a href="#portfolio-item-4" class="button">
          <img src="https://unsplash.it/250?image=1020" alt="" />
        </a>
      </div>

      <!-- portfolio item 05 -->
      <div class="portfolio_item">
        <a href="#portfolio-item-5" class="button">
          <img src="https://unsplash.it/250?image=1035" alt="" />
        </a>
      </div>
      
      <!-- portfolio item 06 -->
      <div class="portfolio_item">
        <a href="#portfolio-item-6" class="button">
          <img src="https://unsplash.it/250?image=965" alt="" />
        </a>
      </div>
      
      <!-- portfolio item 07 -->
      <div class="portfolio_item">
        <a href="#portfolio-item-7" class="button">
          <img src="https://unsplash.it/250?image=132" alt="" />
        </a>
      </div>

      
      <!-- portfolio item 08 -->
      <div class="portfolio_item">
        <a href="#portfolio-item-8" class="button">
          <img src="https://unsplash.it/250?image=666" alt="" />
        </a>
      </div>

      <!-- The portfolio lightboxes -->
      <div class="portfolio-lightboxes">

        <!-- lightbox 01 -->

        <div id="portfolio-item-1" class="portfolio-lightbox">
          <div class="portfolio-lightbox_content">
            <a href="#portfolio" class="close"></a>
            <img src="https://unsplash.it/900/300?image=1080" alt="" />
            <a href="#" class="lb-prev"></a>
				<a href="#portfolio-item-2" class="lb-next"></a>
          </div>
        </div>
      </div>

      <!-- lightbox 02 -->
      <div class="portfolio-lightboxes">
        <div id="portfolio-item-2" class="portfolio-lightbox">
          <div class="portfolio-lightbox_content">
            <a href="#portfolio" class="close"></a>
            <img src="https://unsplash.it/900/300?image=1081" alt="" />
            <a href="#portfolio-item-1" class="lb-prev"></a>
				<a href="#portfolio-item-3" class="lb-next"></a>
          </div>
        </div>
      </div>

      <!-- lightbox 03 -->
      <div class="portfolio-lightboxes">
        <div id="portfolio-item-3" class="portfolio-lightbox">
          <div class="portfolio-lightbox_content">
            <a href="#portfolio" class="close"></a>
            <img src="https://unsplash.it/900/300?image=1060" alt="" />
            <a href="#portfolio-item-2" class="lb-prev"></a>
				<a href="#portfolio-item-4" class="lb-next"></a>
          </div>
        </div>
      </div>

      <!-- lightbox 04 -->

      <div class="portfolio-lightboxes">
        <div id="portfolio-item-4" class="portfolio-lightbox">
          <div class="portfolio-lightbox_content">
            <a href="#portfolio" class="close"></a>
            <img src="https://unsplash.it/900/300?image=1020" alt="" />
            <a href="#portfolio-item-3" class="lb-prev"></a>
				<a href="#portfolio-item-5" class="lb-next"></a>
          </div>
        </div>
      </div>

      <!-- lightbox 05 -->
      <div class="portfolio-lightboxes">
        <div id="portfolio-item-5" class="portfolio-lightbox">
          <div class="portfolio-lightbox_content">
            <a href="#portfolio" class="close"></a>
            <img src="https://unsplash.it/900/300?image=1035" alt="" />
            <a href="#portfolio-item-4" class="lb-prev"></a>
				<a href="#portfolio-item-6" class="lb-next"></a>
          </div>
        </div>
      </div>

      <!-- lightbox 06 -->
      <div class="portfolio-lightboxes">
        <div id="portfolio-item-6" class="portfolio-lightbox">
          <div class="portfolio-lightbox_content">
            <a href="#portfolio" class="close"></a>
            <img src="https://unsplash.it/900/300?image=965" alt="" />
            <a href="#portfolio-item-5" class="lb-prev"></a>
				<a href="#portfolio-item-7" class="lb-next">t</a>
          </div>
        </div>
      </div>

      <!-- lightbox 07 -->
      <div class="portfolio-lightboxes">
        <div id="portfolio-item-7" class="portfolio-lightbox">
          <div class="portfolio-lightbox_content">
            <a href="#portfolio" class="close"></a>
            <img src="https://unsplash.it/900/300?image=132" alt="" />
            <a href="#portfolio-item-6" class="lb-prev"></a>
				<a href="#portfolio-item-8" class="lb-next"></a>
          </div>
        </div>
      </div>

      <!-- lightbox 08 -->
      <div class="portfolio-lightboxes">
        <div id="portfolio-item-8" class="portfolio-lightbox">
          <div class="portfolio-lightbox_content">
            <a href="#portfolio" class="close"></a>
            <img src="https://unsplash.it/900/300?image=666" alt="" />
            <a href="#portfolio-item-7" class="lb-prev"></a>
				<a href="#portfolio" class="lb-next"></a>
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
img {
  max-width: 100%;
}
.portfolio {
  height: 500px;
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-gap: 1em;
  padding: 1em;
  background: url("https://t3.ftcdn.net/jpg/02/14/26/32/360_F_214263275_yFsy0Uk8QXxqp1vf31hHiJ0zKJwKdcoS.jpg");
  background-repeat: no-repeat;
  background-position: center;
  background-size: cover;
  overflow-y: scroll;
}
.portfolio img{
  width: auto;
  height: auto;
}
.portfolio-lightbox {
  position: fixed;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  background: rgba(27, 27, 27, 0.5);
  color: white;
  display: flex;
  align-items: center;
  justify-content: center;
  transform: scale(1, 0);
  transform-origin: center;
  transition: transform ease-in-out 10ms;
}
.portfolio-lightbox:target {
  transform: scale(1, 1);
  transform-origin: center;
}
.portfolio-lightbox_content {
  width: 50%;
  padding: 1em;
  position: relative;
}
.close {
  position: absolute;
  width: 0.35em;
  height: 0.35em;
  background: url("https://t3.ftcdn.net/jpg/02/14/26/32/360_F_214263275_yFsy0Uk8QXxqp1vf31hHiJ0zKJwKdcoS.jpg");
  background-repeat: no-repeat;
  background-position: center;
  background-size: cover;
  top: -0.55em;
  left: -0.55em;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  text-decoration: none;
}
.close::after {
  content: "X";
  color: white;
  font-weight: 700;
}
.lb-next{
  position: flex;
  text-decoration: none;
}
.lb-prev{
  position: flex;
  text-decoration: none;
}
.lb-next::after{
  color: white;
  content: ">";
  font-weight: 700;
  font-size: 30px;
}
.lb-prev::after{
  color: white;
  content: "<";
  font-weight: 700;
  font-size: 30px;
}
</style>