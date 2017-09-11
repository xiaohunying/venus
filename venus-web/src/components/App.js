import React from 'react';
import {Navbar} from 'react-bootstrap';
import {Link, Route, withRouter} from 'react-router-dom';
import PrivateRoute from './commons/PrivateRoute';
import ValidUser from './tools/ValidUser';
import HomePage from './home/HomePage';
import lookForHelpPage from './look-for-help/LookForHelpPage';
import LookForWorkPage from './look-for-work/LookForWorkPage';
import RegisterLoginPage from './account/RegisterLoginPage';
import HelpPage from './help/HelpPage';
import RequestPage from './request/RequestPage';

class App extends React.Component {
  constructor(props, context) {
    super(props, context);
    this.state = {};
    this.setUser = this.setUser.bind(this);
  }

  setUser(user) {
    this.setState({user: user});
  }

  // noop(e) {
  //   e.preventDefault();
  // }

  render() {
    return (
      <div>
        <header>
          <Navbar className="navbar-fixed-top" fluid>
            <div className="navbar-header">
              <Link to="/" className="navbar-brand">
                <strong>Venus</strong>
              </Link>
              <Navbar.Toggle />
            </div>

            <Navbar.Collapse>
              <div className="container">
                <ul className="nav navbar-nav navbar-nav-underline-interaction">
                  <li>
                    <Link to="/lookForHelp">Look For Help</Link>
                  </li>
                  <li>
                    <Link to="/lookForWork">Look For Work</Link>
                  </li>
                </ul>
                <ul className="nav navbar-nav navbar-nav-underline-interaction pull-right">
                  <li>
                    {ValidUser(this.state.user)
                    ? <Link to="/">{this.state.user.firstName} {this.state.user.lastName}</Link>
                    : <Link to="/registerlogin">Register / Login</Link>}
                  </li>
                  <li>
                    <Link to="/help"><i className="fa fa-question-circle-o fa-lg" aria-hidden="true" /></Link>
                  </li>
                </ul>
              </div>
            </Navbar.Collapse>
          </Navbar>
        </header>

        <div className="fixed-layout">
          <Route exact path="/" component={HomePage} />
          <Route path="/lookForWork" component={LookForWorkPage} />
          <Route path="/registerlogin" render={(props) => <RegisterLoginPage {...props} loggedIn={this.setUser} />} />
          <Route path="/help" component={HelpPage} />
          <PrivateRoute path="/lookForHelp" component={lookForHelpPage} authed={this.state.user} />
          <Route path="/request/:id" component={RequestPage} />
        </div>
      </div>
    );
  }
}

export default withRouter(App);
