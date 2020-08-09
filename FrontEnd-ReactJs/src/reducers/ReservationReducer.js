import {} from "../keys"
import {ADD_RESERVATION} from "../keys";
import {GET_RESERVATIONS} from "../keys";
import {GET_RESERVATION} from "../keys";
import {DELETE_RESERVATION} from "../keys";
import {EDIT_RESERVATION} from "../keys";

const initialState = {
    reservations: []

}

export default function (state = initialState, action) {
    switch (action.type) {
        case ADD_RESERVATION:
            return {
                ...state,
                reservations: [action.data, ...state.reservations]
            }
        case GET_RESERVATIONS:
            return {
                ...state,
                reservations: action.data
            }
        case GET_RESERVATION:
            return {
                ...state,
                reservation: state.reservations.find(reservation => reservation.id == action.data)
            }

        case DELETE_RESERVATION:
            return {
                ...state,
                categories: state.reservations.filter(reservation => reservation.id != action.data)
            }
        case EDIT_RESERVATION:
            return {
                ...state,
                categories: state.reservations.map(reservation => {
                    if (reservation.id == action.data.id) {
                        reservation = action.data
                    }
                    return reservation
                })
            }
        default: {
            return state
        }
    }
}