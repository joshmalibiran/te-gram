import axios from 'axios';

export default{
    favoritePost(id){
        return axios.post(`/favorite/${id}`)
    },
    unFavoritePost(id) {
        return axios.delete(`/favorite/${id}`)
    },
    getIsFavorite(id)  {
        return axios.get(`/favorite/${id}`)
    }

}