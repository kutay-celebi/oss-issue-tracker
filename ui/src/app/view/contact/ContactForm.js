import React from 'react';
import PropTypes from 'prop-types';
import Grid from "@material-ui/core/Grid";
import {useTranslation} from "react-i18next";
import KzTextField from "../../../@kuartz/components/TextInput/KzTextField";
import KzMaskedInput from "../../../@kuartz/components/mask/KzMaskedInput";

const ContactForm = props => {
    let {t} = useTranslation(["contact"]);
    return (
        <Grid container spacing={2} direction="column" className="my-5">
            <Grid item md={12} lg={6}>
                <KzTextField label={t("adress")}
                             {...props.formik.getFieldProps("contact.adress")}
                             fullWidth
                             multiline
                             rows={5}/>
            </Grid>

            <Grid item md={12} lg={6}>
                <KzMaskedInput label={t("gsm1")}
                               {...props.formik.getFieldProps("contact.gsm1")}
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
                               {...props.formik.getFieldProps("contact.gsm2")}
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
                               {...props.formik.getFieldProps("contact.tel")}
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
                             {...props.formik.getFieldProps("contact.mail")}
                             fullWidth/>
            </Grid>

            <Grid item md={12} lg={6}>
                <KzTextField label={t("web")}
                             {...props.formik.getFieldProps("contact.web")}
                             fullWidth/>
            </Grid>

        </Grid>
    )
};

ContactForm.propTypes = {
    formik : PropTypes.any.isRequired,
    contact: PropTypes.object.isRequired
};

export default React.memo(ContactForm);