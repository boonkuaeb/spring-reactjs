import React, {Component} from "react";
import AppNavbar from "../../AppNavbar";
import {Button, Container, Form, FormGroup, Input, Label} from 'reactstrap';
import {withRouter} from "react-router-dom";


class LoginPage extends Component {

    emptyLogin = {
        email: '',
        password: ''
    };


    constructor(props) {
        super(props);
        this.state = {
            user: this.emptyLogin
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.validateLogin = this.validateLogin.bind(this);
    }

    validateLogin() {
        let user = {...this.state.user};
        return user.email.length > 0 && user.password.length > 0;

    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let user = {...this.state.user};
        user[name] = value;
        this.setState({user});

    }

    async handleSubmit(event) {
        event.preventDefault();

        let uri = '/api/login';

        let user = {...this.state.user};

        await fetch(uri, {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(user),
        });
       // this.props.history.push('/groups');

    }


    render() {
        let user = {...this.state.user};
        const title = <h2>Login</h2>;

        return (
            <div>
                <AppNavbar/>
                <Container>
                    <hr/>
                    {title}
                        <Form onSubmit={this.handleSubmit}>
                            <FormGroup >
                                <Label>Email</Label>
                                <Input
                                    name="email"
                                    id="email"
                                    type="email"
                                    value={user.email || ''}
                                    onChange={this.handleChange}
                                />
                            </FormGroup>
                            <FormGroup >
                                <Label>Password</Label>
                                <Input
                                    name="password"
                                    id="password"
                                    value=""
                                    onChange={this.handleChange}
                                    type="password"
                                />
                            </FormGroup>
                            <Button block  disabled={!this.validateLogin()} type="submit">
                                Login
                            </Button>
                        </Form>



                </Container>
            </div>

        );
    }

}

export default withRouter(LoginPage);
