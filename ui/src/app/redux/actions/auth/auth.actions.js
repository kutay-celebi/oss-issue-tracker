import {LOGIN_FAIL, LOGIN_SUCCESS, LOGOUT_SUCCESS} from "./action.types";
import AuthService from "../../../service/authServiceImpl";
import {PATH_HOME_PAGE} from "../../../constants";
import history from '../../../../@history'
import {enqueueSnackbar} from "../core";

export const loginSuccess = (response) => (dispatch) => {
    dispatch({
                 type   : LOGIN_SUCCESS,
                 payload: {
                     response
                 }
             });

    history.push(PATH_HOME_PAGE);
};

export const loginFail = (error) => (dispatch) => {
    dispatch(enqueueSnackbar(error, {variant: "error"}));
    return {
        type: LOGIN_FAIL
    }
};

export const login = (username, password) => async (dispatch) => {
    await AuthService.getToken(username, password)
                     .then((response) => {
                         dispatch(loginSuccess(response.data))
                     })
                     .catch((e) => {
                         dispatch(loginFail(e.response.data.message))
                     });

};

export const logout = () => (dispatch) => {
    dispatch({
                 type: LOGOUT_SUCCESS
             })
};