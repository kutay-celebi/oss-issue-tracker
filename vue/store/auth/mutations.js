export default {
  login(state, payload) {
    state.isLogin = !state.isLogin
    state.user    = payload
  }
}
