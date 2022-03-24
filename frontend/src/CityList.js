import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class CityList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            _embedded : {
                city: []
            }
        };
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/city')
            .then(response => response.json())
            .then(data => this.setState({
                _embedded : {
                    city:data._embedded.city
                }
            }));
    }

    async remove(id) {
        await fetch(`/city/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedCity = [...this.state._embedded.city].filter(i => i.id !== id);
            this.setState({
                _embedded : {
                    city: updatedCity
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
            cityList = this.state._embedded.city.map(city => {
            return <tr key={city.id}>
                <td style={{whiteSpace: 'nowrap'}}>{city.name}</td>
                {/*<td>{city.email}</td>*/}
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/city/" + city.id}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(city.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/city/new">Add city</Button>
                    </div>
                    <h3>city</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="30%">Name</th>
                            {/*<th width="30%">Email</th>*/}
                            <th width="40%">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {cityList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}

export default CityList;