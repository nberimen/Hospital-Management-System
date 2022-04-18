import axios from "axios";

export const getAll = () => {
  return axios.get(`/api/v1/patients`);
};

export const save = (creds) => {
  return axios.post(`/api/v1/patients`, creds);
};

export const getById = (id) => {
  return axios.get(`/api/v1/patients/${id}`);
};

export const remove = (id) => {
  return axios.delete(`/api/v1/patients/${id}`);
};

export const createAppointment = (body) => {
  return axios.post(`/api/v1/appointments`, body);
};
export const getAllByDoctorIdAndPatientId = (patientId, doctorId) => {
  return axios.get(`/api/v1/appointments/active/${patientId}/${doctorId}`);
};
export const getAllByPatientId = (patientId) => {
  return axios.get(`/api/v1/appointments/patient/${patientId}`);
};
