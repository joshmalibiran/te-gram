<template>
  <div>
      <!-- <navigation-bar/> -->
<top-nav-bar id="Topnavbar"/>
<new-searchbar/>
  </div>
</template>

<script>
// import NavigationBar from '../components/NavigationBar.vue';

import NewSearchbar from '../components/NewSearchbar.vue'
import TopNavBar from '../components/TopNavBar.vue'

export default {
    name: 'search',
  components: { NewSearchbar, TopNavBar
   },

};
</script>

<style>
#Topnavbar{
    display: flex;
    align-items: center;
    border-radius: 60px;
    height: 100px;
}
</style>