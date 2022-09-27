<template>
  <div id="registerView">
    <register-form/>
    <carousel/>
  </div>
</template>

<script>

import RegisterForm from "../components/RegisterForm.vue"
import Carousel from "../components/Carousel.vue"

export default {
  components: {
    RegisterForm,
    Carousel
  }
}
</script>

<style>
#registerView{
  display: flex;
  flex-direction: row;
}
</style>