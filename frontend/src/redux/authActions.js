import * as ACTIONS from "./Constants";
import { login, registerPatient } from "../api/auth/AuthService";
export const logoutSuccess = () => {
  return {
    type: ACTIONS.LOGOUT_SUCCESS,
  };
};

export const loginSuccess = (authState) => {
  return {
    type: ACTIONS.LOGIN_SUCCESS,
    payload: authState,
  };
};

export const loginHandler = (credentials) => {
  return async function (dispatch) {
    const response = await login(credentials);
    const authState = {
      ...response.data.data,
      password: credentials.password,
    };

    dispatch(loginSuccess(authState));
    return response;
  };
};

export const signupHandler = (user) => {
  return async function (dispatch) {
    const response = await registerPatient(user);
    await dispatch(loginHandler(user));
    return response;
  };
};
