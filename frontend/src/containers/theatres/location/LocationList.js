import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from '../../../AppNavbar';
import { Link } from 'react-router-dom';

class LocationList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            _embedded : {
                location: []
            }
        };
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/location')
            .then(response => response.json())
            .then(data => this.setState({
                _embedded : {
                    location:data._embedded.location
                }
            }));
    }

    async remove(id) {
        await fetch(`/location/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedLocation = [...this.state._embedded.location].filter(i => i.id !== id);
            this.setState({
                _embedded : {
                    location: updatedLocation
                }
            });
        });
    }

    render() {
        // const {_embedded, isLoading} = this.state;
        //
        // if (isLoading) {
        //     return <p>Loading...</p>;
        // }

        const
            locationList = this.state._embedded.location.map(location => {
            return <tr key={location.id}>
                <td style={{whiteSpace: 'nowrap'}}>{location.longtitude}</td>
                <td style={{whiteSpace: 'nowrap'}}>{location.lattitude}</td>
                {/*<td>{location.email}</td>*/}
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/location/" + location.id}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(location.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/location/new">Add location</Button>
                    </div>
                    <h3>location</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="30%">Longtitude</th>
                            <th width="30%">Lattitude</th>
                            <th width="40%">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {locationList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}

export default LocationList;