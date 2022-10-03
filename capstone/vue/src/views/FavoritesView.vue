<template>
    <div id="favorites">
        <favorites-feed/>
        <navigation-bar/>
    </div>
</template>

<script>
import FavoritesFeed from '../components/FavoritesFeed.vue'
import NavigationBar from '../components/NavigationBar.vue'

export default {
    components: {
        FavoritesFeed,
        NavigationBar
    },
    name: "FavoritesView"
}
</script>

<style>
#favorites{
    display: flex;
    justify-content: center;
}
</style>