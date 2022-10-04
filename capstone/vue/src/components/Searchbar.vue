<template>
    <div>
        <form>
            <input type="text" id="search" placeholder="" value="Search" v-on="user in this.$store.state.user.username" v-bind:key="user.username" class = card>
            
        </form>
    </div>
    
</template>
<script>

import postService from '../services/PostService';

export default {
    name:'post-feed',

    methods:{
        retrieveRecentPostsByOneUser(){
            postService.getUserPostsFromUsername(this.$store.state.user.username).then(response=>{
                this.recentPost = response.data;
                this.$store.commit("SET_RECENT_POSTS", response.data)
            })
            }
    },
    created(){
            this.retrieveRecentPosts();
    }
}
</script>

<style>
.search-wrapper{
    display:flex;
    flex-direction: column;
    gap: .25rem;
}
input{
    font-size:1rem;
}
.user-profile{
    display:grid;
    grid-template-columns: repeat(auto-fill, min(150px, 1fr));
    gap: .25rem;
    margin-top: 1rem;
}
.card{
    boarder: 1px solid black;
    background-color: white;
    padding: .5rem;
}
.card > .header{
    margin-bottom: .25rem;
}
.hide{
    display: none;
}
</style>