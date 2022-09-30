<template>
  <div>

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

export default {
    components:  {
        singlePost,
        comments  
    },
    created() {
      postService.getPostById(this.$route.params.postId).then(response => {
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
}

#commentBox {
  background-color:white;
  width:auto;
}

</style>