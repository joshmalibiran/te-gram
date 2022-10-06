<template>
  <div>
    <div id="searchPage">
      <!-- <img src="../images/background-cohortpic.png" /> -->
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
        <div
          v-for="user in users"
          class="singleUser"
          v-bind:key="user.id"
          
        >{{user.username}}</div>
      </form>
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
      // user: {},
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
  width: 1000px;
  height: 45px;
  display: flex;
  align-self: center;
  position: relative;
  border-radius: 10px;
}
#submit {
  justify-content: center;
  align-self: center;
}
</style>