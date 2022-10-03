<template>
  <div class="Homepage">
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

</style>

