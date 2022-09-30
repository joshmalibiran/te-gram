<template>
  <div>

      <router-link :to="{ name: 'details'}">
      <div id = card>
        <img :src="post.postPicture" id="picture" />
        <div id = "btns">
            <button v-on:click="toggleLike($event)" id="like">Like</button>
            <button v-on:click="toggleFavorite($event)">Favorite</button>
        </div>
        <div id = "info"> 
        <p>{{likes}} Likes</p>   
        <p>{{post.username}}</p>
        <p>{{post.caption}}</p>
        </div>
      </div>
      </router-link>


  </div>
</template>

<script>
import likeService from '../services/LikeService'

export default {
    name: 'single-post',
    props: ['post'],
    data()  {
        return{
            isLiked:'',
            isFavorited: false,
            likes: this.post.numOfLikes

        }
    },

    methods: {
        toggleLike(event)    {
            //CODE TO CHANGE SERVE / STATE
            if(this.isLiked)    {
                likeService.unLikePost(this.post.postId).then(response =>   {
                    if(response.status === 200) {
                        console.log("RMEOVED")
                        this.likes = this.likes - 1
                        event.target.classList.remove('likeBtn')
                        this.isLiked =!this.isLiked
                    }
                })
                //catch?
            
            }
            else    {
                likeService.likePost(this.post.postId).then(response => {
                    if(response.status === 201) {
                        this.likes = this.likes + 1
                        event.target.classList.add('likeBtn')
                        this.isLiked =!this.isLiked
                    }
                })
                .catch(error => {
                if(error.response || error.response.status === 404) {
                    alert(
                        "Error Liking Post"
                    );
                }
                })
            
            }
    
           
        },
        toggleFavorite(event)   {
             //CODE TO CHANGE SERVE / STATE
            if(this.isFavorited)    {
                event.target.classList.remove('favoriteBtn')
            }
            else{
                event.target.classList.add('favoriteBtn')
            }
            this.isFavorited = !this.isFavorited
        }
    },

    created()   {
        //set isLiked to true or false depending on if is liked on database
        likeService.getIsLiked(this.post.postId).then(response =>   {
            //console.log(response.data)
            this.isLiked = response.data

            if(this.isLiked)    {
                //NOT WORKING?
                console.log("TEST----")
                let element = document.getElementById("like")
                element.classList.add('likeBtn')
            }
        })
        //add catch?
    }
}
</script>

<style scoped>
#info   {
    display: flex;
    flex-direction: column;
    
}

#btns   {
    width: 600px;
    display:flex;
    flex-direction: row;
    height:auto;
    justify-content:  space-between;
}

#card{
    display: flex;
    flex-direction: column;
    justify-content: center;
    border: 5px solid black;
    background-color: rgba(96, 193, 238, 0.867);
}

#picture    {
    height: auto;
    width:auto;
    max-height: 600px;
    max-width: 600px;
}

.likeBtn    {
    background-color:palevioletred;
}

.favoriteBtn    {
    background-color:gold;
}
</style>