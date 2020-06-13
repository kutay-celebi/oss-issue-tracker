import React from 'react';
import PropTypes from 'prop-types';
import CompanySelectDialog from "../../company/CompanySelectDialog";
import Grid from "@material-ui/core/Grid";
import {useTranslation} from "react-i18next";
import {Typography} from "@material-ui/core";
import CompanySummaryForm from "../../company/CompanySummaryForm";
import Button from "@material-ui/core/Button";

const UserCompanyInfoForm = (props) => {

    const {t} = useTranslation();

    const handeCompanySelect = (company) => {
        props.formik.setFieldValue("person.company", company);
    };

    const handleCompanyClear = () => {
        props.formik.setFieldValue("person.company", null);
    };

    return (
        <div>
            <div className="flex flex-1 flex-grow-1">
                <CompanySelectDialog onSelect={handeCompanySelect}/>
                <Button onClick={() => handleCompanyClear()}>
                    {t("clear")}
                </Button>
            </div>
            <div className="mt-5">
                <Typography variant="h6" className="font-bold border-solid border-0 border-b " color="secondary">{t("current")}</Typography>

                <CompanySummaryForm company={props.formik.values.person.company}/>
            </div>
        </div>
    );
};

UserCompanyInfoForm.propTypes = {
    formik: PropTypes.any.isRequired
};

export default UserCompanyInfoForm;