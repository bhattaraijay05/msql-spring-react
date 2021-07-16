import axios from "axios";

//THIS IS THE BASE OF THE URL
const instance = axios.create({
	baseURL: "http://localhost:8080/api",
});

export default instance;
