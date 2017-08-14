import React, {Component} from 'react';
import WorkCard from '../commons/WorkCard';

export default class LookForWorkPage extends Component {
  constructor(props) {
    super(props);
    this.state = {
      works: [],
      modalIsOpen: false
    };
  }

  openModal() {
    this.setState({modalIsOpen: true});
  }

  closeModal() {
    this.setState({modalIsOpen: false});
  }

  seedServices() {
    this.setState({
      works: [
        {
          'id': '1001',
          'type': 'fix roof',
          'address': {
            'street': '1240 Blacksmith Dr.',
            'city': 'Westerville OH',
            'zip': '43081'
          },
          'status': 'open',
          'note': 'asap'
        },
        {
          'id': '1002',
          'type': 'mow lawn',
          'address': {
            'street': '1240 Blacksmith Dr.',
            'city': 'A very very long city name',
            'zip': '43081'
          },
          'status': 'open',
          'note': 'asap'
        },
        {
          'id': '1003',
          'type': 'fix toilet',
          'address': {
            'street': '1240 Blacksmith Dr.',
            'city': 'Westerville OH',
            'zip': '43081'
          },
          'status': 'open',
          'note': 'i need help'
        }
      ]
    });
  }

  componentDidMount() {
    this.seedServices();
  }

  render() {
    return (
      <div>
        <div className="container">
          <div className="card-deck">
            {this.state.works.map(
              (work, index) => <WorkCard work={work} key={index} />
            )}
          </div>
        </div>
      </div>
    );
  };
}
