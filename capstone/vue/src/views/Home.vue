<template>
  <div id="home">
    <homepage/>
    <feed/>
    
  </div>
  
</template>

<script>
import Homepage from "../components/HomePage.vue"
import Feed from "../components/Feed.vue"


export default {
  components: {
    Homepage,
    Feed,
  },
  name: "home"
};
</script>
<style>

</style>