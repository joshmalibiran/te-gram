<template>
  <div>
      <div id = "card">
          <div id="picture">
          <router-link :to="{ name: 'details', params: { postId: post.postId}}">
        <img :src="post.postPicture"  />
        </router-link>
        </div>
        <div id = "btns">
            <button v-on:click="toggleLike()" id="like" :class=" isLikeClicked ? 'likeBtn': '' ">{{likes}}  Like  </button>
            <button v-on:click="toggleFavorite()" id="favorite" :class="isFavorited ? 'favoriteBtn': '' ">Favorite</button>
        </div>
        <div id = "info">  
        <p>{{post.username}}<b>:    </b>{{post.caption}}</p>
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
            isLikeClicked: this.post.liked,
            isFavorited: this.post.favorited,
            likes: this.post.numOfLikes
        }
    },

    methods: {
        toggleLike()    {
            //CODE TO CHANGE SERVE / STATE
            if(this.isLikeClicked)    {
                likeService.unLikePost(this.post.postId).then(response =>   {
                    if(response.status === 200) {
                        this.likes = this.likes - 1

                        this.isLikeClicked =!this.isLikeClicked
                    }
                })
                //catch?
            
            }
            else    {
                likeService.likePost(this.post.postId).then(response => {
                    if(response.status === 201) {
                        this.likes = this.likes + 1

                        this.isLikeClicked =!this.isLikeClicked
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
        toggleFavorite()   {
             //CODE TO CHANGE SERVE / STATE
            if(this.isFavorited)    {
                

                favoriteService.unfavoritePost(this.post.postId).then(response => {
                    if(response.status === 200) {
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

    created() {
        console.log(this.post);
    }
}
</script>

<style>
#info   {
    display: flex;
    flex-direction: row;
    margin-left: 5px;
    width: 400px;
    height: auto;
}
#info > p{
    width: auto;
}
#btns   {
    width: 100vw;
    display: flex;
    flex-direction: row;
    height: auto;
    justify-content: space-between;
}

#card{
    display: flex;
    flex-direction: column;
    border: 3px solid black;
    border-radius: 10px;
    box-shadow: 3px 6px powderblue;
    background-color: rgba(175, 227, 252, 0.867);
    width: 400px;
    height: 430px;
  padding: 10px 10px 20px 10px;
  border: 1px solid #BFBFBF;
  background-color: rgb(197, 241, 255);
  box-shadow: 10px 10px 5px #aaaaaa;
}

#picture    {
    display: flex;
    align-content: center;
    height: auto;
    width: auto;
}
#like{
    border-radius: 10px;
    width: 70px;
    margin-left: 5px;
}
#favorite{
    border-radius: 10px;
    width: 70px;
}
.likeBtn    {
    background-color:palevioletred;
}

.favoriteBtn    {
    background-color:gold;
}
</style>