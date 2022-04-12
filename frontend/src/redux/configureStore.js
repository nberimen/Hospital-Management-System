import { createStore, applyMiddleware, compose } from "redux";
import authReducer from "./authReducer";
import SecureLS from "secure-ls";
import thunk from "redux-thunk";
import { setAuthorizationHeader } from "../api/auth/AuthService";

const secureLs = new SecureLS();

const getStateFromStorage = () => {
  const authState = secureLs.get("auth");
  let stateInLocalStorage = {
    isLoggedIn: false,
    identityNo: undefined,
    password: undefined,
  };
  if (authState) {
    return authState;
  }
  return stateInLocalStorage;
};

const updateStateInStorage = (newState) => {
  secureLs.set("auth", newState);
};

const configureStore = () => {
  const initialState = getStateFromStorage();
  setAuthorizationHeader(initialState);
  const composeEnhancers =
    window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;
  const store = createStore(
    authReducer,
    initialState,
    composeEnhancers(applyMiddleware(thunk))
  );

  store.subscribe(() => {
    updateStateInStorage(store.getState());
    setAuthorizationHeader(store.getState());
  });
  return store;
};
export default configureStore;
