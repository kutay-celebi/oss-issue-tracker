<template>
  <div>
    <v-data-table :items="result"
                  :items-per-page.sync="query.pageable.pageSize"
                  :page.sync="query.pageable.page"
                  :headers="headers"
                  @update:items-per-page="changeRows"
                  @update:page="changePage"
                  :server-items-length="totalElement"
                  @item-selected="selectRow"
                  @toggle-select-all="selectRow"
                  show-select
                  v-model="selected"
                  class="w-full"
                  :footer-props="{'items-per-page-options':[5,10, 20, 30, 100, -1]}">
      <template v-slot:item.enabled="{ item }">
        {{item.enabled ? $t("common.isEnabled.enabled") : $t("common.isEnabled.disabled")}}
      </template>
      <template v-slot:item.data-table-select="{ item,isSelected, select }">
        <v-simple-checkbox color="green" :value="item.username !== 'kcelebi' && isSelected" @input="select($event)" :disabled="item.username === 'kcelebi'"/>
      </template>
    </v-data-table>

    {{selected}}
  </div>
</template>

<script>
  import {API_GET_USER_PAGE} from "~/common/constant/api/path";
  import {userPageQuery}     from "~/common/query/uaa/user/userPageQuery";

  export default {
    name   : "UserDatatable",
    props  : {
      query: {
        required: true,
        type    : Object,
        default : userPageQuery
      },
      onSelect: {
        type: Function
      }
    },
    data() {
      return {
        result      : [],
        headers     : [
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
        selected    : [],
        totalElement: null
      }
    },
    methods: {
      async getDataFromApi() {
        await this.$api.$post(API_GET_USER_PAGE, this.query).then(response => {
          console.log(response)
          this.totalElement = response.totalElements
          this.result       = response.content
        });
      },
      changePage(page) {
        this.query.pageable.pageNumber = page - 1
        this.getDataFromApi()
      },
      changeRows(rows) {
        this.query.pageable.pageNumber = 0
        this.query.pageable.pageSize   = rows
        this.getDataFromApi()
      },
      selectRow(item) {
        this.$emit("onSelect", item)
      }
    },
    async fetch() {
      await this.getDataFromApi();
    }
  }
</script>

<style scoped>

</style>
