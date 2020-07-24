<template>
  <v-app id="inspire">

    <kz-navbar/>
    <kz-appbar/>


    <v-main>
      <v-container
        class="contentWrapper border-4"
        fluid
      >
        <Nuxt/>
      </v-container>
    </v-main>

    <v-footer app>
      <span>&copy; {{ new Date().getFullYear() }}</span>
    </v-footer>
  </v-app>
</template>

<script>
  import KzNavbar from "~/components/navbar/KzNavbar";
  import KzAppbar from "~/components/appbar/KzAppbar";

  export default {
    components: {KzAppbar, KzNavbar},
    props     : {
      source: String,
    },

    created() {
      this.$vuetify.theme.dark = false
    },
  }
</script>

<style scoped>
  .contentWrapper {
    max-width: 100%;
    margin: 0 auto;
    min-height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    text-align: center;
    width: 100%;
    padding: 12px;
  }
</style>
