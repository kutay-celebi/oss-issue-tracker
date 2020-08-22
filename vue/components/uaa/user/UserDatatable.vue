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
                  dense
                  v-model="selected"
                  class="w-full"
                  :footer-props="{'items-per-page-options':[5,10, 20, 30, 100, -1]}">
      <template v-slot:item.enabled="{ item }">
        {{ item.enabled ? $t("common.isEnabled.enabled") : $t("common.isEnabled.disabled") }}
      </template>
      <template v-slot:item.data-table-select="{ item,isSelected, select }">
        <v-simple-checkbox color="green"
                           :value="item.username !== 'kcelebi' && isSelected"
                           @input="select($event)"/>
      </template>
      <template v-slot:item.actions="{ item }" class="text-center" c>
        <v-icon
          small
          @click="editRow(item)"
        >
          $vuetify.icons.edit
        </v-icon>
      </template>
    </v-data-table>
  </div>
</template>

<script>
import {API_GET_USER_PAGE} from "~/common/constant/api/path";
import {userPageQuery}     from "~/common/query/uaa/user/userPageQuery";

export default {
  name   : "UserDatatable",
  props  : {
    query   : {
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
        },
        {
          text    : "Actions", //todo @kcelebi migrate i18n
          value   : "actions",
          sortable: false,
          align   : "center"
        }
      ],
      selected    : [],
      totalElement: null
    }
  },
  methods: {
    changePage(page) {
      this.query.pageable.pageNumber = page - 1
      this.$fetch()
    },
    changeRows(rows) {
      this.query.pageable.pageNumber = 0
      this.query.pageable.pageSize   = rows
      this.$fetch()
    },
    selectRow(item) {
      this.$emit("onSelect", item)
    },
    editRow(item) {
      this.$router.push({ path: `/user/${item.username}`, force:true })
    }
  },
  async fetch() {
    await this.$api.$post(API_GET_USER_PAGE, this.query).then(response => {
      this.totalElement = response.totalElements
      this.result       = response.content
    });
  }
}
</script>

<style scoped>

</style>
