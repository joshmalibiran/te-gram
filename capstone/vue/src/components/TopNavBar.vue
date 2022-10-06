<template>
    <header id="topNavPanel">
      <div id="leftNavBar">
      <router-link class="links" v-bind:to="{ name: 'home' }"><img id="logo" src="../images/TE-GRAM.jpg" /></router-link>

      <router-link id="magGlass" class="links" v-bind:to="{name: 'searchUsers'}"><img src="../images/animation-science-magnifyglass.gif"/></router-link>

      
      <router-link
        class="links"
        v-bind:to="{ name: 'upload' }"
        v-if="$store.state.token != ''"
        ><img id="upload" src="../images/Upload-Icon.png"/></router-link>

      <router-link  class="links" v-bind:to="{ name: 'favorite'}">Favorites</router-link>
      </div>

      <div id="rightNavBar">
      <router-link id="usernameLink" class="links" v-bind:to="{ name: 'PublicUserProfile', params: {username:this.$store.state.user.username}}">
      <p>{{this.$store.state.user.username}}</p>
      </router-link>
      <router-link class="links" v-bind:to="{ name: 'PublicUserProfile', params: {username:this.$store.state.user.username}}">
      </router-link>
       <img id="profilePicture" :src="this.user.picture" />

       <router-link
        class="links"
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link>
        </div>
    </header>
    

</template>

<script>
import userService from '../services/UserService'
export default {
  components: { },
  name: "top-nav-bar",
  data()  {
    return  {
      user:{}
    }
  },
  methods:  {
    getCurrentUser()    {
            userService.getCurrentUser().then(response =>   {
                this.user = response.data;
                
            })
        }
  },
  created() {
    this.getCurrentUser()
  }
    
}
</script>

<style>

#usernameLink{
  font-size: 17px;
}
#upload{
  height: auto;
  width: auto;
  max-height: 35px;
}
#magGlass{
  height: 100px;
  width: 100px;
}
#topNavPanel > #logo {
  height: auto;
  width: auto;
  margin-bottom: 50px;
  
}
#rightNavBar {
  display: flex;
  justify-content: space-evenly;
  align-items: center;
  flex-direction: row;
  margin-right: 30px;
}
#leftNavBar{
    display: flex;
    align-items: center;
    margin-left: 20px;
}
.panel {
  margin-bottom: 10px;
  margin-top: 10px;
}
#rightNavBar > #profilePicture {
  align-items: center;
  height: 60px;
  border-radius: 50%;
}
.links{
  font-size: 17px;
  text-decoration: none;
  color: black;
}
.links:hover{
  color: teal;
}
</style>