<template>
  <div>
      <div v-for="post in this.$store.state.recentPosts" v-bind:key="post.postId" class = card>
      <SinglePost v-bind:post="post"/>
      </div>
  </div>
</template>

<script>
import SinglePost from '../components/Post.vue'
import postService from '../services/PostService';

export default {
    name:'post-feed',

    components: {
        SinglePost
    }
    ,
    methods:{
        retrieveRecentPosts(){
            postService.getRecentPost().then(response=>{
                //this.retrieveRecentPosts = response.data;
                // this.recentPost = response.data;
                this.$store.commit("SET_RECENT_POSTS", response.data)
            })
            .catch(error => {
            if (error.response && error.response.status === 404) {
            alert(
              "Feed not available."
            );
            this.$router.push({ name: 'Login' });
          }
        });
    }

    
    },

    created(){
            this.retrieveRecentPosts();
    }
}
</script>

<style>


</style>