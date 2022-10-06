<template>
<div>
    <top-nav-bar id="Topnavbar"/>
    <UploadForm/>
    
</div>
</template>

<script>
import TopNavBar from '../components/TopNavBar.vue';
import UploadForm from '../components/UploadForm.vue';

export default {
    components: {
        UploadForm,
        TopNavBar
    }

}
</script>

<style>
#Topnavbar{
    display: flex;
    align-items: center;
    border-radius: 60px;
    height: 100px;
}
</style>