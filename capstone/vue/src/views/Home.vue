<template>
  <div id="home">
    <homepage/>
    <feed/>
    
  </div>
  
</template>

<script>
import Homepage from "../components/HomePage.vue"
import feed from "../components/Feed.vue"


export default {
  components: {
    Homepage,
    feed
  },
  name: "home"
};
</script>
<style>

</style>