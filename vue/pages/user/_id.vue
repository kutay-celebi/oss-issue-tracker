<template>
  <div>
    <user-definition-form/>
  </div>
</template>

<script>
import UserDefinitionForm               from "~/components/uaa/UserDefinitionForm";
import {API_GET_USER_USERNAME_OR_EMAIL} from "@/common/constant/api/path";

export default {
  name         : "id",
  components   : {UserDefinitionForm},
  async fetch() {
    if (this.$route.params.id !== undefined) {
      const user = await this.$api.$get(API_GET_USER_USERNAME_OR_EMAIL + this.$route.params.id)
                               .then(res => {
                       return res;
                     })
                               .catch(e => console.log(e));
      this.$store.commit("auth/userform/setuser", user)
      this.$store.commit("auth/userform/openDialog");
    }
  },
}
</script>

<style scoped>

</style>
