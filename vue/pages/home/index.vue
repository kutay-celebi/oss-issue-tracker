<template>
  <div>
    Logged in as {{username}}
  </div>
</template>

<script>
  export default {
    name      : "Home",
    middleware: "auth",
    computed: {
      username() {
        return this.$store.state.auth.username
      }
    }
  }
</script>

<style scoped>

</style>
