import React, {useState} from 'react';
import PropTypes from 'prop-types';
import KzTable from "../../../../@kuartz/components/KzTable/KzTable";
import {useDispatch} from "react-redux";
import {useTranslation} from "react-i18next";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faTrashAlt} from "@fortawesome/free-solid-svg-icons";
import {useTheme} from "@material-ui/core";
import clsx from "clsx";
import KzAutocomplete from "../../../../@kuartz/components/autocomplete/KzAutocomplete";
import ListItemText from "@material-ui/core/ListItemText";
import {initRoleQuery} from "../../../redux/reducers/auth/role.reducer";
import {API_GET_ROLE_PAGE} from "../../../constants";
import {enqueueSnackbar} from "../../../redux/actions/core";
import {AxiosInstance as apiClient} from "axios";


const UserRoleRelationForm = (props) => {

    // const {roleList, wait} = useSelector(({authReducers}) => authReducers.role);

    const dispatch = useDispatch();

    const [roleList, setRoleList] = useState({content: []});
    const [roleWait, setRoleWait] = useState(false);

    const roleQuery = initRoleQuery();
    const {t}       = useTranslation();
    const theme     = useTheme();
    const tableRef  = React.createRef();

    const asyncAutocomplete = async (text) => {
        roleQuery.code = text;
        setRoleWait(true);
        await apiClient.post(API_GET_ROLE_PAGE, roleQuery)
                         .then((response) => {
                             setRoleList(response.data);
                             setRoleWait(false);
                         })
                         .catch((error) => {
                             dispatch(enqueueSnackbar(error.response.data.message, {variant: "error"})); //todo generic error method.
                             setRoleWait(false);
                         });
    };

    const addRoleToList = (values) => {
        const existRole = props.userModel.roleList;
        const map       = values.map((o) => {
            if (!existRole.some(er => er.role.code === o.code)) {
                return Object.assign({}, {user: props.userUuid}, {role: o});
            }
        });

        props.userModel.roleList = {...props.userModel.roleList,...map};
    };

    const handleRemoveRole = (role) => {
        // const existRole   = props.fieldProps.value;
        // const removedRole = existRole.filter((r) => {
        //     return r.role.code !== role.role.code;
        // });
        // props.helper.setValue(removedRole);
    };

    return (
        <div>
            <KzAutocomplete options={roleList.content}
                            containerClassName="mb-5"
                            loading={roleWait}
                            getOptionLabel={(option) => option.name}
                            getOptionDisabled={(option) => props.userModel.roleList.some(
                                e => e.role.code === option.code) || option.defaultRole}
                            addButton
                            renderOption={(option) => (
                                <React.Fragment>
                                    <ListItemText>
                                        {option.code}
                                    </ListItemText>
                                    <ListItemText>
                                        {option.name}
                                    </ListItemText>
                                    <ListItemText>
                                        {option.description}
                                    </ListItemText>
                                    <ListItemText>
                                        {option.defaultRole ? t("default") : null}
                                    </ListItemText>
                                </React.Fragment>
                            )}
                            addFunc={values => addRoleToList(values)}
                            asyncFunc={text => asyncAutocomplete(text)}/>

            <KzTable columns={[
                {title: t("code"), field: "role.code"},
                {title: t("name"), field: "role.name"},
                {title: t("description"), field: "role.description"},
            ]}
                     options={{
                         showTextRowsSelected: false,
                         paging              : false,
                         search              : false,
                         toolbar             : false,
                     }}
                     tableRef={tableRef}
                     data={props.userModel.roleList}
                     actions={[
                         rowData => ({
                             icon   : () => <FontAwesomeIcon color={clsx(theme.palette.error.main)} icon={faTrashAlt} size="sm"/>,
                             onClick: (event, rowData) => handleRemoveRole(rowData),
                             hidden : rowData.role.defaultRole !== undefined && rowData.role.defaultRole === true
                         })
                     ]}/>
        </div>
    );
};

UserRoleRelationForm.propTypes = {
    userUuid : PropTypes.string,
    // fieldProps: PropTypes.any,
    // helper    : PropTypes.any
    form     : PropTypes.any.isRequired,
    userModel: PropTypes.object.isRequired
};

export default UserRoleRelationForm;