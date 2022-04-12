import axios from "axios";

//*********************DOCTOR***********************/
export const getAllDoctor = () => {
    return axios.get(`/api/v1/admins/find-all-doctor`);
  };
  
  export const saveDoctor = (creds) => {
    return axios.post(`/api/v1/admins/save-doctor`, creds);
};
  
export const deleteDoctor = (id) => {
    return axios.delete(`/api/v1/admins/delete-doctor/${id}`);
};
  

//*********************PATIENT***********************/
export const getAllPatient = () => {
    return axios.get(`/api/v1/admins/find-all-patient`);
  };
  
  export const savePatient = (creds) => {
    return axios.post(`/api/v1/admins/save-patient`, creds);
};
  
export const deletePatient = (id) => {
    return axios.delete(`/api/v1/admins/delete-patient/${id}`);
};
  

//*********************APPOINTMENT***********************/
export const getAllAppointment = () => {
    return axios.get(`/api/v1/admins/find-all-appointment`);
  };
  
 
  
export const deleteAppointment = (id) => {
    return axios.delete(`/api/v1/admins/delete-appointment/${id}`);
  };