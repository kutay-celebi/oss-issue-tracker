import React       from 'react';
import {useFormik} from "formik";
import KzFormGrid  from "../../../../@kuartz/components/form/KzFormGrid";
import KzTextField from "../../../../@kuartz/components/TextInput/KzTextField";
import Button      from "@material-ui/core/Button";
import clsx        from "clsx";


const RoleQueryForm = (props) => {

    const formik = useFormik({
                                 initialValues   : props.query,
                                 validateOnChange: true,
                                 validateOnBlur  : true,
                                 onSubmit        : values => props.onSubmit(values)
                             });

    return (
        <form onSubmit={formik.handleSubmit} className={clsx("p-10", props.classes.query_form)}>
            <KzFormGrid>
                <KzTextField label={"Role Name"}
                             value={formik.values.code}
                             onChange={formik.handleChange("code")}/>
            </KzFormGrid>
            <div id="query-form-button-group" className="my-5">
                <Button id="find-button" type="submit" variant="outlined">
                    getir
                </Button>
            </div>
        </form>
    );
};

export default RoleQueryForm;