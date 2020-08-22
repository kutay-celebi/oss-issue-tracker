<template>
  <div>
    <user-definition-form/>
    {{deto}}
  </div>
</template>

<script>
import UserDefinitionForm               from "~/components/uaa/UserDefinitionForm";
import {API_GET_USER_USERNAME_OR_EMAIL} from "@/common/constant/api/path";

export default {
  name         : "id",
  components   : {UserDefinitionForm},
  data: function (){
    return{
      deto: ""
    }
  },
  async fetch() {
    if (this.$route.params.id !== undefined) {
      const user = await this.$api.$get(API_GET_USER_USERNAME_OR_EMAIL + this.$route.params.id)
                               .then(res => {
                       return res;
                     })
                               .catch(e => console.log(e));

      this.deto = user
      this.$store.commit("auth/userform/setuser", this.deto)
      this.$store.commit("auth/userform/openDialog");
    }
  },
}
</script>

<style scoped>

</style>
