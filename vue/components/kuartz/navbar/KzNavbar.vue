<template>
  <div>
    <v-navigation-drawer
      v-model="isNavbarOpen"
      app
      clipped>
      <v-list dense>
        <kz-navbar-item v-for="item in items" :navItem="item" :authorities="userAuthorities"/>
      </v-list>
    </v-navigation-drawer>
  </div>
</template>

<script>

  import {navItem}    from "~/common/config/navbarConfig";
  import KzNavbarItem from "~/components/kuartz/navbar/KzNavbarItem";

  export default {
    name      : "KzNavbar",
    components: {KzNavbarItem},
    data      : () => ({
      items: navItem
    }),
    computed  : {
      isNavbarOpen() {
        return this.$store.state.navbar.isOpen
      },
      createNavbarItems() {
        return navItem;
      },
      userAuthorities() {
        return this.$store.state.auth.user.principal.authority
      }
    }
  }
</script>

<style scoped>

</style>
