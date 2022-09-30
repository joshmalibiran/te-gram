<template>
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Welcome to TE Gram!<br>Please Sign In</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
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
      <button type="submit">Sign in</button>
      <router-link :to="{ name: 'register' }">Need an account?</router-link>
    </form>
    <carousel id="carousel"/>
  </div>
</template>

<script>
import authService from "../services/AuthService";
import Carousel from "../components/Carousel.vue"

export default {
  name: "login",
  components: {
    Carousel,
  },
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>
<style>
#login.text-center{
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  height: 100vh;
}
.form-signin{
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  margin-right: 100px;
}
.sr-only{
  padding: 3px;

}
a{
  padding: 10px;
  text-align: center;
}
button{
  margin: 1px;
  margin-top: 8px;
}
#carousel{
  display: flex;
  margin-left: 100px;
}

</style>