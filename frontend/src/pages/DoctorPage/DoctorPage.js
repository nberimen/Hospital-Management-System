import React, { useEffect, useState } from "react";
import png from "../../assets/doctor-home-page.png";
import { useSelector } from "react-redux";
import { FaUserCheck } from "react-icons/fa";
import { Link } from "react-router-dom";
import { getById } from "../../api/doctor/DoctorService";

const DoctorPage = () => {
  const { isLoggedIn, doctorId } = useSelector((store) => ({
    isLoggedIn: store.isLoggedIn,
    doctorId: store.id,
  }));
  const [doctor, setDoctor] = useState({});

  useEffect(() => {
    getDetails();
  }, [doctorId]);
  const getDetails = async () => {
    try {
      const result = await getById(doctorId);
      setDoctor(result.data.data);
    } catch (error) {}
  };

  const { firstName, lastName } = doctor;
  return (
    <>
      <section className="mt-5">
        <div className="container">
          <div className="pt-5">
            <div className="row">
              <div className="col-lg-5 p-5">
                <h1 className="display-4">
                  Hoş Geldiniz {firstName + " " + lastName}
                </h1>
              </div>

              <div
                className="col-lg-6 bg-white"
                style={{
                  borderTopLeftRadius: "5rem",
                  borderBottomRightRadius: "5rem",
                }}
              >
                <img className="mt-2 d-md-none d-none d-lg-block" src={png} />
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
                <Link className="nav-link" to="/add-appointment">
                  <span className="ms-3"> Hemen Randevu Al</span>
                </Link>
              </div>
            </div>
          </div>
        </div>
      </section>
    </>
  );
};

export default DoctorPage;
