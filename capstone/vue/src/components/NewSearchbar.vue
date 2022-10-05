<template>
  <div id="searchForm">
    <img id="overlay" src="../images/background-cohortpic.png"/>
    <form action="" class="search-bar" v-on:submit.prevent="filterUsers">
      <input id="input" type="text" v-model="search" placeholder="Search Username" />
      
      <div id="buttons">
      <button id="submitBtn" type="submit" value="submit">Search</button>
      <button id="clearBtn" type="clear" value="clear">Clear</button>
      </div>
      <div
        v-for="user in users"
        class="singleUser"
        v-bind:key="user.id"
        v-bind:user="user"
      >
        <router-link id="resultsLink" v-bind:to="{name: 'PublicUserProfile', params: {username: user.username}}">
          <div id="results" v-if="hasResults">
          <img id="profilePic" src="user.user_picture" />
          {{ user.username }}
          </div>
        </router-link>
      </div>
    </form>
  </div>
</template>

<script>
import UserService from "../services/UserService.js";

export default {
  name: "NewSearchbar",
  data() {
    return {
      users: [],
      user: [],
      search: "",
      post: [],
      hasResults: false,
    };
  },
  components: {},
  created() {},
  methods: {
    filterUsers() {
      console.log(this.users);
      UserService.getUsersByUsername(this.search).then(response => {
        this.users = response.data;
        this.hasResults = true;
        console.log(this.users);
      })
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
#searchForm{
  display: flex;
 justify-content: center;
 align-items: center;
 height: 100vh;
}
#input{
  position: relative;
  border-radius: 10px;
  height: 30px;
  width: 40vw;
}
#results{
  position: relative;
    display: flex;
    flex-direction: row;
    background-color: white;
    width: 40vw;
}
#resultsLink{
    text-decoration: none;
}
#profilePic{
    margin-right: 5px;

}

#submitBtn, #clearBtn{
  position: relative;
  border-radius: 10px;
  height: 30px;
  width: 200px;

}
#buttons{
  display: flex;
  justify-content: space-evenly;
}
#overlay{
  position: absolute;
  opacity: 0.3;
  height: auto;
  width: auto;
  max-height: 1000px;
  max-width: 1000px;
}
</style>