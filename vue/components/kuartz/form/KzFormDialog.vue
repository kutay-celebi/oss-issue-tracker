<template>
  <v-dialog v-model="isOpen" persistent max-width="w-10">

    <template v-slot:activator="{ on, attrs }">
      <v-btn color="primary"
             dark
             v-bind="attrs"
             v-on="on">
        {{buttonText}}
      </v-btn>
    </template>

    <v-card>
      <v-card-title>
        {{title}}
      </v-card-title>
      <v-card-text>
        <slot name="content"/>
      </v-card-text>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn color="blue darken-1" text @click="toggleDialog">{{$t("common.close")}}</v-btn>
        <v-btn color="blue darken-1" text @click="$emit('save')">{{$t("common.save")}}</v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>

  export default {
    name   : "KzFormDialog",
    data   : () => ({
      isOpen: false
    }),
    props  : {
      buttonText: {
        type   : String,
        default: "New"
      },
      title     : {
        required: true,

      }
    },
    methods: {
      toggleDialog() {
        this.isOpen = !this.isOpen
      }
    }
  }
</script>

<style scoped>

</style>
