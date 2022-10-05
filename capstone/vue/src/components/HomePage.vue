<template>
  <div class="Homepage">
    <div id="feed-header">
      <h1>Feed</h1>
    </div>
      <div id="post">
      <post-feed />
    </div>
    <div id="userInfo"></div>
  </div>
</template>

<script>
import PostFeed from "../components/PostFeed";

export default {
  components: {
    PostFeed,
  },
};
</script>

<style>
#post {
  order: 2;
  display: flex;
  flex-direction: column;
  align-items: center;
}
#feed-header{
    display: flex;
    background-color: rgb(207, 234, 255);
    justify-content: center;
}

</style>

