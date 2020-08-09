import React, {Component} from 'react'
import PropTypes from 'prop-types';
import {Redirect} from 'react-router-dom';

class Salle extends Component {

    constructor(props) {
        super(props)
    }

    storeIdRoom = () => localStorage.setItem("salle_detail", JSON.stringify(this.props.salle))
    getImage = (salle) => {
        var i = ""
        if (salle.images != null) {
            salle.images.map(ee => {
                i = ee.url
            })
        }
        return i
    }

    render() {
        const salle = this.props.salle;
        return (
            <div class="room-box background-grey">
                <div class="room-name"></div>
                <div class="room-per">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                </div>
                <img src={this.getImage(salle)} alt="image not found"/>
                <div class="room-box-in">
                    <p class="mt-1">{salle.description}</p>
                    <a class="mt-1 btn btn-primary" href="/detail-room-meeting" onClick={
                        this.storeIdRoom
                    }>book from {salle.prix}$</a>
                    <div class="room-icons mt-4 pt-4">
                        <i className="fa fa-star"></i>
                        <i className="fa fa-star"></i>
                        <i className="fa fa-star"></i>
                        <i className="fa fa-star"></i>
                        <i className="fa fa-star"></i>
                        <a href="/detail-room-meeting" className="cursor" onClick={
                            this.storeIdRoom
                        }>full info</a>
                    </div>
                </div>
            </div>
        )
    }
}

Salle.propTypes = {
    salle: PropTypes.object.isRequired
};
export default Salle;
