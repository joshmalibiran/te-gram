import axios from 'axios';

export default{
    favoritePost(id){
        return axios.post(`/favorite/${id}`)
    },
    unfavoritePost(id) {
        return axios.delete(`/favorite/${id}`)
    },
    getIsFavorite(id)  {
        return axios.get(`/favorite/${id}`)
    },
    getFavoritePosts() {
        return axios.get('/favorite');
    }

}