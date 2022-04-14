import axios from "axios";

export const getAll = () => {
    return axios.get(`/api/v1/doctors`);
  };
  
  export const save = (creds) => {
    return axios.post(`/api/v1/doctors`, creds);
};
  
export const getById = (id) => {
    return axios.get(`/api/v1/doctors/${id}`);
};

export const remove = (id) => {
    return axios.delete(`/api/v1/doctors/${id}`);
};