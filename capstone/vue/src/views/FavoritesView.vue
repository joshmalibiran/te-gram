<template>
    <div id="favorites">
        <favorites-feed/>
        <h1>This is our favorites Page!</h1>
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

