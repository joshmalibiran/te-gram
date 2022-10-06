<template>
    <div id="profile">
        <top-nav-bar id="Topnavbar"/>
        <div id="header-profile">
            <h1>My Profile</h1>
        </div>
        <UserGallery id="UserGallery"/>
    </div>
</template>

<script>

import TopNavBar from '../components/TopNavBar.vue';
import UserGallery from '../components/UserGallery.vue';

export default {

    name: "PublicUserProfile",
    components: {
        UserGallery,
        TopNavBar,
    }

}
</script>

<style>
#profile{
    display: flex;
    flex-direction: column;
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
}


</style>