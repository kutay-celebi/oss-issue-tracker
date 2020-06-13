import React from 'react';
import PropTypes from 'prop-types';
import Grid from "@material-ui/core/Grid";
import KzTextField from "../../../../@kuartz/components/TextInput/KzTextField";
import KzSelect from "../../../../@kuartz/components/select/KzSelect";
import {gender} from "../../../reference/Gender";
import KzKeyboardDatePicker from "../../../../@kuartz/components/Date/KzKeyboardDatePicker";
import {useTranslation} from "react-i18next";

const MainInformationForm = props => {

    const {t}                         = useTranslation();

    return (
        <Grid container spacing={2} direction="column" className="my-5">
            <Grid item xs={12} md={12} lg={6} xl={6}>
                <KzTextField label={t("username")}
                             fullWidth
                             formikMeta={props.formik.getFieldMeta("username")}
                             {...props.formik.getFieldProps("username")}/>
            </Grid>
            <Grid item xs={12} md={12} lg={12} xl={12}>
                <KzTextField label={t("email")}
                             fullWidth
                             formikMeta={props.formik.getFieldMeta("email")}
                             {...props.formik.getFieldProps("email")}/>
            </Grid>
            <Grid item xs={12} md={12} lg={6} xl={6}>
                <KzTextField label={t("name")}
                             fullWidth
                             formikMeta={props.formik.getFieldMeta("person.name")}
                             {...props.formik.getFieldProps("person.name")}/>
            </Grid>
            <Grid item xs={12} md={12} lg={6} xl={6}>
                <KzTextField label={t("surname")}
                             fullWidth
                             {...props.formik.getFieldProps("person.lastName")}/>
            </Grid>
            <Grid item xs={12} md={12} lg={6} xl={6}>
                <KzSelect options={gender}
                          label={t("gender")}
                          variant="outlined"
                          fullWidth
                          formikMeta={props.formik.getFieldMeta("person.gender")}
                          {...props.formik.getFieldProps("person.gender")}/>
            </Grid>
            <Grid item xs={12} md={12} lg={6} xl={6}>
                <KzKeyboardDatePicker label={t("birthday")}
                                      {...props.formik.getFieldProps("person.birthday")}
                                      formikMeta={props.formik.getFieldMeta("person.birthday")}
                                      maxDate={new Date()}
                                      onChange={(value) => props.formik.setFieldValue("person.birthday", value)}/>
            </Grid>
        </Grid>
    );
};

MainInformationForm.propTypes = {
    userUuid: PropTypes.string,
    formik  : PropTypes.any.isRequired
};

export default MainInformationForm;