<template>
  <div>
    <navigation-bar/>
    <div id = detailCard>
      <single-post v-bind:post="this.$store.state.post"/>
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
        postId:''
      }
    },
    components:  {
        singlePost,
        comments,
        NavigationBar  
    },
    created() {
      postService.getPostById(this.$route.params.postId).then(response => {
        this.postId = this.$route.params.postId
        console.log(response.data)
        this.post = response.data
        this.$store.commit("SET_CURRENT_POST", response.data)
      })
    }
}
</script>

<style>
#detailCard {
  display:flex;
  justify-content: center;
}

#commentBox {
  background-color:white;
  width:auto;
}

</style>