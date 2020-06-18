import {CLEAR_ADD_USER_FORM, CLOSE_USER_FORM, OPEN_USER_FORM, SET_USER, SUCCESS_ADD_USER, SUCCESS_USER_PAGE} from "./action.types";
import {API_GET_USER_PAGE} from "../../../constants";
import {enqueueSnackbar} from "../core";
import {apiClient} from "../../../service/apiClient";

// todo api call support memoize.
export const successUserPage = (query, response) => (dispatch) => {
    dispatch({
                 type: SUCCESS_USER_PAGE,
                 response,
                 query
             })
};

export const getUserPage = (query) => async (dispatch) => {
    // todo add wait reducer.
    await apiClient.post(API_GET_USER_PAGE, query)
                   .then((response) => {
                       dispatch(successUserPage(query, response.data));
                   })
};

export const saveUser = (user) => async (dispatch) => {
    await apiClient.post("user/save", user)
                   .then((response) => {
                       dispatch(successAddUser(response.data));
                   })
};

export const successAddUser = (response) => (dispatch) => {
    dispatch(enqueueSnackbar("success", {variant: "success",}));
    dispatch({
                 type: SUCCESS_ADD_USER,
                 response
             })
};

export const clearAddUserForm = () => (dispatch) => {
    dispatch({
                 type: CLEAR_ADD_USER_FORM
             })
};

export const setUser = (user) => (dispatch) => {
    dispatch({
                 type: SET_USER,
                 user
             })
};

export const getUser = (username) => async (dispatch) => {
    // todo add wait reducer.
    // todo move api constant
    await apiClient.get("/user/get/" + username)
                   .then((response) => {
                       if (response.status === 200) {
                           dispatch(setUser(response.data))
                       }
                   })
};

// const _fetchUser = _.memoize(async (username, dispatch) => {
//     await apiClient.get("/user/get/" + username).then(
//         response => {
//             dispatch(setUser(response.data));
//         }
//     )
// });

export const openUserForm = () => (dispatch) => {
    dispatch({
                 type: OPEN_USER_FORM
             })
};

export const closeUserForm = () => (dispatch) => {
    dispatch({
                 type: CLOSE_USER_FORM
             })
};



