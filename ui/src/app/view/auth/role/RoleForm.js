import React from 'react';
import PropTypes from 'prop-types';
import KzFormDialog from "@kuartz/components/form/KzFormDialog";
import {useTranslation} from "react-i18next";
import {CardHeader, DialogContent} from "@material-ui/core";
import Grid from "@material-ui/core/Grid";
import KzTextField from "@kuartz/components/TextInput/KzTextField";
import {useForm} from "react-hook-form";
import Card from "@material-ui/core/Card";
import CardActions from "@material-ui/core/CardActions";
import PrivilegeSelectDialog from "../privilege/PrivilegeSelectDialog";
import KzTable from "@kuartz/components/KzTable/KzTable";
import AuthService from "../../../service/authServiceImpl";
import {API_ADD_ROLE_PRIVILEGE} from "../../../constants";
import {useDispatch} from "react-redux";
import {getRole} from "../../../redux/actions/auth/role.actions";
import {enqueueSnackbar} from "../../../redux/actions/core";


const RoleForm = props => {
    const dispatch                                = useDispatch();
    let {t}                                       = useTranslation();
    const {register, handleSubmit, errors, watch} = useForm({mode: 'onChange'});

    const addPrivilege = async (selectedList) => {
        console.log(selectedList);
        await AuthService.postApi().post(API_ADD_ROLE_PRIVILEGE, selectedList.map(p => p.id),
                                         {
                                             params: {
                                                 "roleId": props.roleModel.id
                                             }
                                         })
                         .then(
                             response => {
                                 dispatch(getRole(props.roleModel.id));
                                 console.log("done");
                             }
                         )
                         .catch((error) => {
                             dispatch(enqueueSnackbar(error.response.data.message, {variant: "error"})); //todo generic error method.
                         })
    };

    return (
        <KzFormDialog open={props.openForm}
                      onClose={props.onClose}
                      headerText={t("role:title")}
                      fullWidth
                      maxWidth={"lg"}
                      onSubmit={handleSubmit(props.saveAction)}
                      onClear={props.clearForm}>
            <DialogContent>
                <form>

                    <Grid container spacing={2} direction="column" className="my-5">
                        <Grid item xs={12} md={12} lg={6} xl={6}>
                            <KzTextField label={t("role:roleCode")} inputRef={register} name="code" defaultValue={props.roleModel.code}/>
                        </Grid>

                        <Grid item xs={12} md={12} lg={6} xl={6}>
                            <KzTextField label={t("role:roleName")} inputRef={register} name="name" defaultValue={props.roleModel.name}/>
                        </Grid>

                        <Grid item xs={12} md={12} lg={12} xl={12}>
                            <KzTextField label={t("description")}
                                         inputRef={register}
                                         name="description"
                                         fullWidth
                                         rows={4}
                                         multiline
                                         defaultValue={props.roleModel.description}/>
                        </Grid>
                    </Grid>

                    <Card>
                        <CardHeader title={t("role:currentPrivilege")}/>
                        <CardActions>
                            <PrivilegeSelectDialog onSelect={addPrivilege}
                                                   disabled={props.roleModel.id === null}
                                                   existPrivilegeList={props.roleModel.rolePrivilegeRelationList}/>
                        </CardActions>
                        <KzTable
                            options={{search: false, initialPage: 1, pageSize: 20}}
                            columns={[
                                {title: t("code"), field: "privilege.code"},
                                {title: t("parent") + " " + t("code"), field: "privilege.parentPrivilege.code"},
                                {title: t("default"), field: "privilege.defaultPrivilege", type: "boolean"},
                            ]}
                            data={props.roleModel ? props.roleModel.rolePrivilegeRelationList : null}
                            totalCount={props.roleModel.rolePrivilegeRelationList ? props.roleModel.rolePrivilegeRelationList.length : 0}/>
                    </Card>

                </form>
            </DialogContent>
        </KzFormDialog>
    );
};

RoleForm.propTypes = {
    roleModel : PropTypes.object.isRequired,
    openForm  : PropTypes.bool.isRequired,
    clearForm : PropTypes.func.isRequired,
    onClose   : PropTypes.func.isRequired,
    saveAction: PropTypes.func.isRequired
};

export default RoleForm;