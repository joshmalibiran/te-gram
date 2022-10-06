<template>
  <div>
    <div id="searchPage">
      <img id="cohortpic" src="../images/background-cohortpic.png" />
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
          <img id="resultsPic" src="user.user_picture"/>
          {{user.username}}
          </router-link>
          </div>
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
#cohortpic{
  position: absolute;
  align-self: center;
  height: 600px;
  width: 1000px;
  opacity: 0.3;
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
  width: 900px;
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
}
#results{
  display: flex;
  flex-direction: column;
  background-color: white;
  justify-content: flex-start;
  align-self: flex-start;
  position: relative;
  width: 300px;
  margin-left: 500px;
  margin-top: 50px;
}
#resultLinks{
  text-decoration: none;
}
#resultsPic{
  margin-right: 5px;
}
</style>