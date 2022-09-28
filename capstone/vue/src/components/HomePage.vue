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
  flex-direction: row;;
}
#panel{
    display: flex;
    flex-direction: column;
    flex-grow: 2;
    align-items: flex-start;
    background: rgb(203, 236, 252);
    height: 100vh;
}
#post{
    display: flex;
    flex-direction: column;
    flex-grow: 4;
    align-items: center;
}
#userInfo{
    display: flex;
    flex-grow: 2;
    flex-direction: column;
    align-items: center;
    justify-content: flex-start;
    background: rgb(203, 236, 252);
}
#userInfo>img{
    justify-content: center;
    align-items: center;
    height: 100px;
    width: 150px;
}
</style>

