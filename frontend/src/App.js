import {
  BrowserRouter as Router,
  Route,
  Redirect,
  Switch,
} from "react-router-dom";
import "./App.css";
import Footer from "./layouts/Footer";
import TopBar from "./layouts/TopBar";
import * as ROLE from "./shared/ConstantsRole";
import AdminPage from "./pages/AdminPage/AdminPage";
import DoctorPage from "./pages/DoctorPage/DoctorPage";
import HomePage from "./pages/HomePage/HomePage";
import PatientPage from "./pages/PatientPage/PatientPage";
import PatientSignupPage from "./pages/PatientPage/PatientSignupPage";
import LoginPage from "./pages/LoginPage/LoginPage";
import { useSelector } from "react-redux";
import DoctorAdd from "./pages/AdminPage/DoctorAdd";
import DoctorList from "./pages/AdminPage/DoctorList";
import PatientList from "./pages/AdminPage/PatientList";
import AppointmentDetails from "./pages/AdminPage/AppointmnetDetails";
import DeleteDoctor from "./pages/AdminPage/DeleteDoctor";
import AppointmentHistory from "./pages/PatientPage/AppointmentHistory";
import AddAppointment from "./pages/PatientPage/AddAppointment";
import Appointments from "./pages/DoctorPage/Appointments";
import Visit from "./pages/PatientPage/Visit";
import Prescription from "./pages/PatientPage/Prescription";
import Report from "./pages/PatientPage/Report";
import Test from "./pages/PatientPage/Test";
import DrAppointmentHistory from "./pages/DoctorPage/AppointmentHistory";

const App = () => {
  const { isLoggedIn, role } = useSelector((store) => ({
    isLoggedIn: store.isLoggedIn,
    role: store.role,
  }));
  return (
    <div className="App">
      <Router>
        <TopBar />
        <Switch>
          {!role && <Route exact path="/" component={HomePage} />}
          {!isLoggedIn && (
            <Route path="/signup" component={PatientSignupPage} />
          )}
          {!isLoggedIn && <Route path="/login" component={LoginPage} />}
          {role === ROLE.ADMIN && (
            <Route exact path="/" component={AdminPage} />
          )}
          {role === ROLE.ADMIN && (
            <Route path="/add-doctor" component={DoctorAdd} />
          )}
          {role === ROLE.ADMIN && (
            <Route path="/delete-doctor" component={DeleteDoctor} />
          )}
          {role === ROLE.ADMIN && (
            <Route path="/doctor-list" component={DoctorList} />
          )}
          {role === ROLE.ADMIN && (
            <Route path="/patient-list" component={PatientList} />
          )}
          {role === ROLE.ADMIN && (
            <Route path="/appointment-details" component={AppointmentDetails} />
          )}

          {role === ROLE.DOCTOR && (
            <Route exact path="/" component={DoctorPage} />
          )}
          {role === ROLE.DOCTOR && (
            <Route path="/appointments" component={Appointments} />
          )}

          {role === ROLE.DOCTOR && (
            <Route
              path="/appointment-history"
              component={DrAppointmentHistory}
            />
          )}
          {role === ROLE.PATIENT && (
            <Route exact path="/" component={PatientPage} />
          )}
          {role === ROLE.PATIENT && (
            <Route path="/appointment-list" component={AppointmentHistory} />
          )}
          {role === ROLE.PATIENT && (
            <Route path="/add-appointment" component={AddAppointment} />
          )}
          {role === ROLE.PATIENT && <Route path="/visits" component={Visit} />}
          {role === ROLE.PATIENT && (
            <Route path="/prescriptions" component={Prescription} />
          )}
          {role === ROLE.PATIENT && (
            <Route path="/reports" component={Report} />
          )}
          {role === ROLE.PATIENT && <Route path="/tests" component={Test} />}
          <Redirect to="/" />
        </Switch>

        <Footer />
      </Router>
    </div>
  );
};
export default App;
