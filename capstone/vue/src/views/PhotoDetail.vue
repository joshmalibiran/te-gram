<template>
  <div id="container">
    <navigation-bar/>
    <div id = "detailCard">
      <single-post v-bind:post="this.$store.state.post" v-if="postExists"/>
      <div id = commentBox>
      <comments v-bind:postId="this.$route.params.postId"/>
      </div>

    </div> 

  </div>
</template>

<script>
import singlePost from '../components/Post.vue';
import postService from '../services/PostService'
import comments from '../components/Comments.vue'
import NavigationBar from '../components/NavigationBar.vue';

export default {
    data()  {
      return{
        postExists: null,
        postId:'',
      }
    },
    components:  {
        singlePost,
        comments,
        NavigationBar  
    },
    methods: {
      retrievePost() {
        postService.getPostById(this.$route.params.postId).then(response => {
        this.postId = this.$route.params.postId
        console.log(response.data)

        // this.post = response.data
        this.$store.commit("SET_CURRENT_POST", response.data)
        this.postExists = true;

        console.log('store state post');
      console.log(this.$store.state.post);
      })
      }
    },
    // computed: {
    //   post() {
    //     return this.$store.state.post;
    //   }
    // },
    created() {
      this.retrievePost();
      
    },
}
</script>

<style>
#container{
  display: flex;
  justify-content: center;
  height: 100vh;
}
#detailCard {
  justify-content: center; 
  height: 400px; 
}

#commentBox {
  background-color:white;
  width:auto;
  height: 300px;
  overflow-y: scroll;
}

</style>