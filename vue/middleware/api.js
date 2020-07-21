export default function ({store, $api}) {
  if (store.state.auth) {
    $api.setHeader("Authorization", "Bearer " + store.state.auth.user.access_token)
  }
}
