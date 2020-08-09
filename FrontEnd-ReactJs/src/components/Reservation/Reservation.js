import React, {Component} from 'react';
import PropTypes from 'prop-types';
import Chambre from "../Chambre/Chambre";
import './style.css'

class Reservation extends Component {
    moreDetail = () => {
        console.log(this.props.chambre)
    }
    getImage = (chambre) => {
        let i = ""
        if (chambre.images != null) {
            chambre.images.map(ee => {
                i = ee.url
            })
        }
        return i
    }

    render() {
        const chambre = this.props.chambre;
        const reservation = this.props.reservation;
        return (
            <div className="col-sm-6 pt-3 float-left">
                <div className="card">
                    <img className="widh-15" src={this.getImage(chambre)} alt="image not found"/>
                    <span className="mt-1 btn btn-primary" href="rooms-gallery.html">Montant : <u>{chambre.prix}</u>$</span>
                    <span className="btn btn-primary"
                          title={reservation.etat ? 'confirmed' : 'no confirmed'}>{reservation.dateDebut} - {reservation.dateFin} {reservation.etat ? '✅' : '⤬'}</span>

                </div>
            </div>
        );
    }
}

Reservation.propTypes = {};

export default Reservation;