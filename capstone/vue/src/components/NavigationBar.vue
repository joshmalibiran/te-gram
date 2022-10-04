<template>
    <sidebar id="navPanel">
      <router-link v-bind:to="{ name: 'home' }"><img id="logo" src="../images/TE-GRAM.jpg" /></router-link>
      <router-link v-bind:to="{ name: 'PublicUserProfile', params: {username:this.$store.state.user.username}}">
      <p>{{this.$store.state.user.username}}</p>
      </router-link>
      <router-link v-bind:to="{ name: 'PublicUserProfile', params: {username:this.$store.state.user.username}}">
        <img id="profilePicture" src="../images/default.jpg" />
      </router-link>
      <router-link
        class="panel"
        v-bind:to="{ name: 'upload' }"
        v-if="$store.state.token != ''"
        >Upload Photo</router-link
      >
      <router-link v-bind:to="{ name: 'favorite'}">Favorites</router-link>
      <router-link
        class="panel"
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
    </sidebar>

</template>

<script>
export default {
  components: { },
    name: "nav-bar",
    
}
var prevScrollpos = window.pageYOffset;
window.onscroll = function() {
  var currentScrollPos = window.pageYOffset;
  if (prevScrollpos > currentScrollPos) {
    document.getElementById("navPanel").style.left = "0";
  } else {
    document.getElementById("navPanel").style.left = "-200px";
  }
  prevScrollpos = currentScrollPos;
}
</script>


<style>
#navPanel > #logo {
  height: auto;
  width: auto;
  margin-bottom: 50px;
}
#navPanel {
  float: left;
  order: 1;
  height: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  background: rgb(207, 234, 255);
  position: fixed;
  top: 0;
  left: 0;
  width: 175px;
  transition: left 0.5s;
}
.panel {
  margin-bottom: 10px;
  margin-top: 10px;
}
#navPanel > #profilePicture {
  justify-content: center;
  align-items: center;
  height: auto;
  width: 150px;
  border-radius: 50%;
  margin-bottom: 10px;
}
</style>