<template>
  <div id="crudHeaderWrapper" class="flex">

    <div id="headerTextWrapper" class="flex flex-col">
      <div id="headerText" class="text-h5 text-capitalize">
        {{ headerText }}
      </div>
      <div id="headerSubtitle" class="text-caption">
        {{ subTitle }}
      </div>
    </div>
    <div id="crudActionsWrapper">
      <slot name="form"/>
    </div>
    <div>
      <slot name="filter"/>
    </div>
  </div>
</template>

<script>
import KzFormDialog from "~/components/kuartz/form/KzFormDialog";

export default {
  name      : "CrudHeader",
  components: {KzFormDialog},
  props     : {
    headerText: {
      type    : String,
      required: true
    },
    subTitle  : {
      type    : String,
      required: false
    },
    save      : {
      type    : Function,
      required: false
    }
  },
}
</script>

<style scoped>

</style>
