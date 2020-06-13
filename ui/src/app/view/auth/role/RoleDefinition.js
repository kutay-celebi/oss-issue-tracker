import React, {Component} from 'react';
import PropTypes from 'prop-types';
import KzFormCard from "../../../../@kuartz/components/form/KzFormCard";
import {withTranslation} from "react-i18next";

class RoleDefinition extends Component {
    render() {
        const {t} = this.props;

        return (
            <KzFormCard headerText={t("role:title")}>

            </KzFormCard>
        );
    }
}

RoleDefinition.propTypes = {};

export default withTranslation()(RoleDefinition);