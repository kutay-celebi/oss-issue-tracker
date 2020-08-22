<template>
  <div>
    <kz-form-dialog :buttonText="$t('user.new')"
                    :title="$t('user.new')"
                    :is-open="isOpen"
                    @open-dialog="openForm"
                    @close-dialog="closeDialog"
                    @save="save">
      <div slot="content">
        <form>
          <v-container fluid>
            <v-row align="center" align-content="center" dense>
              <v-col cols="12" sm="12" md="6">
                <text-field-outlined :label="$t('user.username')" required v-model="username" outlined/>
              </v-col>
              <v-col cols="12" sm="12" md="6">
                <text-field-outlined :label="$t('common.email')" required v-model="email"/>
              </v-col>
            </v-row>
          </v-container>

          <v-subheader>{{ $t('user.personalInfo') }}</v-subheader>
          <v-divider/>

          <v-container fluid>
            <v-row align="center" align-content="center" dense>
              <v-col cols="12" sm="12" md="6">
                <text-field-outlined :label="$t('user.identificationNumber')" required v-model="personIdentificationNumber"/>
              </v-col>

              <v-col cols="12" sm="12" md="6">
                <text-field-outlined :label="$t('user.nationality')" required v-model="personNationality"/>
              </v-col>

              <v-col cols="12" sm="12" md="6">
                <text-field-outlined :label="$t('user.name')" required v-model="personName"/>
              </v-col>

              <v-col cols="12" sm="12" md="6">
                <text-field-outlined :label="$t('user.midName')" required v-model="personMidname"/>
              </v-col>

              <span/>

              <v-col cols="12" sm="12" md="6">
                <text-field-outlined :label="$t('user.lastName')" required v-model="personLastname"/>
              </v-col>

              <v-col cols="12" sm="12" md="6">
                <text-field-outlined :label="$t('user.title')" required v-model="personTitle"/>
              </v-col>

              <v-col cols="12" sm="12" md="6">
                <kz-date-picker :date="personBirthday"/>
              </v-col>

              <v-col cols="12" sm="12" md="6">
                <gender-select :field.sync="personGender"/>
              </v-col>
            </v-row>
          </v-container>
        </form>
      </div>
    </kz-form-dialog>
  </div>
</template>

<script>
import KzFormDialog               from "~/components/kuartz/form/KzFormDialog";
import KzDatePicker               from "~/components/kuartz/datepicker/KzDatePicker";
import GenderSelect               from "~/components/form/GenderSelect";
import {createHelpers, mapFields} from 'vuex-map-fields';

export default {
  name      : "UserDefinitionForm",
  components: {GenderSelect, KzDatePicker, KzFormDialog},
  computed  : {
    ...mapFields("auth/userform/", {
      username                  : "userForm.username",
      email                     : "userForm.email",
      personIdentificationNumber: "userForm.person.identificationNumber",
      personNationality         : "userForm.person.nationality",
      personName                : "userForm.person.name",
      personMidname             : "userForm.person.midName",
      personLastname            : "userForm.person.lastName",
      personTitle               : "userForm.person.title",
      personBirthday            : "userForm.person.birthday",
      personGender              : "userForm.person.gender"
    }),
    testText() {
      return this.$store.state.auth.userform.testText.aa
    },
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
}
</script>

<style scoped>

</style>
