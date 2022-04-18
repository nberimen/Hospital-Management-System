import React, { useEffect, useState } from "react";
import {
  getAllAppointment,
  getAllDoctor,
  getPatientById,
} from "../../api/admin/AdminService";

const AppointmentDetails = () => {
  const [appointments, setAppointments] = useState([]);
  useEffect(() => {
    loadAppointments();
  }, []);

  const loadAppointments = async () => {
    const result = await getAllAppointment();
    setAppointments(result.data.data);
  };

  return (
    <div className="container">
      <table className="table table-striped">
        <thead style={{ background: "#060b26", color: "#fff" }}>
          <tr>
            <th>#</th>
            <th>Patient</th>
            <th>Identity No</th>
            <th>Appointment Date</th>
            <th>Appointment Time</th>
            <th>Doctor</th>
            <th>Department</th>
          </tr>
        </thead>
        <tbody>
          {appointments.map((appointment, index) => {
            return (
              <tr key={appointment.id}>
                <td>{index + 1}</td>
                <td>{appointment.patientDto.firstName +" "+appointment.patientDto.lastName}</td>
                <td>{appointment.patientDto.identityNo}</td>
                <td>{appointment.appointmentDate}</td>
                <td>{appointment.appointmentTime}</td>
                <td>{appointment.doctorDto.firstName + " "+ appointment.doctorDto.lastName}</td>
                <td>{appointment.doctorDto.departmentDto.name}</td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
};

export default AppointmentDetails;
