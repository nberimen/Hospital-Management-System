import React, { useEffect, useState } from "react";
import { getAllDoctor } from "../../api/admin/AdminService";

const DoctorList = () => {
  const [doctors, setDostors] = useState([]);
  useEffect(() => {
    loadDoctors();
  }, []);

  const loadDoctors = async () => {
    const result = await getAllDoctor();
    setDostors(result.data.data);
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
            <th>Department</th>
          </tr>
        </thead>
        <tbody>
          {doctors.map((doctor, index) => (
            <tr key={doctor.id}>
              <td>{index+1}</td>
              <td>{doctor.firstName}</td>
              <td>{doctor.lastName}</td>
              <td>{doctor.identityNo}</td>
              <td>{doctor.departmentDto.name}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default DoctorList;
