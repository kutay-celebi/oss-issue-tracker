<template>
  <div>
    Logged in as {{username}}
    {{$t('hello.world')}}
    <div>
      {{availableLocales}}
    </div>
  </div>
</template>

<script>
  export default {
    name      : "Home",
    middleware: "auth",
    computed  : {
      username() {
        return this.$store.state.auth.username
      },
      availableLocales() {
        console.warn(this.$i18n)
        return this.$i18n.availableLocales.filter(i => i !== this.$i18n.locale)
      }
    }
  }
</script>

<style scoped>

</style>
