<template>
  <div>
    {{user}}
  </div>
</template>

<script>
  import {API_GET_USER_USERNAME_OR_EMAIL} from "~/common/constant/api/path";

  export default {
    name      : "index",
    middleware: ["auth", "api"],
    data      : function () {
      return {
        user: {}
      }
    },
    async fetch() {
      await this.$api.get(API_GET_USER_USERNAME_OR_EMAIL + "kcelebi").then(response => {
        console.log(response)
        this.user = JSON.stringify(response.data)
      })
    }
  }
</script>

<style scoped>

</style>
