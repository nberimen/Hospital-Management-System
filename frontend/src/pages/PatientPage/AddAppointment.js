import React, { useEffect, useState } from "react";
import * as IoIcons from "react-icons/io";
import Input from "../../components/Input";
import png from "../../assets/add-appointment.jpg";
import * as Yup from "yup";
import Select from "../../components/Select";
import {
  getAllCity,
  getAllDepartmentsByHospitalId,
  getAllDoctorByDepartmentId,
  getAllHospitalByCityId,
} from "../../api/apiCall";
import { useSelector } from "react-redux";
import {
  createAppointment,
  getAllByDoctorIdAndPatientId,
} from "../../api/patient/PatientService";
import ButtonWithProgress from "../../components/ButtonWithProgress";
import { useFormik } from "formik";

const AddAppointment = (props) => {
  const { isLoggedIn, patientId } = useSelector((store) => ({
    isLoggedIn: store.isLoggedIn,
    patientId: store.id,
  }));

  const [cities, setCities] = useState([]);
  const [hospitals, setHospitals] = useState([]);
  const [departments, setDepartments] = useState([]);
  const [doctors, setDoctors] = useState([]);
  const [filteredTime, setFilteredTime] = useState([]);
  const initialTime = [
    {
      time: "07:00:00",
      name: "09:00:00",
      status: "ACTIVE",
    },
    {
      time: "07:30:00",
      name: "09:30:00",
      status: "ACTIVE",
    },
    {
      time: "08:00:00",
      name: "10:00:00",
      status: "ACTIVE",
    },
    {
      time: "08:30:00",
      name: "10:30:00",
      status: "ACTIVE",
    },
    {
      time: "09:00:00",
      name: "11:00:00",
      status: "ACTIVE",
    },
    {
      time: "09:30:00",
      name: "11:30:00",
      status: "ACTIVE",
    },
    {
      time: "11:00:00",
      name: "13:00:00",
      status: "ACTIVE",
    },
    {
      time: "11:30:00",
      name: "13:30:00",
      status: "ACTIVE",
    },
    {
      time: "12:00:00",
      name: "14:00:00",
      status: "ACTIVE",
    },
    {
      time: "12:30:00",
      name: "14:30:00",
      status: "ACTIVE",
    },
    {
      time: "13:00:00",
      name: "15:00:00",
      status: "ACTIVE",
    },
    {
      time: "13:30:00",
      name: "15:30:00",
      status: "ACTIVE",
    },
    {
      time: "14:00:00",
      name: "16:00:00",
      status: "ACTIVE",
    },
    {
      time: "14:30:00",
      name: "16:30:00",
      status: "ACTIVE",
    },
  ];

  const { handleSubmit, handleChange, handleBlur, values, errors, touched } =
    useFormik({
      initialValues: {
        city: undefined,
        hospital: undefined,
        department: undefined,
        doctorId: undefined,
        appointmentDate: undefined,
        appointmentTime: undefined,
      },
      validationSchema: Yup.object({
        city: Yup.string().required("Bu alan boş bırakılamaz!"),
        hospital: Yup.string().required("Bu alan boş bırakılamaz!"),
        department: Yup.string().required("Bu alan boş bırakılamaz!"),
        doctorId: Yup.string().required("Bu alan boş bırakılamaz!"),
        appointmentDate: Yup.string().required("Bu alan boş bırakılamaz!"),
        appointmentTime: Yup.string().required("Bu alan boş bırakılamaz!"),
      }),
      onSubmit: async (values) => {
        const { doctorId, appointmentDate, appointmentTime } = values;
        const { history } = props;
        const { push } = history;
        const body = {
          patientId,
          doctorId,
          appointmentDate,
          appointmentTime,
        };
        console.log(body);
        try {
          await createAppointment(body);
          push("/");
        } catch (error) {}
      },
    });

  const {
    city,
    hospital,
    department,
    doctorId,
    appointmentDate,
    appointmentTime,
  } = values;

  useEffect(() => {
    loadCities();
    loadHospitals(city);
    loadDepartments(hospital);
    loadDoctors(department);
    loadTimes(doctorId);
  }, [city, hospital, department, doctorId, appointmentDate]);

  
  const loadCities = async () => {
    try {
      const result = await getAllCity();
      setCities(result.data.data);
    } catch (error) {}
  };
  const loadHospitals = async (cityId) => {
    try {
      const result = await getAllHospitalByCityId(cityId);
      setHospitals(result.data.data);
    } catch (error) {}
  };
  const loadDepartments = async (hospitalId) => {
    try {
      const result = await getAllDepartmentsByHospitalId(hospitalId);
      setDepartments(result.data.data);
    } catch (error) {}
  };
  const loadDoctors = async (doctorId) => {
    try {
      const result = await getAllDoctorByDepartmentId(doctorId);
      setDoctors(result.data.data);
    } catch (error) {}
  };

  const loadTimes = async (doctorId) => {
    try {
      const result = await getAllByDoctorIdAndPatientId(patientId, doctorId);
      const dataResult = result.data.data;
      setFilteredTime(initialTime);
      let a = [];
      let newT = initialTime;
      for (let i = 0; i < dataResult.length; i++) {
        if (dataResult[i].appointmentDate === appointmentDate)
          a.push(dataResult[i].appointmentTime);
      }

      for (let i = 0; i < a.length; i++) {
        for (let j = 0; j < newT.length; j++) {
          if (a[i] === newT[j].name) {
            newT[j] = {
              time: newT[j].time,
              name: newT[j].name,
              status: "PASSIVE",
            };
          }
        }
      }
      setFilteredTime(newT)
    } catch (error) {}
  };

  return (
    <>
      <section className="mt-5">
        <div className="container">
          <div className="pt-5">
            <div className="row">
              <div className="col-lg-6 p-5">
                <div className="container">
                  <form onSubmit={handleSubmit}>
                    <h1 className="text-center">Randevu Al</h1>

                    <Select
                      label="Şehir"
                      name="city"
                      onChange={handleChange}
                      onBlur={handleBlur}
                      error={touched.city && errors.city}
                      defaultOption={{ label: "Şehir Seçiniz", value: "" }}
                      options={cities.map((c) => ({
                        value: c.id,
                        label: c.name,
                      }))}
                    />
                    <Select
                      label="Hastane"
                      name="hospital"
                      onChange={handleChange}
                      onBlur={handleBlur}
                      error={touched.hospital && errors.hospital}
                      defaultOption={{ label: "Hastane Seçiniz", value: "" }}
                      options={hospitals.map((h) => ({
                        value: h.id,
                        label: h.name,
                      }))}
                    />
                    <Select
                      label="Klinik"
                      name="department"
                      onChange={handleChange}
                      onBlur={handleBlur}
                      error={touched.department && errors.department}
                      defaultOption={{ label: "Klinik Seçiniz", value: "" }}
                      options={departments.map((d) => ({
                        value: d.id,
                        label: d.name,
                      }))}
                    />
                    <Select
                      label="Hekim"
                      name="doctorId"
                      onChange={handleChange}
                      onBlur={handleBlur}
                      error={touched.doctorId && errors.doctorId}
                      defaultOption={{ label: "Hekim Seçiniz", value: "" }}
                      options={doctors.map((doctor) => ({
                        value: doctor.id,
                        label: doctor.firstName + " " + doctor.lastName,
                      }))}
                    />
                    <Input
                      label="Başlangız zamanı seçiniz."
                      type="date"
                      name="appointmentDate"
                      value={appointmentDate}
                      onBlur={handleBlur}
                      onChange={handleChange}
                      error={touched.appointmentDate && errors.appointmentDate}
                    />
                    <Select
                      label="Muayene Saati"
                      name="appointmentTime"
                      onChange={handleChange}
                      onBlur={handleBlur}
                      error={touched.appointmentTime && errors.appointmentTime}
                      defaultOption={{
                        label: "Muayene Saati Seçiniz",
                        value: "",
                      }}
                      options={filteredTime.map((t) => ({
                        value: t.time,
                        label: t.name.substring(0, 5),
                        disabled: t.status,
                      }))}
                    />

                    <div className="text-center">
                      <ButtonWithProgress
                        text="Randevu Al"
                        icon={<IoIcons.IoMdCreate className="large-icon" />}
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

export default AddAppointment;
