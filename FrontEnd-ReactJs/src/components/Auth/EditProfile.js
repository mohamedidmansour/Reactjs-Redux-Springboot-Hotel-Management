import React, {Component} from 'react';
import Axios from "axios";
import {URL} from "../../keys";
import MenuLeft from "./MenuLeft";
import Reservations from "../Reservation/Reservations";
import Email from "../Email/Email";
import './Auth.css'

class EditProfile extends Component {

    show = 1
    state = {
        id: null,
        nom: null,
        prenom: null,
        username: null,
        password: null,
        repassword: null,
        adresse: null,
        tel: null,
        cne: null
    }

    componentWillMount() {
        this.show = parseInt(localStorage.getItem('e'))
        if (localStorage.getItem("token") == null) {
            this.props.history.push('/')
        } else {
            const c = JSON.parse(localStorage.getItem("token"))
            console.log(c.id)
            this.setState({
                id: c.id,
                nom: c.nom,
                prenom: c.prenom,
                username: c.username,
                password: null,
                repassword: null,
                adresse: c.adresse,
                tel: c.tel,
                cne: c.cne
            })
        }
    }

    inputValueChange = e => this.setState({[e.target.name]: e.target.value});
    reload = () => {
        localStorage.setItem('e', this.show)
        window.location.reload(false);
    }
    update = (event) => {
        event.preventDefault()
        console.log(this.state);
        Axios.post(URL + '/update', this.state)
            .then(response => {
                localStorage.removeItem("token")
                localStorage.setItem("token", JSON.stringify(this.state))
                this.props.history.push('/')
            })
            .catch(error => console.log(error))
    }

    render() {
        const {nom, prenom, username, repassword, password, adresse, tel, cne} = this.state
        return (
            <div>
                <div className="section big-55-height over-hide z-bigger">
                    <div className="parallax parallax-top" style={{backgroundImage: 'url(img/gallery/10.jpg)'}}></div>
                    <div className="dark-over-pages"></div>

                    <div className="hero-center-section pages">
                        <div className="container">
                            <div className="row justify-content-center">
                                <div className="col-12 parallax-fade-top">
                                    <div className="hero-text">Profile</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="container pad">
                    <div className="row">
                        <div className="col-xl-4 section background-dark p-4">
                            <ul className="list-unstyled menu-back cbp-af-header">
                                <li><img width="100"
                                         src="data:image/png;base64,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"
                                         alt=""/></li>
                                <li><h5 className="color-white mb-3 pt-3">{`${prenom} ${nom}`}</h5></li>
                                <li></li>
                                <li></li>
                                <hr className="color-white"/>
                                <li className={this.show == 1 ? ' color-white cursorLi' : 'cursorLi'}><span
                                    onClick={() => {
                                        this.show = 1
                                        this.reload()
                                    }}>Modifier Profile</span></li>
                                <li className={this.show == 2 ? ' color-white cursorLi' : 'cursorLi'}><span
                                    onClick={() => {
                                        this.show = 2
                                        this.reload()
                                    }}>Mes Reservation</span></li>
                                <li className={this.show == 4 ? ' color-white cursorLi' : 'cursorLi'}><span
                                    onClick={() => {
                                        this.show = 4
                                        this.reload()
                                    }}>Notification Email</span></li>

                            </ul>
                            <nav>
                            </nav>
                        </div>
                        <div className="col-xl-8">
                            <div className="card" style={{textAlign: "left"}}>
                                <div className="card-header">
                                </div>
                                <div className="card-body">
                                    {this.show == 1 ?
                                        <form onSubmit={this.update}>
                                            <div className="form-group mb-1">
                                                <label htmlFor="exampleInputEmail1">Nom</label>
                                                <input type="text" name="nom" defaultValue={nom}
                                                       onChange={this.inputValueChange} className="form-control"
                                                       required
                                                       id="exampleInputEmail1" aria-describedby="emailHelp"
                                                       placeholder="Enter votre nom"/>
                                            </div>
                                            <div className="form-group mb-1">
                                                <label htmlFor="exampleInputEmail2">Prenom</label>
                                                <input type="text" name="prenom" defaultValue={prenom}
                                                       onChange={this.inputValueChange} className="form-control"
                                                       required
                                                       id="exampleInputEmail2" aria-describedby="emailHelp"
                                                       placeholder="Enter votre prenom"/>
                                            </div>
                                            <div className="form-group mb-1">
                                                <label htmlFor="exampleInputEmail3">Email Adresse</label>
                                                <input type="email" name="username" defaultValue={username}
                                                       onChange={this.inputValueChange} className="form-control"
                                                       required
                                                       id="exampleInputEmail3" aria-describedby="emailHelp"
                                                       placeholder="Enter votre email"/>
                                            </div>
                                            <div className="form-group mb-1">
                                                <label htmlFor="exampleInputEmail">Mot de passe </label>
                                                <input type="password" name="password" defaultValue={password}
                                                       onChange={this.inputValueChange} className="form-control"
                                                       required
                                                       id="exampleInputEmail" aria-describedby="emailHelp"
                                                       placeholder="Enter votre mot de passe"/>
                                            </div>
                                            <div className="form-group mb-1">
                                                <label htmlFor="exampleInputEmail">Confirmer Mot de passe </label>
                                                <input type="password" name="repassword" defaultValue={repassword}
                                                       onChange={this.inputValueChange} className="form-control"
                                                       required
                                                       id="exampleInputEmailTwo" aria-describedby="emailHelp"
                                                       placeholder="Confirmer votre mot de passe"/>
                                            </div>
                                            <div className="form-group mb-1">
                                                <label htmlFor="exampleInputEmail4">Numero CNE</label>
                                                <input type="text" name="cne" defaultValue={cne}
                                                       onChange={this.inputValueChange} className="form-control"
                                                       required
                                                       id="exampleInputEmail4" aria-describedby="emailHelp"
                                                       placeholder="Enter votre cne"/>
                                            </div>
                                            <div className="form-group mb-1">
                                                <label htmlFor="exampleInputEmail5">N° Tel</label>
                                                <input type="tel" name="tel" defaultValue={tel}
                                                       onChange={this.inputValueChange} className="form-control"
                                                       required
                                                       id="exampleInputEmail5" aria-describedby="emailHelp"
                                                       placeholder="Enter votre N°tel"/>
                                            </div>
                                            <div className="form-group mb-1">
                                                <label htmlFor="exampleInputEmail6">Adresse </label>
                                                <input type="text" name="adresse" defaultValue={adresse}
                                                       onChange={this.inputValueChange} className="form-control"
                                                       required
                                                       id="exampleInputEmail6" aria-describedby="emailHelp"
                                                       placeholder="Enter votre adresse"/>
                                            </div>
                                            <button type="submit" className="btn btn-primary btn-block">MODIFIER</button>
                                        </form>
                                        : null
                                    }
                                    {this.show == 2 ?
                                        <Reservations/>
                                        : null
                                    }
                                    {this.show == 4 ?
                                        <Email/>
                                        : null
                                    }
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

export default EditProfile