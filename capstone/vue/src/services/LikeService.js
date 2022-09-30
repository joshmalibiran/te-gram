import axios from 'axios';

export default{
    likePost(id){
        return axios.post(`/like/${id}`)
    },
    unLikePost(id) {
        return axios.delete(`/like/${id}`)
    },
    getIsLiked(id)  {
        return axios.get(`/isLiked/${id}`)
    }

}