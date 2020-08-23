<template>
  <div>
    <contact-form v-if="$route.params['tab'] === 'contact'"/>
    <user-definition-form v-else/>
  </div>
</template>

<script>
import UserDefinitionForm from "@/components/uaa/UserDefinitionForm";
import ContactForm        from "@/components/contact/ContactForm";

export default {
  name      : "index",
  components: {ContactForm, UserDefinitionForm}
}
</script>

<style scoped>

</style>
