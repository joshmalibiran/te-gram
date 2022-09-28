<template>
    <div id="recentPosts" class="posts">
        <div v-for="(post,key) in this.$store.state.recentPosts" v-bind:key="key" class= "singlePost">
            <img :src="post.postPicture" id="picture"/>
            <div id = "btns">
            <button id="likeBtn">Like</button>
            <button id="favoriteBtn">Favorite</button>
            </div>
            <p>{{post.caption}}</p>
        </div>
    </div>
</template>

<script>
import postService from "../services/PostService";

export default {
  name: "feed",
  components: {},
  data() {
    return {
      recentPost: [],
      errorMsg: "",
    };
  },
  methods: {
    retrieveRecentPosts() {
      postService
        .getRecentPost()
        .then((response) => {
          this.retrieveRecentPosts = response.data;
          this.$store.commit("SET_RECENT_POSTS", response.data.post);
        })
        .catch((error) => {
          if (error.response && error.response.status === 404) {
            alert("Feed not available.");
            this.$router.push({ name: "Login" });
          }
        });
    },
  },
  created() {
    this.retrieveRecentPosts();
  },
};
</script>

<style scoped>

#btns   {
    width: 600px;
    display:flex;
    flex-direction: row;
    height:auto;
    justify-content:  space-between;
}

#picture    {
    height: auto;
    width:auto;
    max-height: 600px;
    max-width: 600px;
}

#likeBtn    {
    background-color:palevioletred;
}

#favoriteBtn    {
    background-color:gold;
}

.singlePost{
    padding-top: 7.5%;
    border-radius: 9%;
    background-color: lightgray;
    
    margin-bottom: 3%;
}
</style>