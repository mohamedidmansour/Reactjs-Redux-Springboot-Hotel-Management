import {ADD_PRODUCT} from "../keys";
import {GET_PRODUCTS} from "../keys";
import {GET_PRODUCT} from "../keys";
import {DELETE_PRODUCT} from "../keys";
import {EDIT_PRODUCT} from "../keys";

const initialState = {
    products: []

}

export default function (state = initialState, action) {
    switch (action.type) {
        case ADD_PRODUCT:
            return {
                ...state,
                products: [action.data, ...state.products]
            }
        case GET_PRODUCTS:
            return {
                ...state,
                products: [action.data, ...state.products]
            }
        case GET_PRODUCT:
            return {
                ...state,
                product: state.chambres.find(product => product.id == action.data)
            }

        case DELETE_PRODUCT:
            return {
                ...state,
                products: state.chambres.filter(product => product.id != action.data)
            }
        case EDIT_PRODUCT:
            return {
                ...state,
                products: state.chambres.map(product => {
                    if (product.id == action.data.id) {
                        product = action.data
                    }
                    return product
                })
            }
        default: {
            return state
        }
    }
}