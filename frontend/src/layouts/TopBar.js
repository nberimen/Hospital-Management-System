import React, { useState } from "react";
import { Link } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { logoutSuccess } from "../redux/authActions";
import * as FaIcons from "react-icons/fa";
import * as AiIcons from "react-icons/ai";
import { SidebarDataAdmin, SidebarDataDoctor, SidebarDataPatient } from "../components/SidebarData";
import * as ROLE from "../shared/ConstantsRole";
import "./TopBar.css";
import { IconContext } from "react-icons";

const TopBar = (props) => {
  const [sidebar, setSidebar] = useState(false);
  const { isLoggedIn, role } = useSelector((store) => ({
    isLoggedIn: store.isLoggedIn,
    role: store.role,
  }));
  const dispatch = useDispatch();
  const onLogoutSuccess = () => {
    dispatch(logoutSuccess());
  };
  const showSidebar = () => setSidebar(!sidebar);

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
    <IconContext.Provider value={{ color: "fff" }}>
      <div className="shadow-sm bg-primary mb-2">
        {isLoggedIn && (
          <Link to="#" className="menu-bars">
            <FaIcons.FaBars onClick={showSidebar} />
          </Link>
        )}
        <nav className="navbar navbar-dark navbar-expand container">
          <div className="container-fluid">
            <Link className="navbar-brand" to="/">
              Hospital Management
            </Link>
            {links}
          </div>
        </nav>

        <nav className={sidebar ? "nav-menu active" : "nav-menu"}>
          <ul className="nav-menu-items" onClick={showSidebar}>
            <li className="navbar-toggle">
              <Link to="#" className="menu-bars">
                <AiIcons.AiOutlineClose />
              </Link>
            </li>
            {role == ROLE.ADMIN &&
              SidebarDataAdmin.map((item, index) => {
                return (
                  <li key={index} className={item.cName}>
                    <Link to={item.path}>
                      {item.icon}
                      <span>{item.title}</span>
                    </Link>
                  </li>
                );
              })}
            {role == ROLE.PATIENT &&
              SidebarDataPatient.map((item, index) => {
                return (
                  <li key={index} className={item.cName}>
                    <Link to={item.path}>
                      {item.icon}
                      <span>{item.title}</span>
                    </Link>
                  </li>
                );
              })}
            {role == ROLE.DOCTOR &&
              SidebarDataDoctor.map((item, index) => {
                return (
                  <li key={index} className={item.cName}>
                    <Link to={item.path}>
                      {item.icon}
                      <span>{item.title}</span>
                    </Link>
                  </li>
                );
              })}
          </ul>
        </nav>
      </div>
    </IconContext.Provider>
  );
};

export default TopBar;
