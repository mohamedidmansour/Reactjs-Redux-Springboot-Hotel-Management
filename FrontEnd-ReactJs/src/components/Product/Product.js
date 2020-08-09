import React, {Component} from 'react'
import PropTypes from 'prop-types';
class Product extends Component {

    moreDetail = ()=>{
        console.log(this.props.product)
    }
    getImage = (product)=>{
        let i = ""
        if(product.images!=null){
            product.images.map(ee=>{
                i = ee.url
            })
        }
        return i
    }

    render() {
        const product = this.props.product;
        return (
            <div className="restaurant-box">
                <img src={this.getImage(product)} alt="not found photo"/>
                <h6><span>{product.libelle}</span></h6>
                <p><span>salmon / veggies / oil</span></p>
                <h5><span>${product.prix}</span></h5>
            </div>
        )
    }
}
Product.propTypes = {
    product: PropTypes.object.isRequired
};
export  default Product