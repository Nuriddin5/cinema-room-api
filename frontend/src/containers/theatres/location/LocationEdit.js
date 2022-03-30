import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from '../../../AppNavbar';

class LocationEdit extends Component {

    emptyItem = {
        longtitude:'',
        lattitude:''
    };

    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    async componentDidMount() {
        if (this.props.match.params.id !== 'new') {
            const location = await (await fetch(`/location/${this.props.match.params.id}`)).json();
            this.setState({item: location});
        }
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        // const updatedAt = target.;
        const name = target.name;
        let item = {...this.state.item};
        item[name] = value;
        // item[updatedAt] = updatedAt;
        this.setState({item});
    }

    async handleSubmit(event) {
        event.preventDefault();
        const {item} = this.state;

        await fetch('/location' + (item.id ? '/' + item.id : ''), {
            method: (item.id) ? 'PUT' : 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item),
        });
        this.props.history.push('/location');
    }

    render() {
        const {item} = this.state;
        const title = <h2>{item.id ? 'Edit Location' : 'Add Location'}</h2>;

        return <div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                        <Label for="name">Longtitude</Label>
                        <Input type="text" name="longtitude" id="longtitude" value={item.longtitude || ''}
                               onChange={this.handleChange} autoComplete="name"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="name">Lattitude</Label>
                        <Input type="text" name="lattitude" id="lattitude" value={item.lattitude || ''}
                               onChange={this.handleChange} autoComplete="name"/>
                    </FormGroup>

                    <FormGroup>
                        <Button color="primary" type="submit">Save</Button>{' '}
                        <Button color="secondary" tag={Link} to="/location">Cancel</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>
    }
}

export default withRouter(LocationEdit);