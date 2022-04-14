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
          {!isLoggedIn && <Route path="/signup" component={PatientSignupPage} />}
          {!isLoggedIn && <Route path="/login" component={LoginPage} />}
          {role == ROLE.ADMIN &&  <Route exact path="/" component={AdminPage} />}
          <Route path="/add-doctor" component={DoctorAdd} />
          <Route path="/delete-doctor" component={DeleteDoctor} />
          <Route path="/doctor-list" component={DoctorList} />
          <Route path="/patient-list" component={PatientList} />
          <Route path="/appointment-details" component={AppointmentDetails} />
          {role == ROLE.DOCTOR && <Route exact path="/" component={DoctorPage} />}
          {role == ROLE.PATIENT && <Route exact path="/" component={PatientPage} />}
        </Switch>

        <Footer />
      </Router>
    </div>
  );
};
export default App;
