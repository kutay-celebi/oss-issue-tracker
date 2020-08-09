<template>
  <CrudPage>
    <div slot="content">
      <user-definition-form/>
      <user-datatable :query="query"/>
    </div>
  </CrudPage>
</template>

<script>
  import CrudPage           from "~/components/form/PageContent";
  import UserDefinitionForm from "~/components/uaa/UserDefinitionForm";
  import UserDatatable      from "~/components/uaa/user/UserDatatable";
  import {userPageQuery}    from "~/common/query/uaa/user/userPageQuery";

  export default {
    name      : "index",
    components: {UserDatatable, UserDefinitionForm, CrudPage},
    middleware: ["auth", "api"],
    data      : function () {
      return {
        query: userPageQuery
      }
    }
  }
</script>
