import React from 'react';
import PropTypes from 'prop-types';
import KzTable from "../../../../@kuartz/components/KzTable/KzTable";
import {useDispatch, useSelector} from "react-redux";
import {getRolePage} from "../../../redux/actions/auth/role.actions";
import {useTranslation} from "react-i18next";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faTrashAlt} from "@fortawesome/free-solid-svg-icons";
import {ListSubheader, useMediaQuery, useTheme} from "@material-ui/core";
import clsx from "clsx";
import KzAutocomplete from "../../../../@kuartz/components/autocomplete/KzAutocomplete";
import ListItem from "@material-ui/core/ListItem";
import Autocomplete from "@material-ui/lab/Autocomplete";
import List from "@material-ui/core/List";
import ListItemText from "@material-ui/core/ListItemText";


const UserRoleRelationForm = (props) => {

    const dispatch                    = useDispatch();
    const {roleQuery, roleList, wait} = useSelector(({authReducers}) => authReducers.role);
    const {t}                         = useTranslation();
    const theme                       = useTheme();
    const tableRef                    = React.createRef();

    const asyncAutocomplete = async (text) => {
        roleQuery.code = text;
        dispatch(getRolePage(roleQuery));
    };

    const addRoleToList = (values) => {
        const existRole = props.fieldProps.value;
        const map       = values.map((o) => {
            if (!existRole.some(er => er.role.code === o.code)) {
                return Object.assign({}, {user: props.userUuid}, {role: o});
            }
        });

        if (map !== undefined && !map.includes(undefined)) {
            const concat = existRole.concat(map);
            props.helper.setValue(concat);
        }
    };

    const handleRemoveRole = (role) => {
        const existRole   = props.fieldProps.value;
        const removedRole = existRole.filter((r) => {
            return r.role.code !== role.role.code;
        });
        props.helper.setValue(removedRole);
    };

    return (
        <div>
            <KzAutocomplete options={roleList.content}
                            containerClassName="mb-5"
                            loading={wait}
                            getOptionLabel={(option) => option.name}
                            getOptionDisabled={(option) => props.fieldProps.value.some(
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
                     data={props.fieldProps.value}
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
    userUuid  : PropTypes.string,
    fieldProps: PropTypes.any,
    helper    : PropTypes.any
};

export default UserRoleRelationForm;