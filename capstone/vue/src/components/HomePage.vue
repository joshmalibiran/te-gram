<template>
    <div class="Homepage">
        <sidebar id="panel">
            <router-link v-bind:to="{ name: 'home' }">TE Gram</router-link>&nbsp;&nbsp;
            <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
            <router-link v-bind:to="{name: 'upload'}" v-if="$store.state.token != ''">Upload Photo</router-link>
        </sidebar>
        <div id="post">
            <feed/>
        </div>
        <div id="userInfo">
            <p>username</p>
            <img src="../images/default.jpg"/>
        </div>
    </div>
    
</template>

<script>
import feed from "../components/Feed.vue"

export default{
    components:{
        feed
    }
}

</script>

<style>

.Homepage{
  display: flex;
  flex-direction: row;
  column-gap: 150px;
  
}
#panel{
    order: 1;
    height: 100%;
    display: flex;
    flex-direction: column;
  
    align-items: flex-start;
    background: rgb(255, 255, 255);
}
#post{
    margin-top: 100%;
    order: 2;
    display: flex;
    flex-direction: column;
    
    align-items: center;
    
} 
#userInfo{
    order: 3;
    justify-content: flex-start;
    display: flex;
    
    flex-direction: column;
    align-items: center;
    background: rgb(255, 255, 255);
}
#userInfo>img{
    justify-content: center;
    align-items: center;
    height: 100px;
    width: 150px;
}
</style>

