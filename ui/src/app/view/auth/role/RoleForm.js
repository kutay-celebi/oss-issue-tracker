import React from 'react';
import PropTypes from 'prop-types';
import KzFormDialog from "@kuartz/components/form/KzFormDialog";
import {useTranslation} from "react-i18next";
import {DialogContent} from "@material-ui/core";
import Grid from "@material-ui/core/Grid";
import KzTextField from "@kuartz/components/TextInput/KzTextField";
import {useFormik} from "formik";
import {useSelector} from "react-redux";

const RoleForm = props => {
    let {t}    = useTranslation();
    const roleModel = useSelector(({authReducers}) => authReducers.role.roleModel);
    let formik = useFormik({
                               initialValues     : roleModel,
                               enableReinitialize: true,
                               validateOnChange: true,
                               validateOnBlur  : true,
                               onSubmit          : (values) => props.saveAction(values)
                           });
    return (
        <KzFormDialog open={props.openForm}
                      onClose={props.onClose}
                      headerText={t("role:title")}
                      fullWidth
                      maxWidth={"lg"}
                      onSubmit={formik.handleSubmit}
                      onClear={props.clearForm}>
            <DialogContent>
                <form>
                    <Grid container spacing={2} direction="column" className="my-5">
                        <Grid item xs={12} md={12} lg={6} xl={6}>
                            <KzTextField label={t("code")}
                                         fullWidth
                                         value={formik.values.code}
                                         onChange={formik.handleChange("code")}/>
                        </Grid>
                        <Grid item xs={12} md={12} lg={6} xl={6}>
                            <KzTextField label={t("name")}
                                         fullWidth
                                         value={formik.values.name}
                                         onChange={formik.handleChange("name")}/>
                        </Grid>
                        <Grid item xs={12} md={12} lg={6} xl={6}>
                            <KzTextField label={t("description")}
                                         fullWidth
                                         multiline
                                         rows={4}
                                         value={formik.values.description}
                                         onChange={formik.handleChange("description")}/>
                        </Grid>

                    </Grid>
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