import React, { useEffect, useState } from "react";
import { getAllMeds } from "../api/patient/PatientService";
import "./Modal.css";
const Modal = (props) => {
  const {
    visible,
    onClickCancel,
    title,
    prescriptionId,
    hospitalName,
    department,
  } = props;

  const [meds, setMeds] = useState([]);

  useEffect(() => {
    loadMeds();
  }, [prescriptionId]);

  const loadMeds = async () => {
    try {
      const result = await getAllMeds(prescriptionId);
      console.log(result.data.data);
      setMeds(result.data.data);
    } catch (error) {}
  };
  let className = "modal fade";
  if (visible) {
    className += " show d-block";
  }
  return (
    <div className={className} style={{ backgroundColor: "#000000b0" }}>
      <div className="modal-dialog mod">
        <div className="modal-content">
          <div className="modal-header">
            <h5 className="modal-title">{title}</h5>
          </div>
          <div className="modal-body list">
            <ul class="list-group list-group-flush ">
              <li class="list-group-item li">
                <span className="span">Hastane Adı:</span> <span className="text-uppercase">{hospitalName}</span>
              </li>
              <li class="list-group-item li">
                <span className="span">Klinik:</span> <span className="text-uppercase">{department}</span>
              </li>
            </ul>
          </div>
          <div className="modal-body">
            <h5 className="modal-title">Reçetede Yazan İlaçlar</h5>
            {meds.length > 0 && (
              <table className="table table-dark table-striped">
                <thead>
                  <tr>
                    <th scope="col">Barkod</th>
                    <th scope="col">İlaç Adı</th>
                    <th scope="col">Açıklama</th>
                    <th scope="col">Doz</th>
                    <th scope="col">Periyot</th>
                    <th scope="col">Kullanım Şekli</th>
                    <th scope="col">Kullanım Sayısı</th>
                    <th scope="col">Kutu Adedi</th>
                  </tr>
                </thead>
                <tbody>
                  {meds.map((med) => (
                    <tr key={med.id}>
                      <td>{med.barcode}</td>
                      <td>{med.name}</td>
                      <td>{med.description}</td>
                      <td>{med.dose}</td>
                      <td>{med.period} GÜN</td>
                      <td>{med.usage}</td>
                      <td>{med.useCount}</td>
                      <td>{med.numberOfBoxes}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
            )}
            {meds.length == 0 && (
              <div className="alert alert-danger" role="alert">
                Reçetede İlaç Bulunmamaktadır!
              </div>
            )}
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
  );
};

export default Modal;
