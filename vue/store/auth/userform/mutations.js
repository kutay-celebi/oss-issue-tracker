export default {
  openForm(state, payload) {
    console.warn(payload)
    state.user = payload
  }
}
