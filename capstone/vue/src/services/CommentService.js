import axios from 'axios';

export default{
    createComment(comment){
        return axios.post(`/comment/${comment.post_id}`, comment)
    },

    deleteComment(commentId)    {
        return axios.delete(`/comment/${commentId}`)
    },
    getCommentsByPostId(postId) {
        return axios.get(`/comment/${postId}`)
    }



}