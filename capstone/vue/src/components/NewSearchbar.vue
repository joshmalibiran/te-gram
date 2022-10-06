<template>
    <div id="searchPage">
      <img id="cohortpic" src="../images/background-cohortpic.png" />
      <h2 id="h2">Search for Users!</h2>
      <form
        id="searchBar"
        action=""
        class="search-bar"
        v-on:submit.prevent="filterUsers"
      >
        <input
          id="searchInput"
          type="text"
          v-model="search"
          placeholder="Search Username"
        />
        <button id="submit" value="submit" type="submit">Search</button>
      </form>
      <div id="results">
      <div 
          v-for="user in users"
          class="singleUser"
          v-bind:key="user.id"
          
        ><div id="list">
          <router-link id="resultLinks" v-bind:to="{name: 'PublicUserProfile', params: {username: user.username}}">
          <img id="resultsPic" :src="user.picture"/>
          {{user.username}}
          </router-link>
          </div>
        </div>
        </div>
    </div>
</template>

<script>
import UserService from "../services/UserService.js";

export default {
  name: "NewSearchbar",
  data() {
    return {
      users: [],
      search: "",
      post: [],
    };
  },
  components: {},
  created() {},
  methods: {
    filterUsers() {
      UserService.getUsersByUsername(this.search).then((response) => {
        console.log(this.username);
        this.users = response.data;
        console.log(this.users);
        console.log(response.data);
      });
    },
  },
  computed: {
    filteredUsernames() {
      return this.user.filter((username) => {
        return username.toLowerCase().includes();
      });
    },
  },
};
</script>
    

<style>
#h2{
  position: relative;
  color: black;
  font-size: 30px;
}
#cohortpic{
  position: absolute;
  align-self: center;
  height: 600px;
  width: 1000px;
  opacity: 0.3;
  border-radius: 5px;
}
#searchPage {
  display: flex;
  flex-direction: column;
  justify-content: center;
  height: 100vh;
  width: auto;
}
#searchBar {
  display: flex;
  flex-direction: column;
  justify-content: center;
}
#searchInput {
  width: 500px;
  height: 45px;
  display: flex;
  align-self: center;
  position: relative;
  border-radius: 10px;
}
#submit {
  justify-content: center;
  align-self: center;
  position: relative;
  width: 70px;
}
#results{
  display: flex;
  flex-direction: column;
  background-color: white;
  justify-content: center;
  align-self: center;
  position: relative;
  width: 500px;
  margin-top: 50px;
}
#resultLinks{
  text-decoration: none;
  color: black;
}
#resultsPic{
  border-radius: 50%;
  width: 40px;
  height: 40px;
  object-fit: cover;
  margin-right: 5px;
}
</style>