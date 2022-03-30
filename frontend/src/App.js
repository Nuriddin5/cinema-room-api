import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import CityList from "./containers/theatres/city/CityList";
import CityEdit from "./containers/theatres/city/CityEdit";
import LocationList from "./containers/theatres/location/LocationList";
import LocationEdit from "./containers/theatres/location/LocationEdit";

class App extends Component {
    render() {
        return (
            <Router>
                <Switch>
                    <Route path='/' exact={true} component={Home}/>
                    <Route path='/city' exact={true} component={CityList}/>
                    <Route path='/city/:id' component={CityEdit}/>
                    <Route path='/location' exact={true} component={LocationList}/>
                    <Route path='/location/:id' component={LocationEdit}/>
                </Switch>
            </Router>
        )
    }
}

export default App;