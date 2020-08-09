import React, {Component} from 'react';
import {connect} from "react-redux";
import {getCategories} from "../../actions/CategorieAction";

class Categories extends Component {
    componentDidMount() {
    }

    render() {
        return (
            <div>

            </div>
        );
    }
}

const mapStateToProps = (state) => {
    return {
        categories: state.categories.categories
    }
}
export default connect(mapStateToProps, {getCategories})(Categories)