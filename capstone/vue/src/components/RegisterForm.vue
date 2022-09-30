<template>
  <div id="register" class="text-center">
    <div>
      <form class="form-register" @submit.prevent="register">
        <h1 class="create">Create a free account!</h1>
        <div class="alert alert-danger" role="alert" v-if="registrationErrors">
          {{ registrationErrorMsg }}
        </div>
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
        <input
          type="password"
          id="confirmPassword"
          class="form-control"
          placeholder="Confirm Password"
          v-model="user.confirmPassword"
          required
        />
        <label for="email" class="sr-only">Email</label>
        <input
          type="email"
          id="email"
          class="form-control"
          placeholder="Email"
          v-model="user.email"
          required
        />
        <router-link :to="{ name: 'login' }">Have an account?</router-link>
        <button id="create-btn" class="btn btn-lg btn-primary btn-block" type="submit">
          Create Account
        </button>
      </form>
    </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
        email: "",
        picture: "",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style>
#register.text-center{
    display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  height: 100vh;
}
.form-register {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  margin-right: 100px;
}
.sr-only {
  font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  width: 155px;
  align-self: center;
}

#confirmPassword {
  margin-top: 5px;
}
.form-control{
  font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  align-self: center;
}
#create-btn{
  width: 165px;
  align-self: center;
  font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  border-radius: 10px;
}
</style>
