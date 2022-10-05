<template>
  <div id="app">
    <!-- <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">TE Gram</router-link>&nbsp;&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div> -->
    <router-view />
  </div>
</template>
<script setup>
</script>

<style>
body {
  background: url("https://t3.ftcdn.net/jpg/02/14/26/32/360_F_214263275_yFsy0Uk8QXxqp1vf31hHiJ0zKJwKdcoS.jpg");
  background-repeat: no-repeat;
  background-position: center;
  background-size: cover;
  font-family: "Lucida Sans", "Lucida Sans Regular", "Lucida Grande",
    "Lucida Sans Unicode", Geneva, Verdana, sans-serif;
}
</style>