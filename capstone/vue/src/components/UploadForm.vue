<template>
  <div id="container">
    <img id="cohortpic" src="../images/background-cohortpic.png" />
    <h1 id="h1">UPLOAD YOUR PHOTO!</h1>
    <form id="upload" @submit.prevent="submitForm">
      <div id="form-container">
        <label id="link" for="postPicture"> Post Link </label>
        <input
          id="picInput"
          type="text"
          placeholder="paste image url"
          v-model="post.postPicture"
        />
        <label id="caption" for="caption"> Caption </label>
        <textarea
          id="captionInput"
          placeholder="write your caption"
          v-model="post.caption"
        ></textarea>
      </div>

      <button id="submitBtn" value="submit" type="submit">Upload</button>
    </form>
    <div v-if="formAddedFailure">{{ errorMessage }}</div>
  </div>
</template>

<script>
import postService from "../services/PostService";

// import {storage} from '../firebase/index'
// import { getStorage, ref, uploadBytes } from "firebase/storage";

export default {
  data() {
    return {
      post: {
        postPicture: "",
        caption: "",
        imageUrl: "",
      },
      errorMessage: "",
      formAddedFailure: false,
    };
  },
  methods: {
    submitForm() {
      //something
      postService
        .addPost(this.post)
        .then((response) => {
          this.$router.push("/");
          console.log(response.data);
          //router push to profile page
        })
        .catch((error) => {
          this.errorMessage = "";

          if (error.response) {
            if (error.response.status === 500) {
              this.errorMessage =
                "Error submitting form. An internal server error occurred.";
            } else if (error.response.status === 404) {
              this.errorMessage =
                "Error submitting form. URL could not be found.";
            } else {
              this.errorMessage =
                "Error submitting form. Response received was code " +
                error.response.status +
                " '" +
                error.response.statusText +
                "'.";
            }
          } else if (error.request) {
            this.errorMessage =
              "Error submitting form. Server could not be reached.";
          } else {
            this.errorMessage =
              "Error submitting form. Request could not be created.";
          }

          this.formAddedFailure = true;
        });
    },
  },
};
</script>

<style scoped>
#container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100vh;
  width: auto;
}
#h1{
  position: relative;
  color: black;
  font-size: 30px;
}
#upload {
  display: flex;
  position: relative;
  flex-direction: column;
  width: 350px;
}
#picInput,
#captionInput {
  border-radius: 10px;
  border: 1px solid black;
}
#captionInput {
  display: flex;
  height: 90px;
  width: 345px;
  justify-content: flex-start;
  align-items: flex-start;
  resize: none;
  font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}
#picInput {
  height: 25px;
}
#form-container {
  display: flex;
  flex-direction: column;
}
#submitBtn {
  border-radius: 10px;
  border: 1px solid black;
  width: 70px;
  align-self: center;
  margin-top: 10px;
}
#cohortpic{
  position: absolute;
  align-self: center;
  height: 600px;
  width: 1000px;
  opacity: 0.3;
  border-radius: 5px;
}
</style>