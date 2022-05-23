import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { getAllPrescription } from "../../api/patient/PatientService";
import Modal from "../../components/Modal";

const Prescription = (props) => {
  const { isLoggedIn, patientId } = useSelector((store) => ({
    isLoggedIn: store.isLoggedIn,
    patientId: store.id,
  }));

  const [prescriptionId, setPrescriptionId] = useState();
  const [hospitalName, setHospitalName] = useState();
  const [department, setDepartment] = useState();
  const [modalVisible, setModalVisible] = useState(false);
  const [prescriptions, setPrescriptions] = useState([]);

  useEffect(() => {
    loadPrescriptions();
  }, [setPrescriptions]);

  const loadPrescriptions = async () => {
    try {
      const result = await getAllPrescription(patientId);
      console.log(result.data.data);
      setPrescriptions(result.data.data);
    } catch (error) {}
  };

  const onClickCancel = () => {
    setModalVisible(false);
  };
  const onClickDetail = (id, department, hospital) => {
    setModalVisible(true);
    setPrescriptionId(id);
    setDepartment(department);
    setHospitalName(hospital);
  };

  return (
    <>
      <div className="container">
        {prescriptions.length > 0 && (
          <table className="table table-striped">
            <thead style={{ background: "#060b26", color: "#fff" }}>
              <tr>
                <th>Tarih</th>
                <th>Reçete No</th>
                <th>Hekim</th>
                <th></th>
              </tr>
            </thead>

            <tbody>
              {prescriptions.map((prescription) => (
                <tr key={prescription.id}>
                  <td>{prescription.prescriptionDate}</td>
                  <td>{prescription.prescriptionNo}</td>
                  <td>{prescription.doctorDto.firstName}</td>
                  <td>
                    <button
                      type="button"
                      className="btn btn-info"
                      onClick={() =>
                        onClickDetail(
                          prescription.id,
                          prescription.doctorDto.departmentDto.name,
                          prescription.doctorDto.departmentDto.hospitalDto.name
                        )
                      }
                    >
                      Detay Görüntüle
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
        {prescriptions.length === 0 && (
          <div className="alert alert-danger" role="alert">
            Reçeteleriniz Bulunmamaktadır!
          </div>
        )}
      </div>
      <Modal
        visible={modalVisible}
        onClickCancel={onClickCancel}
        title="Reçete Detay"
        prescriptionId={prescriptionId}
        hospitalName={hospitalName}
        department={department}
      />
    </>
  );
};

export default Prescription;
