import React, {Component} from 'react'
import {connect} from 'react-redux'
import {getBureaux} from '../../actions/BureauAction'
import Bureau from "./Bureau";
import Select from 'react-select';
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";


class Bureaux extends Component {
    // format date `${e.getDate()}/${e.getFullYear()}/${e.getMonth() + 1}`
    state = {
        checkInDate: new Date(),
        checkOutDate: new Date(),
        valuePrice: 500,
        loading: true,
        bureaux: null,
    }

    async componentWillMount() {
        const cat = await this.props.getBureaux()
        this.setState({
            bureaux: this.props.bureaux[0],
        }, () => {
            this.setState({loading: false})
        })
    }


    clickFilter = async () => {
        await this.props.getRoomsFree({
                dateDebut: new Date(this.state.checkInDate),
                dateFin: new Date(this.state.checkOutDate),
                prix: this.state.valuePrice,
            }
        )
        this.setState({bureaux: this.props.bureaux[0]}, () => {
            console.log(this.state.bureaux)
        })
    }

    render() {
        return (
            <div>
                <div class="section big-55-height over-hide z-bigger">
                    <div class="parallax parallax-top" style={{backgroundImage: 'url(img/1.jpg)'}}></div>
                    <div class="dark-over-pages"></div>

                    <div class="hero-center-section pages">
                        <div class="container">
                            <div class="row justify-content-center">
                                <div class="col-12 parallax-fade-top">
                                    <div class="hero-text">Les Bureaux</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="section padding-top-bottom z-bigger">
                    <div class="section z-bigger">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-8 mt-4 mt-lg-0">
                                    <div class="row">
                                        {this.state.loading == true ?
                                            <img className="offset-5" src="/img/loading.gif"/> :
                                            this.state.bureaux.map(c => (
                                                <div className="col-lg-6 mt-4 mt-lg-0 "
                                                     data-scroll-reveal="enter bottom move 50px over 0.7s after 0.4s">
                                                    <Bureau key={c.id} bureau={c}/>
                                                </div>
                                            ))
                                        }
                                        <div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 order-first order-lg-last">
                                    <div class="section background-dark p-4">
                                        <div class="row">
                                            <div class="col-12">
                                                <div class="input-daterang input-group" id="fligh-datepicker">
                                                    <div class="row">
                                                        <h6 className="color-white mb-3">Vérifier la disponibilité</h6>
                                                        <div className="col-12 ">

                                                            <DatePicker selected={this.state.checkInDate}
                                                                        showPopperArrow={false}
                                                                        onChange={(e) => {
                                                                            this.setState({checkInDate: e})
                                                                            console.log(e)
                                                                        }}/>

                                                        </div>
                                                        <div class="col-12 pt-4">

                                                            <DatePicker
                                                                style={{width: "100%"}}
                                                                selected={this.state.checkOutDate}
                                                                showPopperArrow={false}
                                                                onChange={(e) => {
                                                                    this.setState({checkOutDate: e})
                                                                }}/>
                                                            <span className="date-text date-depart"></span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-12 pt-5">
                                                <h6 className="color-white mb-3">Max Montant:</h6>
                                                <div className="selecteurPrix2">
                                                    <div className="range-slider">
                                                        <input defaultValue={this.state.valuePrice} onChange={(e) => {
                                                            this.setState({valuePrice: e.target.value}, () => {
                                                                console.log(this.state.valuePrice)
                                                            })
                                                        }} type="range" className="input-range" id="points"
                                                               name="points" min="300" max="4000"/>
                                                        <div className="valeurPrix">
                                                            <span className="range-value"></span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-12 col-md-6 col-lg-12 pt-5">
                                                <h6 class="color-white mb-3">Services:</h6>
                                                <ul class="list">
                                                    <li class="list__item">
                                                        <label class="label--checkbox">
                                                            <input type="checkbox" class="checkbox"/>
                                                            Pot d'accueil
                                                        </label>
                                                    </li>
                                                    <li class="list__item">
                                                        <label class="label--checkbox">
                                                            <input type="checkbox" class="checkbox"/>
                                                            no smoking
                                                        </label>
                                                    </li>
                                                </ul>
                                            </div>
                                            <div class="col-12 col-md-6 col-lg-12 pt-5">
                                                <h6 class="color-white mb-3">Extra services:</h6>
                                                <ul class="list">
                                                    <li class="list__item">
                                                        <label class="label--checkbox">
                                                            <input type="checkbox" class="checkbox"/>
                                                            Vue sur la mer
                                                        </label>
                                                    </li>
                                                    <li class="list__item">
                                                        <label class="label--checkbox">
                                                            <input type="checkbox" class="checkbox"/>
                                                            Blanchisserie
                                                        </label>
                                                    </li>
                                                    <li class="list__item">

                                                    </li>
                                                </ul>
                                                <button onClick={this.clickFilter} style={{width: "100%"}}
                                                        className="mt-1 mb-3 btn btn-primary"
                                                        href="rooms-gallery.html">
                                                    Filter Bureaux
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

const mapStateToProps = (state) => {
    return {
        bureaux: state.bureaux.bureaux
    }
}
export default connect(mapStateToProps, {getBureaux})(Bureaux)