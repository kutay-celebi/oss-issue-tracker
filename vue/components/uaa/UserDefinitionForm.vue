<template>
  <kz-form-dialog :buttonText="$t('user.new')" :title="$t('user.new')" @save="save">
    <div slot="content">
      <form>
        <v-container fluid>
          <v-row align="center" align-content="center">
            <v-col cols="12" sm="12" md="6">
              <v-text-field :label="$t('user.username')" required v-model="user.username" outlined/>
            </v-col>

            <v-col cols="12" sm="12" md="6">
              <v-text-field :label="$t('common.email')" required v-model="user.email"/>
            </v-col>
          </v-row>
        </v-container>

        <v-subheader>{{$t('user.personalInfo')}}</v-subheader>
        <v-divider/>

        <v-container fluid>
          <v-row align="center" align-content="center">
            <v-col cols="12" sm="12" md="6">
              <v-text-field :label="$t('user.identificationNumber')" required v-model="user.person.identificationNumber"/>
            </v-col>

            <v-col cols="12" sm="12" md="6">
              <v-text-field :label="$t('user.nationality')" required v-model="user.person.nationality"/>
            </v-col>

            <v-col cols="12" sm="12" md="6">
              <v-text-field :label="$t('user.name')" required v-model="user.person.name"/>
            </v-col>

            <v-col cols="12" sm="12" md="6">
              <v-text-field :label="$t('user.midName')" required v-model="user.person.midName"/>
            </v-col>

            <span/>

            <v-col cols="12" sm="12" md="6">
              <v-text-field :label="$t('user.lastName')" required v-model="user.person.lastName"/>
            </v-col>

            <v-col cols="12" sm="12" md="6">
              <v-text-field :label="$t('user.title')" required v-model="user.person.title"/>
            </v-col>

            <v-col cols="12" sm="12" md="6">
              <kz-date-picker :date="user.person.birthday"/>
            </v-col>

            <v-col cols="12" sm="12" md="6">
              <gender-select :field.sync="user.person.gender"/>
            </v-col>
          </v-row>
        </v-container>
      </form>
    </div>
  </kz-form-dialog>
</template>

<script>
  import KzFormDialog from "~/components/kuartz/form/KzFormDialog";
  import KzDatePicker from "~/components/kuartz/datepicker/KzDatePicker";
  import GenderSelect from "~/components/form/GenderSelect";

  export default {
    name      : "UserDefinitionForm",
    components: {GenderSelect, KzDatePicker, KzFormDialog},
    data      : () => ({
      user: {
        "email"   : "",
        "enabled" : true,
        "username": "",
        "password": "",
        "person"  : {
          "birthday"            : "",
          "gender"              : "FEMALE",
          "identificationNumber": "",
          "lastName"            : "",
          "midName"             : "",
          "name"                : "",
          "nationality"         : "",
          "title"               : "",
        },
      }
    }),
    methods   : {
      save() {
        console.log(this.user.person.gender)
        this.$store.dispatch("auth/user/save", this.user)
      }
    },
  }
</script>

<style scoped>

</style>
