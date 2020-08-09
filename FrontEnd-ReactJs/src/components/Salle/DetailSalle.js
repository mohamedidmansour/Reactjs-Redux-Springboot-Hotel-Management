import React, {Component} from 'react';
import Header from "../Header/Header";
import Modal from 'react-modal';
import DatePicker from "react-datepicker";
import axios from "axios";
import {URL} from "../../keys";
import Salle from "./Salle";
import {connect} from "react-redux";
import {getSalles} from "../../actions/SalleAction";

class DetailSalle extends Component {
    state = {
        salles: null,
        loadingSalles: true,
        salle: JSON.parse(localStorage.getItem('salle_detail')),
        checkOutDate: new Date(),
        checkInDate: new Date(),
        client: JSON.parse(localStorage.getItem('token')),
        Difference_In_Days: null
    }
    onChangeDate = () => {
        let Difference_In_Time = this.state.checkOutDate.getTime() - this.state.checkInDate.getTime();
        this.setState({Difference_In_Days: parseInt((Difference_In_Time / (1000 * 3600 * 24)) + 0.1)});
    }
    bookNow = async () => {
        if (window.confirm("Voullez-vous vraiment reserver la salle ?")) {
            axios.post(URL + '/reservation/salle/save', {
                //yyyy-MM-dd
                idEspace: this.state.salle.id,
                checkOutDate: this.state.checkOutDate.getFullYear() + '-' + (this.state.checkOutDate.getMonth() + 1) + '-' + this.state.checkOutDate.getDate(),
                checkInDate: this.state.checkInDate.getFullYear() + '-' + (this.state.checkInDate.getMonth() + 1) + '-' + this.state.checkInDate.getDate(),
                idClient: this.state.client.id
            }).then(res => {
                if (res.data.id != null)
                    alert("Bien Réserver")
                else
                    alert("déja la salle est réserver !!!")
            }).catch(err => {

            })
        }

        console.log({
            //yyyy-MM-dd
            idEspace: this.state.salle.id,
            checkOutDate: this.state.checkOutDate.getFullYear() + '-' + (this.state.checkOutDate.getMonth() + 1) + '-' + this.state.checkOutDate.getDate(),
            checkInDate: this.state.checkInDate.getFullYear() + '-' + (this.state.checkInDate.getMonth() + 1) + '-' + this.state.checkInDate.getDate(),
            idClient: this.state.client.id
        })
    }

    async componentWillMount() {
        const cat = await this.props.getSalles()
        this.setState({
            salles: this.props.salles[0].slice(0, 3),
        }, () => {
            this.setState({loadingSalles: false})
        })
    }

