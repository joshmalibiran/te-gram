<template>
  <div>

      
      <div id = card>
          <router-link :to="{ name: 'details', params: { postId: post.postId}}">
        <img :src="post.postPicture" id="picture" />
        </router-link>
        <div id = "btns">
            <button v-on:click="toggleLike($event)" id="like">Like</button>
            <button v-on:click="toggleFavorite($event)">Favorite</button>
        </div>
        <div id = "info"> 
        <p>{{likes}} Likes</p>   
        <p><b>{{post.username}}</b> {{post.caption}}</p>
        </div>
      </div>


  </div>
</template>

<script>
import likeService from '../services/LikeService'
import favoriteService from '../services/FavoriteService'

export default {
    name: 'single-post',
    props: ['post'],
    data()  {
        return{ 
            isLiked: false,
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
                

                favoriteService.unfavoritePost(this.post.postId).then(response => {
                    if(response.status === 200) {
                        event.target.classList.remove('favoriteBtn');
                        this.isFavorited = !this.isFavorited;
                    }
                }).catch(error => {
                if(error.response || error.response.status === 404) {
                    alert(
                        "Error unfavoriting Post"
                    );
                }
                })
            }
            else{
                
                favoriteService.favoritePost(this.post.postId).then(response => {
                    if(response.status === 201) {
                        event.target.classList.add('favoriteBtn')
                        this.isFavorited = !this.isFavorited;
                    }
                }).catch(error => {
                if(error.response || error.response.status === 404) {
                    alert(
                        "Error favoriting Post"
                    );
                }
                })
            }
            
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

<style>
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