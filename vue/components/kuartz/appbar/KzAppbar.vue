<template>
  <v-app-bar
    app
    clipped-left
  >
    <v-app-bar-nav-icon @click="openNavbar"/>
    <v-toolbar-title>Application</v-toolbar-title>
  </v-app-bar>
</template>

<script>

  export default {
    name    : "KzAppbar",
    methods: {
      openNavbar(){
        this.$store.dispatch("navbar/toggleNabar")
      }
    }
  }
</script>

<style scoped>

</style>
