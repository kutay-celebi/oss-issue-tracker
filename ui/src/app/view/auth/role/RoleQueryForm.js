import React from 'react';
import PropTypes from 'prop-types';
import KzFormGrid from "../../../../@kuartz/components/form/KzFormGrid";
import KzTextField from "../../../../@kuartz/components/TextInput/KzTextField";
import Button from "@material-ui/core/Button";
import {useForm} from "react-hook-form";


const RoleQueryForm = (props) => {
    const {register, handleSubmit} = useForm({mode: "onSubmit", defaultValues: props.query});
    return (
        <form>
            <KzFormGrid>
                <KzTextField label={"Role Name"}
                             name={"code"}
                             inputRef={register}/>
            </KzFormGrid>
            <div id="query-form-button-group" className="my-5">
                <Button id="find-button"
                        onClick={handleSubmit(data => props.pageFunction({...props.query, ...data}))}
                        variant="outlined">
                    getir
                </Button>
            </div>
        </form>
    );
};

RoleQueryForm.propTypes = {
    query       : PropTypes.object.isRequired,
    pageFunction: PropTypes.func.isRequired
};

export default RoleQueryForm;