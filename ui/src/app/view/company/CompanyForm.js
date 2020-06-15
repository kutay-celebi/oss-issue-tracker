import React from 'react';
import PropTypes from 'prop-types';
import KzFormDialog from "../../../@kuartz/components/form/KzFormDialog";
import {useTranslation} from "react-i18next";
import {DialogContent} from "@material-ui/core";
import Grid from "@material-ui/core/Grid";
import KzTextField from "../../../@kuartz/components/TextInput/KzTextField";
import ContactForm from "./ContactForm";
import {useForm} from "react-hook-form";

const CompanyForm = props => {
    let {t}    = useTranslation("company");

    const companyForm = useForm({mode: 'onChange', reValidateMode: "onChange"});

    return (
        <KzFormDialog open={props.openForm}
                      onClose={props.onClose}
                      headerText={t("title")}
                      fullWidth
                      maxWidth={"lg"}
                      onSubmit={companyForm.handleSubmit(props.saveAction)}
                      onClear={props.clearForm}>
            <DialogContent>
                <form>
                    <Grid container spacing={2} direction="column" className="my-5">
                        <Grid item md={12} lg={6}>
                            <KzTextField label={t("name")}
                                         fullWidth
                                         name={"name"}
                                         defaultValue={props.companyModel.name}
                                         inputRef={companyForm.register}/>
                        </Grid>
                        <Grid item md={12} lg={6}>
                            <KzTextField label={t("shortName")}
                                         fullWidth
                                         name={"shortName"}
                                         defaultValue={props.companyModel.shortName}
                                         inputRef={companyForm.register}/>
                        </Grid>
                        <Grid item md={12} lg={6}>
                            <KzTextField label={t("country")}
                                         fullWidth
                                         name={"country"}
                                         defaultValue={props.companyModel.country}
                                         inputRef={companyForm.register}/>
                        </Grid>
                    </Grid>
                    <ContactForm contactForm={companyForm} contact={props.companyModel.contact}/>
                </form>
            </DialogContent>
        </KzFormDialog>
    );
};

CompanyForm.propTypes = {
    companyModel   : PropTypes.object.isRequired,
    openForm  : PropTypes.bool.isRequired,
    clearForm : PropTypes.func.isRequired,
    onClose   : PropTypes.func,
    saveAction: PropTypes.func.isRequired
};

export default CompanyForm;