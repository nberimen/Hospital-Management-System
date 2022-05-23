import { useFormik } from "formik";
import * as Yup from "yup";
import React, { useState } from "react";
import Input from "./Input";
import ButtonWithProgress from "./ButtonWithProgress";
import { addTest, appointmentSetPassive } from "../api/doctor/DoctorService";

const AddPrescription = (props) => {
  const { visible, onClickCancel, appointmetnId, patientId, doctorId, history } = props;
  let className = "modal fade";
  if (visible) {
    className += " show d-block";
  }

  const [pendingApiCall, setPendingApiCall] = useState(false);

  const { handleSubmit, handleChange, handleBlur, values, errors, touched } =
    useFormik({
      initialValues: {
        processName: "",
        result: "",
        resultUnit: "",
        referenceValue: "",
      },
      validationSchema: Yup.object({
        processName: Yup.string().required("Bu alan boş bırakılamaz"),
        result: Yup.string().required("Bu alan boş bırakılamaz"),
        resultUnit: Yup.string().required("Bu alan boş bırakılamaz"),
        referenceValue: Yup.string().required("Bu alan boş bırakılamaz"),
      }),
      onSubmit: async (values) => {
        const { processName, result, resultUnit, referenceValue } = values;

        const body = {
          patientId,
          doctorId,
          processName,
          result,
          resultUnit,
          referenceValue,
        };
        try {
          setPendingApiCall(true);
          await addTest(body);
          await appointmentSetPassive(appointmetnId);
        } catch (err) {}
        setPendingApiCall(false);
      },
    });

  const { processName, result, resultUnit, referenceValue } = values;
  const {
    processName: processNameError,
    result: resultError,
    resultUnit: resultUnitError,
    referenceValue: referenceValueError,
  } = errors;

  return (
    <>
      <div className={className} style={{ backgroundColor: "#000000b0" }}>
        <div className="modal-dialog mod">
          <div className="modal-content">
            <div className="modal-header">
              <h5 className="modal-title">Test Ekle</h5>
            </div>
            <div className="modal-body">
              <div className="container">
                <form onSubmit={handleSubmit}>
                  <Input
                    label="İşlem Adı"
                    type="text"
                    name="processName"
                    value={processName}
                    onBlur={handleBlur}
                    onChange={handleChange}
                    error={touched.processName && processNameError}
                  />
                  <Input
                    label="Sonuç"
                    type="text"
                    name="result"
                    value={result}
                    onBlur={handleBlur}
                    onChange={handleChange}
                    error={touched.result && resultError}
                  />
                  <Input
                    label="Sonuç Birimi"
                    type="text"
                    name="resultUnit"
                    value={resultUnit}
                    onBlur={handleBlur}
                    onChange={handleChange}
                    error={touched.resultUnit && resultUnitError}
                  />

                  <Input
                    label="Referans Değeri"
                    type="text"
                    name="referenceValue"
                    value={referenceValue}
                    onBlur={handleBlur}
                    onChange={handleChange}
                    error={touched.referenceValue && referenceValueError}
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

export default AddPrescription;
