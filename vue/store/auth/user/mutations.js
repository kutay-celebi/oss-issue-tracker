export default {
  login(state, payload) {
    state.isLogin = true
    state.user    = payload
  },
  storePayload(state, payload) {
    state.user = payload;
  },
  clearAuth(state) {
    state.user = {};
  }
}
