import React, { useState } from "react";
import { getAllPatient } from "../../api/admin/AdminService";
import AppointmentPage from "../AppointmentPage/AppointmentPage";

const PatientPage = () => {
  const [users, setUsers] = useState();

  const onClick = async () => {
    try {
      const response = await getAllPatient();
  
      console.log(response);
      setUsers(response);
    } catch (err) {
      console.log(err.response)
    }
  };
  return <div>
    <AppointmentPage/>
  </div>;
};

export default PatientPage;
