import settings          from "./settings.reducer";
import {combineReducers} from "redux";
import navbar            from "./navbar.reducers";
import notify            from "./notify.reducer"

const coreReducers = combineReducers({
                                         settings,
                                         navbar,
                                         notify
                                     });

export default coreReducers;