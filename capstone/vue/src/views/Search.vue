<template>
  <div>
      <top-nav-bar id="Topnavbar"/>
<new-searchbar/>
  </div>
</template>

<script>
import topNavBar from '../components/TopNavBar.vue'

import NewSearchbar from '../components/NewSearchbar.vue'


export default {
    name: 'search',
  components: { NewSearchbar, topNavBar
   },

};
</script>

<style>

</style>

