<template>
  <div>
      
      <form id = "updateUserForm" @submit.prevent="updateUser">

        <label for="usernameInput">Username</label>
        <input class="inputBox" type = "text" id = "usernameInput" v-model="user.username" required/>
        <label for="passwordInput">Password</label>
        <input class="inputBox" type = "text" id = "passwordInput" v-model="user.password" required/>
        <label for="confirmPasswordInput"> Confirm Password</label>
        <input class="inputBox" type = "text" id = "confirmPasswordInput" v-model="confirmPassword" required/>
        <label for="emailInput">Email</label>
        <input class="inputBox" type = "text" id = "emailInput" v-model="user.email" required/>
        <label for="pictureInput">Picture</label>
        <input class="inputBox" type = "text" id = "pictureInput" v-model="user.picture" required/>
        <input type = "submit" id = "Submit"/>

      </form>
  </div>
</template>

<script>
import userService from '../services/UserService'

export default {
    data()  {
        return  {
            confirmPassword: '',
            user:   {
                username: '',
                password:'',
                email:'',
                picture:''
            }
        }
    },
    methods:    {
        updateUser()    {
            if(this.user.password === this.confirmPassword) {
            userService.updateUser(this.user).then(response =>  {
                console.log(response)
                this.$router.push({name: 'logout'})
                //SUCCESS
            })
            .catch(error => {
                console.log(error)
            })
            }
            else{
                alert("Passwords Don't Match")

                // const input = document.getElementById("confirmPasswordInput")
                // input.setCustomValidity("Passwords Don't Match")
            }
        },

        getCurrentUser()    {
            userService.getCurrentUser().then(response =>   {
                this.user = response.data;
                
            })
        }


    },
    created()    {
        this.getCurrentUser()
    }
}
</script>

<style>

#updateUserForm {
    display: flex;
    flex-direction: column;
    width: 100%;
}
#pictureInput{
    margin-bottom: 5px;
}
.inputBox{
    border-radius: 10px;
    height: 25px;
    width: 200px;
    border: 1px solid black;
}
#Submit{
    border-radius: 10px;
    border: 1px solid black;
    width: 70px;
    align-self: center;
}
</style>