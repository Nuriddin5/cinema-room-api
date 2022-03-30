import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from '../../../AppNavbar';

class CityEdit extends Component {

    emptyItem = {
        // createdAt:new Date(),
        updatedAt:Date.now(),
        name: ''
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
            const city = await (await fetch(`/city/${this.props.match.params.id}`)).json();
            this.setState({item: city});
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

        await fetch('/city' + (item.id ? '/' + item.id : ''), {
            method: (item.id) ? 'PUT' : 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item),
        });
        this.props.history.push('/city');
    }

    render() {
        const {item} = this.state;
        const title = <h2>{item.id ? 'Edit City' : 'Add City'}</h2>;

        return <div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                        <Label for="name">Name</Label>
                        <Input type="text" name="name" id="name" value={item.name || ''}
                               onChange={this.handleChange} autoComplete="name"/>
                    </FormGroup>
                    {/*<FormGroup>*/}
                    {/*    <Label for="email">Email</Label>*/}
                    {/*    <Input type="text" name="email" id="email" value={item.email || ''}*/}
                    {/*           onChange={this.handleChange} autoComplete="email"/>*/}
                    {/*</FormGroup>*/}
                    <FormGroup>
                        <Button color="primary" type="submit">Save</Button>{' '}
                        <Button color="secondary" tag={Link} to="/city">Cancel</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>
    }
}

export default withRouter(CityEdit);