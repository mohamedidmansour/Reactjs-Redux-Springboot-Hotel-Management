import React, {Component} from 'react'
import PropTypes from 'prop-types';
import {Redirect} from 'react-router-dom';

class Bureau extends Component {

    constructor(props) {
        super(props)
    }

    storeIdRoom = () => localStorage.setItem("bureau_detail", JSON.stringify(this.props.bureau))
    getImage = (bureau) => {
        var i = ""
        if (bureau.images != null) {
            bureau.images.map(ee => {
                i = ee.url
            })
        }
        return i
    }

    render() {
        const bureau = this.props.bureau;
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
                <img src={this.getImage(bureau)} alt="image not found"/>
                <div class="room-box-in">
                    <p class="mt-1">{bureau.description}</p>
                    <a class="mt-1 btn btn-primary" href="/detail-office-meeting" onClick={
                        this.storeIdRoom
                    }>book from {bureau.prix}$</a>
                    <div class="room-icons mt-4 pt-4">
                        <i className="fa fa-star"></i>
                        <i className="fa fa-star"></i>
                        <i className="fa fa-star"></i>
                        <i className="fa fa-star"></i>
                        <i className="fa fa-star"></i>
                        <a href="/detail-office-meeting" className="cursor" onClick={
                            this.storeIdRoom
                        }>full info</a>
                    </div>
                </div>
            </div>
        )
    }
}

Bureau.propTypes = {
    bureau: PropTypes.object.isRequired
};
export default Bureau;
