<template>
  <v-container
    class="fill-height"
    fluid>
    <v-row
      align="center"
      justify="center">
      <v-col
        cols="12"
        sm="8"
        md="4">
        <v-card class="elevation-12">
          <v-toolbar
            color="primary"
            dark
            flat>
            <v-toolbar-title>Login form</v-toolbar-title>
            <v-spacer></v-spacer>
          </v-toolbar>
          <v-card-text>
            <v-form>
              <v-text-field
                label="Login"
                v-model="formUsername"
                name="login"
                prepend-icon="mdi-account"
                type="text"/>

              <v-text-field
                id="password"
                label="Password"
                name="password"
                v-model="formPassword"
                prepend-icon="mdi-lock"
                type="password"/>
            </v-form>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="primary" @click="login">Login</v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
  export default {
    layout : "login",
    data() {
      return {
        formError   : null,
        formUsername: "kcelebi",
        formPassword: "123"
      }
    },
    methods: {
      login() {
        this.$store.dispatch("auth/login", {
          username: this.formUsername,
          password: this.formPassword
        });
      }
    },

  }
</script>

<style>
  /* Sample `apply` at-rules with Tailwind CSS
  .container {
  @apply min-h-screen flex justify-center items-center text-center mx-auto;
  }
  */
  .container {
    margin: 0 auto;
    min-height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    text-align: center;
  }

  .title {
    font-family: 'Quicksand',
    'Source Sans Pro',
    -apple-system,
    BlinkMacSystemFont,
    'Segoe UI',
    Roboto,
    'Helvetica Neue',
    Arial,
    sans-serif;
    display: block;
    font-weight: 300;
    font-size: 100px;
    color: #35495e;
    letter-spacing: 1px;
  }

  .subtitle {
    font-weight: 300;
    font-size: 42px;
    color: #526488;
    word-spacing: 5px;
    padding-bottom: 15px;
  }

  .links {
    padding-top: 15px;
  }
</style>
