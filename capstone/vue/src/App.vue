<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">TE Gram</router-link>&nbsp;&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>
<style>
#app{
  display: flex;
  height: 100vh;
  font-family:'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif ;
}
body{
background-color: rgb(26, 174, 243);
}
</style>