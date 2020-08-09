import React, {Component} from 'react';
import {connect} from "react-redux";
import {getTypeMessage} from "../../actions/EmailTypeAction";
import Select from "react-select";
import Axios from "axios";
import {URL} from "../../keys";

class Email extends Component {
    state = {
        emailfrom: JSON.parse(localStorage.getItem('token')).username,
        emailto: null,
        selectedOption: '',
        messageBody: null,
        date: new Date()
    }

    async componentWillMount() {
        await this.props.getTypeMessage()
        this.props.typeMessages.map(el => {
            console.log(el)
        })
        //console.log(this.props.typeMessages)
    }

    handleChange = selectedOption => {
        this.setState({selectedOption: selectedOption.value});
        console.log(`Option selected:`, selectedOption);
    };
    inputValueChangeSendMessage = e => this.setState({[e.target.name]: e.target.value});
    sendEmail = (event) => {
        event.preventDefault()
        Axios.defaults.headers = {
            'Content-Type': 'application/json'
        }
        Axios.post(URL + "/message/save/", this.state)
            .then(response => {
                this.setState({
                    emailfrom: JSON.parse(localStorage.getItem('token')).username,
                    emailto: null,
                    selectedOption: '',
                    messageBody: null,
                    date: new Date()
                })
                alert("Message Bien Envoyer")
            })
            .catch(error => {
                console.log(error);
            })
        console.log(this.state)
    }

    render() {
        const typeMail = this.props.typeMessages.map(cat => ({
            label: cat.libelle,
            value: cat.id
        }))
        const {selectedOption} = this.state.selectedOption;
        return (
            <form onSubmit={this.sendEmail}>
                <div className="form-row">
                    <div className="col-12">
                        <span>destination email address:</span>
                        <input type="email" name="emailto"
                               onChange={this.inputValueChangeSendMessage}
                               className="form-control"
                               required
                               id="exampleInputEmail3" aria-describedby="emailHelp"
                               placeholder="Destination email address"/>
                    </div>
                    <div className="col-12">
                        <span>Type Message :</span>
                        <Select
                            value={selectedOption}
                            onChange={this.handleChange}
                            options={typeMail}
                        />
                    </div>
                    <div className="col">
                                                    <textarea name="messageBody"
                                                              onChange={this.inputValueChangeSendMessage}
                                                              className="form-control"
                                                              required
                                                              id="exampleInputEmail" aria-describedby="emailHelp"
                                                              placeholder="Taper Votre Message" rows="25"></textarea>
                    </div>
                    <button type="submit" className="btn btn-primary btn-block mt-2">Envoyer Message
                    </button>
                </div>
            </form>
        );
    }
}

const mapStateToProps = (state) => {
    return {
        typeMessages: state.typeMessages.typeMessages,
    }
}
export default connect(mapStateToProps, {getTypeMessage})(Email)
