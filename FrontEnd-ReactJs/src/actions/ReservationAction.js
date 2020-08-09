import {
    ADD_RESERVATION, DELETE_RESERVATION,
    EDIT_RESERVATION,
    GET_RESERVATION,
    GET_RESERVATIONS,
    URL
} from "../keys"
import axios from "axios"

export const getReservationsRoom = () => async (dispatch) => {
    const obj = JSON.parse(localStorage.getItem("token"))
    await axios.get(URL + "/reservation/all/byClient/" + obj.id).then(res => {
        console.log(res.data)
        dispatch({
            type: GET_RESERVATIONS,
            data: res.data
        })
    }).catch(err => {
        console.log(err)
    })

}

export const getReservation = (id) => async (dispatch) => {
    const res = await axios.get(URL + '/all/byClient/' + id)
    await dispatch({
        type: GET_RESERVATION,
        data: id
    })
}
export const editReservation = (id) => async (dispatch) => {
    await dispatch({
        type: EDIT_RESERVATION,
        data: id
    })
}
export const addReservation = (u) => (dispatch) => {
    dispatch({
        type: ADD_RESERVATION,
        data: u
    })
}

export const deleteReservation = (id) => (dispatch) => {
    dispatch({
        type: DELETE_RESERVATION,
        data: id
    })
}