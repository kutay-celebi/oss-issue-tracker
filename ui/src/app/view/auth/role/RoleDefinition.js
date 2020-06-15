import React, {Component} from 'react';
import KzFormCard from "../../../../@kuartz/components/form/KzFormCard";
import {withTranslation} from "react-i18next";
import RoleQueryForm from "./RoleQueryForm";
import KzFormFrame from "../../../../@kuartz/components/form/KzFormFrame";
import Button from "@material-ui/core/Button";
import {bindActionCreators} from "redux";
import {connect} from "react-redux";
import RoleForm from "./RoleForm";
import {clearRoleForm, closeRoleForm, getRole, getRolePage, openRoleForm, saveRole} from "../../../redux/actions/auth/role.actions";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faEdit} from "@fortawesome/free-solid-svg-icons";
import KzTable from "../../../../@kuartz/components/KzTable/KzTable";

class RoleDefinition extends Component {
    handePageChange = (event) => {
        const currentPage = this.props.query.pageable.pageNumber;
        if (event !== currentPage) {
            this.props.query.pageable.pageNumber = event;
            this.props.getRolePage(this.props.query)
        }
    };

    handleRowPerPageChange = event => {
        const currentPageSize = this.props.query.pageable.pageSize;
        if (event !== currentPageSize) {
            this.props.query.pageable.pageSize = event;
            this.props.getRolePage(this.props.query)
        }
    };

    render() {
        const {t} = this.props;

        return (
            <KzFormCard title={t("role:title")}>
                <KzFormFrame>
                    <RoleQueryForm/>
                </KzFormFrame>
                <KzFormFrame>
                    <Button className="my-3" onClick={this.props.handleOpenForm}>
                        {t("add-new")}
                    </Button>
                    <RoleForm roleModel={this.props.roleModel}
                              openForm={this.props.openForm}
                              clearForm={this.props.handleClearForm}
                              saveAction={this.props.handleSaveForm}
                              onClose={this.props.handleCloseForm}/>

                    <KzTable
                        columns={[
                            {title: t("role:code"), field: "code"},
                            {title: t("role:name"), field: "name"},

                        ]}
                        data={this.props.roleList.content}
                        onChangeRowsPerPage={this.handleRowPerPageChange}
                        onChangePage={this.handePageChange}
                        page={this.props.query.pageable.pageNumber}
                        pageSize={this.props.query.pageable.pageSize}
                        totalCount={this.props.roleList ? this.props.roleList.totalElements : 0}
                        actions={[
                            {
                                icon   : () => <FontAwesomeIcon icon={faEdit}/>,
                                onClick: (event, rowData) => this.props.getRole(rowData.id)
                            }
                        ]}/>

                </KzFormFrame>
            </KzFormCard>

        );
    }
}

const mapStateToProps = ({authReducers}) => {
    return {
        roleModel: authReducers.role.roleModel,
        query    : authReducers.role.roleQuery,
        roleList : authReducers.role.roleList,
        openForm : authReducers.role.roleFormOpen,
    }
};

function mapDispatchToProps(dispatch) {
    return bindActionCreators({
                                  handleOpenForm : openRoleForm,
                                  handleCloseForm: closeRoleForm,
                                  handleClearForm: clearRoleForm,
                                  handleSaveForm : saveRole,
                                  getRolePage    : getRolePage,
                                  getRole        : getRole,
                              }, dispatch)
}


RoleDefinition.propTypes = {};

export default withTranslation()(connect(mapStateToProps, mapDispatchToProps)(RoleDefinition));