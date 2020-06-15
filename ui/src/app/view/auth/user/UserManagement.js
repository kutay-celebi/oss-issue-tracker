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
import {saveUser} from "../../../redux/actions/auth";
import Button from "@material-ui/core/Button";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faEdit} from "@fortawesome/free-solid-svg-icons";
import KzOutputDate from "../../../../@kuartz/components/Date/KzOutputDate";
import KzTable from "../../../../@kuartz/components/KzTable/KzTable";
import {initUserQuery} from "../../../redux/reducers/auth/user.reducer";
import KzFormFrame from "../../../../@kuartz/components/form/KzFormFrame";

const styles = (theme) => ({
    borderFrame: {
        border: "1px solid #ccc !important",
    },
});

class UserManagement extends Component {

    constructor(props, context) {
        super(props, context);
        this.state = {
            query    : initUserQuery()
        }
    }

    handePageChange = (event) => {
        if (event !== this.state.query.pageable.pageNumber) {

            this.setState(state => {
                              state.query.pageable.pageNumber = event
                          },
                          () => {
                              this.props.getUserPage(this.state.query)
                          });
        }
    };

    handleRowPerPageChange = event => {
        if (event !== this.state.query.pageable.pageSize) {

            this.setState(state => {
                              state.query.pageable.pageSize = event
                          },
                          () => {
                              this.props.getUserPage(this.state.query)
                          });
        }
    };

    render() {
        const {classes, t} = this.props;
        return (
            <KzFormCard title="User Management">
                <KzFormFrame>
                    <UserQueryForm query={this.state.query} pageFunction={this.props.getUserPage}/>
                </KzFormFrame>

                <KzFormFrame>
                    <Button className={clsx("mb-5")} onClick={this.props.openUserForm}>
                        {t("common:add-new")}
                    </Button>

                    <AddUserForm handleAddUser={this.props.addUser}
                                 userModel={this.props.user}
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
                        page={this.state.query.pageable.pageNumber}
                        pageSize={this.state.query.pageable.pageSize}
                        totalCount={this.props.userList ? this.props.userList.totalElements : 0}
                        actions={[
                            {
                                icon   : () => <FontAwesomeIcon icon={faEdit}/>,
                                onClick: (event, rowData) => this.props.getUser(rowData.username)
                            }
                        ]}/>
                </KzFormFrame>
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