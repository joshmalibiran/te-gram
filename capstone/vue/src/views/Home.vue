<template>
  <div id="home">
    <div class = page>
    <homepage/>
    <navigation-bar/>
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
