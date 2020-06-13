import React, {Component}   from "react";
import {connect}            from "react-redux";
import {withRouter}         from "react-router-dom";
import AppContext           from "../../../app/AppContext";
import {matchRoutes}        from "react-router-config";
import KzUtils              from "../../KzUtils";
import {PATH_LOGIN_ROOT}    from "../../../app/constants";
import {bindActionCreators} from "redux";
import {logout}             from "../../../app/redux/actions/auth";


class KzAuth extends Component {

    constructor(props, context) {
        super(props);
        const {routes} = context;
        this.state     = {
            accessGranted: true,
            routes
        };
    }

    static getDerivedStateFromProps(props, state) {

        const {location} = props;

        const {routes} = state;

        const matched = matchRoutes(routes, location.pathname)[0];

        return {
            // ekrandaki yetki ile aktif kullanicinin yetkisi kontrol edilir.
            accessGranted: matched ? KzUtils.hasPermission(matched.route.auth, props.authority) : true
        };
    }

    shouldComponentUpdate(nextProps, nextState, nextContext) {
        return nextState.accessGranted !== this.state.accessGranted;
    }

    componentDidMount() {
        if (!this.state.accessGranted) {
            this.redirectRoute();
        }
    }

    componentDidUpdate() {
        if (!this.state.accessGranted) {
            this.redirectRoute();
        }
    }


    redirectRoute() {
        const {location, history, userRole} = this.props;

        // kullanici giris yapmadiysa henuz bir yetkisi yoktur.
        // login ekranina gonderilir.
        if (!userRole || userRole.length === 0) {
            this.props.logout();
            history.push({
                             pathname: PATH_LOGIN_ROOT,
                             state   : {redirectUrl: location.pathname}
                         });
        } else {
            history.push({
                             pathname: "/"
                         });
        }
    }

    render() {
        return (
            this.state.accessGranted ? <React.Fragment>{this.props.children}</React.Fragment> : null
        );
    }
}

const mapDispatchToProps = (dispatch) => {
    return bindActionCreators({
                                  logout: logout
                              }, dispatch);
};

const mapStateToProps = ({authReducers}) => {
    return {
        authority: authReducers.auth.principal.authority // todo sayfa ilk acildiginda hata veriyor inceleyelim.
    };
};

KzAuth.contextType = AppContext;

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(KzAuth));