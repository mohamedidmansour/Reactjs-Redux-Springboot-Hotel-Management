import {GET_CHAMBRES, GET_CHAMBRE, EDIT_CHAMBRE, ADD_CHAMBRE, DELETE_CHAMBRE, URL} from "../keys"
import axios from "axios"

export const getChambres = () => async (dispatch) => {
    const res = await axios.get(URL + "/chambre/all")
    await dispatch({
        type: GET_CHAMBRES,
        data: res.data
    })

}

export const getRoomsFree = (obj) => async (dispatch) => {
     await axios.post(URL + "/chambre/allFree", obj).then(re=>{
         console.log(re.data)
        dispatch({
            type: GET_CHAMBRES,
            data: re.data
        })
    }).catch(e=>{
        console.log(e)

    })


}

export const getChambre = (id) => async (dispatch) => {
    await dispatch({
        type: GET_CHAMBRE,
        data: id
    })

}
export const editChambre = (id) => async (dispatch) => {
    await dispatch({
        type: EDIT_CHAMBRE,
        data: id
    })
}
export const addChambre = (u) => (dispatch) => {
    dispatch({
        type: ADD_CHAMBRE,
        data: u
    })
}

export const deleteChambre = (id) => (dispatch) => {
    dispatch({
        type: DELETE_CHAMBRE,
        data: id
    })
}