import {GET_CATEGORIE, GET_CATEGORIES, EDIT_CATEGORIE, ADD_CATEGORIE, DELETE_CATEGORIE} from "../keys"

const initialState = {
    categories: []

}

export default function (state = initialState, action) {
    switch (action.type) {
        case ADD_CATEGORIE:
            return {
                ...state,
                categories: [action.data, ...state.categories]
            }
        case GET_CATEGORIES:
            return {
                ...state,
                categories: [action.data, ...state.categories]
            }
        case GET_CATEGORIE:
            return {
                ...state,
                categorie: state.chambres.find(categorie => categorie.id == action.data)
            }

        case DELETE_CATEGORIE:
            return {
                ...state,
                categories: state.chambres.filter(categorie => categorie.id != action.data)
            }
        case EDIT_CATEGORIE:
            return {
                ...state,
                categories: state.chambres.map(categorie => {
                    if (categorie.id == action.data.id) {
                        categorie = action.data
                    }
                    return categorie
                })
            }
        default: {
            return state
        }
    }
}