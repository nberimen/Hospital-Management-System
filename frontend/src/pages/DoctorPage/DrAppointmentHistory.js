import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { getAllPassiveByDoctorId } from "../../api/doctor/DoctorService";

const DrAppointmentHistory = (props) => {
  const { isLoggedIn, doctorId } = useSelector((store) => ({
    isLoggedIn: store.isLoggedIn,
    doctorId: store.id,
  }));
  const [appointments, setAppointments] = useState([]);

  useEffect(() => {
    loadAppointments();
  }, [setAppointments]);

  const loadAppointments = async () => {
    const result = await getAllPassiveByDoctorId(doctorId);
    setAppointments(result.data.data);
    console.log(result.data.data);
  };

  return (
    <>
      <div className="container">
        {appointments.length > 0 && (
          <table className="table table-striped">
            <thead style={{ background: "#060b26", color: "#fff" }}>
              <tr>
                <th>#</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Identity No</th>
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
                  <td>{appointment.appointmentDate}</td>
                  <td>{appointment.appointmentTime}</td>
                  <td>{appointment.statusType}</td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
        {appointments.length === 0 && (
          <div className="alert alert-danger" role="alert">
            Geçmiş Randevu Bulunmamaktadır!
          </div>
        )}
      </div>
    </>
  );
};

export default DrAppointmentHistory;
