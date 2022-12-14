import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    recentPosts: [],
    commentsOnPost:[],
    favoritePosts: [],
    currentProfilePosts: [],

    token: currentToken || '',
    user: currentUser || {},
    post: {
      user: '',
      caption: '',
      image: '',
      commentSection: '',
      datePosted: '',
      postId:'',
      numOfLikes:'',
    }
  },
  mutations: {
    SET_COMMENTS(state, data){
      state.commentsOnPost = data;
    },
    SET_RECENT_POSTS(state, data){
      state.recentPosts = data;
    },
    SET_CURRENT_POST(state, data){
      state.post = data;
    },
    SET_FAVORITE_POSTS(state, data){
      state.favoritePosts = data;
    },
    SET_CURRENT_PROFILE_POSTS(state, data){
      state.currentProfilePosts = data;
    },
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    }
  }
})
