<template>
  <div>
    <div id="portfolio" class="portfolio">
      <!-- portfolio item 01 -->

      <div class="portfolio_item">
        <a href="#portfolio-item-1" class="button">
          <img src="../images/lightbox/sample1small.png" alt="" />
        </a>
      </div>

      <!-- portfolio item 02 -->
      <div class="portfolio_item">
        <a href="#portfolio-item-2" class="button">
          <img src="../images/lightbox/sample2small.png" alt="" />
        </a>
      </div>

      <!-- portfolio item 03 -->
      <div class="portfolio_item">
        <a href="#portfolio-item-3" class="button">
          <img src="../images/lightbox/sample3small.png" alt=""
        /></a>
      </div>

      <!-- portfolio item 04 -->
      <div class="portfolio_item">
        <a href="#portfolio-item-4" class="button">
          <img src="../images/lightbox/sample4small.png" alt="" />
        </a>
      </div>

      <!-- portfolio item 05 -->
      <div class="portfolio_item">
        <a href="#portfolio-item-5" class="button">
          <img src="../images/lightbox/sample5small.png" alt="" />
        </a>
      </div>

      <!-- portfolio item 06 -->
      <div class="portfolio_item">
        <a href="#portfolio-item-6" class="button">
          <img src="../images/lightbox/sample6small.png" alt="" />
        </a>
      </div>

      <!-- portfolio item 07 -->
      <div class="portfolio_item">
        <a href="#portfolio-item-7" class="button">
          <img src="../images/lightbox/sample7small.png" alt="" />
        </a>
      </div>

      <!-- portfolio item 08 -->
      <div class="portfolio_item">
        <a href="#portfolio-item-8" class="button">
          <img src="../images/lightbox/sample8small.png" alt="" />
        </a>
      </div>

      <!-- portfolio item 09 -->
      <div class="portfolio_item">
        <a href="#portfolio-item-9" class="button">
          <img src="../images/lightbox/sample9small.png" alt="" />
        </a>
      </div>

      <!-- The portfolio lightboxes -->
      <div class="portfolio-lightboxes">
        <!-- lightbox 01 -->
        <div id="portfolio-item-1" class="portfolio-lightbox">
          <div class="portfolio-lightbox_content">
            <a href="#portfolio" class="close"></a>
            <img class="lightbox-popup" src="../images/lightbox/sample1big.png" alt="" />
            <div class="navBtns">
              <a href="#" class="lb-prev"></a>
              <a href="#portfolio-item-2" class="lb-next"></a>
            </div>
          </div>
        </div>

      <!-- lightbox 02 -->
      
        <div id="portfolio-item-2" class="portfolio-lightbox">
          <div class="portfolio-lightbox_content">
            <a href="#portfolio" class="close"></a>
            <img class="lightbox-popup" src="../images/lightbox/sample2big.png" alt="" />
            <div class="navBtns">
              <a href="#portfolio-item-1" class="lb-prev"></a>
              <a href="#portfolio-item-3" class="lb-next"></a>
            </div>
          </div>
        </div>

      <!-- lightbox 03 -->
        <div id="portfolio-item-3" class="portfolio-lightbox">
          <div class="portfolio-lightbox_content">
            <a href="#portfolio" class="close"></a>
            <img class="lightbox-popup" src="../images/lightbox/sample3big.png" alt="" />
            <div class="navBtns">
              <a href="#portfolio-item-2" class="lb-prev"></a>
              <a href="#portfolio-item-4" class="lb-next"></a>
            </div>
          </div>
        </div>

      <!-- lightbox 04 -->

        <div id="portfolio-item-4" class="portfolio-lightbox">
          <div class="portfolio-lightbox_content">
            <a href="#portfolio" class="close"></a>
            <img class="lightbox-popup" src="../images/lightbox/sample4big.png" alt="" />
            <div class="navBtns">
              <a href="#portfolio-item-3" class="lb-prev"></a>
              <a href="#portfolio-item-5" class="lb-next"></a>
            </div>
          </div>
        </div>

      <!-- lightbox 05 -->
        <div id="portfolio-item-5" class="portfolio-lightbox">
          <div class="portfolio-lightbox_content">
            <a href="#portfolio" class="close"></a>
            <img class="lightbox-popup"
              src="../images/lightbox/sample5big.png"
              alt=""
            />
            <div class="navBtns">
              <a href="#portfolio-item-4" class="lb-prev"></a>
              <a href="#portfolio-item-6" class="lb-next"></a>
            </div>
          </div>
        </div>

      <!-- lightbox 06 -->
        <div id="portfolio-item-6" class="portfolio-lightbox">
          <div class="portfolio-lightbox_content">
            <a href="#portfolio" class="close"></a>
            <img class="lightbox-popup" src="../images/lightbox/sample6big.png" alt="" />
            <div class="navBtns">
              <a href="#portfolio-item-5" class="lb-prev"></a>
              <a href="#portfolio-item-7" class="lb-next"></a>
            </div>
          </div>
        </div>

      <!-- lightbox 07 -->
        <div id="portfolio-item-7" class="portfolio-lightbox">
          <div class="portfolio-lightbox_content">
            <a href="#portfolio" class="close"></a>
            <img class="lightbox-popup" src="../images/lightbox/sample7big.png" alt="" />
            <div class="navBtns">
              <div class="navBtns">
                <a href="#portfolio-item-6" class="lb-prev"></a>
                <a href="#portfolio-item-8" class="lb-next"></a>
              </div>
            </div>
          </div>
      </div>

      <!-- lightbox 08 -->
        <div id="portfolio-item-8" class="portfolio-lightbox">
          <div class="portfolio-lightbox_content">
            <a href="#portfolio" class="close"></a>
            <img class="lightbox-popup" src="../images/lightbox/sample8big.png" alt="" />
            <div class="navBtns">
              <a href="#portfolio-item-7" class="lb-prev"></a>
              <a href="#portfolio-item-9" class="lb-next"></a>
            </div>
          </div>
        </div>

      <!-- lightbox 09 -->
      <div id="portfolio-item-9" class="portfolio-lightbox">
        <div class="portfolio-lightbox_content">
          <a href="#portfolio" class="close"></a>
          <img class="lightbox-popup" src="../images/lightbox/sample9big.png" alt="" />
          <div class="navBtns">
            <a href="#portfolio-item-8" class="lb-prev"></a>
            <a href="#portfolio" class="lb-next"></a>
          </div>
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
  max-height: 100%;
}
.portfolio {
  height: 400px;
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
.portfolio img {
  width: auto;
  height: auto;
}
.lightbox-popup{
  border-radius: 10px;
}
.portfolio-lightbox {
  position: fixed;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  background: rgba(31, 31, 31, 0.5);
  color: white;
  display: none;
  align-items: center;
  justify-content: center;
  transform: scale(1, 1);
  transform-origin: center;
  transition: transform ease-in-out 1000ms;
}
.portfolio-lightbox:target {
  display: flex;
  transform: scale(1.5, 1.5);
}
.portfolio-lightbox_content {
  width: 18%;
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
.navBtns {
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  margin-right: 85px;
}
.lb-next,
.lb-prev {
  text-decoration: none;
}
.lb-next::after {
  color: white;
  content: ">";
  font-weight: 700;
  font-size: 30px;
}
.lb-prev::after {
  color: white;
  content: "<";
  font-weight: 700;
  font-size: 30px;
}
#btns {
  width: 255px;
}
#info {
  font-size: 15px;
}
</style>