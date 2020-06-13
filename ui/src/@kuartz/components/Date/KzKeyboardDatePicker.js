import React from "react";
import {KeyboardDatePicker} from "@material-ui/pickers";
import {DD_MM_YYYY} from "../../../app/constants";
import {KeyboardDatePickerProps} from "@material-ui/pickers/DatePicker/DatePicker";
import PropTypes from "prop-types";
import {useTranslation} from "react-i18next";

const KzKeyboardDatePicker = (props) => {
    const {t} = useTranslation();
    return (
        <KeyboardDatePicker
            invalidDateMessage={t("validation:invalid.date")}
            value={props.value || ''}
            InputProps={{
                error     : props.formikMeta !== undefined && props.formikMeta !== null && props.formikMeta.error !== undefined &&
                            props.formikMeta.error !== null,
                helperText: props.formikMeta !== undefined && props.formikMeta !== null && props.formikMeta.error !== undefined &&
                            props.formikMeta.error !== null ? props.formikMeta.error : null
            }}
            {...props}/>
    );
};

KzKeyboardDatePicker.defaultProps = {
    color             : "secondary",
    fullWidth         : true,
    inputVariant      : "outlined",
    format            : DD_MM_YYYY,
    initialFocusedDate: new Date(),
    variant           : "inline"
};

KzKeyboardDatePicker.propTypes = {
    ...KeyboardDatePickerProps,
    formikMeta: PropTypes.object,
};

export default KzKeyboardDatePicker;