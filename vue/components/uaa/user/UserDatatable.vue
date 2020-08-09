<template>
  <v-data-table :items="result" :items-per-page="query.pageable.pageSize" :page="query.pageable.page" :headers="headers" :footer-props="{'items-per-page-options':[2,15, 30, 50, 100, -1]}" >
    <template v-slot:item.enabled="{ item }">
      {{item.enabled ? $t("common.isEnabled.enabled") : $t("common.isEnabled.disabled")}}
    </template>
  </v-data-table>
</template>

<script>
  import {API_GET_USER_PAGE} from "~/common/constant/api/path";
  import {userPageQuery}     from "~/common/query/uaa/user/userPageQuery";

  export default {
    name : "UserDatatable",
    props: {
      query: {
        required: true,
        type    : Object,
        default : userPageQuery
      }
    },
    data() {
      return {
        result : [],
        headers: [
          {
            value   : 'username',
            text    : this.$t('user.username'),
            align   : 'center',
            sortable: false,
          },
          {
            value   : 'enabled',
            text    : this.$t('common.isEnabled.text'),
            align   : 'center',
            sortable: false,
          },
          {
            value   : 'email',
            text    : this.$t('common.email'),
            align   : 'center',
            sortable: false,
          },
          {
            value   : 'person.name',
            text    : this.$t('user.name'),
            align   : 'center',
            sortable: false,
          },
          {
            value   : 'person.lastName',
            text    : this.$t('user.surname'),
            align   : 'center',
            sortable: false,
          }
        ],
      }
    },
    async fetch() {
      await this.$api.$post(API_GET_USER_PAGE, this.query).then(response => {
        console.log(response)
        this.result = response.content
      });
    }
  }
</script>

<style scoped>

</style>
