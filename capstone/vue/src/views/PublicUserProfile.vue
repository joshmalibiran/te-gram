<template>
    <div id="profile">
    <UserGallery/>
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
</style>