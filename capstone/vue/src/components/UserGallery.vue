<template>
  <div>
      <h1>{{ this.username }}</h1>
      <div v-for="post in this.$store.state.currentProfilePosts" v-bind:key="post.postId">
          <SinglePost :post="post"/>
      </div>
    </div>
</template>

<script>
import SinglePost from '../components/Post.vue';
import postService from '../services/PostService';

export default {
    name: "UserGallery",
    components: {
        SinglePost,
    },
    data(){
        return {
            username: this.$route.params.username,
        }
    },
    methods:{
        retrieveProfilePosts(){
            postService.getUserPostsFromUsername(this.username).then(response => {
                this.$store.commit("SET_CURRENT_PROFILE_POSTS", response.data);
            })
            .catch(error => {
            if (error.response && error.response.status === 404) {
            alert(
              "Feed not available."
            );
          }
        });
        },
    },
    created() {
        this.retrieveProfilePosts();
    }

}
</script>

<style>

</style>