import {createStore , applyMiddleware ,compose} from 'redux'
import rootReaducers from "../reducers/rootReaducers"
import thunk from 'redux-thunk';

const initialState = {
    
}
const store = createStore(
    rootReaducers,
    initialState,
    compose(
        applyMiddleware(thunk)
        ,
        //window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()
    ))
export default store