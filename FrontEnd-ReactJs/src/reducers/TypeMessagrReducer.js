import {GET_TYPE_MESSAGES} from "../keys";


const initialState = {
    typeMessages: []

}

export default function (state = initialState, action) {
    switch (action.type) {

        case GET_TYPE_MESSAGES:
            return {
                ...state,
                typeMessages: action.data
            }
        default: {
            return state
        }
    }
}