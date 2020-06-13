import React, {Component} from "react";
import KzFormCard from "../../../../@kuartz/components/form/KzFormCard";
import {withStyles} from "@material-ui/core";
import {connect} from "react-redux";
import {bindActionCreators} from "redux";
import UserQueryForm from "./UserQueryForm";
import {clearAddUserForm, closeUserForm, getUser, getUserPage, openUserForm} from "../../../redux/actions/auth/user.actions";
import {withTranslation} from "react-i18next";
import clsx from "clsx";
import AddUserForm from "./AddUserForm";
import {saveUser}  from "../../../redux/actions/auth";
import Button      from "@material-ui/core/Button";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faEdit} from "@fortawesome/free-solid-svg-icons";
import KzOutputDate from "../../../../@kuartz/components/Date/KzOutputDate";
import KzTable from "../../../../@kuartz/components/KzTable/KzTable";

const styles = (theme) => ({
    borderFrame: {
        border: "1px solid #ccc !important",
    },
});

class UserManagement extends Component {

    handePageChange = (event) => {
        const currentPage = this.props.userQuery.pageable.pageNumber;
        if (event !== currentPage) {
            this.props.userQuery.pageable.pageNumber = event;
            this.props.getUserPage(this.props.userQuery)
        }
    };

    handleRowPerPageChange = event => {
        const currentPageSize = this.props.userQuery.pageable.pageSize;
        if (event !== currentPageSize) {
            this.props.userQuery.pageable.pageSize = event;
            this.props.getUserPage(this.props.userQuery)
        }
    };

    render() {
        const {classes, t} = this.props;
        return (
            <KzFormCard title="User Management">
                <div className={clsx(classes.borderFrame)}>
                    <UserQueryForm query={this.props.userQuery} onSubmit={this.props.getUserPage} classes={classes}/>
                </div>
                <div id="table-container" className={clsx("p-5 mt-5", classes.borderFrame)}>
                    <Button className={clsx("mb-5")} onClick={this.props.openUserForm}>
                        {t("common:add-new")}
                    </Button>

                    <AddUserForm handleAddUser={this.props.addUser}
                                 user={this.props.user}
                                 open={this.props.userFormOpen}
                                 handleClear={this.props.clearUser}
                                 handleFormClose={this.props.closeUserForm}/>

                    <KzTable
                        columns={[
                            {title: t("name"), field: "person.name"},
                            {title: t("surname"), field: "person.lastName"},
                            {
                                title : t("birthday"),
                                field : "person.birthday",
                                render: (row) => <KzOutputDate value={row.person ? row.person.birthday : null}/>
                            },
                            {title: t("username"), field: "username"},
                            {title: t("email"), field: "email"},
                        ]}
                        data={this.props.userList.content}
                        onChangeRowsPerPage={this.handleRowPerPageChange}
                        onChangePage={this.handePageChange}
                        page={this.props.userQuery.pageable.pageNumber}
                        pageSize={this.props.userQuery.pageable.pageSize}
                        totalCount={this.props.userList ? this.props.userList.totalElements : 0}
                        actions={[
                            {
                                icon   : () => <FontAwesomeIcon icon={faEdit}/>,
                                onClick: (event, rowData) => this.props.getUser(rowData.username)
                            }
                        ]}/>
                </div>
            </KzFormCard>
        )
    }
}

const mapDispatchToProps = (dispatch) => {
    return bindActionCreators({
                                  getUserPage  : getUserPage,
                                  addUser      : saveUser,
                                  clearUser    : clearAddUserForm,
                                  getUser      : getUser,
                                  openUserForm : openUserForm,
                                  closeUserForm: closeUserForm
                              }, dispatch)
};

const mapStateToProps = ({authReducers}) => {
    return {
        user        : authReducers.user.user,
        userQuery   : authReducers.user.query,
        userList    : authReducers.user.userList,
        userFormOpen: authReducers.user.userFormOpen,
    }
};

export default withTranslation()(withStyles(styles)(connect(mapStateToProps, mapDispatchToProps)(UserManagement)));