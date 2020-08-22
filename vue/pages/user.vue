<template>
  <PageContent>
    <crud-header slot="header" :header-text="$t('user.userDefinition')" sub-title="Subtitle">
      <div slot="form">
        <client-only>
          <nuxt-child :key="$route.fullPath"/>
        </client-only>
      </div>
    </crud-header>
    <div slot="content">
      <v-container fluid>
        <user-datatable :query="query"/>
      </v-container>
    </div>
  </PageContent>
</template>

<script>
import PageContent        from "~/components/form/PageContent";
import UserDefinitionForm from "~/components/uaa/UserDefinitionForm";
import UserDatatable      from "~/components/uaa/user/UserDatatable";
import {userPageQuery}    from "~/common/query/uaa/user/userPageQuery";
import CrudHeader         from "~/components/form/CrudHeader";
import GenderSelect       from "~/components/form/GenderSelect";
import KzDatePicker       from "~/components/kuartz/datepicker/KzDatePicker";
import KzFormDialog       from "~/components/kuartz/form/KzFormDialog";

export default {
  name      : "index",
  components: {CrudHeader, UserDatatable, UserDefinitionForm, PageContent, GenderSelect, KzDatePicker, KzFormDialog},
  middleware: ["auth", "api"],
  data      : function () {
    return {
      query: userPageQuery,
    }
  }
}
</script>
