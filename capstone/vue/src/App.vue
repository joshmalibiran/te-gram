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
  //import {storage} from '../src/firebase/index';

</script>

<style>
body{
background-color: rgb(167, 222, 253);
font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}
</style>