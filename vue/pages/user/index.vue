<template>
  <CrudPage>
    <div slot="content">
      <user-definition-form/>

      <v-container fluid class="my-css-class naberCss">
        <user-datatable v-bind:query="query"/>
      </v-container>
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

<style lang="scss">
.naberCss{
  font-size: $naber-font;
}
</style>
