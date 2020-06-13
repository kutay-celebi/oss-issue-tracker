import React from 'react';
import PropTypes from 'prop-types';
import {useTranslation} from "react-i18next";
import {useFormik} from "formik";
import clsx from "clsx";
import Grid from "@material-ui/core/Grid";
import KzTextField from "../../../@kuartz/components/TextInput/KzTextField";
import Button from "@material-ui/core/Button";
import {useDispatch, useSelector} from "react-redux";
import {getCompanyPage} from "../../redux/actions/company";

const CompanyQueryForm = props => {

    const {t}          = useTranslation();
    const dispatch = useDispatch();
    const {query} = useSelector(({companyReducers}) => companyReducers.company);

    let formik = useFormik({
                               initialValues   : query,
                               validateOnChange: true,
                               validateOnBlur  : true,
                               onSubmit        : (values) => dispatch(getCompanyPage(values))
                           });

    return (
        <div>
            <form>

                <Grid container spacing={2}>
                    <Grid item>
                        <KzTextField label={t("company:name")}
                                     {...formik.getFieldProps("companyName")}/>
                    </Grid>
                </Grid>
            </form>

            <div id="query-form-button-group" className="my-5">
                <Button id="find-button" onClick={formik.handleSubmit} variant="outlined" color="secondary">
                    {t("find")}
                </Button>
            </div>
        </div>
    );
};

export default CompanyQueryForm;