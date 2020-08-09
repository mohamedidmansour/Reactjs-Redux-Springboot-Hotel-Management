import {} from "../keys"
import {GET_BUREAUX} from "../keys";

const initialState = {
    bureaux: []

}

export default function (state = initialState, action) {
    switch (action.type) {
        case GET_BUREAUX:
            return {
                ...state,
                bureaux: [action.data, ...state.bureaux]
            }


        default: {
            return state
        }
    }
}