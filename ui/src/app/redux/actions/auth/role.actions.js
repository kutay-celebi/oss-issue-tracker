import {FAIL_ROLE_PAGE, GET_ROLE_PAGE, SUCCESS_ROLE_PAGE} from "./action.types";
import AuthService from "../../../service/authServiceImpl";
import {API_GET_ROLE_PAGE} from "../../../constants";
import {enqueueSnackbar} from "../core";


export const successRolePage = (query, response) => (dispatch) => {
    dispatch({
                 type: SUCCESS_ROLE_PAGE,
                 response
             })
};

export const getRolePage = (query) => async (dispatch) => {
    dispatch({
                 type: GET_ROLE_PAGE,
             });

    await AuthService.postApi().post(API_GET_ROLE_PAGE, query)
                     .then((response) => {
                         dispatch(successRolePage(query, response.data))
                     })
                     .catch((e) => {
                         dispatch(failRolePage(e))
                     });
};

export const failRolePage = (error) => (dispatch) => {
    dispatch(enqueueSnackbar(error.response.data.message, {variant: "error"})); //todo generic error method.
    dispatch({
                 type: FAIL_ROLE_PAGE
             })
};