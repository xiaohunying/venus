import React, {Component} from 'react';
import GoogleLogin from 'react-google-login';
import FacebookLogin from 'react-facebook-login';

export default class LoginForm extends Component {
  constructor(props, context) {
    super(props, context);
    this.state = {
      username: '',
      password: ''
    };
    this.handleLogin = this.handleLogin.bind(this);
    this.responseGoogle = this.responseGoogle.bind(this);
    this.responseFacebook = this.responseFacebook.bind(this);
    this.handleChange = this.handleChange.bind(this);
  }

  responseGoogle(event) {
  }

  responseFacebook(event) {
  }

  handleLogin(event) {
    event.preventDefault();
    this.props.handleLogin(this.state.username, this.state.password);
  }

  handleChange(event) {
    event.preventDefault();
    this.setState({[event.target.name]: event.target.value});
  }

  render() {
    return (
      <div>
        <form onSubmit={this.handleLogin}>
          <div>
            <label><b>Username</b></label>
            <input type="text" placeholder="Enter Username"
              onChange={this.handleChange} value={this.state.username}
              name="username" required />
          </div>
          <div>
            <label><b>Password</b></label>
            <input type="password" placeholder="Enter Password"
              onChange={this.handleChange} value={this.state.password}
              name="password" required />
          </div>
          <div>
            <button type="submit">Login</button>
          </div>
          {this.props.errorMessage && <font color="red">{this.props.errorMessage}</font>}
          <div>
            <input type="checkbox" /> Remember me
          </div>
          <div>
            <span className="psw"><a href="#">Forgot password?</a></span>
          </div>
        </form>
        <div>
          <GoogleLogin
            buttonText="Login with Google"
            onSuccess={this.responseGoogle}
            onFailure={this.responseGoogle}
            clientId="658977310896-knrl3gka66fldh83dao2rhgbblmd4un9.apps.googleusercontent.com" />
        </div>
        <div>
          <FacebookLogin
            appId="1088597931155576"
            autoLoad='true'
            fields="name,email,picture"
            callback={this.responseFacebook}
            cssClass="my-facebook-button-class"
            icon="fa-facebook" />
        </div>
      </div>
    );
  };
}
