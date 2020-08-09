import React, {Component} from 'react';
import {connect} from "react-redux";
import {getReservationsRoom} from "../../actions/ReservationAction";
import Chambre from "../Chambre/Chambre";
import Reservation from "./Reservation";

class Reservations extends Component {
    state = {
        isLoading: true,
        notFound: true,
        data: null
    }

    async componentWillMount() {
        await this.props.getReservationsRoom()
        this.setState({
            data: this.props.reservations
        }, () => {
            this.setState({isLoading: false, notFound: false})
            console.log(this.props.reservations[0])
        })
    }

    render() {
        return (
            <div>
                {this.state.isLoading ?
                    <img  src="/img/loading.gif"/> : this.state.notFound ? 'Not Found !!' :
                    <section>
                        {
                            this.state.data.map((value, index)=>{
                              return <Reservation chambre={value[0]} reservation={value[1]}/>
                            })
                        }
                    </section>
                }
            </div>
        );
    }
}

const mapStateToProps = (state) => {
    return {
        reservations: state.reservations.reservations
    }
}
export default connect(mapStateToProps, {getReservationsRoom})(Reservations)