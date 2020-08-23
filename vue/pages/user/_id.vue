<template>
  <kz-form-dialog :buttonText="$t('user.new')"
                  :title="$t('user.new')"
                  :is-open="isOpen"
                  @open-dialog="openForm"
                  @close-dialog="closeDialog"
                  @save="save">
    <v-tabs slot="tabs" @change="changeTab" v-model="tab">
      <v-tab>Temel Bilgiler</v-tab> <!--todo @kcelebi i18n-->
      <v-tab>İletişim</v-tab> <!--todo @kcelebi i18n-->
    </v-tabs>
    <v-tabs-items slot="content">
      <nuxt-child :key="$route.fullPath"/>
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
    },
    changeTab(tab) {
      let params = this.$route.params;
      switch (tab) {
        case 0: {
          params.tab = null
          break;
        }
        case 1: {
          params.tab = "contact"
          break;
        }
      }
      this.$router.push({params})
    }
  },
  asyncData({route}) {
    console.log(route.params)
    let tab;
    if (route.params.tab === "contact") {
      tab = 1
    } else {
      tab = 0
    }
    return {
      tab: tab
    }
  },
  async fetch() {
    if (this.$route.params.id !== undefined) {
      console.log(this.$route)
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
