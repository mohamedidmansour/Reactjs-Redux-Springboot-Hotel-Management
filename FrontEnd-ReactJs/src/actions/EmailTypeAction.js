import {
    GET_TYPE_MESSAGES,

    URL
} from "../keys"
import axios from "axios"

export const getTypeMessage = () => async (dispatch) => {
    await axios.get(URL + "/typeMessage/all").then(res => {
        dispatch({
            type: GET_TYPE_MESSAGES,
            data: res.data
        })
    }).catch(err => {
        console.log(err)
    })

}