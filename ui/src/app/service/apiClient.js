import React from 'react';
import {store} from "../redux/persistor";
import axios from "axios";
import {logout} from "../redux/actions/auth";
import history from "../../@history";
import {AUTH_PATH, BASE_PATH, PATH_LOGIN_ROOT} from "../constants";
import {enqueueSnackbar} from "../redux/actions/core";
import {closeBackdrop, openBackdrop} from "../redux/actions/core/common.actions";

export const apiClient = axios.create({
                                   baseURL: BASE_PATH + AUTH_PATH,
                                   headers: {
                                       "content-type": "application/json",
                                       "Accept"      : "application/json"
                                   },
                                   timeout: 60000
                               });

const {dispatch} = store; // direct access to redux store.
apiClient.interceptors.request.use((config) => {
    dispatch(openBackdrop());
    config.headers.Authorization = "Bearer " + localStorage.getItem("access_token"); //todo constantlara alalim alternatif cozum bulalim
    return config;
});

apiClient.interceptors.response.use(
    response => {
        dispatch(closeBackdrop());
        return response;
    },
    error => {
        dispatch(closeBackdrop());
        if (error.response.status === 401) {
            dispatch(logout());
            localStorage.removeItem("access_token");
            history.push({
                             pathname: PATH_LOGIN_ROOT
                         });
        } else {
            dispatch(enqueueSnackbar(error.response.data.message, {variant: "error"})); //todo generic error method.
            return Promise.reject(error)
        }
        return error;
    }
);