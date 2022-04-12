import React from "react";
import { FaGithub, FaInstagram, FaLinkedin } from "react-icons/fa";

const Footer = () => {
  return (
    <footer className="text-center text-lg-start bg-light text-muted border-top py-4">
      <section className="">
        <div className="container text-center text-md-start">
          <div className="row">
            <div className="col-md-3 col-lg-6 col-xl-6 mx-auto ">
              <h6 className="text-uppercase fw-bold ">Hospital Management</h6>
            </div>

            <div className="col-md-3 col-lg-2 col-xl-2 mx-auto align-self-center ">
              <a
                className="text-reset"
                href="https://github.com/nberimen/"
                target="_blank"
                rel="noreferrer"
              >
                <FaGithub className="fs-2" />
              </a>
              <a
                className="text-reset"
                href="https://instagram.com/nberimen/"
                target="_blank"
                rel="noreferrer"
              >
                <FaInstagram className="fs-2 mx-2" />
              </a>
              <a
                className="text-reset"
                href="https://www.linkedin.com/in/necati-berimen-0324291a1/"
                target="_blank"
                rel="noreferrer"
              >
                <FaLinkedin className="fs-2" />
              </a>
            </div>
          </div>
        </div>
      </section>

      <div className="text-center">
        © 2022
        <span className="text-reset fw-bold"> nberimen</span>
      </div>
    </footer>
  );
};

export default Footer;
