import React, {Component} from 'react';

class LogOut extends Component {
    componentWillMount() {
        localStorage.removeItem("token")
        this.props.history.push('/')
    }
    render() {
        return (
            <div>
                <h1>Log out .........</h1>
            </div>
        );
    }
}

export default LogOut;