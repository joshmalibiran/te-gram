<template>
    <div id="profile">
        <top-nav-bar id="Topnavbar"/>
        <div id="header-profile">
            <h1>{{ this.user.username }}</h1>
            <img id="headerPic" :src="this.user.picture" />
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
  align-items: center;
  width: auto;
  height: 60px;
  border-radius: 50%;
  column-gap: 50px;
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