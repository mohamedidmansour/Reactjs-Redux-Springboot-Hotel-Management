import {GET_CHAMBRES, GET_CHAMBRE, EDIT_CHAMBRE, ADD_CHAMBRE, DELETE_CHAMBRE} from "../keys"

const initialState = {
    chambres: []

}

export default function (state = initialState, action) {
    switch (action.type) {
        case ADD_CHAMBRE:
            return {
                ...state,
                chambres: [action.data, ...state.chambres]
            }
        case GET_CHAMBRES:
            return {
                ...state,
                chambres: [action.data, ...state.chambres]
            }
        case GET_CHAMBRE:
            return {
                ...state,
                user: state.chambres.find(user => user.id == action.data)
            }

        case DELETE_CHAMBRE:
            return {
                ...state,
                chambres: state.chambres.filter(user => user.id != action.data)
            }
        case EDIT_CHAMBRE:
            return {
                ...state,
                chambres: state.chambres.map(user => {
                    if (user.id == action.data.id) {
                        user = action.data
                    }
                    return user
                })
            }
        default: {
            return state
        }
    }
}