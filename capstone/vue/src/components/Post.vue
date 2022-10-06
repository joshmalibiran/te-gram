<template>
  <div>
    <div id="card">
      <div id="userInfo">
          <img id="profilePic" :src="this.postAuthor.picture" />
          {{ post.username }}
          </div>
      <div id="picture">
        <router-link :to="{ name: 'details', params: { postId: post.postId } }">
          <img :src="post.postPicture" />
        </router-link>
      </div>
      <div id="btns">

        <button
          v-on:click="toggleLike()"
          id="like"
          :class="isLikeClicked ? 'likeBtn' : ''"
        >

          <div v-if="likes === 1">
          {{ likes }} Like
          </div>

          <div v-else>
          {{likes}} Likes
          </div>


        </button>


        <button
          v-on:click="toggleFavorite()"
          id="favorite"
          :class="isFavorited ? 'favoriteBtn' : ''"
        >
          Favorite
        </button>
      </div>
      <div id="info">
        <h4 id="username">{{ post.username }}<b>:</b></h4>
        <h5 id="caption">{{ post.caption }}</h5>
      </div>
    </div>
  </div>
</template>

<script>
import likeService from "../services/LikeService";
import favoriteService from "../services/FavoriteService";
import userService from '../services/UserService';

export default {
  name: "single-post",
  props: ["post"],
  data() {
    return {
      isLikeClicked: this.post.liked,
      isFavorited: this.post.favorited,
      likes: this.post.numOfLikes,
      postAuthor: {},
    };
  },

  methods: {
    toggleLike() {
      //CODE TO CHANGE SERVE / STATE
      if (this.isLikeClicked) {
        likeService.unLikePost(this.post.postId).then((response) => {
          if (response.status === 200) {
            this.likes = this.likes - 1;

            this.isLikeClicked = !this.isLikeClicked;
          }
        });
        //catch?
      } else {
        likeService
          .likePost(this.post.postId)
          .then((response) => {
            if (response.status === 201) {
              this.likes = this.likes + 1;

              this.isLikeClicked = !this.isLikeClicked;
            }
          })
          .catch((error) => {
            if (error.response || error.response.status === 404) {
              alert("Error Liking Post");
            }
          });
      }
    },
    toggleFavorite() {
      //CODE TO CHANGE SERVE / STATE
      if (this.isFavorited) {
        favoriteService
          .unfavoritePost(this.post.postId)
          .then((response) => {
            if (response.status === 200) {
              this.isFavorited = !this.isFavorited;
            }
          })
          .catch((error) => {
            if (error.response || error.response.status === 404) {
              alert("Error unfavoriting Post");
            }
          });
      } else {
        favoriteService
          .favoritePost(this.post.postId)
          .then((response) => {
            if (response.status === 201) {
              this.isFavorited = !this.isFavorited;
            }
          })
          .catch((error) => {
            if (error.response || error.response.status === 404) {
              alert("Error favoriting Post");
            }
          });
      }
    },
     getUser() {
            userService.findByUsername(this.post.username).then(response => {
                console.log(response.data);
                this.postAuthor = response.data;
            });
        }

  },

  created() {
    this.getUser();
  },
};
</script>

<style>
#info {
  display: flex;
  flex-direction: row;
  column-gap: 10px;
  margin-left: 5px;
  width: 400px;
  height: auto;
}
#info > p {
  width: auto;
}
#card {
  display: flex;
  flex-direction: column;
  border-radius: 10px;
  width: 400px;
  height: 400px;
  padding: 5px 5px 20px 5px;
  border: 1px solid #557992d0;
  background-color: rgb(197, 241, 255);
  box-shadow: 10px 10px 5px #7097b3af;
}
#userInfo {
  margin-left: 10px;
  height: 50px;
  position: relative;
}
#picture {
  display: flex;
  align-content: center;
  height: auto;
  width: auto;
}
#caption{
    color: rgb(63, 63, 63);
}
#btns {

}
#like, #favorite{
    border-radius: 10px;
    width: 70px;
    height: 25px;
}
.likeBtn {
  background-color: palevioletred;
}

.favoriteBtn {
  background-color: gold;
}
</style>