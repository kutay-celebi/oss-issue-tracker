<template>
  <form>
    <v-container fluid>
      <v-row align="center" align-content="center" dense>
        <v-col cols="12" sm="12" md="6">
          <text-field-outlined :label="$t('contact.web')" required v-model="web" outlined/>
        </v-col>
      </v-row>
    </v-container>
  </form>
</template>

<script>
import {mapFields} from "vuex-map-fields";

export default {
  name    : "ContactForm",
  props   : {
    contactObjectPath: {
      type    : String,
      required: true
    },
    storeNameSpace   : {
      required: true,
      type    : String
    }
  },
  computed: {
    ...mapFields("auth/userform/", {
      web: "userForm.person.contact" + ".web",
    }),
    operation() {
      console.log("CHILD")
      console.log(this.$route.params)
      return this.$route.fullPath
    }
  },
}
</script>

<style scoped>

</style>
