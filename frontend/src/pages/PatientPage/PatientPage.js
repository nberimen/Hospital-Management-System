import React, { useEffect, useState } from "react";
import png from "../../assets/patient-home-page.png";
import { useSelector } from "react-redux";
import { getById } from "../../api/patient/PatientService";
import { FaUserCheck } from "react-icons/fa";
import { Link } from "react-router-dom";

const PatientPage = () => {
  const { isLoggedIn, patientId } = useSelector((store) => ({
    isLoggedIn: store.isLoggedIn,
    patientId: store.id,
  }));
  const [patient, setPatient] = useState({});

  useEffect(() => {
    getDetails();
  }, [patientId]);
  const getDetails = async () => {
    try {
      const result = await getById(patientId);
      setPatient(result.data.data);
    } catch (error) {}
  };

  const { firstName, lastName } = patient;
  return (
    <>
      <section className="mt-5">
        <div className="container">
          <div className="pt-5">
            <div className="row">
              <div className="col-lg-5 p-5">
                <h1 className="display-4">Hoş Geldiniz {firstName + " " + lastName}</h1>
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

export default PatientPage;
