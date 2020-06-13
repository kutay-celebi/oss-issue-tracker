import React, {Component} from 'react';
import {connect} from 'react-redux';
import KzFormCard from "../../../@kuartz/components/form/KzFormCard";
import {withTranslation} from "react-i18next";
import clsx from "clsx";
import KzTable from "../../../@kuartz/components/KzTable/KzTable";
import {bindActionCreators} from "redux";
import {
    clearCompanyForm,
    closeCompanyForm,
    getCompany,
    getCompanyPage,
    openCompanyForm,
    saveCompanyForm
} from "../../redux/actions/company";
import {Button, withStyles} from "@material-ui/core";
import CompanyForm from "./CompanyForm";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faEdit} from "@fortawesome/free-solid-svg-icons";
import CompanyQueryForm from "./CompanyQueryForm";

const styles = (theme) => ({
    borderFrame: {
        border: "1px solid #ccc !important",
    },
});

class CompanyDefinition extends Component {
    handePageChange = (event) => {
        const currentPage = this.props.query.pageable.pageNumber;
        if (event !== currentPage) {
            this.props.query.pageable.pageNumber = event;
            this.props.getPage(this.props.query)
        }
    };

    handleRowPerPageChange = event => {
        const currentPageSize = this.props.query.pageable.pageSize;
        if (event !== currentPageSize) {
            this.props.query.pageable.pageSize = event;
            this.props.getPage(this.props.query)
        }
    };

    render() {
        let {t, classes} = this.props;
        return (
            <KzFormCard title={t("company:title")}>
                <div className={clsx(classes.borderFrame, "p-5")}>
                    <CompanyQueryForm/>
                </div>

                <div className={clsx(classes.borderFrame, "p-5 mt-5")}>
                    <Button className={"my-3"} variant="outlined" color="secondary" onClick={this.props.handleOpenForm}>
                        {t("add-new")}
                    </Button>

                    <CompanyForm company={this.props.company} openForm={this.props.openForm} onClose={this.props.handleCloseForm}
                                 clearForm={this.props.handleClearForm} saveAction={this.props.handleSaveForm}/>

                    <KzTable
                        columns={[
                            {title: t("company:name"), field: "name"},
                            {title: t("company:shortName"), field: "shortName"},
                            {title: t("company:country"), field: "country"},

                        ]}
                        data={this.props.companyList.content}
                        onChangeRowsPerPage={this.handleRowPerPageChange}
                        onChangePage={this.handePageChange}
                        page={this.props.query.pageable.pageNumber}
                        pageSize={this.props.query.pageable.pageSize}
                        totalCount={this.props.companyList ? this.props.companyList.totalElements : 0}
                        actions={[
                            {
                                icon   : () => <FontAwesomeIcon icon={faEdit}/>,
                                onClick: (event, rowData) => this.props.getCompany(rowData.id)
                            }
                        ]}/>
                </div>
            </KzFormCard>
        );
    }
}

const mapStateToProps = ({companyReducers}) => {
    return {
        company    : companyReducers.company.company,
        query      : companyReducers.company.query,
        companyList: companyReducers.company.companyList,
        openForm   : companyReducers.company.openForm,
    }
};

function mapDispatchToProps(dispatch) {
    return bindActionCreators({
                                  handleOpenForm : openCompanyForm,
                                  handleCloseForm: closeCompanyForm,
                                  handleClearForm: clearCompanyForm,
                                  handleSaveForm : saveCompanyForm,
                                  getCompany     : getCompany,
                              }, dispatch)
}

export default withStyles(styles)(withTranslation()(connect(mapStateToProps, mapDispatchToProps)(CompanyDefinition)));