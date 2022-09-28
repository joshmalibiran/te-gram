<template>
    <div class="Homepage">
        <sidebar id="panel">
            <router-link v-bind:to="{ name: 'home' }">TE Gram</router-link>&nbsp;&nbsp;
            <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
        </sidebar>
        <div id="post">
            <img  src="../images/cat.png"/>
            <h4>Caption</h4>
            <p>Comments Here</p>

            <img  src="../images/oceanpic.jpg"/>
            <h4>Caption</h4>
            <p>Comments Here</p>
        </div>
        <div id="userInfo">
            <p>username</p>
            <img src="../images/default.jpg"/>
        </div>
    </div>
    
</template>

<script>

</script>

<style>
.Homepage{
  display: flex;
  flex-direction: row;

}
#panel{
    display: flex;
    flex-direction: column;
    flex-grow: 2;
    align-items: flex-start;
    background: rgb(203, 236, 252);
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
    background: rgb(203, 236, 252);
}
#userInfo>img{
    justify-content: center;
    align-items: center;
    height: 100px;
    width: 150px;
}
</style>

