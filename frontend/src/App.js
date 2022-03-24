import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
// import ClientList from './ClientList';
// import ClientEdit from "./ClientEdit";
import CityList from "./CityList";
import CityEdit from "./CityEdit";

class App extends Component {
    render() {
        return (
            <Router>
                <Switch>
                    <Route path='/' exact={true} component={Home}/>
                    {/*<Route path='/clients' exact={true} component={ClientList}/>*/}
                    <Route path='/city' exact={true} component={CityList}/>
                    {/*<Route path='/clients/:id' component={ClientEdit}/>*/}
                    <Route path='/city/:id' component={CityEdit}/>
                </Switch>
            </Router>
        )
    }
}

export default App;