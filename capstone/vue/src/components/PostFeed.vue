<template>
  <div >
      <div v-for="post in this.$store.state.recentPosts" v-bind:key="post.postId" class = card> 
      <SinglePost v-bind:post="post" v-if="postExists"/>
      </div>
  </div>
</template>

<script>
import SinglePost from '../components/Post.vue'
import postService from '../services/PostService';

export default {
    name:'post-feed',
    data()  {
      return{
        postExists: null
      }
    },

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
                this.postExists = true;
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

    mounted(){
            this.retrieveRecentPosts();
    }
}
</script>
