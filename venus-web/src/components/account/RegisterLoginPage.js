import React, {Component} from 'react';
import UserApi from '../../api/UserApi';
import LoginForm from './LoginForm';
import Register from './Register';
import ValidUser from '../tools/ValidUser';

export default class RegisterLoginPage extends Component {
  constructor(props, context) {
    super(props, context);
    this.state = {
      errorMessageLogin: ''
    };
    this.handleLogin = this.handleLogin.bind(this);
  }

  handleLogin(username, password) {
    const from = this.props.location.state ? this.props.location.state.from.pathname : '/';
    UserApi.getUser(username, password).then(response => {
      if (ValidUser(response)) {
        this.setState({
          errorMessageLogin: ''
        });
        this.props.loggedIn(response);
        this.props.history.push(from);
      } else {
        this.setState({
          errorMessageLogin: 'Login Failed'
        });
      }
    });
  }

  render() {
    return (
      <div>
        <div className="col-sm-4">
          <div><h3>Login</h3></div>
          <LoginForm handleLogin={this.handleLogin} errorMessage={this.state.errorMessageLogin} />
        </div>
        <div className="col-sm-4">
          <div><h3>Register</h3></div>
          <Register />
        </div>
        <button onClick={this.test} />
      </div>
    );
  };
}
