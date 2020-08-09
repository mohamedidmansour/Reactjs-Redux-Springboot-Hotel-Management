import React, {Component} from 'react'
import Chambre from "./Chambre";
import {getChambres, getRoomsFree} from '../../actions/ChambreAction'
import {connect} from "react-redux";
import {getCategories} from "../../actions/CategorieAction";

class ChambresHomePage extends Component {
    state = {
        loading:true,
        chambres: null
    }
    async componentWillMount() {
        const res = await this.props.getChambres()
        this.setState({
            chambres: this.props.chambres[0].slice(0,this.props.chambres[0].length/2),
        }, () => {
            this.setState({loading: false})
        })
    }

    render() {
        return (
            <div class="section padding-top-bottom over-hide background-grey">
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-md-8 align-self-center">
                            <div class="subtitle with-line text-center mb-4">luxury</div>
                            <h3 class="text-center padding-bottom-small">Nos chambres</h3>
                        </div>
                        <div class="section clearfix"></div>
                        {this.state.loading == true ?
                            <img  src="/img/loading.gif"/> :
                            this.state.chambres.map(c => (
                                <div className="col-lg-6 mt-4 mt-lg-0 "
                                     data-scroll-reveal="enter bottom move 50px over 0.7s after 0.4s">
                                    <Chambre key={c.id} chambre={c}/>
                                </div>
                            ))
                        }
                    </div>
                    <div className="row justify-content-center mt-5">
                        <a className="mt-1 p-3 btn btn-primary" href="/ourRoom">plus chambre.......</a>
                    </div>
                </div>
            </div>
        )
    }
}
const mapStateToProps = (state) => {
    return {
        chambres: state.chambres.chambres,
        categories: state.categories.categories
    }
}
export default connect(mapStateToProps, {getChambres})(ChambresHomePage)
