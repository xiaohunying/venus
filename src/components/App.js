import React from 'react';
import {Navbar} from 'react-bootstrap';
import {Link, Route} from 'react-router-dom';
// import {LinkContainer} from 'react-router-bootstrap';
import HomePage from './home/HomePage';
import lookForHelpPage from './look-for-help/LookForHelpPage';
import LookForWorkPage from './look-for-work/LookForWorkPage';
import Register from './account/Register';
import Login from './account/Login';
import HelpPage from './help/HelpPage';

class App extends React.Component {
  noop(e) {
    e.preventDefault();
  }

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
                    <Link to="/register">Register</Link>
                  </li>
                  <li>
                    <Link to="/login">Login</Link>
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
          <Route path="/lookForHelp" component={lookForHelpPage} />
          <Route path="/lookForWork" component={LookForWorkPage} />
          <Route path="/register" component={Register} />
          <Route path="/login" component={Login} />
          <Route path="/help" component={HelpPage} />
        </div>
      </div>
    );
  }
}

export default App;
