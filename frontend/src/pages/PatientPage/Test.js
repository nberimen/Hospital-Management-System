import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { getAllTests } from "../../api/patient/PatientService";

const Test = (props) => {
  const { isLoggedIn, patientId } = useSelector((store) => ({
    isLoggedIn: store.isLoggedIn,
    patientId: store.id,
  }));

  const [tests, setTests] = useState([]);

  useEffect(() => {
    loadTests();
  }, [setTests]);

  const loadTests = async () => {
    try {
      const result = await getAllTests(patientId);
      console.log(result.data.data);
      setTests(result.data.data);
    } catch (error) {}
  };
  return (
    <>
      <div className="container">
        {tests.length > 0 && (
          <table className="table table-striped">
            <thead style={{ background: "#060b26", color: "#fff" }}>
              <tr>
                <th>Hastane</th>
                <th>İşlem Adı</th>
                <th>Sonuç</th>
                <th>Sonuç Birimi</th>
                <th>Referans Değeri</th>
                <th>Tarih</th>
              </tr>
            </thead>

            <tbody>
              {tests.map((test) => (
                <tr key={test.id}>
                  <td>{test.doctorDto.departmentDto.hospitalDto.name}</td>
                  <td>{test.processName}</td>
                  <td>{test.result}</td>
                  <td>{test.resultUnit}</td>
                  <td>{test.referenceValue}</td>
                  <td>{test.date}</td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
        {tests.length === 0 && (
          <div className="alert alert-danger" role="alert">
            Raporlarınız Bulunmamaktadır!
          </div>
        )}
      </div>
    </>
  );
};

export default Test;
