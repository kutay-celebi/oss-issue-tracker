<template>
  <div class="w-full">
    <div class="formHeader mb-4 shades--text text--white p-4 justify-center flex items-center">

      <div class="flex-1 text-left p-4">
        <slot name="header"/>
      </div>
    </div>
    <slot name="content" class="w-full"/>
  </div>
</template>

<script>

export default {
  name: "PageContent",
}
</script>

<style lang="scss" scoped>
.formHeader {
  background-color: var(--v-primary-base);
}
</style>
