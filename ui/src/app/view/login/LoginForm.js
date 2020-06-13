import React          from "react";
import * as PropTypes from "prop-types";
import {Button}       from "@material-ui/core";
import makeStyles     from "@material-ui/core/styles/makeStyles";
import clsx           from "clsx";
import {useFormik}    from "formik";
import KzTextField    from "../../../@kuartz/components/TextInput/KzTextField";


const useStyles = makeStyles(theme => ({
    root          : {
        display       : 'flex',
        flexDirection : 'column',
        justifyContent: 'center',
        flex          : 1,
    },
    contentWrapper: {
        background  : 'rgba(20,20,20,0.6)',
        borderRadius: 25,
        boxShadow   : theme.shadows[10]
    },
    content       : {
        display                 : 'flex',
        flexDirection           : 'row',
        justifyContent          : 'center',
        '& .kzMuiInputBase-root': {
            margin: '10px 10px',
        }
    },
    form          : {
        maxWidth                      : '15rem',
        '& .kz-MuiFormControl-root-61': {
            margin: '10px 0px',
        }
    }
}));

const validate = (values) => {
    const errors = {};
    if (!values.username) {
        errors.username = "Required"
    }

    if (values.username.length < 3) {
        errors.username = "Dont < 3"
    }
    return errors;
};

const LoginForm = (props) => {
    const classes = useStyles();
    // const { values, submitForm } = useFormikContext();
    const formik  = useFormik({
                                  initialValues   : {
                                      username: "kcelebi",
                                      password: "test"
                                  },
                                  validate,
                                  validateOnChange: true,
                                  validateOnBlur  : true,
                                  onSubmit        : values => props.handleForm(values),
                              });
    return (
        <div id="form-div1" className={clsx(classes.root, 'max-w-lg')}>
            <div id="form-div2" className={clsx(classes.contentWrapper)}>
                <div id="form-div3" className={clsx(classes.content)}>
                    <form onSubmit={formik.handleSubmit}
                          className={clsx(classes.form, 'flex flex-1 flex-col py-20')}>
                        <KzTextField label={"Username"}
                                     value={formik.values.username}
                                     helperText={formik.errors.username}
                                     onChange={formik.handleChange("username")}/>
                        <KzTextField label={"Password"}
                                     type="password"
                                     value={formik.values.password}
                                     onChange={formik.handleChange("password")}/>
                        <Button type="submit" variant="outlined">
                            Giriş
                        </Button>
                    </form>
                </div>
            </div>
        </div>
    );
};

LoginForm.propTypes = {
    handleForm: PropTypes.func
};

export default LoginForm