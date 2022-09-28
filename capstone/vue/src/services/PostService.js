import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000"
});

export default{
    getRecentPost(){
        return http.get('/post')
    },
    addPost(post) {
        return http.post('/post', post)
    }
}

