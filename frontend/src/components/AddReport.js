import { useFormik } from "formik";
import * as Yup from "yup";
import React, { useState } from "react";
import Input from "./Input";
import ButtonWithProgress from "./ButtonWithProgress";
import { addReport, appointmentSetPassive } from "../api/doctor/DoctorService";

const AddReport = (props) => {
  const {
    visible,
    onClickCancel,
    appointmetnId,
    patientId,
    doctorId,
    history,
  } = props;
  let className = "modal fade";
  if (visible) {
    className += " show d-block";
  }

  const [pendingApiCall, setPendingApiCall] = useState(false);

  const { handleSubmit, handleChange, handleBlur, values, errors, touched } =
    useFormik({
      initialValues: {
        reportNo: "",
        reportType: "",
        diagnosis: "",
      },
      validationSchema: Yup.object({
        reportNo: Yup.string().required("Bu alan boş bırakılamaz"),
        reportType: Yup.string().required("Bu alan boş bırakılamaz"),
        diagnosis: Yup.string().required("Bu alan boş bırakılamaz"),
      }),
      onSubmit: async (values) => {
        const { reportNo, reportType, diagnosis } = values;
        const { push } = history;
        const body = {
          patientId,
          doctorId,
          reportNo,
          reportType,
          diagnosis,
        };
        try {
          setPendingApiCall(true);
          await addReport(body);
          await appointmentSetPassive(appointmetnId);
          push("/");
        } catch (err) {}
        setPendingApiCall(false);
      },
    });

  const { reportNo, reportType, diagnosis } = values;
  const {
    reportNo: reportNoError,
    reportType: reportTypeError,
    diagnosis: diagnosisError,
  } = errors;

  return (
    <>
      <div className={className} style={{ backgroundColor: "#000000b0" }}>
        <div className="modal-dialog mod">
          <div className="modal-content">
            <div className="modal-header">
              <h5 className="modal-title">Rapor Ekle</h5>
            </div>
            <div className="modal-body">
              <div className="container">
                <form onSubmit={handleSubmit}>
                  <Input
                    label="Rapor No"
                    type="text"
                    name="reportNo"
                    value={reportNo}
                    onBlur={handleBlur}
                    onChange={handleChange}
                    error={touched.reportNo && reportNoError}
                  />
                  <Input
                    label="Rapor Türü"
                    type="text"
                    name="reportType"
                    value={reportType}
                    onBlur={handleBlur}
                    onChange={handleChange}
                    error={touched.reportType && reportTypeError}
                  />
                  <Input
                    label="Sonuç Birimi"
                    type="text"
                    name="diagnosis"
                    value={diagnosis}
                    onBlur={handleBlur}
                    onChange={handleChange}
                    error={touched.diagnosis && diagnosisError}
                  />

                  <div className="text-center">
                    <ButtonWithProgress
                      disabled={pendingApiCall}
                      pendingApiCall={pendingApiCall}
                      text="Ekle"
                    />
                  </div>
                </form>
              </div>

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
    </>
  );
};

export default AddReport;
