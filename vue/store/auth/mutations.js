export default {
  login(state, payload) {
    state.isLogin = true
    state.user    = payload
  },
  storePayload(state, payload) {
    console.log("payload", payload)
    state.naber   = true;
    state.isLogin = payload.isLogin
    state.user    = payload.user;
  }
}
