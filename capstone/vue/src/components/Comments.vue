<template>
  <div>
      <div id="commentListBox">
        <div v-for="comment in this.$store.state.post.commentsOnPost" v-bind:key="comment.id">
          <p id="comments">{{comment.username}}: {{comment.description}}</p>
        </div>
      </div>
      
      <form v-on:submit.prevent="postComment" id = "commentForm">
      <input id="commentInput" type="text" placeholder="Add a comment..." v-model="createdComment.description"/>
      <button type="submit" value ="Submit" >Post</button>
      </form>
  </div>
</template>

<script>
import postService from '../services/PostService'
import commentService from '../services/CommentService'

export default {
    name: 'comments',
    props:['postId'],
    data()  {
        return  {
            createdComment: {
                //ONLY WORKS HARDCODED RIGHT NOW
                post_id: this.postId,
                user_id: this.$store.state.user.id,
                description:''
            }
        }
    },
    created()   {
        postService.getPostById(this.$route.params.postId).then(response => {
            this.$store.commit("SET_COMMENTS", response.data)
            //console.log(this.post)
        })
    },
    methods:    {
        postComment()   {
            // this.createdComment.postId = this.$store.state.post.postId
            // this.createdComment.userId = 2
            commentService.createComment(this.createdComment).then(response =>   {
                if(response.status === 201) {
                    this.$router.go();
                }
            })
            .catch(error => {
                if(error.response || error.response.status === 404) {
                    alert(
                        "Error Commenting"
                    );
                }
            })

        }
    }
}
</script>

<style>
#comments{
    margin-left: 5px;
}
#commentListBox {
    max-height: 500px;
}
#commentInput{
    position: relative;
    margin-left: 3px;
    width: 348px;
}


</style>