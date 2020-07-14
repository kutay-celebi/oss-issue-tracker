<template>
  <div>
    <v-list-group v-if="checkAuth" :key="navItem.key">
      <template slot="activator">
        <v-list-item-content>
          <v-list-item-title>{{navItem.title}}</v-list-item-title>
        </v-list-item-content>
        <!--<v-list-item-icon>-->
        <!--  <font-awesome-icon :icon="navItem.icon"/>-->
        <!--</v-list-item-icon>-->
      </template>
      <v-list-item v-for="(child, i) in navItem.children">
        <v-list-item-content>
          <v-list-item-title>
            <nuxt-link :to="child.url">
            {{child.title}}
            </nuxt-link>
          </v-list-item-title>
        </v-list-item-content>
      </v-list-item>
    </v-list-group>
    <v-list-group :key="navItem.key" v-else-if="checkAuth">
      <v-list-item>
        <v-list-item-title>
          <nuxt-link :to="navItem.url">
            {{navItem.title}}
          </nuxt-link>
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
