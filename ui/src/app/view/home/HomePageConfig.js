import {PATH_HOME_PAGE} from "../../constants";
import HomePage         from "./HomePage";

export const HomePageConfig = {
    settings: {},
    auth    : [],
    routes  : [
        {
            path     : PATH_HOME_PAGE,
            component: HomePage,
        }

    ]
};