    render() {
        const salle = this.state.salle

        return (
            <div>
                <div className="section big-55-height over-hide">

                    <div className="parallax parallax-top" style={{backgroundImage: 'url(img/rooms.jpg)'}}></div>
                    <div className="dark-over-pages"></div>

                    <div className="hero-center-section pages">
                        <div className="container">
                            <div className="row justify-content-center">
                                <div className="col-12 parallax-fade-top">
                                    <div className="hero-text">Rooms Gallery</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div className="section background-dark padding-top-bottom-smaller over-hide">
                    <div className="section z-bigger">
                        <div className="container">
                            <div className="row">
                                <div className="col-6 col-sm-6 col-md-4 col-lg-2 text-center">
                                    <div className="amenities">
                                        <img src="img/icons/1.svg" alt=""/>
                                        <p>no smoking</p>
                                    </div>
                                </div>
                                <div className="col-6 col-sm-6 col-md-4 col-lg-2 text-center">
                                    <div className="amenities">
                                        <img src="img/icons/2.svg" alt=""/>
                                        <p>big beds</p>
                                    </div>
                                </div>
                                <div className="col-6 col-sm-6 col-md-4 col-lg-2 text-center mt-4 mt-md-0">
                                    <div className="amenities">
                                        <img src="img/icons/3.svg" alt=""/>
                                        <p>yacht riding</p>
                                    </div>
                                </div>
                                <div className="col-6 col-sm-6 col-md-4 col-lg-2 text-center mt-4 mt-lg-0">
                                    <div className="amenities">
                                        <img src="img/icons/4.svg" alt=""/>
                                        <p>free drinks</p>
                                    </div>
                                </div>
                                <div className="col-6 col-sm-6 col-md-4 col-lg-2 text-center mt-4 mt-lg-0">
                                    <div className="amenities">
                                        <img src="img/icons/5.svg" alt=""/>
                                        <p>swimming pool</p>
                                    </div>
                                </div>
                                <div className="col-6 col-sm-6 col-md-4 col-lg-2 text-center mt-4 mt-lg-0">
                                    <div className="amenities">
                                        <img src="img/icons/6.svg" alt=""/>
                                        <p>room breakfast</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <div className="section padding-top-bottom z-bigger">
                    <div className="section z-bigger">
                        <div className="container">
                            <div className="row">
                                <div className="col-lg-8 mt-4 mt-lg-0">
                                    <div className="section">
                                        <div className="customNavigation rooms-sinc-1-2">
                                            <a className="prev-rooms-sync-1"></a>
                                            <a className="next-rooms-sync-1"></a>
                                        </div>
                                        <div id="rooms-sync1" className="owl-carousel">
                                            {salle.images.map(im => {
                                                return <div className="item">
                                                    <img src={im.url} alt="not found"/>
                                                </div>
                                            })}
                                            <div className="item">
                                                <img
                                                    src="https://lh3.googleusercontent.com/proxy/3m98UuTiw65LaIPyiuZmBYOFmAZECZhy7N-OY6mITGeVnL8Q2fsGJPpXRR3P0I1Y7uHKIXPte0CnyM3YsIi4ITktHqjSrdgbVIg-gH4UsksrR8hEnuFNCe8tllBRSAzmOxVzwRF1X1DRqTHdZ-oYZac"
                                                    alt=""/>
                                            </div>
                                            <div className="item">
                                                <img
                                                    src="http://lightingequipmentsales.com/wp-content/uploads/2017/08/Meeting-Hall-Lighting-Design-740x416.jpg"
                                                    alt=""/>
                                            </div>
                                            <div className="item">
                                                <img
                                                    src="https://media-cdn.tripadvisor.com/media/photo-s/0b/8c/ec/c1/meeting-room-ball-room.jpg"
                                                    alt=""/>
                                            </div>
                                            <div className="item">
                                                <img
                                                    src="https://lh3.googleusercontent.com/proxy/3m98UuTiw65LaIPyiuZmBYOFmAZECZhy7N-OY6mITGeVnL8Q2fsGJPpXRR3P0I1Y7uHKIXPte0CnyM3YsIi4ITktHqjSrdgbVIg-gH4UsksrR8hEnuFNCe8tllBRSAzmOxVzwRF1X1DRqTHdZ-oYZac"
                                                    alt=""/>
                                            </div>
                                            <div className="item">
                                                <img
                                                    src="http://lightingequipmentsales.com/wp-content/uploads/2017/08/Meeting-Hall-Lighting-Design-740x416.jpg"
                                                    alt=""/>
                                            </div>
                                            <div className="item">
                                                <img
                                                    src="https://media-cdn.tripadvisor.com/media/photo-s/0b/8c/ec/c1/meeting-room-ball-room.jpg"
                                                    alt=""/>
                                            </div>
                                        </div>
                                    </div>
                                    <div className="section pt-5">
                                        <h5>discription</h5>
                                        <p className="mt-3">
                                            {salle.description}
                                        </p>
                                    </div>
                                    <div className="section pt-4">
                                        <div className="row">
                                            <div className="col-12">
                                                <h5 className="mb-3">Les Options</h5>
                                            </div>
                                            <div className="col-lg-6">
                                                <p><strong className="color-black">Nombre de
                                                    Chaise:</strong> {salle.nbrChaise}
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                    <div className="section pt-4">
                                        <h5>Features</h5>
                                        <p className="mt-3">Neque porro quisquam est, qui dolorem ipsum quia dolor sit
                                            amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora
                                            incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad
                                            minima veniam, quis nostrum exercitationem ullam corporis suscipit
                                            laboriosam, nisi ut aliquid ex ea commodi consequatur.</p>
                                    </div>
                                </div>
                                <div className="col-lg-4 order-first order-lg-last">
                                    <div className="section background-dark p-4">
                                        <div className="row">
                                            <div className="col-12">
                                                <div className="input-daterang input-group" id="fligh-datepicker">
                                                    <div className="row">
                                                        <div className="col-12 customDatePickerWidth">
                                                            <h6 className="color-white mb-3">Date Départ </h6>
                                                            <DatePicker selected={this.state.checkInDate}
                                                                        showPopperArrow={false}
                                                                        onChange={(e) => {
                                                                            this.setState({checkInDate: e}, () => {
                                                                                this.onChangeDate()
                                                                            })
                                                                            console.log(e)
                                                                        }}/>

                                                        </div>
                                                        <div className="col-12 pt-4">
                                                            <h6 className="color-white mb-3">Date Fin </h6>
                                                            <DatePicker
                                                                style={{width: "100%"}}
                                                                selected={this.state.checkOutDate}
                                                                showPopperArrow={false}
                                                                onChange={(e) => {
                                                                    this.setState({checkOutDate: e}, () => {
                                                                        this.onChangeDate()
                                                                    })
                                                                }}/>
                                                            <span className="date-text date-depart"></span>
                                                        </div>

                                                    </div>
                                                </div>
                                            </div>
                                            <div className="col-12">
                                                <div className="row">
                                                </div>
                                            </div>
                                            <div className="col-12 pt-4">
                                                <a className="booking-button" href="#" onClick={this.bookNow}>book
                                                    now {salle.prix}$/day
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <h5 className="p-2">Total à payer: <u>{
                                        this.state.Difference_In_Days * salle.prix

                                    }$</u></h5>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div className="section padding-bottom over-hide">
                    <div className="container">
                        <div className="row justify-content-center">
                            {this.state.loadingSalles ? 'loading Salles' :
                                this.state.salles.map(s => (
                                    <div className="col-lg-4"
                                         data-scroll-reveal="enter bottom move 50px over 0.7s after 0.2s">
                                        <div className="room-box background-grey">
                                            <Salle salle={s}/>
                                        </div>
                                    </div>
                                ))
                            }
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

const mapStateToProps = (state) => {
    return {
        salles: state.salles.salles
    }
}
export default connect(mapStateToProps, {getSalles})(DetailSalle)