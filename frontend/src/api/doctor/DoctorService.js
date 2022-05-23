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

export const getAllPassiveByDoctorId = (doctorId) => {
  return axios.get(`/api/v1/appointments/doctor/${doctorId}/passive`);
};
export const getAllActiveByDoctorId = (doctorId) => {
  return axios.get(`/api/v1/appointments/doctor/${doctorId}/active`);
};

export const getAllByDoctorId = (doctorId) => {
  return axios.get(`/api/v1/appointments/doctor/${doctorId}`);
};

export const addTest = (creds) => {
  return axios.post(`/api/v1/tests`, creds);
};

export const addReport = (creds) => {
  return axios.post(`/api/v1/reports`, creds);
};

export const appointmentSetPassive = (appointmentId) => {
  return axios.patch(`/api/v1/appointments/cancel/${appointmentId}`);
};
