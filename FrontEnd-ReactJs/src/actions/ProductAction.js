import {
    ADD_PRODUCT, DELETE_PRODUCT,
    EDIT_PRODUCT,
    GET_PRODUCT,
    GET_PRODUCTS,
    URL,
} from "../keys"
import axios from "axios"

export const getProducts = () => async (dispatch) => {
    const res = await axios.get(URL + "/produit/all")
    await dispatch({
        type: GET_PRODUCTS,
        data: res.data
    })
}

export const getProduct = (id) => async (dispatch) => {
    const res = await axios.get(URL + '/produit/all' + id)
    await dispatch({
        type: GET_PRODUCT,
        data: id
    })
}
export const editProduct = (id) => async (dispatch) => {
    await dispatch({
        type: EDIT_PRODUCT,
        data: id
    })
}
export const addProduct = (u) => (dispatch) => {
    dispatch({
        type: ADD_PRODUCT,
        data: u
    })
}

export const deleteProduct = (id) => (dispatch) => {
    dispatch({
        type: DELETE_PRODUCT,
        data: id
    })
}