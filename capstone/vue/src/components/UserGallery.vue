<template>
  <div>
    <!-- <div id="profileHeader">
    <h1 id="username">{{ this.username }}'s Profile</h1>
      </div> -->
      <div id="userPosts">
      <div
        v-for="post in this.$store.state.currentProfilePosts"
        v-bind:key="post.postId"
      >
        <SinglePost :post="post" v-if="postExists"/>
      </div>
    </div>
  </div>
</template>

<script>
import SinglePost from "../components/Post.vue";
import postService from "../services/PostService";

export default {
  name: "UserGallery",
  components: {
    SinglePost,
  },
  data() {
    return {
      username: this.$route.params.username,
      postExists: null
    };
  },
  methods: {
    retrieveProfilePosts() {
      postService
        .getUserPostsFromUsername(this.username)
        .then((response) => {
          this.$store.commit("SET_CURRENT_PROFILE_POSTS", response.data);
          this.postExists = true
        })
        .catch((error) => {
          if (error.response && error.response.status === 404) {
            alert("Feed not available.");
          }
        });
    },
  },
  created() {
    this.retrieveProfilePosts();
  },
};
</script>

<style>
#username {
  text-align: center;
}
#userPosts {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  column-gap: 5px;
}
/* #profileHeader{
    background-color: rgb(207, 234, 255);
} */
</style>