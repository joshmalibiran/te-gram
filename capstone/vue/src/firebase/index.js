
import { initializeApp } from "firebase/app";
import { getStorage } from "firebase/storage";

const firebaseConfig = {
  apiKey: "AIzaSyCMoTpt6QUhbCXuBRVfpsrT9sKAiCNRX04",
  authDomain: "te-gram.firebaseapp.com",
  projectId: "te-gram",
  storageBucket: "te-gram.appspot.com",
  messagingSenderId: "740136734300",
  appId: "1:740136734300:web:48b9776fab2747752ba099"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const storage = getStorage(app);

export  {
    storage
}