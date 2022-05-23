import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { getAllActiveByDoctorId } from "../../api/doctor/DoctorService";
import DoctorAction from "../../components/DoctorAction";

const Appointments = (props) => {
  const { isLoggedIn, doctorId } = useSelector((store) => ({
    isLoggedIn: store.isLoggedIn,
    doctorId: store.id,
  }));
  const [appointments, setAppointments] = useState([]);
  const [modalVisible, setModalVisible] = useState(false);
  const [patientId, setPatientId] = useState();
  const [appointmentId, setAppointmentId] = useState();

  useEffect(() => {
    loadAppointments();
  }, [setAppointments]);

  const loadAppointments = async () => {
    const result = await getAllActiveByDoctorId(doctorId);
    setAppointments(result.data.data);
    console.log(result.data.data);
  };

  const onClickDetail = (id, appointmentId) => {
    setModalVisible(true);
    setPatientId(id);
    setAppointmentId(appointmentId);
  };
  const onClickCancel = () => {
    setModalVisible(false);
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
                <th>Action</th>
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
                  <td>
                    <button
                      type="button"
                      className="btn btn-primary"
                      onClick={() =>
                        onClickDetail(appointment.patientDto.id, appointment.id)
                      }
                    >
                      İşlem Yap
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
        {appointments.length === 0 && (
          <div className="alert alert-danger" role="alert">
            Aktif Randevu Bulunmamaktadır!
          </div>
        )}
      </div>
      <DoctorAction
        visible={modalVisible}
        onClickCancel={onClickCancel}
        appointmentId={appointmentId}
        doctorId={doctorId}
        patientId={patientId}
        history={props.history}
      />
    </>
  );
};

export default Appointments;
