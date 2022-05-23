import axios from "axios";

export const getAllCity = () => {
    return axios.get(`/api/v1/cities`);
};
  
export const getAllHospitalByCityId = (cityId) => {
    return axios.get(`/api/v1/hospitals/city/${cityId}`);
};
export const getAllDepartmentsByHospitalId = (hospitalId) => {
    return axios.get(`/api/v1/departments/hospital/${hospitalId}`);
};
export const getAllDoctorByDepartmentId = (departmentId) => {
    return axios.get(`/api/v1/doctors/department/${departmentId}`);
};

export const deleteAppointmentById = (appointmentId) => {
    return axios.delete(`/api/v1/appointments/${appointmentId}`);
  };
  
