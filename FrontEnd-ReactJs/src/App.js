import React, {Component} from 'react';
import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import SignUp from './components/Auth/SignUp';
import SignIn from './components/Auth/SignIn';
import Contact from './components/Pages/Contact';
import Chambres from './components/Chambre/Chambres';
import Index from './components/Index';
import {Provider} from 'react-redux';
import store from './store/store';
import Footer from "./components/Footer/Footer";
import Header from "./components/Header/Header";
import LogOut from "./components/Auth/LogOut";
import EditProfile from "./components/Auth/EditProfile";
import DetailChambre from "./components/Chambre/DetailChambre";
import Salles from "./components/Salle/Salles";
import DetailSalle from "./components/Salle/DetailSalle";
import Bureaux from "./components/Bureau/Bureaux";
import DetailBureau from "./components/Bureau/DetailBureau";
import Gallery from "./components/Gallery";
import Service from "./components/Service";
import ConditionGeneral from "./components/ConditionGeneral";
import AboutUs from "./components/AboutUs";
import MenuResturant from './components/MenuResturant';

class App extends Component {
    render() {
        return (
            <Provider store={store}>
                <Header/>
                <Router>
                    <Switch>
                        <Route exact component={Chambres} path="/ourRoom"></Route>
                        <Route exact component={Salles} path="/meetingRoom"></Route>
                        <Route exact component={Bureaux} path="/meetingOffice"></Route>
                        <Route exact component={MenuResturant} path="/menu"></Route>
                        <Route exact component={DetailSalle} path="/detail-room-meeting"></Route>
                        <Route exact component={DetailBureau} path="/detail-office-meeting"></Route>
                        <Route exact component={DetailChambre} path="/detail"></Route>
                        <Route exact component={SignUp} path="/signup"></Route>
                        <Route exact component={Gallery} path="/gallery"></Route>
                        <Route exact component={Service} path="/service"></Route>
                        <Route exact component={ConditionGeneral} path="/conditionGeneral"></Route>
                        <Route exact component={AboutUs} path="/aboutUs"></Route>
                        <Route exact component={SignIn} path="/signin"></Route>
                        <Route exact component={LogOut} path="/logout"></Route>
                        <Route exact component={EditProfile} path="/myprofile"></Route>
                        <Route exact component={Contact} path="/contact"></Route>
                        <Route exact component={Index} path="/"></Route>
                    </Switch>
                </Router>
                <Footer/>
            </Provider>
        );
    }
}

export default App;
