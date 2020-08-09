import React, {Component} from 'react';

class Categorie extends Component {
    componentDidMount() {
        console.clear()
        console.log(this.props)
    }

    render() {
        return (
            <option value={this.props.id}>
                {this.props.libelle}
            </option>
        );
    }
}

export default Categorie;