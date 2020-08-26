<template>
  <kz-form-dialog :buttonText="$t('user.new')"
                  :title="$t('user.new')"
                  :is-open="isOpen"
                  @open-dialog="openForm"
                  @close-dialog="closeDialog"
                  @save="save">
    <v-tabs slot="tabs" v-model="tab">
      <v-tab href="#temel">Temel Bilgiler</v-tab> <!--todo @kcelebi i18n-->
      <v-tab href="#contact">İletişim</v-tab> <!--todo @kcelebi i18n-->
    </v-tabs>
    <v-tabs-items slot="content" v-model="tab">
      <v-tab-item value="temel">
        <user-definition-form/>
      </v-tab-item>
      <v-tab-item value="contact">
        <contact-form :store-name-space="`auth/userform/`" contact-object-path="userForm.person.contact"/>
      </v-tab-item>
    </v-tabs-items>
  </kz-form-dialog>
</template>

<script>
import UserDefinitionForm               from "@/components/uaa/UserDefinitionForm";
import {API_GET_USER_USERNAME_OR_EMAIL} from "@/common/constant/api/path";
import KzFormDialog                     from "@/components/kuartz/form/KzFormDialog";
import ContactForm                      from "@/components/contact/ContactForm";

export default {
  name      : "id",
  components: {ContactForm, KzFormDialog, UserDefinitionForm},
  data() {
    return {
      tab: 0
    }
  },
  computed  : {
    isOpen() {
      return this.$store.state.auth.userform.formDialog;
    },
  },
  methods   : {
    save() {
      this.$store.dispatch("auth/userform/save")
    },
    closeDialog() {
      this.$store.dispatch("auth/userform/closeDialog")
    },
    openForm() {
      this.$store.dispatch("auth/userform/openDialog")
    }
  },
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
