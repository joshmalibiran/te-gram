<template>
  <div>
    <h1>UPLOAD YOUR PHOTO</h1>
      <form id="upload" @submit.prevent="submitForm">
        <label for="postPicture"> Post Link </label>
        <input
          type="text"
          v-model="post.postPicture"
          />
        <label for="caption"> Caption </label>
        <input
        type="text"
        placeholder="write your caption"
        v-model="post.caption"
        />
        <button type="submit">Submit</button>


      </form>
      <div v-if="formAddedFailure">{{ errorMessage }}</div>
  </div>
</template>

<script>
import postService from '../services/PostService'

// import {storage} from '../firebase/index'
// import { getStorage, ref, uploadBytes } from "firebase/storage";

export default {
  data() {
    return {
      post: {
        postPicture: '',
        caption: '',
        imageUrl:'',

      },
      errorMessage: '',
      formAddedFailure: false,
  }
    },
    methods: {
      submitForm() {
        //something
        postService.addPost(this.post).then( response => {
          this.$router.push('/');
          console.log(response.data);
          //router push to profile page
        })
        .catch((error) => {
        this.errorMessage = '';

        if (error.response) {
          if (error.response.status === 500) {
            this.errorMessage = "Error submitting form. An internal server error occurred.";
          } else if (error.response.status === 404) {
             this.errorMessage = "Error submitting form. URL could not be found.";
          } else {
             this.errorMessage = "Error submitting form. Response received was code " + error.response.status + " '" + error.response.statusText + "'.";
          }

        } else if (error.request) {
          this.errorMessage = "Error submitting form. Server could not be reached.";

        } else {
          this.errorMessage = "Error submitting form. Request could not be created.";
        }

        this.formAddedFailure = true;
      });
    },

    // onPickFile()  {
    //   this.$refs.fileInput.click();
    // },
    // onFilePicked(event)  {
    //   const files = event.target.files
    //   let fileName = files[0].name;
    //   if(fileName.lastIndexOf('.') <= 0)  {
    //     return alert('Invalid File')
    //   }
    //   const fileReader = new FileReader()
    //   fileReader.addEventListener('load', () => {
    //     this.imageUrl = fileReader.result;
    //   })
    //   fileReader.readAsDataURL(files[0])
    //   this.image = files[0]
    // }
  },
  // created()  {
  //   const storage = getStorage();
  //   const mountainImagesRef = ref(storage, '../images/bears.png');
  //   console.print(mountainImagesRef)

  //   uploadBytes(mountainImagesRef, null).then((snapshot) => {
  //     console.log('Uploaded')
  //     console.log(snapshot)
  //   })

  // }
}

</script>

<style scoped>
div {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100vh;
}
</style>