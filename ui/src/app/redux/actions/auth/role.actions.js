import {
    CLEAR_ADD_ROLE_FORM,
    CLOSE_ROLE_FORM,
    FAIL_ROLE_PAGE,
    GET_ROLE_PAGE,
    OPEN_ROLE_FORM,
    SET_ROLE,
    SUCCESS_ADD_ROLE,
    SUCCESS_ROLE_PAGE
} from "./action.types";
import AuthService from "../../../service/authServiceImpl";
import {API_GET_ROLE_PAGE} from "../../../constants";
import {enqueueSnackbar} from "../core";

export const saveRole = (role) => async (dispatch) => {
    // todo add wait reducer.
    // todo move api constant.
    await AuthService.postApi().post("role/save", role).then(
        (response) => {
            dispatch(successAddRole(response.data));
        }
    ).catch((e) => {
        dispatch(enqueueSnackbar(e.response.data.message, {variant: "error"}));
    })
};

export const successAddRole = (response) => (dispatch) => {
    dispatch(enqueueSnackbar("success", {variant: "success",}));
    dispatch({
                 type: SUCCESS_ADD_ROLE,
                 response
             })
};

export const clearRoleForm = () => (dispatch) => {
    dispatch({
                 type: CLEAR_ADD_ROLE_FORM
             })
};

export const successRolePage = (query, response) => (dispatch) => {
    dispatch({
                 type: SUCCESS_ROLE_PAGE,
                 response
             })
};

export const getRole = (id) => async (dispatch) => {
    // todo add wait reducer.
    // todo move api constant
    await AuthService.getApi().get("/role/get/" + id)
                     .then((response) => {
                         dispatch(setRole(response.data));
                     })
};

export const setRole = (role) => (dispatch) => {
    dispatch({
                 type: SET_ROLE,
                 role
             })
};

export const getRolePage = (query) => async (dispatch) => {

    console.warn(query.pageable);

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

export const openRoleForm = () => (dispatch) => {
    dispatch({
                 type: OPEN_ROLE_FORM
             })
};

export const closeRoleForm = () => (dispatch) => {
    dispatch({
                 type: CLOSE_ROLE_FORM
             })
};
