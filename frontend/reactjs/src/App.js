import React, { Component} from 'react';
import './App.css';
import Home from './component/Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import GroupList from './component/page/group/GroupList';
import GroupEdit from './component/page/group/GroupEdit';
import LoginPage from './component/page/user/LoginPage';

class App extends Component {

    render() {
        return (
            <Router>
                <Switch>
                    <Route path='/' exact={true} component={Home}/>
                    <Route path='/groups' exact={true} component={GroupList}/>
                    <Route path='/groups/:id' component={GroupEdit}/>
                    <Route path='/user/login' exact={true} component={LoginPage}/>
                </Switch>
            </Router>
        )
    }
}

export default App;
