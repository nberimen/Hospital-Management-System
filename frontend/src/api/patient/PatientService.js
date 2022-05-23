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

export const getAllPassiveByPatientId = (patientId) => {
  return axios.get(`/api/v1/appointments/patient/${patientId}/passive`);
};

export const getAllPrescription = (patientId) => {
  return axios.get(`/api/v1/prescriptions/${patientId}`);
};

export const getAllMeds = (prescriptionId) => {
  return axios.get(`/api/v1/meds/prescription/${prescriptionId}`);
};

export const getAllReports = (patientId) => {
  return axios.get(`/api/v1/reports/patient/${patientId}`);
};

export const getAllTests = (patientId) => {
  return axios.get(`/api/v1/tests/patient/${patientId}`);
};
