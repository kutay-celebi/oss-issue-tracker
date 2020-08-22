<template>
  <div>
    <v-btn color="secondary"
           fab
           small
           @click="$emit('open-dialog')">
      <v-icon small> $vuetify.icons.add</v-icon>
    </v-btn>

    <v-dialog :value="isOpen" persistent max-width="w-10">
      <v-card>
        <v-card-title>
          {{ title }}
        </v-card-title>
        <v-card-text>
          <slot name="content"/>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" text @click="$emit('close-dialog');">{{ $t("common.close") }}</v-btn>
          <v-btn color="blue darken-1" text @click="$emit('save')">{{ $t("common.save") }}</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>

<script>


export default {
  name : "KzFormDialog",
  props: {
    buttonText: {
      type   : String,
      default: "New"
    },
    title     : {
      required: true,

    },
    isOpen    : {
      type   : Boolean,
      default: false
    },
  },
  watch: {
    isOpen(newVal) {
      return this.isOpen = newVal;
    }
  },
}
</script>
