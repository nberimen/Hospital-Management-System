import { useFormik } from "formik";
import React, { useEffect, useState } from "react";
import * as Yup from "yup";
import { deleteDoctor } from "../../api/admin/AdminService";
import png from "../../assets/delete-doctor.jpg";
import ButtonWithProgress from "../../components/ButtonWithProgress";
import Input from "../../components/Input";

const DeleteDoctor = (props) => {
  const [pendingApiCall, setPendingApiCall] = useState(false);
  const [error, setError] = useState();
  const { handleSubmit, handleChange, handleBlur, values, errors, touched } =
    useFormik({
      initialValues: {
        identityNo: "",
      },
      validationSchema: Yup.object({
        identityNo: Yup.string().required("Identity No alanı boş bırakılamaz!"),
      }),
      onSubmit: async (values) => {
        const { identityNo } = values;
        const { history } = props;
        const { push } = history;
        setError(undefined);
        try {
          setPendingApiCall(true);
          await deleteDoctor(identityNo);
          push("/");
        } catch (err) {
          setError(err.response.data.messages);
        }
        setPendingApiCall(false);
      },
    });

  const { identityNo } = values;
  const { identityNo: identityNoError } = errors;

  useEffect(() => {
    setError(undefined);
  }, [identityNo]);

  return (
    <>
      <section className="mt-5">
        <div className="container">
          <div className="pt-5">
            <div className="row">
              <div className="col-lg-6 p-5">
                <div className="container">
                  <form onSubmit={handleSubmit}>
                    <h1 className="text-center">Delete Doctor</h1>

                    <Input
                      label="Identity No"
                      type="number"
                      name="identityNo"
                      value={identityNo}
                      onBlur={handleBlur}
                      onChange={handleChange}
                      error={touched.identityNo && identityNoError}
                    />
                    {error && <div className="alert alert-danger">{error}</div>}
                    <div className="text-center">
                      <ButtonWithProgress
                        disabled={pendingApiCall}
                        pendingApiCall={pendingApiCall}
                        text="Delete"
                      />
                    </div>
                  </form>
                </div>
              </div>

              <div
                className="col-lg-5 bg-white"
                style={{
                  borderTopLeftRadius: "5rem",
                  borderBottomRightRadius: "5rem",
                }}
              >
                <img
                  className="mt-2 d-md-none d-none d-lg-block img-fluid"
                  src={png}
                />
              </div>
            </div>
          </div>
        </div>
      </section>
    </>
  );
};

export default DeleteDoctor;
