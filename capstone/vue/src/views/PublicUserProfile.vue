<template>
    <div id="profile">
    <UserGallery id="UserGallery"/>
    <navigation-bar/>
    </div>
</template>

<script>
import NavigationBar from '../components/NavigationBar.vue';
import UserGallery from '../components/UserGallery.vue';

export default {

    name: "PublicUserProfile",
    components: {
        UserGallery,
        NavigationBar,
    }

}
</script>

<style>
#profile{
    display:flex;
    justify-content: center;
}
#UserGallery{
width: 100vw;
}
</style>