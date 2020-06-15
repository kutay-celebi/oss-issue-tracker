import React from 'react';
import {useFormik} from "formik";
import KzFormGrid from "../../../../@kuartz/components/form/KzFormGrid";
import KzTextField from "../../../../@kuartz/components/TextInput/KzTextField";
import Button from "@material-ui/core/Button";
import {useDispatch, useSelector} from "react-redux";
import {getRolePage} from "../../../redux/actions/auth/role.actions";


const RoleQueryForm = (props) => {
    const dispatch = useDispatch();
    const {roleQuery} = useSelector(({authReducers}) => authReducers.role);
    const formik = useFormik({
                                 initialValues   : roleQuery,
                                 validateOnChange: true,
                                 validateOnBlur  : true,
                                 onSubmit        : values => dispatch(getRolePage(values))
                             });

    return (
        <form>
            <KzFormGrid>
                <KzTextField label={"Role Name"}
                             value={formik.values.code}
                             onChange={formik.handleChange("code")}/>
            </KzFormGrid>
            <div id="query-form-button-group" className="my-5">
                <Button id="find-button" onClick={formik.handleSubmit} variant="outlined">
                    getir
                </Button>
            </div>
        </form>
    );
};

export default RoleQueryForm;