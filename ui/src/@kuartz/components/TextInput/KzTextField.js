import React from 'react';
import PropTypes from 'prop-types';
import {InputAdornment, TextField} from "@material-ui/core";

const KzTextField = (props) => {
    return (
        <TextField value={props.value || ''}
                   error={props.formikMeta !== undefined && props.formikMeta !== null && props.formikMeta.error !== undefined &&
                   props.formikMeta.error !== null}
                   helperText={props.formikMeta !== undefined && props.formikMeta !== null && props.formikMeta.error !== undefined &&
                   props.formikMeta.error !== null ? props.formikMeta.error : null}
                   InputProps={{
                       startAdornment: props.adornmentPosition === "start" && props.adornmentText ?
                           <InputAdornment position="start">{props.adornmentText}</InputAdornment> : null,
                       endAdornment  : props.adornmentPosition === "end" && props.adornmentText ?
                           <InputAdornment position="end">{props.adornmentText}</InputAdornment> : null,
                       ...props.InputProps
                   }}
                   {...props}
        />
    );
};

KzTextField.defaultProps = {};

KzTextField.propTypes = {
    ...TextField.propTypes,
    label: PropTypes.string,

    /**
     * Tema renkleri
     */
    color: PropTypes.oneOf(["primary", "secondary"]),

    /**
     * Inputtextin stili
     */
    variant: PropTypes.oneOf(['outlined', 'filled', 'standard']),

    adornmentText: PropTypes.string,

    adornmentPosition: PropTypes.oneOf(['start', 'end']),

    formikMeta: PropTypes.object
};

export default KzTextField;