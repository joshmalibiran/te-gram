<template>
    <div>
    THIS IS THE PUBLIC USER PROFILE VIEW
    <UserGallery/>

    </div>
</template>

<script>
import UserGallery from '../components/UserGallery.vue';

export default {

    name: "PublicUserProfile",
    components: {
        UserGallery,
    }

}
</script>

<style>

</style>