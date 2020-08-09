<template>
  <CrudPage>
    <div slot="content">
      <user-definition-form/>
    </div>
  </CrudPage>
</template>

<script>
  import {API_GET_USER_USERNAME_OR_EMAIL} from "~/common/constant/api/path";
  import CrudPage                         from "~/components/form/PageContent";
  import UserDefinitionForm               from "~/components/uaa/UserDefinitionForm";

  export default {
    name      : "index",
    components: {UserDefinitionForm, CrudPage},
    middleware: ["auth", "api"],
    data      : function () {
      return {
        user: {}
      }
    },
    async fetch() {
      await this.$api.get(API_GET_USER_USERNAME_OR_EMAIL + "kcelebi").then(response => {
        this.user = JSON.stringify(response.data)
      })
    }
  }
</script>
