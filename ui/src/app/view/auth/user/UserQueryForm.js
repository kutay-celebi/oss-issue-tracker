import React            from "react";
import {useFormik}      from "formik";
import KzTextField      from "../../../../@kuartz/components/TextInput/KzTextField";
import Button           from "@material-ui/core/Button";
import clsx             from "clsx";
import PropTypes        from "prop-types";
import Grid             from "@material-ui/core/Grid";
import {useTranslation} from "react-i18next";


const UserQueryForm = (props) => {

    const {t} = useTranslation();

    const formik = useFormik({
                                 initialValues   : props.query,
                                 validateOnChange: true,
                                 validateOnBlur  : true,
                                 onSubmit        : (values) => props.onSubmit(values)
                             });

    return (
        <form onSubmit={formik.handleSubmit} className={clsx("p-5", props.classes.border_frame)}>

            <Grid container spacing={2}>
                <Grid item>
                    <KzTextField label={t("username")}
                                 value={formik.values.username}
                                 onChange={formik.handleChange("username")}/>
                </Grid>

                <Grid item>
                    <KzTextField label={t("email")}
                                 value={formik.values.email}
                                 onChange={formik.handleChange("email")}/>
                </Grid>
            </Grid>

            <div id="query-form-button-group" className="my-5">
                <Button id="find-button" type="submit" variant="outlined" color="default">
                    {t("find")}
                </Button>
            </div>
        </form>
    );
};

UserQueryForm.propTypes = {
    query  : PropTypes.object,
    classes: PropTypes.object
};

export default UserQueryForm;