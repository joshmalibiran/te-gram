<template>
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="welcome-message">
        Welcome to TE Gram!
      </h1>
      <h2>Please Sign In!</h2>
      <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >
        Thank you for registering, please sign in.
      </div>
      <div id="login-box">
        <label for="username" class="sr-only">Username</label>
        <input
          type="text"
          id="username"
          class="form-control"
          placeholder="Username"
          v-model="user.username"
          required
          autofocus
        />
        <label for="password" class="sr-only">Password</label>
        <input
          type="password"
          id="password"
          class="form-control"
          placeholder="Password"
          v-model="user.password"
          required
        />
        <button id="submit" type="submit">Sign in</button>
      </div>
        <router-link id="register-link" :to="{ name: 'register' }">Don't have an account?</router-link>
    </form>
    <carousel id="carousel" />
  </div>
</template>

<script>
import authService from "../services/AuthService";
import Carousel from "../components/Carousel.vue";

export default {
  name: "login",
  components: {
    Carousel,
  },
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>
<style>
#login.text-center {
  margin-left: 100px;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  height: 100vh;
}
.form-signin {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
}
.sr-only {
  padding: 3px;
  font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
}
a {
  padding: 10px;
  text-align: center;
}
button {
  margin: 1px;
  margin-top: 8px;
}
#carousel {
  display: flex;
  margin-left: 100px;
}
.form-control {
  width: 151px;
  height: 25px;
  border: none;
  border-radius: 10px;
}
#submit {
  width: 155px;
  border-radius: 10px;
  margin-left: 3px;
  font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  border: 1px solid black;
}
#login-box{
  display: flex;
  flex-direction: column;
  width: 165px;
  margin-left: 75px;
  font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
}
h2{
  text-align: center;
  color: rgb(7, 125, 194);
  font-size: 30px;
  /* -webkit-text-stroke: .05px white; */
}
.welcome-message{
  text-align: center;
  color: rgb(7, 125, 194);
}
#register-link{
  font-size: 15px;
  margin-right: 15px;
  font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
}
</style>