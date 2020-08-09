import {} from "../keys"
import axios from "axios"
import {GET_BUREAUX} from "../keys";
import {URL} from "../keys";

export const getBureaux = () => async (dispatch) => {
    const res = await axios.get(URL + "/bureau/all")
    await dispatch({
        type: GET_BUREAUX,
        data: res.data
    })
}

export const getSallesFree = (obj) => async (dispatch) => {
     await axios.post(URL + "/bureau/all", obj).then(re=>{
         console.log(re.data)
        dispatch({
            type: GET_BUREAUX,
            data: re.data
        })
    }).catch(e=>{
        console.log(e)

    })


}
