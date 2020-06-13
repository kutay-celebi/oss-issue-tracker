import React, {Component}   from 'react';
import {connect}            from "react-redux";
import {bindActionCreators} from "redux";
import {login}              from "../../redux/actions/auth";
import LoginForm            from "./LoginForm";
import {withStyles}         from "@material-ui/core";
import clsx                 from "clsx";

const styles = () => ({
    root: {
        backgroundImage: 'url("../../assets/images/lbg.jpg")',
        backgroundSize : 'cover',
    }
});

class Login extends Component {

    onFormSubmit = (formProps)=> {
        const {username, password} = formProps;
        this.props.login(username, password);
    };

    render() {
        const {classes} = this.props;
        return (
            <div className={clsx(classes.root, 'flex flex-1 justify-center p-24 w-full')}>
                <LoginForm handleForm={this.onFormSubmit}/>
            </div>
        );
    }
}


const mapDispatchToProps = (dispatch) => {
    return bindActionCreators({
                                  login: login,
                              }, dispatch)
};

const mapStateToProps = ({auth}) => {
    return {
        auth: auth
    }
};

export default withStyles(styles)(connect(mapStateToProps, mapDispatchToProps)(Login));

