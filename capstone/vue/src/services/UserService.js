import axios from 'axios'

export default{
    getUsersByUsername(username){
    return axios.get(`/results/${username}`)
},

    updateUser(UpdateUser)  {
        return axios.put('/user', UpdateUser)
    },

    getCurrentUser()    {
        return axios.get('/user')
    },

    findByUsername(username) {
        return axios.get(`/user/${username}`);
    }


}