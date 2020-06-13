import React from 'react';
import PropTypes from 'prop-types';
import Grid from "@material-ui/core/Grid";
import KzTextField from "../../../../@kuartz/components/TextInput/KzTextField";
import KzMaskedInput from "../../../../@kuartz/components/mask/KzMaskedInput";
import {useTranslation} from "react-i18next";

const UserContactForm = props => {
    const {t}     = useTranslation("contact");
    return (
        <Grid container spacing={2} direction="column" className="my-5">
            <Grid item xs={12} md={12} lg={6} xl={6}>
                <KzTextField label={t("adress")}
                             {...props.formik.getFieldProps("person.contact.adress")}
                             multiline
                             rows={4}
                             fullWidth/>
            </Grid>
            <Grid item md={12} lg={6}>
                <KzMaskedInput label={t("gsm1")}
                               {...props.formik.getFieldProps("person.contact.gsm1")}
                               fullWidth
                               maskProps={{
                                   allowEmptyFormatting: true,
                                   removeFormatting    : true,
                                   format              : "+### (###) ### ## ##",
                                   mask                : "_"
                               }}/>
            </Grid>

            <Grid item md={12} lg={6}>
                <KzMaskedInput label={t("gsm2")}
                               {...props.formik.getFieldProps("person.contact.gsm2")}
                               fullWidth
                               maskProps={{
                                   allowEmptyFormatting: true,
                                   removeFormatting    : true,
                                   format              : "+### (###) ### ## ##",
                                   mask                : "_"
                               }}/>
            </Grid>

            <Grid item md={12} lg={6}>
                <KzMaskedInput label={t("tel")}
                               {...props.formik.getFieldProps("person.contact.tel")}
                               fullWidth
                               maskProps={{
                                   allowEmptyFormatting: true,
                                   removeFormatting    : true,
                                   format              : "+### (###) ### ## ##",
                                   mask                : "_"
                               }}/>
            </Grid>

            <Grid item md={12} lg={6}>
                <KzTextField label={t("mail")}
                             {...props.formik.getFieldProps("person.contact.mail")}
                             fullWidth/>
            </Grid>

            <Grid item md={12} lg={6}>
                <KzTextField label={t("web")}
                             {...props.formik.getFieldProps("person.contact.web")}
                             fullWidth/>
            </Grid>

        </Grid>
    );
};

UserContactForm.propTypes = {
    formik: PropTypes.any.isRequired
};

export default UserContactForm;