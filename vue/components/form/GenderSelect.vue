<template>
  <v-select
    :value="value"
    :items="genders"
    dense
    outlined
    @change="$emit('input', $event)"
    item-value="val"
    :item-text="item => $t(item.label)"
    label="Standard">
  </v-select>
</template>

<script>
import GENDER from "~/common/enum/GENDER";

export default {
    name   : "GenderSelect",
    props  : ['value'],
    data() {
      return {
        genders: Object.values(GENDER),
      }
    },
    watch: {
    },
  }
</script>

<style scoped>

</style>
