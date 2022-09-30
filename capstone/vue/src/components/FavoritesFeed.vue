<template>
  <div>
      <div v-for="post in this.$store.state.favoritePosts" v-bind:key="post.postId" class = card>
      <SinglePost v-bind:post="post"/>
      </div>
  </div>
</template>

<script>
import SinglePost from '../components/Post.vue'
import favoriteService from '../services/FavoriteService';

export default {
    name:'favorites-feed',

    components: {
        SinglePost
    }
    ,
    methods:{
        retrieveFavoritePosts(){
            //pass userId into this method
            favoriteService.getFavoritePosts().then(response=>{
                this.$store.commit("SET_FAVORITE_POSTS", response.data)
            })
            .catch(error => {
            if (error.response && error.response.status === 404) {
            alert(
              "Favorites not available."
            );
          }
        });
    }

    
    },

    created(){
            this.retrieveFavoritePosts();
    }
}
</script>

<style>
#card {
  padding-bottom: 5%;
  margin-bottom: 5%;
}

</style>