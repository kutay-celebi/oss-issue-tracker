import React from 'react';
import PropTypes from 'prop-types';
import KzFormDialog from "@kuartz/components/form/KzFormDialog";
import {useTranslation} from "react-i18next";
import {DialogContent} from "@material-ui/core";
import Grid from "@material-ui/core/Grid";
import KzTextField from "@kuartz/components/TextInput/KzTextField";
import {useForm} from "react-hook-form";

const RoleForm = props => {
    let {t}         = useTranslation();
    const {register, handleSubmit, errors, watch} = useForm({mode: 'onChange'});

    return (
        <KzFormDialog open={props.openForm}
                      onClose={props.onClose}
                      headerText={t("role:title")}
                      fullWidth
                      maxWidth={"lg"}
                      onSubmit={handleSubmit(props.saveAction)}
                      onClear={props.clearForm}>
            <DialogContent>
                <form onSubmit={handleSubmit(props.saveAction)}>
                    <Grid container spacing={2} direction="column" className="my-5">
                        <Grid item xs={12} md={12} lg={6} xl={6}>
                            <KzTextField inputRef={register} name="code" defaultValue={props.roleModel.code}/>
                        </Grid>

                        <Grid item xs={12} md={12} lg={6} xl={6}>
                            <KzTextField inputRef={register} name="name" defaultValue={props.roleModel.name}/>
                        </Grid>

                        <Grid item xs={12} md={12} lg={6} xl={6}>
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