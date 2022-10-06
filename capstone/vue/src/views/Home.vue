<template>
  <div id="home">
    <navigation-bar/>
    <div class = "page">
    <homepage/>
    
    </div>
  </div>
  
</template>

<script>
import Homepage from "../components/HomePage.vue"
import NavigationBar from '../components/NavigationBar.vue';

export default {
  components: {
    Homepage,
    NavigationBar,
  },
  name: "home"
};
</script>
