import {FAIL_ROLE_PAGE, GET_ROLE_PAGE, SUCCESS_ROLE_PAGE} from "../../actions/auth";
import {DEFAULT_QUERY_PAGE_NUMBER, DEFAULT_QUERY_PAGE_SIZE} from "../../../constants";

const initialState = {
    wait     : false,
    roleList : {},
    roleQuery: {
        code    : "",
        pageable: {
            pageNumber: DEFAULT_QUERY_PAGE_NUMBER,
            pageSize  : DEFAULT_QUERY_PAGE_SIZE,
            sort      : {
                kzOrderList: []
            }
        }
    }
};

const roleReducer = (state = initialState, action) => {
    switch (action.type) {
        case GET_ROLE_PAGE: {
            return {
                ...initialState,
                wait: true
            }
        }
        case SUCCESS_ROLE_PAGE: {
            return {
                ...initialState,
                roleList: action.response,
                wait    : false
            }
        }
        case FAIL_ROLE_PAGE: {
            return {
                ...initialState,
                wait: false
            }
        }
        default: {
            return state;
        }
    }
};

export default roleReducer;