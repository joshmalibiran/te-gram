<template>
  <div>
      <navigation-bar/>

<searchbar/>
  </div>
</template>

<script>
import NavigationBar from '../components/NavigationBar.vue';

import searchbar from '../components/Searchbar.vue'

export default {
    name: 'search',
  components: { searchbar,
  NavigationBar },

};
</script>

<style>

</style>