import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { getAllReports } from "../../api/patient/PatientService";

const Report = (props) => {
  const { isLoggedIn, patientId } = useSelector((store) => ({
    isLoggedIn: store.isLoggedIn,
    patientId: store.id,
  }));

  const [reports, setReports] = useState([]);

  useEffect(() => {
    loadReports();
  }, [setReports]);

  const loadReports = async () => {
    try {
      const result = await getAllReports(patientId);
      console.log(result.data.data);
      setReports(result.data.data);
    } catch (error) {}
  };
  return (
    <>
      <div className="container">
        {reports.length > 0 && (
          <table className="table table-striped">
            <thead style={{ background: "#060b26", color: "#fff" }}>
              <tr>
                <th>Tarih</th>
                <th>Rapor No</th>
                <th>Rapor Türü</th>
                <th>Tanı</th>
              </tr>
            </thead>

            <tbody>
              {reports.map((report) => (
                <tr key={report.id}>
                  <td>{report.date}</td>
                  <td>{report.reportNo}</td>
                  <td>{report.reportType}</td>
                  <td>{report.diagnosis}</td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
        {reports.length === 0 && (
          <div className="alert alert-danger" role="alert">
            Raporlarınız Bulunmamaktadır!
          </div>
        )}
      </div>
    </>
  );
};

export default Report;
