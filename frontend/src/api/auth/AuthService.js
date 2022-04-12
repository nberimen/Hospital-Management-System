import axios from "axios";

export const registerPatient = (body) => {
  return axios.post("/auth/registerPatient", body);
};

export const login = (creds) => {
  return axios.post("/auth/login", creds);
};

export const setAuthorizationHeader = ({
    isLoggedIn,
    token
}) => {
  if (isLoggedIn) {
    axios.defaults.headers["Authorization"] = token;
  } else {
    delete axios.defaults.headers["Authorization"];
  }
};
