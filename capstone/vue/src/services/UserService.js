import axios from 'axios'

export default{
    getUsersByUsername(username){
    return axios.get(`/results/${username}`)
},
}