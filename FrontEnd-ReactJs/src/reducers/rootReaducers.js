import { combineReducers } from "redux";
import ChambreReducer from "./ChambreReducer";
import CategorieReducer from "./CategorieReducer";
import ProductReducer from "./ProductReducer";
import ReservationReducer from "./ReservationReducer";
import TypeMessagrReducer from "./TypeMessagrReducer";
import SalleReducer from "./SalleReducer";
import BureauReducer from "./BureauReducer";

// for root reducer
export default combineReducers({
    chambres : ChambreReducer,
    categories : CategorieReducer,
    products : ProductReducer,
    reservations : ReservationReducer,
    typeMessages : TypeMessagrReducer,
    salles : SalleReducer,
    bureaux:BureauReducer,
})