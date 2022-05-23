import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { getAllPassiveByPatientId } from "../../api/patient/PatientService";

const Visit = (props) => {
  const { isLoggedIn, patientId } = useSelector((store) => ({
    isLoggedIn: store.isLoggedIn,
    patientId: store.id,
  }));

  const [appointments, setAppointments] = useState([]);
  useEffect(() => {
    loadAppointments();
  }, [setAppointments]);

  const loadAppointments = async () => {
    const result = await getAllPassiveByPatientId(patientId);
    console.log(result.data.data);
    setAppointments(result.data.data);
  };

  return (
    <>
      <div className="container">
        {appointments.length > 0 && (
          <table className="table table-striped">
            <thead style={{ background: "#060b26", color: "#fff" }}>
              <tr>
                <th>#</th>
                <th>Hastane</th>
                <th>Klinik</th>
                <th>Doktor</th>
                <th>Tarih</th>
              </tr>
            </thead>
            <tbody>
              {appointments.map((appointment, index) => (
                <tr key={appointment.id}>
                  <td>{index + 1}</td>
                  <td>
                    {appointment.doctorDto.departmentDto.hospitalDto.name}
                  </td>
                  <td>{appointment.doctorDto.departmentDto.name}</td>
                  <td>
                    {appointment.doctorDto.firstName +
                      " " +
                      appointment.doctorDto.lastName}
                  </td>
                  <td>{appointment.appointmentDate + " " + appointment.appointmentTime}</td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
        {appointments.length === 0 && (
          <div className="alert alert-danger" role="alert">
            Hastane Ziyaretleriniz Bulunmamaktadır!
          </div>
        )}
      </div>
    </>
  );
};

export default Visit;
