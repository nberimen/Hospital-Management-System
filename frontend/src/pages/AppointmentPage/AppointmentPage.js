import React, { useEffect, useState } from "react";
import * as IoIcons from "react-icons/io";
import Input from "../../components/Input";

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

const AppointmentPage = (props) => {
  const { isLoggedIn, patientId } = useSelector((store) => ({
    isLoggedIn: store.isLoggedIn,
    patientId: store.id,
  }));

  const [cities, setCities] = useState([]);
  const [hospitals, setHospitals] = useState([]);
  const [departments, setDepartments] = useState([]);
  const [doctors, setDoctors] = useState([]);
  const initialTime = [
    {
      time: "09:00",
      status: "ACTIVE",
    },
    {
      time: "09:30",
      status: "ACTIVE",
    },
    {
      time: "10:00",
      status: "ACTIVE",
    },
    {
      time: "10:30",
      status: "ACTIVE",
    },
    {
      time: "11:00:00",
      status: "ACTIVE",
    },
    {
      time: "11:30",
      status: "ACTIVE",
    },
    {
      time: "13:00",
      status: "ACTIVE",
    },
    {
      time: "13:30",
      status: "ACTIVE",
    },
  ];
  const [time, setTime] = useState([...initialTime]);

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

        const body = {
          patientId,
          doctorId,
          appointmentDate,
          appointmentTime,
        };
        console.log(body);
        try {
          await createAppointment(body);
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
  }, [city, hospital, department, doctorId]);

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
      //console.log(result.data.data);
      //result.data.data.map(data => console.log(data.appointmentDate))
      result.data.data
        .filter(
          (data) =>
            data.appointmentDate == appointmentDate &&
            data.statusType === "ACTIVE"
        )
        .map((filteredData) => {
          console.log("filtered: " + filteredData);
        });
    } catch (error) {}
    //console.log("time:"+time);
  };

  return (
    <div className="container">
      <form onSubmit={handleSubmit}>
        <h1 className="text-center">Randevu Al</h1>

        <Select
          label="Şehir"
          name="city"
          onChange={handleChange}
          error={errors.city}
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
          error={errors.hospital}
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
          error={errors.department}
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
          error={errors.doctorId}
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
          error={errors.appointmentTime}
          defaultOption={{ label: "Muayene Saati Seçiniz", value: "" }}
          options={time.map((t) => ({
            value: t.time,
            label: t.time,
          }))}
        />

        <div className="text-center">
          <ButtonWithProgress
            /*  disabled={pendingApiCall}
            pendingApiCall={pendingApiCall} */
            text="Randevu Al"
            icon={<IoIcons.IoMdCreate className="large-icon" />}
          />
        </div>
      </form>
    </div>
  );
};

export default AppointmentPage;
