<template>
  <div class="w-full">
    <div class="formHeader">
      <!--  todo @kcelebi add header-->
    </div>
    <slot name="content" class="w-full" />
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
