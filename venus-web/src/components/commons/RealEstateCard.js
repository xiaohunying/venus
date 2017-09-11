import React, {Component} from 'react';
import {Link} from 'react-router-dom';
import {Modal} from 'react-bootstrap';
import EditRealEstateForm from '../commons/EditRealEstateForm';

export default class RealEstateCard extends Component {
  constructor(props) {
    super(props);
    this.state = {
      deleteModalIsOpen: false,
      editModalIsOpen: false,
      addRequestModalIsOpen: false,
      requestNote: ''
    };
    this.openDeleteModal = this.openDeleteModal.bind(this);
    this.closeDeleteModal = this.closeDeleteModal.bind(this);
    this.openEditModal = this.openEditModal.bind(this);
    this.closeEditModal = this.closeEditModal.bind(this);
    this.openAddRequestModal = this.openAddRequestModal.bind(this);
    this.closeAddRequestModal = this.closeAddRequestModal.bind(this);
    this.handleDeleteRealEstate = this.handleDeleteRealEstate.bind(this);
    this.onEditRealEstate = this.onEditRealEstate.bind(this);
    this.handleAddRequest = this.handleAddRequest.bind(this);
    this.handleChange = this.handleChange.bind(this);
  }

  openDeleteModal() {
    this.setState({deleteModalIsOpen: true});
  }

  closeDeleteModal() {
    this.setState({deleteModalIsOpen: false});
  }

  openEditModal() {
    this.setState({editModalIsOpen: true});
  }

  closeEditModal() {
    this.setState({editModalIsOpen: false});
  }

  openAddRequestModal(event) {
    this.setState({
      addRequestModalIsOpen: true,
      requestNote: event.target.name
    });
  }

  closeAddRequestModal() {
    this.setState({addRequestModalIsOpen: false, requestNote: ''});
  }

  handleDeleteRealEstate(event) {
    event.preventDefault();
    this.props.onDelete(this.props.realEstate);
    this.closeDeleteModal();
  }

  onEditRealEstate(realEstate) {
    console.info('===> edit: ' + JSON.stringify(realEstate));
    this.props.onEdit(realEstate);
    this.closeEditModal();
  }

  handleAddRequest(event) {
    event.preventDefault();
    console.info('===> add request: ' + JSON.stringify(this.state.requestNote));
    this.closeAddRequestModal();
  }

  handleChange(event) {
    event.preventDefault();
    this.setState({[event.target.name]: event.target.value});
  }

  render() {
    const realEstate = this.props.realEstate;
    return (
      <div className="real-estate-card" style={{width: 500}}>
        <div className="real-estate-card-body">
          <div className="real-estate-card-title">
            <div><span className="fa fa-home fa-lg" aria-hidden="true" />{realEstate.name}</div>
          </div>

          <div className="real-estate-card-left">
            <div className="real-estate-card-address-label">Address:</div>
            <div className="real-estate-card-address">
              {realEstate.address}<br />
              {realEstate.city}<br />
              {realEstate.zip}
            </div>
          </div>
          <div className="real-estate-card-right">
            <div>
              <button type="button" className="btn btn-default btn-sm"
                name="Mow Lawn" onClick={this.openAddRequestModal}>
                Mow Lawn</button>
            </div>
            <div>
              <button type="button" disabled
                className="btn btn-default btn-sm">
                Fix Roof</button>
            </div>
            <div>
              <button type="button" disabled
                className="btn btn-default btn-sm">
                Others</button>
            </div>
            <br />
            <div><strong>Request</strong></div>
            {this.props.activeRequests.map((request, index) => (
              <div key={index}>
                <Link to={'/request/' + request.id}>{request.type}</Link>
              </div>
            ))}
          </div>
        </div>
        <div className="real-estate-card-footer">
          <button type="button" className="btn btn-default btn-sm"
            onClick={this.openDeleteModal}>
            Delete</button>
          <button type="button" className="btn btn-default btn-sm"
            onClick={this.openEditModal}>
            Edit</button>
        </div>
        {this.editModal()}
        {this.deleteModal()}
        {this.addRequestModal()}
      </div>
    );
  }

  addRequestModal() {
    const realEstate = this.props.realEstate;
    return (
      <Modal show={this.state.addRequestModalIsOpen}
        onHide={this.closeAddRequestModal}>
        <Modal.Header closeButton>
          <Modal.Title>{realEstate.name}</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <div>
            Address: {realEstate.address}<br />
            City: {realEstate.city}<br />
            Zip: {realEstate.zip}
          </div>
          <form onSubmit={this.handleAddRequest}>
            <div>Note: </div>
            <textarea rows="4" cols="50" onChange={this.handleChange}
              name="requestNote"
              value={this.state.requestNote} />
            <div>
              <button type="button" className="btn btn-default btn-sm"
                onClick={this.closeAddRequestModal}>Cancel</button>
              <button type="submit" className="btn btn-success btn-sm">
                Submit</button>
            </div>
          </form>
        </Modal.Body>
      </Modal>
    );
  }

  deleteModal() {
    const realEstate = this.props.realEstate;
    return (
      <Modal show={this.state.deleteModalIsOpen}
        onHide={this.closeDeleteModal}>
        <Modal.Header closeButton>
          <Modal.Title>Delete Real Estate: {realEstate.name}</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <div>
            Address: {realEstate.address}<br />
            City: {realEstate.city}<br />
            Zip: {realEstate.zip}
          </div>
        </Modal.Body>
        <Modal.Footer>
          <form onSubmit={this.handleDeleteRealEstate}>
            <span>Are You Sure?</span>
            <button type="button" className="btn btn-default btn-sm"
              onClick={this.closeDeleteModal}>No</button>
            <button type="submit" className="btn btn-success btn-sm">
              Yes</button>
          </form>
        </Modal.Footer>
      </Modal>
    );
  }

  editModal() {
    return (
      <Modal show={this.state.editModalIsOpen}
        onHide={this.closeEditModal}>
        <Modal.Header closeButton>
          <Modal.Title>Edit Real Estate:</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <EditRealEstateForm realEstate={this.props.realEstate}
            onCancel={this.closeEditModal}
            onSubmit={this.onEditRealEstate} />
        </Modal.Body>
      </Modal>
    );
  }
}
