import { useFormik } from "formik";
import * as Yup from "yup";
import React, { useEffect, useState } from "react";
import Input from "../../components/Input";
import png from "../../assets/signup-page.png";
import { useApiProgress } from "../../shared/ApiProgress";
import ButtonWithProgress from "../../components/ButtonWithProgress";
import Select from "../../components/Select";
import { getDepartment } from "../../api/admin/AdminService";
import { signupDoctorHandler } from "../../redux/authActions";
import { useDispatch } from "react-redux";

const DoctorAdd = (props) => {
  const dispatch = useDispatch();
  const [departments, setDepartments] = useState([]);
  useEffect(() => {
    loadDepartment();
  }, []);

  const loadDepartment = async () => {
    try {
      const result = await getDepartment();
      setDepartments(result.data.data);
    } catch (err) {}
  };
  const { handleSubmit, handleChange, handleBlur, values, errors, touched } =
    useFormik({
      initialValues: {
        firstName: "",
        lastName: "",
        password: "",
        passwordRepeat: "",
        identityNo: "",
        departmentId: undefined,
      },
      validationSchema: Yup.object({
        firstName: Yup.string().required("Fist Name alanı boş bırakılamaz!"),
        lastName: Yup.string().required("Last Name alanı boş bırakılamaz!"),
        password: Yup.string().required("Şifre boş bırakılamaz!"),
        passwordRepeat: Yup.string()
          .oneOf([Yup.ref("password")], "Şifre aynı olmalı!")
          .required("Şifre Tekrar alanı boş bırakılamaz!"),
        identityNo: Yup.string().required("Identity No alanı boş bırakılamaz!"),
        departmentId: Yup.number().required("Bu alan boş bırakılamaz!"),
      }),
      onSubmit: async (values) => {
        const { firstName, lastName, password, identityNo, departmentId } =
          values;
        const { history } = props;
        const { push } = history;
        const body = {
          identityNo,
          firstName,
          lastName,
          password,
          departmentId,
        };
        try {
          await dispatch(signupDoctorHandler(body));
          push("/");
        } catch (err) {}
      },
    });

  const { firstName, lastName, password, passwordRepeat, identityNo } = values;
  const {
    firstName: firstNameError,
    lastName: lastNameError,
    password: passwordError,
    passwordRepeat: passwordRepeatError,
    identityNo: identityNoError,
    departmentId: departmentIdError,
  } = errors;

  const pendingApiCall = useApiProgress("/api/v1/admins/save-doctor");

  return (
    <>
      <section className="mt-5">
        <div className="container">
          <div className="pt-5">
            <div className="row">
              <div className="col-lg-6 p-5">
                <div className="container">
                  <form onSubmit={handleSubmit}>
                    <h1 className="text-center">Add Doctor</h1>

                    <Input
                      label="Identity No"
                      type="number"
                      name="identityNo"
                      value={identityNo}
                      onBlur={handleBlur}
                      onChange={handleChange}
                      error={touched.identityNo && identityNoError}
                    />
                    <Input
                      label="First Name"
                      type="text"
                      name="firstName"
                      value={firstName}
                      onBlur={handleBlur}
                      onChange={handleChange}
                      error={touched.firstName && firstNameError}
                    />
                    <Input
                      label="Last Name"
                      type="text"
                      name="lastName"
                      value={lastName}
                      onBlur={handleBlur}
                      onChange={handleChange}
                      error={touched.lastName && lastNameError}
                    />

                    <Input
                      label="Password"
                      type="password"
                      name="password"
                      value={password}
                      onBlur={handleBlur}
                      onChange={handleChange}
                      error={touched.password && passwordError}
                    />

                    <Input
                      label="Password Repeat"
                      type="password"
                      name="passwordRepeat"
                      value={passwordRepeat}
                      onBlur={handleBlur}
                      onChange={handleChange}
                      error={touched.passwordRepeat && passwordRepeatError}
                    />
                    <Select
                      label="Department"
                      name="departmentId"
                      onChange={handleChange}
                      error={departmentIdError}
                      defaultOption={{ label: "Bölüm", value: "" }}
                      options={departments.map((l) => ({
                        value: l.id,
                        label: l.name,
                      }))}
                    />

                    <div className="text-center">
                      <ButtonWithProgress
                        disabled={pendingApiCall}
                        pendingApiCall={pendingApiCall}
                        text="Add"
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

export default DoctorAdd;
