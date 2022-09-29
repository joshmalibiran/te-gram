<template>
  <div>
    <img :src="post.postPicture" id="picture" />
    <div id = "btns">
    <button id="likeBtn">Like</button>
    <button id="favoriteBtn">Favorite</button>
    </div>
    <p>{{post.caption}}</p>
  </div>
</template>

<script>
export default {
    name: 'single-post',
    props: ['post']
}
</script>

<style>
#btns   {
    width: 600px;
    display:flex;
    flex-direction: row;
    height:auto;
    justify-content:  space-between;
}

#picture    {
    height: auto;
    width:auto;
    max-height: 600px;
    max-width: 600px;
}

#likeBtn    {
    background-color:palevioletred;
}

#favoriteBtn    {
    background-color:gold;
}
</style>