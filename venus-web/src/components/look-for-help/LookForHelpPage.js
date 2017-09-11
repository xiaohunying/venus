import React, {Component} from 'react';
import {Modal} from 'react-bootstrap';
import FetchApi from '../../api/FetchApi';
import RealEstateCard from '../commons/RealEstateCard';
import AddRealEstateForm from '../commons/AddRealEstateForm';

export default class LookForHelpPage extends Component {
  constructor(props) {
    super(props);
    this.state = {
      realEstateInfos: [],
      addModalIsOpen: false
    };

    this.openAddModal = this.openAddModal.bind(this);
    this.closeAddModal = this.closeAddModal.bind(this);
    this.onAddRealEstate = this.onAddRealEstate.bind(this);
    this.handleDeleteRealEstate = this.handleDeleteRealEstate.bind(this);
    this.handleEditRealEstate = this.handleEditRealEstate.bind(this);
  }

  getRealEstateInfos() {
    FetchApi.post('/api/realestates', this.props.user).then(response => {
      this.setState({realEstateInfos: response});
    });
  }

  componentDidMount() {
    this.getRealEstateInfos();
  }

  openAddModal() {
    this.setState({addModalIsOpen: true});
  }

  closeAddModal() {
    this.setState({addModalIsOpen: false});
  }

  onAddRealEstate(realEstate) {
    realEstate.userProfileId = this.state.userProfile.id;
    FetchApi.post('/api/addrealestate', realEstate).then(response => {
      const newRealEstateInfos = this.state.realEstateInfos.slice();
      newRealEstateInfos.push({'realEstate': response});
      this.setState({
        realEstateInfos: newRealEstateInfos
      });
    });
    this.closeAddModal();
  }

  handleDeleteRealEstate(realEstate) {
    FetchApi.post('/api/deleterealestate', realEstate).then(response => {
      const newRealEstateInfos = [];
      this.state.realEstateInfos.filter(function(realEstateInfo) {
        return realEstateInfo.realEstate.id !== realEstate.id;
      }).map(function(realEstateInfo) {
        newRealEstateInfos.push(realEstateInfo);
      });
      this.setState({
        realEstateInfos: newRealEstateInfos
      });
    });
  }

  handleEditRealEstate(realEstate) {
    console.log('===> edit: ' + JSON.stringify(realEstate));
    FetchApi.post('/api/editrealestate', realEstate).then(response => {
      const newRealEstateInfos = [];
      this.state.realEstateInfos.forEach(function(realEstateInfo) {
        if (realEstateInfo.realEstate.id === realEstate.id) {
          newRealEstateInfos.push({
            'realEstate': realEstate,
            'activeRequests': realEstateInfo.activeRequests
          });
        } else {
          newRealEstateInfos.push(realEstateInfo);
        }
      });
      this.setState({
        realEstateInfos: newRealEstateInfos
      });
    });
  }

  render() {
    return (
      <div>
        <div className="container">
          <section>
            <span>
              <h3>Your Real Estates:
                <button onClick={this.openAddModal}
                  type="button" className="btn btn-success btn-sm">
                  Add New Real Estate</button></h3>
            </span>
          </section>

          <div className="real-estate-card-deck">
            {this.state.realEstateInfos.map((realEstateInfo, index) => (
              <RealEstateCard key={index}
                realEstate={realEstateInfo.realEstate}
                activeRequests={realEstateInfo.activeRequests}
                onDelete={this.handleDeleteRealEstate}
                onEdit={this.handleEditRealEstate} />
            ))}
          </div>
        </div>
        {this.addModal()}
      </div>
    );
  }

  addModal() {
    return (
      <Modal show={this.state.addModalIsOpen}
        onHide={this.closeAddModal}>
        <Modal.Header closeButton>
          <Modal.Title>Add New Real Estate</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <AddRealEstateForm
            onSubmit={this.onAddRealEstate}
            onCancel={this.closeAddModal} />
        </Modal.Body>
      </Modal>
    );
  }
}
