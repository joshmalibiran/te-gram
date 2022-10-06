<template>
  <div id = "page">
      <h1 id = "editHeader">Edit Profile</h1>
      
      <div id = "userInfo">
      <img :src = "this.user.picture" id = "profilePic"/>
      <p>{{this.user.username}}</p>
      </div>
      <update-user-form/>
      <navigation-bar/>
      
  </div>
</template>

<script>
import updateUserForm from '../components/UpdateUserForm.vue'
import userService from '../services/UserService'
import navigationBar from '../components/NavigationBar.vue'

export default {
    components: { updateUserForm, navigationBar },
    name: 'UpdateUserPage',
    data()  {
        return{
            user:{}
        }
    },
    methods:    {
        getCurrentUser()    {
            userService.getCurrentUser().then(response =>   {
                this.user = response.data;
                
            })
        }
    },
    created()   {
        this.getCurrentUser()
    }
}   

</script>

<style>
#page   {
    display:flex;
    flex-direction: column;
    align-items: center;
}

#profilePic {
    border-radius: 50%;
    width: 70px;
    height:auto;
}

#userInfo   {
    display:flex;
}



#editHeader {
    text-align: center;
}

</style>