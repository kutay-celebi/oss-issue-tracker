<template>
  <v-select
    v-model="myValue"
    :items="genders"
    @change="$emit('update:field', myValue)"
    item-value="val"
    :item-text="item => $t(item.label)"
    label="Standard">
  </v-select>
</template>

<script>
  import GENDER from "~/common/enum/GENDER";

  export default {
    name   : "GenderSelect",
    props  : {
      field: {
        required: true
      }
    },
    data() {
      return {
        myValue: this.field,
        genders: Object.values(GENDER),
      }
    },
    watch: {
      field(){
        this.myValue = this.field;
      }
    },
    methods: {
      select(e) {
        this.$emit('input', e)
        this.myValue = e
      }
    }
  }
</script>

<style scoped>

</style>
