import React, {Component} from 'react';
import {Modal} from 'react-bootstrap';
import RealEstateCard from '../commons/RealEstateCard';
import AddRealEstateForm from '../commons/AddRealEstateForm';

export default class LookForHelpPage extends Component {
  constructor(props) {
    super(props);
    this.state = {
      realEstates: [],
      addModalIsOpen: false
    };

    this.openAddModal = this.openAddModal.bind(this);
    this.closeAddModal = this.closeAddModal.bind(this);
    this.onAddRealEstate = this.onAddRealEstate.bind(this);
  }

  seedRealEstates() {
    this.setState({
      realEstates: [
        {
          'id': '1',
          'name': 'Home',
          'address': '1240 Blacksmith Dr.',
          'city': 'Westerville, OH',
          'zip': '43081'
        },
        {
          'id': '2',
          'name': 'Parents\' Home',
          'address': '1234 Sawmill Commons Rd.',
          'city': 'Dublin, OH',
          'zip': '43026'
        }
      ]
    });
  }

  componentDidMount() {
    this.seedRealEstates();
  }

  openAddModal() {
    this.setState({addModalIsOpen: true});
  }

  closeAddModal() {
    this.setState({addModalIsOpen: false});
  }

  onAddRealEstate(realEstate) {
    console.info('===> add: ' + JSON.stringify(realEstate));
    this.closeAddModal();
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
            {this.state.realEstates.map((realEstate, index) => (
              <RealEstateCard key={index}
                realEstate={realEstate} />
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
