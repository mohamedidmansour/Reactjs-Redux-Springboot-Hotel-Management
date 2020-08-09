import React, {Component} from 'react';
import {Link} from "react-router-dom";

class MenuLeft extends Component {


    render() {
        const {nom, prenom} = this.props
        return (
            <div className="col-xl-4 section background-dark p-4">
                <ul className="list-unstyled menu-back cbp-af-header">
                    <li><img width="100"
                             src="data:image/png;base64,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"
                             alt=""/></li>
                    <li><h5 className="color-white mb-3">{`${prenom} ${nom}`}</h5></li>
                    <li></li>
                    <li></li>
                    <h6 className="color-white mb-2">Profile Service</h6>
                    <li className="mt-3 cursorLi">Edit Profile Data
                    </li>
                    <li className="cursorLi"><a className="btn btn-link" href="/profile/reservation">My Reservations</a>
                    </li>
                    <li className="cursorLi"><a className="btn btn-link" href="">Carte Bancaire</a></li>
                    <li className="cursorLi"><a className="btn btn-link" href="">Envoyer Email</a></li>
                </ul>
                <nav>
                </nav>
            </div>
        );
    }
}

export default MenuLeft;