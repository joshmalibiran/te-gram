<template>
    <div id="profile">
        <top-nav-bar id="Topnavbar"/>
        <div id="header-profile">

            <div v-if="this.user.username === this.$store.state.user.username">
            <h1>My Profile</h1>
            </div>

            <div v-else>
            <h1>{{ this.user.username }}</h1>
            </div>

            <div id = "imgContainer">
            <img id="headerPic" :src="this.user.picture" />
            </div>
        </div>
        <UserGallery id="UserGallery"/>
    </div>
</template>

<script>

import TopNavBar from '../components/TopNavBar.vue';
import UserGallery from '../components/UserGallery.vue';
import userService from '../services/UserService.js'

export default {

    name: "PublicUserProfile",
    components: {
        UserGallery,
        TopNavBar,
    },
    data() {
        return {
            user: {},

        }
    },

    methods: {
        getUser() {
            console.log('HELP');
            userService.findByUsername(this.$route.params.username).then(response => {
                console.log(response.data);
                console.log(this.$route.params);
                this.user = response.data;
            });
        }
        
    },
    created() {
        this.getUser();
    }

}
</script>

<style>
#profile{
    display: flex;
    flex-direction: column;
}

#headerPic{
  border-radius: 50%;
  width: 60px;
  height: 60px;
  object-fit: cover;

  /* background-color: red; */
}
#UserGallery{
    margin: 75px;
}
#Topnavbar{
    display: flex;
    align-items: center;
    justify-content: space-between;
    background-color:rgb(216,233,243);
    
}
#header-profile{
    text-align: center;
    display: flex;
    justify-content: center;
    align-items:center;
}


</style>