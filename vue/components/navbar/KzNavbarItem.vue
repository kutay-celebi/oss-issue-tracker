<template>
  <div>
    <v-list-group v-if="checkAuth" :key="navItem.key">
      <template slot="activator">
        <v-list-item-content>
          <v-list-item-title>{{navItem.title}}</v-list-item-title>
        </v-list-item-content>
      </template>
      <v-list-item v-for="(child, i) in navItem.children">
        <nuxt-link :to="child.path">
          <v-list-item-content>
            <v-list-item-title>{{child.title}}</v-list-item-title>
          </v-list-item-content>
        </nuxt-link>
      </v-list-item>
    </v-list-group>
    <v-list-group :key="navItem.key" v-else-if="checkAuth">
      <v-list-item>
        <v-list-item-title>
          {{navItem.title}}
        </v-list-item-title>
      </v-list-item>
    </v-list-group>
  </div>
</template>

<script>
  export default {
    name    : "KzNavbarItem",
    props   : {
      navItem    : {
        required: true
      },
      authorities: {
        required: true
      }
    },
    computed: {
      checkAuth() {
        let render = false
        render     = this.navItem.auth.some(navAuth => {
          return this.authorities.some(userAuth => {
            if (navAuth.startsWith(userAuth.code)) {
              return true;
            }
          })
        })
        return render;
      }
    }
  }
</script>

<style scoped>

</style>
