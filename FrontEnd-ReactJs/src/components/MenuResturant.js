import React, {Component} from 'react'
import {connect} from "react-redux";
import {getProducts} from "../actions/ProductAction";
import Product from "./Product/Product";

class MenuResturant extends Component {
    state = {
        loading: true,
        products: null
    }

    async componentWillMount() {
        const res = await this.props.getProducts()
        this.setState({
            products: this.props.products[0].slice(0, 3),
        }, () => {
            this.setState({loading: false})
            console.log(this.props.products)
        })
    }


    render() {
        return (
            <div>

                <div class="section big-55-height over-hide z-bigger">

                    <div class="parallax parallax-top" style={{backgroundImage: 'url(https://maggiesgalley.com/sites/maggiesgalley.com/files/menu-banner.jpg)'}}></div>
                    <div class="dark-over-pages"></div>

                    <div class="hero-center-section pages">
                        <div class="container">
                            <div class="row justify-content-center">
                                <div class="col-12 parallax-fade-top">
                                    <div class="hero-text">Notre Menu</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="section padding-top-bottom over-hide">
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-md-8 align-self-center">
                                <div class="subtitle with-line text-center mb-4">main dishes</div>
                                <h3 class="text-center padding-bottom-small">Notre Menu</h3>
                            </div>
                            <div class="section clearfix"></div>
                            {this.state.loading == true ? <img  src="/img/loading.gif"/> :
                                this.state.products.map(c => (
                                    <div className="col-md-6"
                                        data-scroll-reveal="enter bottom move 50px over 0.7s after 0.2s">
                                        <Product key={c.id} product={c}/>
                                    </div>
                                ))
                            }
                        </div>
                    </div>
                </div>
                <div class="scroll-to-top"></div>
            </div>
        );
    }
}

const mapStateToProps = (state) => {
    return {
        products: state.products.products
    }
}
export default connect(mapStateToProps, {getProducts})(MenuResturant)