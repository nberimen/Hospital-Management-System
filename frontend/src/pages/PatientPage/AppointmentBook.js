import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { getAllByPatientId } from "../../api/patient/PatientService";

const AppointmentBook = () => {
  const { isLoggedIn, patientId } = useSelector((store) => ({
    isLoggedIn: store.isLoggedIn,
    patientId: store.id,
  }));
  const [appointments, setAppointments] = useState([]);
  useEffect(() => {
    loadAppointments();
  }, [setAppointments]);

  const loadAppointments = async () => {
    const result = await getAllByPatientId(patientId);
      setAppointments(result.data.data);
      console.log(result.data.data)
  };

  return (
    <div className="container">
      <table className="table table-striped">
        <thead style={{ background: "#060b26", color: "#fff" }}>
          <tr>
            <th>#</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Identity No</th>
            <th>Doctor Name</th>
            <th>Department</th>
            <th>Appointment Date</th>
            <th>Appointment Time</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          {appointments.map((appointment, index) => (
            <tr key={appointment.id}>
              <td>{index + 1}</td>
              <td>{appointment.patientDto.firstName}</td>
              <td>{appointment.patientDto.lastName}</td>
              <td>{appointment.patientDto.identityNo}</td>
              <td>{appointment.doctorDto.firstName +" "+ appointment.doctorDto.lastName}</td>
              <td>{appointment.doctorDto.departmentDto.name}</td>
              <td>{appointment.appointmentDate}</td>
              <td>{appointment.appointmentTime}</td>
              <td>{appointment.statusType}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default AppointmentBook;
