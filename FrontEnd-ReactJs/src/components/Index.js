import React, {Component} from 'react'

import Header from './Header/Header';
import Slide from './Header/Slide';
import Footer from './Footer/Footer';
import Restau_index from './Product/ProductHomePage';
import ChambresHomePage from './Chambre/ChambresHomePage';
import Info_index from './Information/Info_index';

export default class Index extends Component {
    state = {
        userData: null
    }

    componentWillMount() {
        const data = JSON.parse(localStorage.getItem('token'))
        this.setState({userData: data}, () => {
            console.log(this.state.userData)
        })
    }

    render() {
        return (
            <div>
                <Slide/>
                <Info_index/>
                <ChambresHomePage/>
                <Restau_index/>
            </div>
        )
    }
}
