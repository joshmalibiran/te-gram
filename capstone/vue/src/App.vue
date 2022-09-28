<template>
  <div id="app">
    <!-- <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">TE Gram</router-link>&nbsp;&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div> -->
    <router-view />
  </div>
</template>
<style>
#nav{
  display: flex;
  flex-direction: column;
  height: 100vh;
  width: 50vh;
}
body{
background-color: rgb(26, 174, 243);
font-family: Georgia, serif;
}
</style>