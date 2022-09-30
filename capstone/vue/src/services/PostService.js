import axios from 'axios';

export default{
    getRecentPost(){
        return axios.get('/post')
    },
    addPost(post) {
        return axios.post('/post', post)
    },
    getUserPostsFromUsername(username) {
        return axios.get(`/profile/${username}`)
    }
}

