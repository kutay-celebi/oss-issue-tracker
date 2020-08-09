<template>
  <v-menu
    v-model="menu2"
    :close-on-content-click="false"
    :nudge-right="40"
    transition="scale-transition"
    offset-y
    min-width="290px"
  >
    <template v-slot:activator="{ on, attrs }">
      <v-text-field
        v-model="date"
        label="Picker without buttons"
        v-bind="attrs"
        :readonly="readonly"
        v-on="on"/>
    </template>
    <v-date-picker v-model="date" @input="menu2 = false" header-color="primary"/>
  </v-menu>
</template>

<script>
  export default {
    name : "KzDatePicker",
    data : () => ({
      menu2: false,
    }),
    props: {
      date    : {
        required: true
      },
      readonly: {
        type   : Boolean,
        default: true
      }
    },
  }
</script>

<style scoped>

</style>
