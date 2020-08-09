import {GET_SALLES} from "../keys"

const initialState = {
    salles: []

}

export default function (state = initialState, action) {
    switch (action.type) {
        case GET_SALLES:
            return {
                ...state,
                salles: [action.data, ...state.salles]
            }


        default: {
            return state
        }
    }
}