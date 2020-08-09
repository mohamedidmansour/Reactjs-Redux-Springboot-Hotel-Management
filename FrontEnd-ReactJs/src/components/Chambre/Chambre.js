import React, {Component} from 'react'
import PropTypes from 'prop-types';
import {Redirect} from 'react-router-dom';

class Chambre extends Component {

    constructor(props) {
        super(props)
    }

    storeIdRoom = () => localStorage.setItem("chambre_detail", JSON.stringify(this.props.chambre))
    getImage = (chambre) => {
        var i = ""
        if (chambre.images != null) {
            chambre.images.map(ee => {
                i = ee.url
            })
        }
        return i
    }

    render() {
        const chambre = this.props.chambre;
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
                <img src={this.getImage(chambre)} alt="image not found"/>
                <div class="room-box-in">
                    <h5 class="">pool suite</h5>
                    <p class="mt-3">{chambre.description}</p>
                    <a class="mt-1 btn btn-primary" href="/detail" onClick={
                        this.storeIdRoom
                    }>book from {chambre.prix}$</a>
                    <div class="room-icons mt-4 pt-4">
                        <img src="img/5.svg" alt=""/>
                        <img src="img/2.svg" alt=""/>
                        <img src="img/3.svg" alt=""/>
                        <a href="/detail" className="cursor" onClick={
                            this.storeIdRoom
                        }>plus info</a>
                    </div>
                </div>
            </div>
        )
    }
}

Chambre.propTypes = {
    chambre: PropTypes.object.isRequired
};
export default Chambre;
