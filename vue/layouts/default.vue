<template>
  <v-app id="inspire">

    <kz-navbar/>
    <kz-appbar/>


    <v-main>
      <v-container
        class="fill-height"
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
    props: {
      source: String,
    },

    created () {
      this.$vuetify.theme.dark = true
    },
  }
</script>
