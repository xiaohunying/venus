import React from 'react';
import { Route, Redirect } from 'react-router-dom';
import ValidUser from '../tools/ValidUser';

const PrivateRoute = ({component: Component, authed, ...rest}) => {
  return (
    <Route
      {...rest}
      render={(props) => ValidUser(authed)
      ? <Component {...props} user={authed} />
      : <Redirect to={{pathname: '/registerlogin', state: {from: props.location}}} />}
    />
  );
};

export default PrivateRoute;
