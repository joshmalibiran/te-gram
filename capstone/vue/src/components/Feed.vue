<template>
    <div id="recentPosts" class="posts">
        <div v-for="post in $store.state.recentPosts" v-bind:key="post.postId">
            <img :src="post.postPicture"/>
        </div>
    </div>
</template>

<script>
import postService from '../services/PostService';

export default {
    name: "feed",
    components:{

    },
    data(){
        return{
            recentPost: [],
            errorMsg: ''
        };
    },
    methods:{
        retrieveRecentPosts(){
            postService.getRecentPost().then(response=>{
                this.retrieveRecentPosts = response.data;
                this.$store.commit("SET_RECENT_POSTS", response.data.post)
            })
            .catch(error => {
            if (error.response && error.response.status === 404) {
            alert(
              "Feed not available."
            );
            this.$router.push({ name: 'Login' });
          }
        });
    },
    created(){
        this.retrieveRecentPosts();
    }
}
}
</script>
