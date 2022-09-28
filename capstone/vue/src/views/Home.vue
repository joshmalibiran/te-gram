<template>
  <div id="home">
    <homepage/>
  </div>
  
</template>

<script>
import Homepage from "../components/HomePage.vue"

export default {
  components: {
    Homepage
  },
  name: "home"
};
</script>
<style>
/* #home{
  display: flex;
  flex-direction: row;
} */
/* #panel{
  display: flex;
  flex-direction: column;
  flex-grow: 1;
  align-self: left;
}
#post{
  display: flex;
  flex-grow: 2;
  justify-content: center;
  align-items: center;
}
#userInfo{
  display:flex;
  flex-grow: 0;
  align-self: right;
} */
</style>