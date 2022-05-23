import React, { useState } from "react";
import { deleteAppointmentById } from "../api/apiCall";
import AddReport from "./AddReport";
import AddTest from "./AddTest";

const DoctorAction = (props) => {
  const {
    visible,
    onClickCancel,
    doctorId,
    patientId,
    appointmentId,
    history,
  } = props;
  const [testVisible, setTestVisible] = useState(false);
  const [prescriptionVisible, setPrescriptionVisible] = useState(false);
  const [reportVisible, setReportVisible] = useState(false);
  let className = "modal fade";
  if (visible) {
    className += " show d-block";
  }

  const deleteAppointment = async () => {
    const { push } = history;
    try {
      await deleteAppointmentById(appointmentId);
      push("/");
    } catch (error) {}
  };

  const onClickTestVisible = () => {
    setTestVisible(true);
  };
  const onClickPrescriptionVisible = () => {
    setPrescriptionVisible(true);
  };
  const onClickReportVisible = () => {
    setReportVisible(true);
  };
  const onClickCancelAction = () => {
    setPrescriptionVisible(false);
    setReportVisible(false);
    setTestVisible(false);
  };
  return (
    <>
      <div className={className} style={{ backgroundColor: "#000000b0" }}>
        <div className="modal-dialog mod">
          <div className="modal-content">
            <div className="modal-header">
              <h5 className="modal-title">Ne yapmak istiyorsunuz?</h5>
            </div>
            <div className="modal-body">
              <button
                type="button"
                className="btn btn-info me-5"
                onClick={onClickReportVisible}
              >
                Rapor Ekle
              </button>
              <button
                type="button"
                className="btn btn-warning me-5"
                onClick={onClickTestVisible}
              >
                Test Ekle
              </button>

              <button
                type="button"
                className="btn btn-success me-5"
                onClick={onClickPrescriptionVisible}
              >
                Reçete Ekle
              </button>
              <button
                type="button"
                className="btn btn-danger me-5"
                onClick={deleteAppointment}
              >
                Randevuyu Sil
              </button>

              <div className="modal-footer">
                <button
                  type="button"
                  onClick={onClickCancel}
                  className="btn btn-secondary"
                >
                  Cancel
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
      <AddTest
        visible={testVisible}
        onClickCancel={onClickCancelAction}
        patientId={patientId}
        doctorId={doctorId}
        appointmetnId={appointmentId}
        history={history}
      />
      <AddReport
        visible={reportVisible}
        onClickCancel={onClickCancelAction}
        patientId={patientId}
        doctorId={doctorId}
        appointmetnId={appointmentId}
        history={history}
      />
    </>
  );
};

export default DoctorAction