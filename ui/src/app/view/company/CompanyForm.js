import React from 'react';
import PropTypes from 'prop-types';
import KzFormDialog from "../../../@kuartz/components/form/KzFormDialog";
import {useTranslation} from "react-i18next";
import {DialogContent} from "@material-ui/core";
import Grid from "@material-ui/core/Grid";
import KzTextField from "../../../@kuartz/components/TextInput/KzTextField";
import ContactForm from "../contact/ContactForm";
import {useFormik} from "formik";

const CompanyForm = props => {
    let {t}    = useTranslation("company");
    let formik = useFormik({
                               initialValues     : props.company,
                               enableReinitialize: true,
                               onSubmit          : (values) => props.saveAction(values)
                           });

    return (
        <KzFormDialog open={props.openForm}
                      onClose={props.onClose}
                      headerText={t("title")}
                      fullWidth
                      maxWidth={"lg"}
                      onSubmit={formik.handleSubmit}
                      onClear={props.clearForm}>
            <DialogContent>
                <form>
                    <Grid container spacing={2} direction="column" className="my-5">
                        <Grid item md={12} lg={6}>
                            <KzTextField label={t("name")}
                                         fullWidth
                                         {...formik.getFieldProps("name")}/>
                        </Grid>
                        <Grid item md={12} lg={6}>
                            <KzTextField label={t("shortName")}
                                         fullWidth
                                         {...formik.getFieldProps("shortName")}/>
                        </Grid>
                        <Grid item md={12} lg={6}>
                            <KzTextField label={t("country")}
                                         fullWidth
                                         {...formik.getFieldProps("country")}/>
                        </Grid>
                    </Grid>
                    <ContactForm formik={formik} contact={props.company.contact}/>
                </form>
            </DialogContent>
        </KzFormDialog>
    );
};

CompanyForm.propTypes = {
    company   : PropTypes.object.isRequired,
    openForm  : PropTypes.bool.isRequired,
    clearForm : PropTypes.func.isRequired,
    onClose   : PropTypes.func,
    saveAction: PropTypes.func.isRequired
};

export default CompanyForm;