/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

/*
 * Created By : IDMANSOUR Mohamed
 */

/*
 * Created By : IDMANSOUR Mohamed
 */

/*
 * Created By : IDMANSOUR Mohamed
 */

/*
 * Created By : IDMANSOUR Mohamed
 */

/*
 * Created By : IDMANSOUR Mohamed
 */

/*
 * Created By : IDMANSOUR Mohamed
 */


import {
    URL,
    GET_CATEGORIE,
    EDIT_CATEGORIE, ADD_CATEGORIE, DELETE_CATEGORIE, GET_CATEGORIES
} from "../keys"
import axios from "axios"

export const getCategories = () => async (dispatch) => {
    const res = await axios.get(URL + "/categorieChambre/all")
    await dispatch({
        type: GET_CATEGORIES,
        data: res.data
    })
}

export const getCategorie = (id) => async (dispatch) => {
    const res = await axios.get(URL + '/categorieChambre/all' + id)
    await dispatch({
        type: GET_CATEGORIE,
        data: id
    })
}
export const editCategorie = (id) => async (dispatch) => {
    await dispatch({
        type: EDIT_CATEGORIE,
        data: id
    })
}
export const addCategorie = (u) => (dispatch) => {
    dispatch({
        type: ADD_CATEGORIE,
        data: u
    })
}

export const deleteCategorie = (id) => (dispatch) => {
    dispatch({
        type: DELETE_CATEGORIE,
        data: id
    })
}