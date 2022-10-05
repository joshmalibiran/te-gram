<template>
    <div>
        <div class="header-favorites">
            <h1>My Favorites</h1>
        </div>
        <div id="favorites">
        <favorites-feed/>
        <navigation-bar/>
        </div>
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
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    column-gap: 5px;
    
}
.header-favorites{
    background-color: rgb(207, 234, 255);
    text-align: center;
}

  
</style>