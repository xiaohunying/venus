import React, {Component} from 'react';
import {Modal} from 'react-bootstrap';

export default class WorkCard extends Component {
  constructor(props) {
    super(props);
    this.state = {
      addResponseModalIsOpen: false,
      responseMessage: ''
    };
    this.openAddResponseModal = this.openAddResponseModal.bind(this);
    this.closeAddResponseModal = this.closeAddResponseModal.bind(this);
    this.handleAddResponse = this.handleAddResponse.bind(this);
    this.handleChange = this.handleChange.bind(this);
  }

  openAddResponseModal() {
    this.setState({addResponseModalIsOpen: true});
  }

  closeAddResponseModal() {
    this.setState({addResponseModalIsOpen: false, responseMessage: ''});
  }

  handleChange(event) {
    event.preventDefault();
    this.setState({[event.target.name]: event.target.value});
  }

  handleAddResponse(event) {
    event.preventDefault();
    console.info('===> response: ' + JSON.stringify(this.state.responseMessage));
    this.closeAddResponseModal();
  }

  render() {
    const work = this.props.work;
    return (
      <div className="card" style={{width: 500}}>
        <div className="card-body">
          <div className="card-title"><div>{work.type}</div></div>
          <table>
            <tbody>
              <tr>
                <td className="card-address-label fa fa-home fa-3x" aria-hidden="true" />
                <td className="card-address overme">{work.address.city}<br />{work.address.zip}</td>
              </tr>
            </tbody>
          </table>
          <div className="card-note">"{work.note}"</div>
        </div>
        <div className="card-footer">
          <button type="button" className="btn btn-success btn-sm btn-block"
            onClick={this.openAddResponseModal}>
            I'm interested</button>
        </div>
        {this.addResponseModal()}
      </div>
    );
  }

  addResponseModal() {
    const work = this.props.work;
    return (
      <Modal show={this.state.addResponseModalIsOpen}
        onHide={this.closeAddResponseModal}>
        <Modal.Header closeButton>
          <Modal.Title>todo</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <div>
            City: {work.address.city}<br />
            Zip: {work.address.zip}
          </div>
          <form onSubmit={this.handleAddResponse}>
            <div>Message: </div>
            <textarea rows="4" cols="50" onChange={this.handleChange}
              name="responseMessage"
              value={this.state.responseMessage} />
            <div>
              <button type="button" className="btn btn-default btn-sm"
                onClick={this.closeAddResponseModal}>Cancel</button>
              <button type="submit" className="btn btn-success btn-sm">
                Submit</button>
            </div>
          </form>
        </Modal.Body>
      </Modal>
    );
  }
}
