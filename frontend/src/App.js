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

const App = () => {
  const { isLoggedIn, role } = useSelector((store) => ({
    isLoggedIn: store.isLoggedIn,
    role: store.role,
  }));
  console.log("app.js", role);
  return (
    <div className="App">
      <Router>
        <TopBar />
        <Switch>
          {!role && <Route exact path="/" component={HomePage} />}
          {!isLoggedIn && <Route path="/signup" component={PatientSignupPage} />}
          {!isLoggedIn && <Route path="/login" component={LoginPage} />}
          {role == ROLE.ADMIN && <Route path="/" component={AdminPage} />}
          {role == ROLE.DOCTOR && <Route path="/" component={DoctorPage} />}
          {role == ROLE.PATIENT && <Route path="/" component={PatientPage} />}
        </Switch>

        <Footer />
      </Router>
    </div>
  );
};
export default App;
