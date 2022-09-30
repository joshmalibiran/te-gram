<template>
    <div id="favorites">
        <h1>This is our favorites Page!</h1>
        <favorites-feed/>
    </div>
</template>

<script>
import FavoritesFeed from '../components/FavoritesFeed.vue'

export default {
    components: {
        FavoritesFeed
    },
    name: "FavoritesView"
}
</script>

