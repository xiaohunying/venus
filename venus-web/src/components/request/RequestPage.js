import React, {Component} from 'react';
import FetchApi from '../../api/FetchApi';

export default class RequestPage extends Component {
  constructor(props) {
    super(props);
    this.state = {
      requestId: props.match.params.id,
      request: {},
      isRequestor: false,
      isAcceptedResponsor: false
    };
  }

  getRequest() {
    FetchApi.get('/api/request/' + this.state.requestId).then(response => {
      const loginUserId = 3;
      let isRequestor = false;
      let isAcceptedResponsor = false;
      if (loginUserId === response.requestorId) {
        isRequestor = true;
      } else if (loginUserId === response.acceptedResponsorId) {
        isAcceptedResponsor = true;
      }
      this.setState({
        request: response,
        isRequestor: isRequestor,
        isAcceptedResponsor: isAcceptedResponsor
      });
    });
  }

  componentDidMount() {
    this.getRequest();
  }

  render() {
    const request = this.state.request;
    return (
      <div>
        <div className="container">
          <section>
            <div><h3>{request.type}</h3></div>
            <p>"{request.message}"</p>
            <div>Requested by {request.requestorFirstName} {request.requestorLastName}</div>
          </section>
          <section>
            <div>
              <h4>Address</h4>
              {(this.state.isRequestor || this.state.isAcceptedResponsor) && (<div>{request.address}</div>)}
              <div>{request.city}</div>
              <div>{request.zip}</div>
            </div>
          </section>
          <section>
            <div><h3>Responses</h3></div>
            {request.responses && this.getAllResponses()}
          </section>
        </div>
      </div>
    );
  }

  getAllResponses() {
    return (
      <table className="table">
        <tbody>
          {this.state.request.responses.map((response, index) => (
            <tr key={index}>
              <td>
                <div>"{response.message}"</div>
                <div>by {response.responsorFirstName} {response.responsorLastName}</div>
              </td>
              {this.state.isRequestor && (
                <td>
                  <button type="button" className="btn btn-default btn-sm">Reply</button>
                  <button type="button" className="btn btn-default btn-sm">Accept</button>
                </td>
              )}
            </tr>
          ))}
        </tbody>
      </table>
    );
  }
}
