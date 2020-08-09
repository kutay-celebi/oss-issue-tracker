<template>
  <v-app id="inspire">

    <kz-navbar/>
    <kz-appbar/>

    <v-main>
      <div class="contentWrapper">
        <Nuxt/>
      </div>
    </v-main>

    <v-footer app>
      <span>&copy; {{ new Date().getFullYear() }}</span>
    </v-footer>
  </v-app>
</template>

<script>
  import KzNavbar from "~/components/kuartz/navbar/KzNavbar";
  import KzAppbar from "~/components/kuartz/appbar/KzAppbar";

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
    /*align-items: center;*/
    text-align: center;
    width: 100%;
    padding: 2rem;
  }
</style>
