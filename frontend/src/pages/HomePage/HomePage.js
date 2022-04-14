import React from "react";
import { FaUserCheck } from "react-icons/fa";
import { Link } from "react-router-dom";
import png from "../../assets/17-825x510.jpg";

const HomePage = () => {
  return (
    <>
      <section className="mt-5">
        <div className="container">
          <div className="pt-5">
            <div className="row">
              <div className="col-lg-5 p-5">
                <h1 className="fw-bold" style={{ marginTop: "5rem" }}>
                  Hoş Geldiniz
                </h1>
              </div>

              <div
                className="col-lg-6 bg-white"
                style={{
                  borderTopLeftRadius: "5rem",
                  borderBottomRightRadius: "5rem",
                }}
              >
                <img
                  className="mt-2 d-md-none d-none d-lg-block"
                  src={png}
                />
              </div>
            </div>
          </div>
        </div>
      </section>

      <section className="apply-steps">
        <div className="container">
          <div className="row">
            <div className="col-lg-4">
              <div>
                <FaUserCheck className="large-icon" />
                <Link className="nav-link" to="/signup">
                  <span className="ms-3"> Hemen Kayıt Ol</span>
                </Link>
              </div>
            </div>
          </div>
        </div>
      </section>
    </>
  );
};

export default HomePage;
