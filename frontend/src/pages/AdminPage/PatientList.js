import React, { useEffect, useState } from "react";
import { getAllDoctor, getAllPatient } from "../../api/admin/AdminService";

const PatientList = () => {
  const [patients, setPatients] = useState([]);
  useEffect(() => {
    loadPatients();
  }, []);

  const loadPatients = async () => {
    const result = await getAllPatient();
    console.log(result.data.data)
    setPatients(result.data.data);
  };

  return (
    <div className="container">
      <table className="table table-striped">
        <thead style={{background:"#060b26", color:"#fff"}}>
          <tr>
            <th>#</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Identity No</th>
          </tr>
        </thead>
        <tbody>
          {patients.map((patient, index) => (
            <tr key={patient.id}>
              <td>{index + 1}</td>
              <td>{patient.firstName}</td>
              <td>{patient.lastName}</td>
              <td>{patient.identityNo}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default PatientList;
