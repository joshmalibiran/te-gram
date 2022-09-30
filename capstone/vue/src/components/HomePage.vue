<template>
  <div class="Homepage">
    <sidebar id="navPanel">
      <img id="logo" src="../images/TE-GRAM.jpg" />
      <!-- <router-link v-bind:to="{ name: 'home' }">TE Gram</router-link>&nbsp;&nbsp; -->
      <p>{{this.$store.state.user.username}}</p>
      <img id="profilePicture" src="../images/default.jpg" />
      <router-link
        class="panel"
        v-bind:to="{ name: 'upload' }"
        v-if="$store.state.token != ''"
        >Upload Photo</router-link
      >
      <router-link
        class="panel"
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
    </sidebar>

    <div id="post">
      <post-feed />
    </div>
    <div id="userInfo"></div>
  </div>
</template>

<script>
import PostFeed from "../components/PostFeed";

export default {
  components: {
    PostFeed,
  },
};
</script>

<style>
.Homepage {
  /* display: flex;
  flex-direction: row;
  
  column-gap: 150px; */
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
  background: rgb(207, 234, 255);
  position: fixed;
  top: 0;
  left: 0;
  width: 175px;
}
.panel {
  margin-bottom: 10px;
  margin-top: 10px;
}
#post {
  order: 2;
  display: flex;
  flex-direction: column;
  align-items: center;
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

