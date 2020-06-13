import {DEFAULT_QUERY_PAGE_NUMBER, DEFAULT_QUERY_PAGE_SIZE} from "../../../constants";
import {
    COMPANY_CLEAR_FORM,
    COMPANY_CLOSE_FORM,
    COMPANY_GET,
    COMPANY_GET_FAIL,
    COMPANY_GET_PAGE,
    COMPANY_GET_PAGE_FAIL,
    COMPANY_GET_PAGE_SUCCESS,
    COMPANY_GET_SUCCESS,
    COMPANY_OPEN_FORM,
    COMPANY_SAVE,
    COMPANY_SAVE_FAIL,
    COMPANY_SAVE_SUCCESS
} from "../../actions/company";

export const initCompanyForm = () => {
    return {
        id       : null,
        createdAt: null,
        updatedAt: null,
        deleted  : false,
        deletedAt: null,
        country  : null,
        name     : null,
        shortName: null,
        uuid     : null,
        contact  : {
            id       : null,
            updatedAt: null,
            createdAt: null,
            uuid     : null,
            deleted  : false,
            deletedAt: null,
            adress   : null,
            gsm1     : null,
            gsm2     : null,
            mail     : null,
            tel      : null,
            web      : null
        },
    }
};

const initialState = {
    openForm   : false,
    wait       : false,
    query      : {
        companyName: null,
        pageable   : {
            pageNumber: DEFAULT_QUERY_PAGE_NUMBER,
            pageSize  : DEFAULT_QUERY_PAGE_SIZE,
            sort      : {}
        }
    },
    company    : {},
    companyList: {}
};

export const companyReducer = (state = initialState, action) => {
    switch (action.type) {
        case COMPANY_GET_PAGE: {
            return {
                ...state,
                wait: true
            }
        }
        case COMPANY_GET_PAGE_SUCCESS: {
            return {
                ...state,
                wait       : false,
                companyList: action.response
            }
        }
        case COMPANY_GET_PAGE_FAIL: {
            return {
                ...state,
                wait       : false,
                companyList: {},
            }
        }
        case COMPANY_OPEN_FORM: {
            return {
                ...state,
                openForm: true,
                company: initCompanyForm()
            }
        }
        case COMPANY_CLOSE_FORM: {
            return {
                ...state,
                openForm: false,
                company : initCompanyForm()
            }
        }
        case COMPANY_CLEAR_FORM: {
            return {
                ...state,
                company: initCompanyForm()
            }
        }
        case COMPANY_SAVE : {
            return {
                ...state,
                wait: true
            }
        }
        case COMPANY_SAVE_SUCCESS: {
            return {
                ...state,
                company: action.response.body,
                wait   : false
            }
        }
        case COMPANY_SAVE_FAIL : {
            return {
                ...state,
                wait: false
            }
        }
        case COMPANY_GET: {
            return {
                ...state,
                wait: true
            }
        }
        case COMPANY_GET_SUCCESS: {
            return {
                ...state,
                company : action.company,
                wait    : false,
                openForm: true
            }
        }
        case COMPANY_GET_FAIL: {
            return {
                ...state,
                wait: false
            }
        }
        default : {
            return state;
        }
    }

};