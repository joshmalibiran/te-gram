<template>
  <div id="home">
    <div class = page>
    <homepage/>
    <!-- <post-feed/> -->
    </div>
  </div>
  
</template>

<script>
import Homepage from "../components/HomePage.vue"
// import postFeed from "../components/PostFeed.vue"

export default {
  components: {
    Homepage,
    // postFeed
  },
  name: "home"
};
</script>
<style scoped>
.page {
  
}

</style>