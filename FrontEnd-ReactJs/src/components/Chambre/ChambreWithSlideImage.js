import React, {Component} from 'react'
import PropTypes from 'prop-types';
import {Redirect} from 'react-router-dom';

class ChambreWithSlideImage extends Component {

    constructor(props) {
        super(props)
    }

    storeIdRoom = () => localStorage.setItem("idChambre", this.props.chambre.id)
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
                <div className="section">
                    <div id="rooms-sync2" className="owl-carousel">
                        <div className="item">
                            <img src="img/gallery/2-s.jpg" alt=""/>
                        </div>
                        <div className="item">
                            <img src="img/gallery/3-s.jpg" alt=""/>
                        </div>
                        <div className="item">
                            <img src="img/gallery/4-s.jpg" alt=""/>
                        </div>
                        <div className="item">
                            <img src="img/gallery/5-s.jpg" alt=""/>
                        </div>
                        <div className="item">
                            <img src="img/gallery/6-s.jpg" alt=""/>
                        </div>
                        <div className="item">
                            <img src="img/gallery/7-s.jpg" alt=""/>
                        </div>
                        <div className="item">
                            <img src="img/gallery/8-s.jpg" alt=""/>
                        </div>
                        <div className="item">
                            <img src="img/gallery/9-s.jpg" alt=""/>
                        </div>
                    </div>
                </div>
                <div className="section pt-5">
                    <h5>discription</h5>
                    <p className="mt-3">Neque porro quisquam est, qui dolorem ipsum quia dolor sit
                        amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora
                        incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad
                        minima veniam, quis nostrum exercitationem ullam corporis suscipit
                        laboriosam, nisi ut aliquid ex ea commodi consequatur.</p>
                </div>
            </div>
        )
    }
}

ChambreWithSlideImage.propTypes = {
    chambre: PropTypes.object.isRequired
};
export default ChambreWithSlideImage;
