// todo @kcelebi migrate generic pageable object
export const userPageQuery = {
  "email"   : null,
  "username": null,
  "pageable": {
    "pageNumber": 0,
    "pageSize"  : 20, // todo @kcelebi move constants
    "sort"      : {}
  }
}
