<template>
  <div>
    <div class="formHeader">
      Header
    </div>
    <slot name="content"/>
  </div>
</template>

<script>
  export default {
    name: "CrudPage"
  }
</script>

<style scoped>
  .formHeader {
    margin: 1rem 0
  }
</style>
