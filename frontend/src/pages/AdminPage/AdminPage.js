import React from "react";
import png from "../../assets/admin-page.jpg";

const AdminPage = () => {
  return (
    <>
      <section className="mt-5">
        <div className="container">
          <div className="pt-5">
            <div className="row">
              <div className="col-lg-5 p-5">
                <h1 className="display-1">Hello Admin</h1>
                <h5 className="display-6">
                  Welcome to Hospital Management System.
                </h5>
              </div>

              <div
                className="col-lg-6 bg-white"
                style={{
                  borderTopLeftRadius: "5rem",
                  borderBottomRightRadius: "5rem",
                }}
              >
                <img
                  className="mt-2 d-md-none d-none d-lg-block"
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

export default AdminPage;
