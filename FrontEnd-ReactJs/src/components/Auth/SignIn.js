import React, {Component} from 'react'
import './Auth.css'
//  import 'bootstrap/dist/css/bootstrap.min.css'
import Axios from 'axios'
import {URL} from '../../keys'
import Header from "../Header/Header";
import Footer from "../Footer/Footer";
// import 'font-awesome/css/font-awesome.min.css'
export default class SignIn extends Component {

    constructor() {
        super()
        this.state = {
            username: '',
            password: '',
            userData: null
        }
    }

    componentWillMount() {
        if(localStorage.getItem("token") != null){
            this.props.history.push('/')
        }
    }

    signUp = (event) => {
        event.preventDefault()
        Axios.defaults.headers = {
            'Content-Type': 'application/json'
        }
        Axios.post(URL + "/signIn", this.state)
            .then(response => {
                this.setState({userDate: response.data}, () => {
                    localStorage.setItem('token', JSON.stringify(response.data));
                });
                window.location.reload(false);
                this.props.history.push('/')
            })
            .catch(error => {
                console.log(error);
            })
    }
    inputValueChange = e => this.setState({[e.target.name]: e.target.value});

    render() {
        const {username, password} = this.state
        return (
            <div>
                <div className="section big-55-height over-hide z-bigger">
                    <div className="parallax parallax-top" style={{backgroundImage: 'url(img/1.jpg)'}}></div>
                    <div className="dark-over-pages"></div>

                    <div className="hero-center-section pages">
                        <div className="container">
                            <div className="row justify-content-center">
                                <div className="col-12 parallax-fade-top">
                                    <div className="hero-text">SIGN IN</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="container">
                    <div className="row">
                        <div className="col-xl-12">
                            <div className="card" style={{textAlign: "left"}}>
                                <div className="card-body p-5">
                                    <form onSubmit={this.signUp}>
                                        <div className="form-row pad">
                                            <div className="col">
                                                <input type="text" name="username" defaultValue={username}
                                                       onChange={this.inputValueChange}
                                                       className="form-control input_sing"
                                                       required
                                                       id="exampleInputEmail3" aria-describedby="emailHelp"
                                                       placeholder="Enter votre email"/>
                                            </div>
                                            <div className="col">
                                                <input type="password" name="password" defaultValue={password}
                                                       onChange={this.inputValueChange}
                                                       className="form-control input_sing"
                                                       required
                                                       id="exampleInputEmail" aria-describedby="emailHelp"
                                                       placeholder="Enter votre mot de passe"/>
                                            </div>
                                            <button type="submit" className="btn btn-primary btn-block mt-2">SIGN IN
                                            </button>
                                        </div>
                                    </form>
                                </div>
                                <div className="card-footer text-muted">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}
