import http from "../http-common";

class TutorialDataService {
  getAll() {
    return http.get("/tutorials");
  }

  get(id: Number) {
    return http.get(`/tutorials/${id}`);
  }

  create(data: String) {
    return http.post("/tutorials", data);
  }

  update(id: Number, data: String) {
    return http.put(`/tutorials/${id}`, data);
  }

  delete(id: Number) {
    return http.delete(`/tutorials/${id}`);
  }

  deleteAll() {
    return http.delete(`/tutorials`);
  }

  findByTitle(title: String) {
    return http.get(`/tutorials?title=${title}`);
  }
}

export default new TutorialDataService();
