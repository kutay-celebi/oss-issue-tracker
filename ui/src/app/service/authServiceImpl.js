import KzUtils                                            from "../../@kuartz/KzUtils";
import axios                                              from "axios";
import {AUTH_PATH, AUTH_TOKEN_PATH, BASE_PATH, PATH_ROOT} from "../constants";
import history                                            from "@history";


// todo naming.
class AuthServiceImpl extends KzUtils.EventEmitter {

    getToken = (username, password) => {

        var urlencoded = new URLSearchParams();
        urlencoded.append("username", username);
        urlencoded.append("password", password);
        urlencoded.append("grant_type", "password");
        return axios.post(BASE_PATH + AUTH_PATH + AUTH_TOKEN_PATH,
                          urlencoded,
                          {
                              headers: {
                                  "Content-Type" : "application/x-www-form-urlencoded",
                                  "Authorization": "Basic dGVzdDp0ZXN0" // todo basic token icin yapilari inceleyelim boyle hardcode vermeyelim.
                              },
                          }
        );
    };

    postApi = () => {
        const instance = axios.create({
                                          baseURL: BASE_PATH + AUTH_PATH,
                                          headers: {
                                              "Authorization": "Bearer " + localStorage.getItem("access_token"), //todo constantlara alalim alternatif cozum bulalim
                                              "content-type" : "application/json",
                                              "Accept"       : "application/json"
                                          },
                                          timeout: 5000

                                      });

        instance.interceptors.response.use((response) => {
            return response;
        }, (error) => {
            if (error.response.status === 401) {
                localStorage.removeItem("access_token");
                history.push({
                                 pathname: PATH_ROOT,
                                 // state   : {redirectUrl: location.pathname} todo active it
                             });
            } else {
                throw error;
            }
        });
        return instance;
    };

    getApi = () => {
        const instance = axios.create({
                                          baseURL: BASE_PATH + AUTH_PATH,
                                          headers: {
                                              "Authorization": "Bearer " + localStorage.getItem("access_token"), //todo constantlara alalim alternatif cozum bulalim
                                              "Accept"       : "application/json"
                                          },
                                          timeout: 5000
                                      });

        instance.interceptors.response.use((response) => {
            return response;
        }, (error) => {
            if (error.response.status === 401) {
                localStorage.removeItem("access_token");
                history.push({
                                 pathname: PATH_ROOT,
                                 // state   : {redirectUrl: location.pathname} todo active it.
                             });
            } else {
                throw error;
            }
        });
        return instance;
    }
}

const AuthService = new AuthServiceImpl();

export default AuthService;