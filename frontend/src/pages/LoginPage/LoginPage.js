import { useFormik } from "formik";
import * as Yup from "yup";
import React, { useEffect, useState } from "react";
import Input from "../../components/Input";
import png from "../../assets/hospital-banner-1.jpg";
import { useDispatch } from "react-redux";
import { loginHandler } from "../../redux/authActions";
import { useApiProgress } from "../../shared/ApiProgress";
import ButtonWithProgress from "../../components/ButtonWithProgress";

const LoginPage = (props) => {
  const [error, setError] = useState();
  const dispatch = useDispatch();

  const { handleSubmit, handleChange, handleBlur, values, errors, touched } =
    useFormik({
      initialValues: {
        identityNo: "",
        password: "",
      },
      validationSchema: Yup.object({
        identityNo: Yup.string().required("Identity No alanı boş bırakılamaz"),
        password: Yup.string().required("Şifre boş bırakılamaz"),
      }),
      onSubmit: async (values) => {
        const { password, identityNo } = values;
        const creds = {
          identityNo,
          password,
        };
        const { history } = props;
        const { push } = history;
        setError(undefined);
        try {
          await dispatch(loginHandler(creds));
          push("/");
        } catch (error) {
          setError(error.response.data.data.message);
        }
      },
    });

  const { password, identityNo } = values;
  const buttonEnabled = identityNo && password;

  useEffect(() => {
    setError(undefined);
  }, [password, identityNo]);

  const pendingApiCall = useApiProgress("/auth/login");

  return (
    <>
      <section className="mt-5">
        <div className="container">
          <div className="pt-5">
            <div className="row">
              <div className="col-lg-5 p-5">
                <div className="container">
                  <form onSubmit={handleSubmit}>
                    <h1 className="text-center">Login</h1>

                    <Input
                      label="Identity No"
                      type="number"
                      name="identityNo"
                      value={identityNo}
                      onBlur={handleBlur}
                      onChange={handleChange}
                      error={touched.identityNo && errors.identityNo}
                    />
                    <Input
                      label="Password"
                      type="password"
                      name="password"
                      value={password}
                      onBlur={handleBlur}
                      onChange={handleChange}
                      error={touched.password && errors.password}
                    />
                    {error && <div className="alert alert-danger">{error}</div>}
                    <div className="text-center">
                      <ButtonWithProgress
                        disabled={!buttonEnabled || pendingApiCall}
                        pendingApiCall={pendingApiCall}
                        text="Login"
                      />
                    </div>
                  </form>
                </div>
              </div>

              <div
                className="col-lg-6 bg-white"
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

export default LoginPage;
