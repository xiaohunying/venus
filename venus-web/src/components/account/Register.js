import React, {Component} from 'react';

export default class Register extends Component {
  handleRegister(event) {
    // TODO
  }

  render() {
    return (
      <div>
        <form onSubmit={this.handleRegister}>
          <div>
            <label><b>First Name</b></label>
            <input type="text" placeholder="Enter First Name" required />
          </div>
          <div>
            <label><b>Last Name</b></label>
            <input type="text" placeholder="Enter Last Name" required />
          </div>
          <div>
            <label><b>Email</b></label>
            <input type="text" placeholder="Enter Email" required />
          </div>
          <button type="submit"
            className="btn btn-success btn-sm">Register</button>
        </form>
      </div>
    );
  };
}
