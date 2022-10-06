<template>
    <sidebar id="navPanel">
      <router-link id="magGlass" class="links" v-bind:to="{name: 'searchUsers'}"><img src="../images/animation-science-magnifyglass.gif"/></router-link>
      <router-link class="links" v-bind:to="{ name: 'home' }"><img id="logo" src="../images/TE-GRAM.jpg" /></router-link>
      <router-link id="usernameLink" class="links" v-bind:to="{ name: 'PublicUserProfile', params: {username:this.$store.state.user.username}}">
      <p>{{this.$store.state.user.username}}</p>
      </router-link>
      <router-link class="links" v-bind:to="{ name: 'PublicUserProfile', params: {username:this.$store.state.user.username}}">
      </router-link>
       <img id="profilePicture" src="../images/default.jpg" />
      <router-link
        class="links"
        v-bind:to="{ name: 'upload' }"
        v-if="$store.state.token != ''"
        ><img id="upload" src="../images/Upload-Icon.png"/></router-link
      >
      <router-link  class="links" v-bind:to="{ name: 'favorite'}">Favorites</router-link>
      <router-link class="links" v-bind:to= "{name: 'updatePage'}"> Edit Profile</router-link>
      <router-link
        class="links"
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
#usernameLink{
  font-size: 25px;
}
#upload{
  height: auto;
  width: auto;
  max-height: 50px;
}
#magGlass{
  height: 100px;
  width: 100px;
}
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
  background: rgb(216,233,243);
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
.links{
  font-size: 20px;
  text-decoration: none;
  color: black;
}
.links:hover{
  color: teal;
}
</style>