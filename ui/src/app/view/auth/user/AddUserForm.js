import React from "react";
import PropTypes from "prop-types";
import {makeStyles} from "@material-ui/core";
import {useTranslation} from "react-i18next";
import DialogContent from "@material-ui/core/DialogContent";
import KzFormDialog from "../../../../@kuartz/components/form/KzFormDialog";
import Avatar from "@material-ui/core/Avatar";
import {useFormik} from "formik";
import * as Yup from "yup";
import Tabs from "@material-ui/core/Tabs";
import Tab from "@material-ui/core/Tab";
import UserRoleRelationForm from "./UserRoleRelationForm";
import moment from "moment";
import MainInformationForm from "./MainInformationForm";
import UserContactForm from "./UserContactForm";
import UserCompanyInfoForm from "./UserCompanyInfoForm";

const useStyles = makeStyles((theme) => ({
    small: {
        width : theme.spacing(3),
        height: theme.spacing(3),
    },
    large: {
        width : 140,
        height: 140,
    },
}));

function a11yProps(index) {
    return {
        id             : `vertical-tab-${index}`,
        'aria-controls': `vertical-tabpanel-${index}`,
    };
}

const AddUserForm = (props) => {
    const classes = useStyles();
    const {t}     = useTranslation();

    // validation schema.
    const validator = Yup.object().shape({
                                             username: Yup.string()
                                                          .typeError(t("validation:required", {field: t("username")}))
                                                          .min(5, t("validation:user.username.min", {value: 5}))
                                                          .max(40, t("validation:user.username.max", {value: 40}))
                                                          .required(t("validation:required", {field: t("username")})),

                                             email : Yup.string()
                                                        .typeError(t("validation:required", {field: t("email")}))
                                                        .matches("^((?!\\.)[\\w-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$",
                                                                 {message: t("validation:user.email.match")})
                                                        .required(t("validation:required", {field: t("email")})),
                                             person: Yup.object().shape({
                                                                            birthday: Yup.string()
                                                                                         .required(t("validation:user.birthday"))
                                                                                         .test("valid-date", t("validation:invalid.date"),
                                                                                               (value) => {
                                                                                                   if (!isNaN(value)) {
                                                                                                       // to check valid date ?
                                                                                                       return moment.unix(value).isValid();
                                                                                                   } else {
                                                                                                       return moment(value).isValid();
                                                                                                   }
                                                                                               })
                                                                        })
                                         });

    const formik = useFormik({
                                 initialValues     : props.user,
                                 validationSchema  : validator,
                                 validateOnChange  : true,
                                 validateOnBlur    : true,
                                 enableReinitialize: true,
                                 onSubmit          : (values) => props.handleAddUser(values)
                             });

    const [value, setValue] = React.useState(0);

    const handleChange = (event, newValue) => {
        setValue(newValue);
    };


    return (
        <KzFormDialog open={props.open}
                      fullWidth
                      onClose={props.handleFormClose}
                      maxWidth={"lg"}
                      headerText={t("new-user")}
                      onClear={props.handleClear}
                      onSubmit={formik.handleSubmit}>
            <DialogContent>
                <Avatar src="/assets/images/add-user.png" className={classes.large}/>
                <Tabs value={value} onChange={handleChange} scrollButtons="on" variant="scrollable" className="mb-3">
                    <Tab label={t("mainInfo")} {...a11yProps(0)}/>
                    <Tab label={t("contactInfo")} {...a11yProps(1)}/>
                    <Tab label={t("userRole")} {...a11yProps(2)}/> {/*todo change tab name*/}
                    <Tab label={t("companyInfo")} {...a11yProps(3)}/> {/*todo change tab name*/}
                </Tabs>
                <form>
                    {
                        value === 0 ?
                            <div id="account" role="tabpanel">
                                <MainInformationForm formik={formik}/>
                            </div>
                            : value === 1 ?
                            <div id="contact" role="tabpanel">
                                <UserContactForm formik={formik}/>
                            </div>
                            : value === 2 ?
                                <UserRoleRelationForm helper={formik.getFieldHelpers("roleList")}
                                                      fieldProps={formik.getFieldProps("roleList")}
                                                      userUuid={formik.getFieldProps("uuid").value}/>
                                : value === 3 ?
                                    <UserCompanyInfoForm formik={formik}/>
                                    : null
                    }
                </form>
            </DialogContent>
        </KzFormDialog>
    );
};

AddUserForm.defaultProps = {
    open: false,
};

AddUserForm.propTypes = {
    handleAddUser  : PropTypes.func.isRequired,
    handleClear    : PropTypes.func.isRequired,
    user           : PropTypes.object.isRequired,
    handleFormClose: PropTypes.func.isRequired,
    open           : PropTypes.bool.isRequired
};

export default AddUserForm;