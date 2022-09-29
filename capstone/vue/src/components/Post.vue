<template>
  <div>

      
      <div id = card>
        <img :src="post.postPicture" id="picture" />
        <div id = "btns">
            <button v-on:click="toggleLike($event)">Like</button>
            <button v-on:click="toggleFavorite($event)">Favorite</button>
        </div>
        <p>{{post.caption}}</p>
      </div>
    

  </div>
</template>

<script>
export default {
    name: 'single-post',
    props: ['post'],
    data()  {
        return{
            isLiked: false,
            isFavorited: false
        }
    },

    methods: {
        toggleLike(event)    {
            //CODE TO CHANGE SERVE / STATE
            if(this.isLiked)    {
                event.target.classList.remove('likeBtn')
            }
            else    {
                event.target.classList.add('likeBtn')
            }
            this.isLiked =!this.isLiked
           
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
    }
}
</script>

<style scoped>
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
    border: 10px solid black;
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