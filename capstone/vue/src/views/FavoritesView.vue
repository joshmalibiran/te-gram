<template>
    <div>
        <top-nav-bar id="Topnavbar"/>
        <h1 id="title">My Favorites</h1>
        <div id="favorites">
        <favorites-feed/>
        
        </div>
    </div>
</template>

<script>
import FavoritesFeed from '../components/FavoritesFeed.vue'
import TopNavBar from '../components/TopNavBar.vue'

export default {
    components: {
        FavoritesFeed,
        TopNavBar
    },
    name: "FavoritesView"
}
</script>

<style>
#favorites{
    display: flex;
    flex-direction: column;
    margin: 75px;
    
}
#Topnavbar{
    display: flex;
    align-items: center;
    border-radius: 60px;
    height: 100px;
}
#title{
    text-align: center;
}
  
</style>