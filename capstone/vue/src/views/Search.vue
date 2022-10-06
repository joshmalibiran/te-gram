<template>
  <div>
      <navigation-bar/>
<new-searchbar/>
  </div>
</template>

<script>
import NavigationBar from '../components/NavigationBar.vue';

import NewSearchbar from '../components/NewSearchbar.vue'


export default {
    name: 'search',
  components: { NewSearchbar, NavigationBar
   },

};
</script>

