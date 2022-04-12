import React from "react";
import { Link } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { logoutSuccess } from "../redux/authActions";
const TopBar = (props) => {
  const { isLoggedIn } = useSelector((store) => ({
    isLoggedIn: store.isLoggedIn,
  }));
  const dispatch = useDispatch();
  const onLogoutSuccess = () => {
    dispatch(logoutSuccess());
  };

  let links = (
    <div className="collapse navbar-collapse">
      <ul className="navbar-nav ms-auto my-2 my-lg-0 navbar-nav-scroll">
        <li className="nav-item">
          <Link className="nav-link" to="/login">
            Login
          </Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link" to="/signup">
            Sign Up
          </Link>
        </li>
      </ul>
    </div>
  );
  if (isLoggedIn) {
    links = (
      <div className="d-flex">
        <ul className="navbar-nav ms-auto my-2 my-lg-0 navbar-nav-scroll">
          <li className="nav-link">
            <span
              className="text-light me-2"
              onClick={onLogoutSuccess}
              style={{ cursor: "pointer" }}
            >
              Logout
            </span>
            {
              //<span className="material-icons text-light ms-2">logout</span>
            }
          </li>
        </ul>
      </div>
    );
  }
  return (
    <div className="shadow-sm bg-primary mb-2">
      <nav className="navbar navbar-dark navbar-expand container">
        <div className="container-fluid">
          <Link className="navbar-brand" to="/">
            Hospital Management
          </Link>
          {links}
        </div>
      </nav>
    </div>
  );
};

export default TopBar;
